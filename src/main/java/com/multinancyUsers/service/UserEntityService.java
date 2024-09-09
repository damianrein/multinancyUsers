package com.multinancyUsers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multinancyUsers.model.UserEntity;
import com.multinancyUsers.repository.IUserEntityRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserEntityService {

	@Autowired
	private IUserEntityRepository userRepo;
	@PersistenceContext
	private EntityManager entityManager;
	
	public UserEntityService(IUserEntityRepository userRepo, EntityManager entityManager) {
		this.userRepo = userRepo;
		this.entityManager = entityManager;
	}

	public void registerUser(UserEntity user) {
		userRepo.save(user);
		String schemaName = "schema_" + user.getId();
		createSchema(schemaName);
	}
	
	@Transactional
	private void createSchema(String schemaName) {
		String sql = "CREATE SCHEMA IF NOT EXISTS " + schemaName;
		entityManager.createNativeQuery(sql).executeUpdate();
	}
	
	public List<UserEntity> getAllUsers(){
		return userRepo.findAll();
	}
}
