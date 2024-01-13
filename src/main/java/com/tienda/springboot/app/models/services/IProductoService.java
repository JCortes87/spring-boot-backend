package com.tienda.springboot.app.models.services;

import java.util.List;

import com.tienda.springboot.app.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> getProductos();
	
	public Producto findProductoById(Long id);

	public List<Producto> findProductoByNombre(String term);
	
	public Producto saveProducto(Producto producto);

}
