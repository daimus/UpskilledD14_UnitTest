package id.daimus.springswagger.application.user.service;

import id.daimus.springswagger.application.user.entity.User;
import id.daimus.springswagger.application.user.repository.UserRepository;
import id.daimus.springswagger.application.user.usecase.GetUserByPhoneUseCase;
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
