package token;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"accessToken"})
public class AccessToken {
    private String accessToken;

    @JsonProperty("accessToken")
    public String getAccessToken() {
        return accessToken;
    }
    @JsonProperty("accessToken")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
