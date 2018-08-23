package br.com.modeloconceitual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modeloconceitual.domain.Categoria;
import br.com.modeloconceitual.exception.ObjectNotFundException;
import br.com.modeloconceitual.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFundException(
				"Objeto não encontrado! ID: " + id + ", tipo: " + Categoria.class.getName()));
	}
	
	 public Categoria insert(Categoria obj) {
		 obj.setId(null);
		 return repo.save(obj);
	 }
}
