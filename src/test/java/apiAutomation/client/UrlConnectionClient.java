package apiAutomation.client;

import org.apache.hc.core5.http.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UrlConnectionClient {

    //1.GET Method without headers
    //inputstream ve output stream farki
    public InputStream getWithHeader(String url, String headerKey, String headerValue) throws IOException, ParseException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty(headerKey, headerValue);
        connection.connect();

        System.out.println(connection.getResponseCode());
        System.out.println(connection.getInputStream());
        return connection.getInputStream();

    }

    //setDoOutput connection will be used to send content
    //
    public InputStream post(String url, String payload, String headerKey, String headerValue) throws IOException, ParseException {

      //connect dedigim baglanti nesnesi olusturdun sonra icine outputstream ile payload koyabilirim ve input stream ile cekebilirim

        //input streamde connection ile api dan veri aldigim yer
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty(headerKey, headerValue);
        connection.setDoOutput(true);
        connection.connect();
        //asagidaki olayim payloadu connection in outputstreamine yazdirmak
        //tum karekterlerin hepsi var
        //programdan ver
        //connectionin output streami benim programdan baglanti kurdugum yere(url) veri yazdigim yer   == os.write connectionin output streamini yazar --
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = payload.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        //asagida ise responsu i read ettik

        //asagidada inputstream alinip read edilir
        //connectionin baglanti kurduktan sonraki aldigi veri input streamde gelir
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response);
        }
        System.out.println(connection.getResponseCode());
        //byte olarak doner bize biz onu jsona cevirmemiz lazim
        //input streami stringe cevirmemiz gerekiyor bunu buffered reader yapar
        return connection.getInputStream();
    }
}
