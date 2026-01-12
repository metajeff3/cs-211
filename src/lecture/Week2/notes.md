# JSON BigData Real Time API

* Imports

```java
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
```

* Setup

```java
public class BigData {
    public static void main(String[] args){
        double rate;
        try{
            String theURL = "https://api-url";

            URL url = new URL(theURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            JSONParser jsonParser = new JSONParser();
            JSONObject myObject = (JSONObject) jsonParser.parse(br);

            JSONArray PeopleArray = (JSONArray) myObject.get("people");​
            JSONObject p = (JSONObject) PeopleArray.get(2);
            // people = (String) p.get("name");
            ​​

            rate = (double) ((JSONObject) myObject.get("rates")).get("ARS");
            System.out.println("US dollar to Argentina Peso = " + rate);
        } catch (Exception e) {

        }
    }
}

```