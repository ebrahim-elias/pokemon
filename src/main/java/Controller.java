import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class Controller {
    private String makeHTTPRequestForLavenderTown(String name) {
        String urlString = "https://pokeapi.co/api/v2/"+name;
        String response = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            Scanner responseScanner = new Scanner(connection.getInputStream());
            while (responseScanner.hasNext()) {
                response = responseScanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    void getInfo(String name){
        String urlText = makeHTTPRequestForLavenderTown("pokemon/"+name);
        JSONParser parser = new JSONParser();
        try{
        JSONObject jsonObject = (JSONObject) parser.parse(urlText);

          long id = (long) jsonObject.get("id");
            System.out.println("Pokemon Id: "+id);

            String pokeName = (String) jsonObject.get("name");
            System.out.println("Pokemon Name: "+pokeName);

         long height = (long) jsonObject.get("height");
            System.out.println("Height: "+height);

            long weight = (long) jsonObject.get("weight");
            System.out.println("Weight: "+weight);


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    void getLocation(String name) {
        String urlText = makeHTTPRequestForLavenderTown("location/"+name);
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(urlText);

            String locationName = (String) jsonObject.get("name");
            System.out.println("Location Name: " + locationName);

            JSONObject regionName = (JSONObject) jsonObject.get("region");
            String name3 = (String)  regionName.get("name");
            System.out.println("Region Name: " + name3);

            JSONArray names = (JSONArray) jsonObject.get("names");
            for (Object obj : names) {
               JSONObject nameLocation = (JSONObject)  obj;
                String locationNameInLanguage = (String) nameLocation.get("name");

                JSONObject languages = (JSONObject)  nameLocation.get("language");
                String languageName = (String) languages.get("name");

                System.out.println("language: "+languageName+":"+locationNameInLanguage);

           }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
