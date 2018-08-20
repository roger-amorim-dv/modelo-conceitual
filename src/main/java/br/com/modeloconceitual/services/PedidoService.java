package br.com.modeloconceitual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modeloconceitual.domain.Pedido;
import br.com.modeloconceitual.exception.ObjectNotFundException;
import br.com.modeloconceitual.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFundException(
				"Objeto não encontrado! ID: " + id + ", tipo: " + Pedido.class.getName()));
	}
}
