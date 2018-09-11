package com.ejemplo.demo.controlador;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.modelo.Usuarios;
import com.ejemplo.demo.servicios.UserServicios;
import com.ejemplo.demo.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserControlador {
	
	@Autowired
	protected UserServicios userServicios;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		
		this.mapper=new ObjectMapper();
		
		Usuarios user=this.mapper.readValue(userJson, Usuarios.class);
		
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"los campos obligatorios no estan diligenciados");
		}
		
		this.userServicios.save(user);
		
		return new RestResponse(HttpStatus.OK.value(),"operacion exitosa");
	
	}
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public List<Usuarios> getUsers() {
		return this.userServicios.findAll();
	}
	
	@RequestMapping(value="/deleteUsers", method=RequestMethod.POST)
	public void deleteUsers(@RequestBody String userJson) throws Exception {

		this.mapper=new ObjectMapper();
		
		Usuarios user=this.mapper.readValue(userJson, Usuarios.class);
		
		if(user.getId()==null) {
			throw new Exception("el Id esta nulo");
		}
		this.userServicios.deleteUsers(user.getId());
	}
	
	
	private boolean validate(Usuarios user) {
		boolean isValid=true;
		
		if(StringUtils.trimToNull(user.getpNombre())==null) {
			isValid=false;
		}
		if(StringUtils.trimToNull(user.getsNombre())==null) {
			isValid=false;
		}
		if(StringUtils.trimToNull(user.getDireccion())==null) {
			isValid=false;
		}
		return isValid;
	}
}
