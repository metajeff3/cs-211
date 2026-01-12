import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class BigData {
    public static void main(String[] args){
        // double rate;
        // try{
        //     String theURL = "http://api.open-notify.org/iss-now.json";

        //     URL url = new URL(theURL);
        //     BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        //     JSONParser jsonParser = new JSONParser();
        //     JSONObject myObject = (JSONObject) jsonParser.parse(br);

        //     JSONArray PeopleArray = (JSONArray) myObject.get("people");
        //     JSONObject p = (JSONObject) PeopleArray.get(2);
        //     // people = (String) p.get("name");

        //     long rate = (double) ((JSONObject) myObject.get("rates")).get("ARS");
        //     System.out.println("US dollar to Argentina Peso = " + rate);
        // } catch (Exception e) {

        // }

        try {
            URL url = new URL("https://open.er-api.com/v6/latest/USD");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            JSONParser jsonParser = new JSONParser();
            JSONObject myObject = (JSONObject) jsonParser.parse(br);
            
            double rate = (double) ((JSONObject) myObject.get("rates")).get("ARS");
            System.out.println("US dollar to Argentina Peso = " + rate);

        } catch (Exception e) {

        }
    }
}
