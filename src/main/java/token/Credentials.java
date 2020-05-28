package token;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "password"})
public class Credentials {

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String email;
    private String password;

    @JsonProperty("email")
    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
