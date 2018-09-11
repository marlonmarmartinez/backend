package com.ejemplo.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.dao.UserRepository;
import com.ejemplo.demo.modelo.Usuarios;

@Service
public class UserServiciosimp implements UserServicios {
	
	@Autowired
	protected UserRepository userRepository;

	@Override
	public Usuarios save(Usuarios user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<Usuarios> findAll() {
		
		return this.userRepository.findAll();
	}
	
}
