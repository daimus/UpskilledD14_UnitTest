package id.daimus.cleanarchitecture.infrastructure.presenter.http.authentication.service;

import id.daimus.cleanarchitecture.application.user.entity.User;
import id.daimus.cleanarchitecture.application.user.usecase.GetUserByEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final GetUserByEmailUseCase getUserByEmailUseCase;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = getUserByEmailUseCase.getUserByEmail(username);
        return user.map(value -> new org.springframework.security.core.userdetails.User(value.getEmail(), value.getPassword(), new ArrayList<>())).orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));
    }
}
