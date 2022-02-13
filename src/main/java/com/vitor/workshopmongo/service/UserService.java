package com.vitor.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitor.workshopmongo.domain.User;
import com.vitor.workshopmongo.repository.UserRepository;
import com.vitor.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public Object findById(String id) {
		Optional<User> user = repo.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
}
