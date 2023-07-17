package com.hotelGeneration.demo.Service;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; //Importacion de la libreria de Spring

import com.hotelGeneration.demo.Entity.User;
import com.hotelGeneration.demo.Repository.UserRepository;

/*
 * Recuerda que la capa de servicios, se encarga de definir la logica de negocio del lado de Java (aqui es donde vamos a definir los metodos enfocados a la operaciones del CRUD que seran "disparados" por los metodos HTTP que se encontraran en el Controller
 * 
 * 
 * */


//Anotaciones son instrucciones que le damo a JAVA para que sepa hacer algo(@Test, @Override)


@Service //Usamos la anotacion @Service para decrile a JAva que esta clase es un servicio.
public class UserService {
	
	//Constante para el autowired
	private final UserRepository userRepository;
	
	//Anotacion
	@Autowired
	
	//Constructor donde se inyecta la dependencia
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//Metodos CRUD para poder iterar sobre esos usuarios
	
	//Metodo para leer todos los usuarios de la BD
	public List<User> readUsuarios(){
		return userRepository.findAll();
		
	}
	
	
	
	//Metodo para borrar usuarios
	
	//Metodo para modificar usuarios
	
	//Metodo para leer usuarios
	
	

} //clase UserService


//public List<User> listaDeUsuarios = new ArrayList<User>();
//
////creo un metodo llamado UserService que me permita agregar informacion a mi lista 
//public UserService() {
//	//Instancias de las personas
//	listaDeUsuarios.add(new User("Felipe", "Maqueda", "felipe@mail.com", "5512345678"));
//	listaDeUsuarios.add(new User("Mariana", "Valladolid", "mariana@mail.com", "3312312312"));
//	listaDeUsuarios.add(new User("Naruto", "Uzumaki", "naruto@mail.com", "5598765432"));
//	
//	
//}
//
////Metodos CRUD para poder iterar sobre esos usuarios 
//
////Metodo para traer a todos los usuarios
//public List<User> readUsuarios(){
//	return listaDeUsuarios; 
//}
