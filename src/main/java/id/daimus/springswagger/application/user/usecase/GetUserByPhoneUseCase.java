package id.daimus.springswagger.application.user.usecase;

import id.daimus.springswagger.application.user.entity.User;

import java.util.Optional;

public interface GetUserByPhoneUseCase {
    Optional<User> getUserByPhone(String phone);
}
