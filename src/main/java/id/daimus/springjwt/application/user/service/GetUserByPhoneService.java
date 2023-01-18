package id.daimus.springjwt.application.user.service;

import id.daimus.springjwt.application.user.entity.User;
import id.daimus.springjwt.application.user.repository.UserRepository;
import id.daimus.springjwt.application.user.usecase.GetUserByPhoneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserByPhoneService implements GetUserByPhoneUseCase {
    private final UserRepository userRepository;
    @Override
    public Optional<User> getUserByPhone(String phone) {
        return userRepository.getUserByPhone(phone);
    }
}
