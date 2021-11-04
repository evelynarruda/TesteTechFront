package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepositorio extends JpaRepository<Postagem, Long>  {
	
     public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
     
   	public List<Postagem> findAllByDescricaoContainingIgnoreCase(String descricao);
     
     
}