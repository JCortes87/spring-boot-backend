package com.tienda.springboot.app.models.services;

import java.util.List;

import com.tienda.springboot.app.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> getAllClientes();
	
	public Cliente getCliente(Long id);
	
	public Cliente saveCliente(Cliente cliente);
	
	public void deleteCliente(Long id);
}
