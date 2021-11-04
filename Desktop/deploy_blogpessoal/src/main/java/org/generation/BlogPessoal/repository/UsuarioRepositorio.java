package org.generation.BlogPessoal.repository;

import java.util.List;
import java.util.Optional;

import java.lang.String;
import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.model.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
		
	    public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	    public Optional <Usuario> findByNome(String nome);

	    public Optional<Usuario> findByEmail(String email);

		public Object save(UsuarioLogin usuario);
	    
}