package JUnit_Tests;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Users {

    JsonArray usersArray;

    public Users() throws IOException {

        URL url = new URL("https://dummyjson.com/users");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Ler resposta JSON do endpoint
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        //parse
        this.usersArray = JsonParser.parseString(response.toString()).getAsJsonObject().getAsJsonArray("users");

    }


    //get user ID of first Name
    public int getUserIDByFirstName(String firstName) {
        int id = 0;

        for (JsonElement userElement : usersArray) {
            JsonObject userObject = userElement.getAsJsonObject();

            if(userObject.get("firstName").getAsString().equals(firstName)){
                id = userObject.get("id").getAsInt();
            }
        }

        return id;
    }


    //get user ID of last Name
    public int getUserIDByMaidenName(String maidenName) {
        int id = 0;

        for (JsonElement userElement : usersArray) {
            JsonObject userObject = userElement.getAsJsonObject();

            if(userObject.get("maidenName").getAsString().equals(maidenName)){
                id = userObject.get("id").getAsInt();
            }
        }

        return id;
    }


    //get user ID of last Name
    public int getUserIDByLastName(String lastName) {
        int id = 0;

        for (JsonElement userElement : usersArray) {
            JsonObject userObject = userElement.getAsJsonObject();

            if(userObject.get("lastName").getAsString().equals(lastName)){
                id = userObject.get("id").getAsInt();
            }
        }

        return id;
    }


    //get user first name
    public String getUserEmailById(int id){
        String email = "";

        for (JsonElement userElement : usersArray) {
            JsonObject userObject = userElement.getAsJsonObject();

            if(userObject.get("id").getAsInt() == id){
                email = userObject.get("email").getAsString();
            }
        }

        return email;
    }

    //get user address
    public String getUserAddress(int id){
        String userAddress = "";

        for (JsonElement userElement : usersArray) {
            JsonObject userObj = userElement.getAsJsonObject();

            JsonObject addressObj = userObj.getAsJsonObject("address");
            String addressN = addressObj.get("address").getAsString();
            //String city = addressObj.get("city").getAsString();

            if(userObj.get("id").getAsInt() == id){
                userAddress = addressN;
            }
        }

        return userAddress;
    }


}
