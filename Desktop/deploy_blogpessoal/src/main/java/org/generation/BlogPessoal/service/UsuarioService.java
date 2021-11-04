package org.generation.BlogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.model.UsuarioLogin;
import org.generation.BlogPessoal.model.dtos.CredenciaisDTO;
import org.generation.BlogPessoal.model.dtos.UsuarioLoginDTO;
import org.generation.BlogPessoal.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UsuarioService {

	@Autowired
	private static UsuarioRepositorio repositorio;
	
	private static String encriptadorDeSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}


	public Optional<Object> cadastrarUsuario(Usuario usuario) {
		return repositorio.findByEmail(usuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			return Optional.ofNullable(repositorio.save(usuario));
		});
	}
	
	public Optional<UsuarioLogin> Logar (Optional<UsuarioLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repositorio.findByEmail(user.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setIdUsuario(usuario.get().getIdUsuario());
				user.get().setToken(authHeader);				
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());

				return user;
			}
		}
		return null;
	}
	
	public Optional<Usuario> atualizarUsuario(Usuario usuarioParaAtualizar) {
		return repositorio.findById(usuarioParaAtualizar.getIdUsuario()).map(resp -> {
			resp.setNome(usuarioParaAtualizar.getNome());
			resp.setSenha(encriptadorDeSenha(usuarioParaAtualizar.getSenha()));
			return Optional.ofNullable(repositorio.save(resp));
		}).orElseGet(() -> {
			return Optional.empty();
		});

	}
	
	
	private static String gerarToken(String email, String senha) {
		String estrutura = email + ":" + senha;
		byte[] estruturaBase64 = Base64.encodeBase64(estrutura.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(estruturaBase64);
	}
		
	public ResponseEntity<CredenciaisDTO> pegarCredenciais(UsuarioLoginDTO usuarioParaAutenticar) {
		return repositorio.findByEmail(usuarioParaAutenticar.getEmail()).map(resp -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(usuarioParaAutenticar.getSenha(), resp.getSenha())) {

				CredenciaisDTO objetoCredenciaisDTO = new CredenciaisDTO();

				objetoCredenciaisDTO.setToken(gerarToken(usuarioParaAutenticar.getEmail(), usuarioParaAutenticar.getSenha()));
				objetoCredenciaisDTO.setIdUsuario(resp.getIdUsuario());
				objetoCredenciaisDTO.setNome(resp.getNome());
				objetoCredenciaisDTO.setEmail(resp.getEmail());
				objetoCredenciaisDTO.setSenha(resp.getSenha());
				objetoCredenciaisDTO.setFoto(resp.getFoto());
				objetoCredenciaisDTO.setTipo(resp.getTipo());

				return ResponseEntity.status(201).body(objetoCredenciaisDTO); // Usuario Credenciado
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha Incorreta!"); // Senha incorreta
			}
		}).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email não existe!"); // Email não existe
		});


		
		
	

	


}

	
	}


	
	

	
	


