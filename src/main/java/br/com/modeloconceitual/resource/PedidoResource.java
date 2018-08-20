package br.com.modeloconceitual.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.modeloconceitual.domain.Pedido;
import br.com.modeloconceitual.exception.ObjectNotFundException;
import br.com.modeloconceitual.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFundException {
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
