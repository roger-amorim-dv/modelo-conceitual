package br.com.modeloconceitual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.modeloconceitual.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
