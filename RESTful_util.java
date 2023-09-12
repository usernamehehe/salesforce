import java.io.*;
import java.net.HttpURLConnection;
import java.util.Scanner; 
import java.net.URL;


public class RESTful_util {
    public static void postMethod(String url, String query) throws IOException {
        URL restURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        conn.setDoOutput(true);

        PrintStream ps = new PrintStream(conn.getOutputStream());
        
        ps.print(query);
        ps.close();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    public static void main(String[] args) {
        try {
            System.out.print("Input message:");
            Scanner myobj = new Scanner(System.in);
            String message = myobj.nextLine();
            String url = "https://pwddemo01-developer-edition.ap6.force.com/exam/services/apexrest/HelloWorld";
            String query = "{ \"message\": \""+ message + "\" }"; 
            postMethod(url, query);
            

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
      }
}