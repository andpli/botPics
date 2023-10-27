import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;


/*
public class Main {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://api.nasa.gov/planetary/apod?api_key=rhzlpvj0Ba6u0hAImIogzKqvVE05upMT4sA2f3N0";
        ObjectMapper mapper = new ObjectMapper();

        CloseableHttpResponse response = client.execute(new HttpGet(url));
        Nasa answer = mapper.readValue(response.getEntity().getContent(), Nasa.class);
        String urlImage = answer.url;
        String[] array = urlImage.split("/");
        String fileName = array[array.length - 1];
        CloseableHttpResponse image = client.execute(new HttpGet(urlImage));
        FileOutputStream fos = new FileOutputStream(fileName);
        image.getEntity().writeTo(fos);
    }
}

 */


public class Main {
    public static void main(String[] args) throws IOException {
        new NasaBot("NasaPicOfDay",
                "6793157556:AAHADaiJSzkROlq7d5JJ1PAny0Kpybrs9yA");
    }
}