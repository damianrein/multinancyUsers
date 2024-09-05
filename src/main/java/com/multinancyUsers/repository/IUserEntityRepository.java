package com.multinancyUsers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multinancyUsers.model.UserEntity;

public interface IUserEntityRepository extends JpaRepository<UserEntity, Long> {

}
