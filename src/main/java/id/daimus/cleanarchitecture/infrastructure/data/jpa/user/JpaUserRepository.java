package id.daimus.cleanarchitecture.infrastructure.data.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
