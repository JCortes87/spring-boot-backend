package com.tienda.springboot.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.springboot.app.models.dao.IFacturaDao;
import com.tienda.springboot.app.models.entity.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired
	private IFacturaDao facturaDao;

	@Override
	@Transactional
	public Factura saveFactura(Factura factura) {
		return facturaDao.save(factura);
	}

	@Override
	@Transactional(readOnly = true)
	public Factura getFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

}
