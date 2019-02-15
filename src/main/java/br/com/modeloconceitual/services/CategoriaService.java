package br.com.modeloconceitual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.modeloconceitual.domain.Categoria;
import br.com.modeloconceitual.domain.DTO.CategoriaDTO;
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
	 
	 public Categoria update(Categoria obj) {
		 find(obj.getId());
		 return repo.save(obj);	 
	 }
	 
	 public void delete(Integer id) {
		  repo.deleteById(id);
	 }
	 
	 public List<Categoria> findAll(){
		 List<Categoria> response = repo.findAll();
		 return response;
	 }
	 
	 public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		 PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		 return repo.findAll(pageRequest);
	 }
	 
	 public Categoria fromDTO(CategoriaDTO objDTO) {
		 return new Categoria(objDTO.getId(), objDTO.getNome());
		 
	 }
}