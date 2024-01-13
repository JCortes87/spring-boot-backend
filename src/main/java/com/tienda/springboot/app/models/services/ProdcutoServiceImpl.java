package com.tienda.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.springboot.app.models.dao.IProductoDao;
import com.tienda.springboot.app.models.entity.Producto;

@Service
public class ProdcutoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> getProductos() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public List<Producto> findProductoByNombre(String term) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Producto saveProducto(Producto producto) {
		return productoDao.save(producto);
	}

}
