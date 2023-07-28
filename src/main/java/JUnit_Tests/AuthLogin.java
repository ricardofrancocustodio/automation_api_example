package JUnit_Tests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class AuthLogin {

    private String _username;
    private String _password;
    private final HttpURLConnection _conn;

   // public AuthLogin(){}

    public AuthLogin() throws IOException {

        JsonObject credentials = new JsonObject();
        credentials.addProperty("username", "kminchelle");
        credentials.addProperty("password", "0lelplR");

        //turn properties into json String
        String request = new Gson().toJson(credentials);

        URL url = new URL("https://dummyjson.com/auth/login");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(request.getBytes());
        outputStream.flush();
        outputStream.close();

        // Ler resposta JSON do endpoint
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        this._username = credentials.get("username").getAsString();
        this._password = credentials.get("password").getAsString();
        this._conn = connection;

        reader.close();
        connection.disconnect();
    }

    /**
     * Structure
     * */
    public String checkHTTPHeader() {
        return _conn.getContentType();
    }

    public boolean checkHTTPBody() throws IOException {
        return _conn.getDoOutput();

    }


    /**
     * Properties
     * */

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    /**
     * Conditions
     * */

    public String geInvalidCredentialsMsg(String username, String password){
        return ( (username.isEmpty() || password.isEmpty() )? "Invalid credentials" : null);

    }


}
