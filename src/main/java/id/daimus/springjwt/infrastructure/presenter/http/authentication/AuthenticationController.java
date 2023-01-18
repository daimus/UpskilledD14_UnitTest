package id.daimus.springjwt.infrastructure.presenter.http.authentication;

import id.daimus.springjwt.infrastructure.presenter.http.Response;
import id.daimus.springjwt.infrastructure.presenter.http.authentication.request.AuthRequest;
import id.daimus.springjwt.infrastructure.presenter.http.authentication.response.AuthResponse;
import id.daimus.springjwt.infrastructure.presenter.http.authentication.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping(path = "/login")
    public ResponseEntity<Object> signIn(@RequestBody AuthRequest authRequest){
        log.info("GET /v1/auth/login called");
        Response response = new Response();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getPhone(), authRequest.getPassword())
            );
            String token = jwtUtil.generateToken(authRequest.getPhone());
            AuthResponse authenticateResponse = new AuthResponse(token);
            response.setData(authenticateResponse);
            return response.getResponse();
        } catch (UsernameNotFoundException usernameNotFoundException) {
            log.error("GET /v1/auth/login error: {}", usernameNotFoundException.getMessage());
            response.setHttpCode(404);
            response.setErrors(usernameNotFoundException.getMessage());
        } catch (BadCredentialsException badCredentialsException) {
            log.error("GET /v1/auth/login error: {}", badCredentialsException.getMessage());
            response.setHttpCode(401);
            response.setErrors(badCredentialsException.getMessage());
        } catch (Exception e){
            log.error("GET /v1/auth/login error: {}", e.getMessage());
            response.setErrors(e.getMessage());
        }
        return response.getResponse();
    }
}
