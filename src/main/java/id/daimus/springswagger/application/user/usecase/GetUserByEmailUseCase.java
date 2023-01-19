package id.daimus.springswagger.application.user.usecase;

import id.daimus.springswagger.application.user.entity.User;

import java.util.Optional;

public interface GetUserByEmailUseCase {
    Optional<User> getUserByEmail(String email);
}
