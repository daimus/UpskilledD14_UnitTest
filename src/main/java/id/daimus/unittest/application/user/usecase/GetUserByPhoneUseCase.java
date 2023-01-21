package id.daimus.unittest.application.user.usecase;

import id.daimus.unittest.application.user.entity.User;

import java.util.Optional;

public interface GetUserByPhoneUseCase {
    Optional<User> getUserByPhone(String phone);
}
