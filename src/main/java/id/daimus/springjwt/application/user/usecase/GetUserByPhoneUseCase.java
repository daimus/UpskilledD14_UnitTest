package id.daimus.springjwt.application.user.usecase;

import id.daimus.springjwt.application.user.entity.User;

import java.util.Optional;

public interface GetUserByPhoneUseCase {
    Optional<User> getUserByPhone(String phone);
}
