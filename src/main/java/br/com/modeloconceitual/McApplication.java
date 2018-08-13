package br.com.modeloconceitual;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.modeloconceitual.domain.Categoria;
import br.com.modeloconceitual.domain.Produto;
import br.com.modeloconceitual.repositories.CategoriaRepository;
import br.com.modeloconceitual.repositories.ProdutoRepository;

@SpringBootApplication
public class McApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat01 = new Categoria(null, "Informática");
		Categoria cat02 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat01.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat02.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat01));
		p2.getCategorias().addAll(Arrays.asList(cat01, cat02));
		p3.getCategorias().addAll(Arrays.asList(cat01));
		
		categoriaRepository.saveAll(Arrays.asList(cat01, cat02));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
}
