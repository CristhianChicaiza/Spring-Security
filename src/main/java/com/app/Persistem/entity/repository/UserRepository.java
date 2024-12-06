package com.app.Persistem.entity.repository;

import com.app.Persistem.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);
}
