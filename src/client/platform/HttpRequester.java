package client.platform;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequester {

    public static String USER_AGENT = "Client/1.0";

    public static String sendGet(String server_url) throws Exception {

        URL obj = new URL(server_url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = 0;
        try {
            responseCode = con.getResponseCode();
        }catch (Exception e){
            return "Connection error";
        }


        System.out.println("\nSending 'GET' request to URL : " + server_url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

}
