package com.tienda.springboot.app.models.services;

import com.tienda.springboot.app.models.entity.Factura;


public interface IFacturaService {

	public Factura saveFactura(Factura factura);
	
	public Factura getFacturaById(Long id);
	
}
