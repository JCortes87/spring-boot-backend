package com.tienda.springboot.app.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.springboot.app.models.entity.Cliente;
import com.tienda.springboot.app.models.entity.Factura;
import com.tienda.springboot.app.models.entity.ItemFactura;
import com.tienda.springboot.app.models.entity.Producto;
import com.tienda.springboot.app.models.services.IClienteService;
import com.tienda.springboot.app.models.services.IFacturaService;
import com.tienda.springboot.app.models.services.IProductoService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200/" })
@RequestMapping("/api")
public class FacturaRestController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IProductoService productoService;

	@GetMapping("/factura/{clienteId}")
	public Cliente getClienteFactura(@PathVariable Long clienteId) {

		Cliente cliente = clienteService.getCliente(clienteId);
		Factura factura = new Factura();
		factura.setCliente(cliente);

		return factura.getCliente();

	}

	@GetMapping("/factura/productos")
	public List<Producto> getProductos() {
		return productoService.getProductos();
	}

	@PostMapping("/factura/{clienteId}")
	public Factura save(@RequestBody Factura factura, @PathVariable Long clienteId) {

		List<ItemFactura> lines = new ArrayList<>();

		for (int i = 0; i < factura.getItems().size(); i++) {
			Producto prod = productoService.findProductoById(factura.getItems().get(i).getProducto().getId());

			ItemFactura linea = new ItemFactura();
			linea.setCantidad(factura.getItems().get(i).getCantidad());
			linea.setProducto(prod);

			lines.add(i, linea);
		}

		Cliente cliente = clienteService.getCliente(clienteId);
		factura.setItems(lines);
		factura.setCliente(cliente);

		return facturaService.saveFactura(factura);
	}
	
	@GetMapping("/ver/{id}")
	public Factura getFacturaById(@PathVariable Long id){	
		return facturaService.getFacturaById(id);
	}

}
