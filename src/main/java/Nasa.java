import com.fasterxml.jackson.annotation.JsonProperty;

public class Nasa {
    String copyright;
    String date;
    String explanation;
    String hdUrl;
    String mediaType;
    String serviceVersion;
    String title;
    String url;

    public Nasa(@JsonProperty("date") String date,
                @JsonProperty("copyright") String copyright,
                @JsonProperty("explanation") String explanation,
                @JsonProperty("hdurl") String hdUrl,
                @JsonProperty("media_type") String mediaType,
                @JsonProperty("service_version") String serviceVersion,
                @JsonProperty("title") String title,
                @JsonProperty("url") String url ) {

        this.url = url;
    }
}

