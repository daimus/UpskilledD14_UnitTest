package id.daimus.springjwt.infrastructure.presenter.http.authentication.service;

import id.daimus.springjwt.application.user.entity.User;
import id.daimus.springjwt.application.user.usecase.GetUserByEmailUseCase;
import id.daimus.springjwt.application.user.usecase.GetUserByPhoneUseCase;
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
    private final GetUserByPhoneUseCase getUserByPhoneUseCase;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = getUserByPhoneUseCase.getUserByPhone(username);
        return user.map(value -> new org.springframework.security.core.userdetails.User(value.getPhone(), value.getPassword(), new ArrayList<>())).orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));
    }
}
