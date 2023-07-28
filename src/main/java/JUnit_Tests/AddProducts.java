package JUnit_Tests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddProducts {

    private int _statusResponse;
    private int _idRecorded;
    private String _title;
    private double _price;
    private HttpURLConnection _conn;

    public AddProducts(String urlApi) throws IOException {
        JsonObject newProduct = new JsonObject();
        newProduct.addProperty("id", 101);
        newProduct.addProperty("title", "Perfume Oil");
        newProduct.addProperty("price", 13);
        newProduct.addProperty("stock", 65);
        newProduct.addProperty("rating", 4.26);
        newProduct.addProperty("thumbnail", "https://i.dummyjson.com/data/products/11/thumnail.jpg");
        newProduct.addProperty("description", "Mega Discount, Impression of A...");
        newProduct.addProperty("brand", "Impression of Acqua Di Gio");
        newProduct.addProperty("category", "fragrances");

    //turn properties into json String
    String request = new Gson().toJson(newProduct);

    URL url = new URL(urlApi);
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

        this._statusResponse = connection.getResponseCode();
        this._idRecorded = newProduct.get("id").getAsInt();
        this._title = newProduct.get("title").getAsString();
        this._price = newProduct.get("price").getAsDouble();
        this._conn = connection;

        reader.close();
        connection.disconnect();

    }

    //MANIPULATED DATA FOR TESTING PURPOSES
    public int get_statusResponse() {
        return _statusResponse +1;
    }

    public int get_idRecorded() {
        return _idRecorded;
    }

    public String get_title() {
        return _title;
    }

    public double get_price() {
        return _price;
    }



}
