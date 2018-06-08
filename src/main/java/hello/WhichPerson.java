package hello;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpResponse;


import org.apache.http.protocol.RequestContent;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.util.Random;



public class WhichPerson {

  private static int port = 8000;
  //String url = "http://localhost:" + port;
  private static int id = 2;
  private static String url = "https://ocean-rest-test.herokuapp.com/items";
  private static String url2 = "http://localhost:" + port + "/person/" + id;

  public WhichPerson() throws MalformedURLException {
  }


  public void whichPortIsHeComingOn(){
    //System.out.println("He is coming on port: " + port);
  }

  public static void main(String[] args) throws IOException {
    URL myURL = new URL(url2);
    HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
    connection.setRequestMethod("GET");
    connection.setDoOutput(true);
    connection.connect();
    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder results = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
      results.append(line);
    }

    connection.disconnect();
    System.out.println(results.toString());
  }







}
