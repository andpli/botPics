import com.fasterxml.jackson.annotation.JsonProperty;

public class Unsplash {
    int total;
    int total_pages;
    String results [];


    public Unsplash(@JsonProperty("total") int total,
                   @JsonProperty("total_pages") int total_pages){

        this.total = total;
    }
}
