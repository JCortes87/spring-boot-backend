package com.tienda.springboot.app.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.springboot.app.models.entity.Cliente;
import com.tienda.springboot.app.models.services.IClienteService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return clienteService.getAllClientes();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente getClienteById(@PathVariable Long id) {
		return clienteService.getCliente(id);
	}
	
	@PostMapping("/clientes")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		
		Cliente clienteActual = clienteService.getCliente(id);
		
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setCorreo(cliente.getCorreo());
		clienteActual.setFoto(cliente.getFoto());
		
		return clienteService.saveCliente(clienteActual);
	}
	
	@DeleteMapping("/clientes/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteService.deleteCliente(id);
	}

}
