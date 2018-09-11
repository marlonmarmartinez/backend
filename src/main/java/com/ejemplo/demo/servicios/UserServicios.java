package com.ejemplo.demo.servicios;

import java.util.List;

import com.ejemplo.demo.modelo.Usuarios;

public interface UserServicios {

	/**	
	 * guarda un usuario
	 * @param user
	 * @return el usuario guardado
	 */
	Usuarios save(Usuarios user);

	
	/**	
	 * recupera la lista de usuarios
	 * @return lista de usuarios 
	 */
	List<Usuarios> findAll();

	

}
