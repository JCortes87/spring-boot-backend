package com.tienda.springboot.app.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.springboot.app.models.entity.Producto;
import com.tienda.springboot.app.models.services.IProductoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200/" })
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> getProductos(){
		return productoService.getProductos();
	}
	
	@GetMapping("/producto/buscar/{term}")
	public @ResponseBody List<Producto> getProductos(@PathVariable String term) {
		return productoService.findProductoByNombre(term);
	}
	
	@GetMapping("/productos/{id}")
	public Producto getProductoById(@PathVariable Long id) {
		return productoService.findProductoById(id);
	}
	
	@PostMapping("/productos")
	public Producto createProducto(@RequestBody Producto producto) {
		return productoService.saveProducto(producto);
	}

}
