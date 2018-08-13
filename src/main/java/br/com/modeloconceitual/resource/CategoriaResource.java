package br.com.modeloconceitual.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.modeloconceitual.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	/*@RequestMapping(method = RequestMethod.GET)*/
	@GetMapping
	public List<Categoria> listar() {
		
		Categoria cat01 = new Categoria(1, "Informática");
		Categoria cat02 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat01);
		lista.add(cat02);
		
		return lista;
	}
}
