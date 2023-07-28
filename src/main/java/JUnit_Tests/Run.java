package JUnit_Tests;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class Run {

    public static void main(String[] args) throws IOException {

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


        // ler rseposta JSON do endpoint
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        connection.disconnect();


        System.out.println(connection.getContentType());
        System.out.println(connection.getResponseMessage());
        System.out.println(connection.getContent());
        System.out.println(connection.getDoOutput());

//        Map<String, List<String>> headers = connection.getHeaderFields();
//        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
//            String headerName = entry.getKey();
//            List<String> headerValues = entry.getValue();
//            System.out.println(headerName + ": " + headerValues);
//        }

// Obter o corpo da resposta JSON
        String responseBody = response.toString();
        //System.out.println("Response Body: " + responseBody);
       // System.out.println(response);


//        SingleProduct singleProduct = new SingleProduct(32);
//        System.out.println(singleProduct);
//        System.out.println(singleProduct.getImagesOfProductByTitle("Sofa for Coffe Cafe"));
//        URL url = new URL("https://dummyjson.com/products/1");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//
//        // Ler resposta JSON do endpoint
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        StringBuilder response = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            response.append(line);
//        }
//        reader.close();
//
//        Gson gson = new Gson();
//        JsonObject product = gson.fromJson(response.toString(), JsonObject.class) ;
//
//           System.out.println(product);

//            JsonObject productObject = product.getAsJsonObject();
//            System.out.println(productObject);

//            if(productObject.get("title").getAsString().equals("Key Holder")){
//                JsonArray images = productObject.get("images").getAsJsonArray();
//
//                for (JsonElement img : images) {
//                    productImages.add(img.toString());
//                }
//
//            }

        }



    }



