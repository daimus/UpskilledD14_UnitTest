package id.daimus.cleanarchitecture.infrastructure.presenter.http.authentication.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateResponse {
    private String token;
    private String token_type = "Bearer";
    private int expires_in = 3600;

    public AuthenticateResponse(String token){
        this.token = token;
    }
}
