package id.daimus.springjwt.infrastructure.presenter.http.authentication.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private String token_type = "Bearer";
    private int expires_in = 3600;

    public AuthResponse(String token){
        this.token = token;
    }
}
