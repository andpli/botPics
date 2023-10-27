import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Utils {
    static String getUrl(String nasaUrl) {
        CloseableHttpClient client = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();

        CloseableHttpResponse response = null;
        Unsplash as = null;
        Nasa answer = null;

        try {
            response = client.execute(new HttpGet(nasaUrl));

          //  answer = mapper.readValue(response.getEntity().getContent(), Nasa.class);
            as = mapper.readValue(response.getEntity().getContent(), Unsplash.class);

            /*
            HttpEntity entity = response.getEntity();

            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            System.out.println(sb);*/
            System.out.println(as.total);
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

       return answer.url;
    }
}
