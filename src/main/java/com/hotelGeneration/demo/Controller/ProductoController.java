package com.hotelGeneration.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelGeneration.demo.Entity.Producto;
import com.hotelGeneration.demo.Service.ProductoService;

@RestController //para indicar que es un controllr 
@RequestMapping (path="/hotelGeneration/productos")

//Anotacion CrossOrigin 
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })

public class ProductoController {
	
	//Inyeccion de dependencias
	
	//Constante
	
	//modificar acceso + constante + nombreClase + nombreDelObjeto
	//public final ClaseGatito Nenito
	//Gatito Nenito = new Gatito(parametros)
	public final ProductoService productoService;
	
	//Anotacion
	@Autowired
	
	//Constructor que utiliza esta instancia
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}//constructor
	
	//Metodos HTTP
	
	//Metodo GET para traer todos los productos
	//localhost:8080/hotelGeneration/productos
	@GetMapping 
	public List<Producto> getTodosLosProductos(){
		return productoService.LeerTodosLosProductos();
	} //getTodosLosProductos
	
	
	//Metodo GET para traer un producto por su id
	@GetMapping (path="{prodId}")
	public Optional<Producto> getProducto(@PathVariable("prodId")Long id) {
		return productoService.leerProductoPorID(id);
		
	}
	
	
	//Metodo POST para agregar un producto
	@PostMapping 
	public Producto postProducto(@RequestBody Producto producto) { //RequestBody es para afectar todo los paramentros dentro del PostMan
		return productoService.crearProducto(producto);
		
	} //post
	
	//Metodo PUT para modificar un producto
	//localhost:8080/hotelGeneation/produtos/2
	@PutMapping(path="{prodId}") //path para agregarle el id el endpoint
	
	public Producto updateProducto(@PathVariable("prodId") Long id, 
			@RequestParam(required=false) String nombre, 
			@RequestParam (required=false)  String descripcion, 
			@RequestParam (required=false) String imagen, 
			@RequestParam (required=false) Double precio) {
		 
		return productoService.actualizarProducto(id, nombre, descripcion, imagen, precio);
		
	} //updateProducto
	
	
	//Metodo DELETE para borrar un producto por su ID
	@DeleteMapping(path="{prodId}")
	public Producto deleteProducto(@PathVariable("prodId")Long id) {
		return productoService.borrarProducto(id);
	}

}
