package id.daimus.springswagger.application.user.usecase;

import id.daimus.springswagger.application.user.entity.User;

import java.util.List;

public interface GetAllUserUseCase {
    List<User> getAllUser();
}
