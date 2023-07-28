package JUnit_Tests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SingleProduct {

    JsonObject singleProductObj;

    public SingleProduct(){}

    public SingleProduct(int id) throws IOException {

        URL url = new URL("https://dummyjson.com/products/"+ id);
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

        Gson gson = new Gson();
        this.singleProductObj = gson.fromJson(response.toString(), JsonObject.class) ;

    }


    public String getBrandByTitle(String title){
        String brand = "";
            if(singleProductObj.get("title").getAsString().equals(title)){
                brand = singleProductObj.get("brand").getAsString();
            }

            return brand;
    }

    public double getRatingByID(int id){
        double rating = 0.0;
        if(singleProductObj.get("id").getAsInt() == id){
            rating = singleProductObj.get("rating").getAsDouble();
        }

        return rating;

    }

    public List<String> getImagesOfProductByTitle(String title){
        List<String> imagesOfProduct = new ArrayList<>();

        JsonArray images = singleProductObj.get("images").getAsJsonArray();
        for (Object obj: images){
            imagesOfProduct.add(obj.toString());

        }

        return imagesOfProduct;
    }


    @Override
    public String toString() {
        return "SingleProduct"  + singleProductObj ;
    }
}
