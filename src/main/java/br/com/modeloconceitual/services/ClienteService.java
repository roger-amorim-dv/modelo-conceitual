package br.com.modeloconceitual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modeloconceitual.domain.Cliente;
import br.com.modeloconceitual.exception.ObjectNotFundException;
import br.com.modeloconceitual.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFundException(
				"Objeto não encontrado! ID: " + id + ", tipo: " + Cliente.class.getName()));
	}
}
