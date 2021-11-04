package org.generation.BlogPessoal.repository;

import java.util.List;

import javax.validation.Valid;

import org.generation.BlogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TemaRepositorio extends JpaRepository<Tema, Long> {


	public List<Tema> findAllByTemaContainingIgnoreCase(String tema);


}