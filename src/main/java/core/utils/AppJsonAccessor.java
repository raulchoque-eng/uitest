package core.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * AppJsonAccessor class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class AppJsonAccessor {

    private static  AppJsonAccessor appJsonAccessor;
    private JsonObject baseURL;
    private JsonArray account;

    private AppJsonAccessor() {

        try {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader("./app.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            baseURL = jsonObject.getAsJsonObject("baseURL");
            account  = jsonObject.getAsJsonArray("users");
        } catch (FileNotFoundException fe) {
            throw new RuntimeException(fe);
        } catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

    public static AppJsonAccessor getInstance() {
        if (appJsonAccessor == null) {
            appJsonAccessor = new AppJsonAccessor();
        }
        return appJsonAccessor;
    }

    public String getUsername() {
        JsonObject admin = searchAdminAccount("admin");
        return admin.get("username").getAsString();
    }

    public String getPassword() {
        JsonObject admin = searchAdminAccount("admin");
        return admin.get("password").getAsString();
    }

    private JsonObject searchAdminAccount(String nameAccount) {

        JsonObject userAccount = new JsonObject();
        for (Object object: account) {
            JsonObject dataAccount = (JsonObject) object;

            if (dataAccount.has(nameAccount)) {
                userAccount = dataAccount.get("admin").getAsJsonObject();
                break;
            }
        }
        return userAccount;
    }

    public String getBaseURL() {
        String protocol = baseURL.get("protocol").getAsString();
        String domain = baseURL.get("domain").getAsString();
        return protocol.concat(domain);
    }
}
