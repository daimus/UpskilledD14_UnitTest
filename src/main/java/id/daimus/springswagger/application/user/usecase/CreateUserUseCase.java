package id.daimus.springswagger.application.user.usecase;

import id.daimus.springswagger.application.user.entity.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
