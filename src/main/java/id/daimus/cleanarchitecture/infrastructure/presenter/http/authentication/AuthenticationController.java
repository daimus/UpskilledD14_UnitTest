package id.daimus.cleanarchitecture.infrastructure.presenter.http.authentication;

import com.sun.tools.jconsole.JConsoleContext;
import id.daimus.cleanarchitecture.infrastructure.presenter.http.Response;
import id.daimus.cleanarchitecture.infrastructure.presenter.http.authentication.entity.AuthRequest;
import id.daimus.cleanarchitecture.infrastructure.presenter.http.authentication.response.AuthenticateResponse;
import id.daimus.cleanarchitecture.infrastructure.presenter.http.authentication.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping(path = "/signin")
    public ResponseEntity<Object> signIn(@RequestBody AuthRequest authRequest){
        log.info("GET /auth/signin called");
        Response response = new Response();
        System.out.println(authRequest);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
            String token = jwtUtil.generateToken(authRequest.getEmail());
            AuthenticateResponse authenticateResponse = new AuthenticateResponse(token);
            response.setData(authenticateResponse);
            return response.getResponse();
        } catch (UsernameNotFoundException usernameNotFoundException) {
            response.setHttpCode(400);
            response.setErrors(usernameNotFoundException.getMessage());
        } catch (Exception e){
            log.error("GET /users error: " + e.getMessage());
            response.setErrors(e.getMessage());
        }
        return response.getResponse();
    }
}
