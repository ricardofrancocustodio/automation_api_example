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
import java.util.ArrayList;
import java.util.List;

public class Products {

    private final JsonArray productsArray;

    public Products() throws IOException {

        URL url = new URL("https://dummyjson.com/products");
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
        this.productsArray = JsonParser.parseString(response.toString()).getAsJsonObject().getAsJsonArray("products");

    }

       //get product ID of by title
    public int getProductIDByTitle(String title) {
        int id = 0;

        for (JsonElement product : productsArray) {
            JsonObject productObject = product.getAsJsonObject();

            if(productObject.get("title").getAsString().equals(title)){
                id = productObject.get("id").getAsInt();
            }
        }

        return id;
    }


    //get product title by ID
    public String getProductTitleByID(int id) {
        String prod = "";

        for (JsonElement product : productsArray) {
            JsonObject productObject = product.getAsJsonObject();

            if(productObject.get("id").getAsInt() == id){
                prod = productObject.get("title").getAsString();
            }
        }

        return prod;
    }


    //get discount percentage by ID
    public double getDiscPercentById(int id) {
        double discountPercent = 0.0;

        for (JsonElement product : productsArray) {
            JsonObject productObject = product.getAsJsonObject();

            if(productObject.get("id").getAsInt() == id){
                discountPercent = productObject.get("discountPercentage").getAsDouble();
            }
        }

        return discountPercent;
    }


    //get price after discount percentage
    public double getPriceAfterDiscount(String title){
        double finalPrice = 0.0;

        for (JsonElement product : productsArray) {
            JsonObject productObject = product.getAsJsonObject();
            double price = productObject.get("price").getAsDouble();
            double discountPercentage = productObject.get("discountPercentage").getAsDouble();

            if(productObject.get("title").getAsString().equals(title)){

                double prodPart = price / 100;
                finalPrice = price - (prodPart * Math.round(discountPercentage));
            }
        }

        return finalPrice;
    }


    //get product images
    public List<String> getProductImages(String title) {
        List<String> productImages = new ArrayList<>();

        for (JsonElement product : productsArray) {
            JsonObject productObject = product.getAsJsonObject();

            if(productObject.get("title").getAsString().equals(title)){
                JsonArray images = productObject.get("images").getAsJsonArray();

                for (JsonElement img : images) {
                    productImages.add(img.toString());
                }

            }

        }

        return productImages;
    }





}
