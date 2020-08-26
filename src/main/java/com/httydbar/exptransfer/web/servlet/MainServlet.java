package com.httydbar.exptransfer.web.servlet;

import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import com.httydbar.exptransfer.i18n.impl.LanguageProvider;
import com.httydbar.exptransfer.service.ExpMigrationService;
import com.httydbar.exptransfer.service.UsernamePasswordVerificationService;
import com.httydbar.exptransfer.service.exception.InvalidTokenException;
import com.httydbar.exptransfer.service.exception.TiebaNotSubscribedException;
import com.httydbar.exptransfer.service.exception.UsernameTokenMismatchException;
import com.httydbar.exptransfer.util.impl.*;
import org.jetbrains.annotations.NotNull;

import javax.json.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

@WebServlet
public class MainServlet extends HttpServlet
{
    static
    {
        try
        {
            ConfigManager.loadJSONConfigFromFile("/etc/exptransfer/config.json");
            //ConfigManager.loadJSONConfigFromFile("E:\\exptransfer\\config.json");
            ConfigManager.parseConfiguration();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            response.sendRedirect("/");
        }
        catch (Exception e)
        {
            onUnhandledException(response, e);
            e.printStackTrace();
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            try
            {
                if (!(request.getHeader("Content-Type").contains("application/json") && request.getHeader(
                        "Referer").contains("exptransfer.wxx9248.tk")))
                {
                    throw new IllegalArgumentException();
                }
            }
            catch (NullPointerException | IllegalArgumentException e)
            {
                response.sendRedirect("/");
                return;
            }
            
            StringBuilder  stringBuilder  = new StringBuilder();
            BufferedReader bufferedReader = request.getReader();
            String         line;
            
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
            
            JsonReader reader      = Json.createReader(new StringReader(stringBuilder.toString()));
            JsonObject requestData = reader.readObject();
            
            String authType = requestData.getString("authType");
            
            switch (authType)
            {
                case "0":
                    // Only verify username and password
                    Account account = new Account(requestData.getString("username"), requestData.getString("password"));
                    if (UsernamePasswordVerificationService.verify(account) > 0)
                    {
                        responseJSON(response, new ServerResponse("0",
                                                                  LanguageProvider.getCurrentLanguage().getField(
                                                                          LanguageFieldHandle.I_WEB_SERVLET_USERNAME_PASSWORD_PASS)));
                    }
                    else
                    {
                        responseJSON(response, new ServerResponse("403.1",
                                                                  LanguageProvider.getCurrentLanguage().getField(
                                                                          LanguageFieldHandle.E_WEB_SERVLET_USERNAME_PASSWORD_MISMATCH)));
                    }
                    return;
                case "1":
                    // Verify all and migrate credits
                    ExtendedAccount extendedAccount = new ExtendedAccount(requestData.getString("username"),
                                                                          requestData.getString("password"),
                                                                          requestData.getString("tiebaID"),
                                                                          requestData.getString("bduss"),
                                                                          requestData.getString("sToken"));
                    try
                    {
                        int credit = ExpMigrationService.migrate(extendedAccount);
                        if (credit > 0)
                        {
                            responseJSON(response, new ExtendedServerResponse("0",
                                                                              LanguageProvider.getCurrentLanguage().getField(
                                                                                      LanguageFieldHandle.I_WEB_SERVLET_MIGRATION_SUCCESS),
                                                                              credit));
                        }
                        else
                            throw new Exception(LanguageProvider.getCurrentLanguage().getField(
                                    LanguageFieldHandle.E_WEB_SERVLET_UNKNOWN_ERROR));
                    }
                    catch (UsernameTokenMismatchException e)
                    {
                        responseJSON(response, new ServerResponse("403.2", e.getMessage()));
                    }
                    catch (InvalidTokenException e)
                    {
                        responseJSON(response, new ServerResponse("403.3", e.getMessage()));
                    }
                    catch (TiebaNotSubscribedException e)
                    {
                        responseJSON(response, new ServerResponse("403.4", e.getMessage()));
                    }
                    return;
                default:
                    throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                            LanguageFieldHandle.E_WEB_SERVLET_INVALID_AUTH_TYPE));
            }
        }
        catch (Exception e)
        {
            onUnhandledException(response, e);
            e.printStackTrace();
        }
    }
    
    private void onUnhandledException(@NotNull HttpServletResponse response, @NotNull Exception exception)
    {
        try
        {
            response.setStatus(500);
            response.setContentType("application/json; charset=utf-8");
            JsonObjectBuilder responseJSONBuilder = Json.createObjectBuilder();
            
            StringWriter stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter, true));
            
            responseJSONBuilder.add("code", "500")
                               .add("exception", exception.getClass().toString())
                               .add("message", exception.getMessage() == null ? "null" : exception.getMessage())
                               .add("stackTrace",
                                    ByteCodec.Base64String.toBase64String(stringWriter.toString().getBytes(
                                            StandardCharsets.UTF_8)));
            
            JsonWriter jsonWriter = Json.createWriter(response.getWriter());
            jsonWriter.writeObject(responseJSONBuilder.build());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void responseJSON(@NotNull HttpServletResponse response, @NotNull ServerResponse responseData)
            throws IOException
    {
        response.setStatus(200);
        response.setContentType("application/json; charset=utf-8");
        
        JsonObjectBuilder responseJSONBuilder = Json.createObjectBuilder()
                                                    .add("code", responseData.getCode())
                                                    .add("message", responseData.getMessage());
        
        if (responseData instanceof ExtendedServerResponse)
        {
            responseJSONBuilder.add("credit", ((ExtendedServerResponse) responseData).getCredit());
        }
        
        JsonWriter jsonWriter = Json.createWriter(response.getWriter());
        jsonWriter.writeObject(responseJSONBuilder.build());
    }
}
