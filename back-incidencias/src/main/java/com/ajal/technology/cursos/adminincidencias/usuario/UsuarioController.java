package com.ajal.technology.cursos.adminincidencias.usuario;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("usuarios")
@CrossOrigin
public class UsuarioController {
	
	@Autowired UsuarioRepository usuarioRepository;
	

	@GetMapping
	public ResponseEntity<List<Usuario>> get(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario usuario){
		Usuario persist = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(persist, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Integer id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deleteById(@PathVariable Integer id){
		Optional<Usuario> persist = usuarioRepository.findById(id);
		if (persist.isPresent()) {
			usuarioRepository.deleteById(id);
			return new ResponseEntity<Usuario>(persist.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateById(@PathVariable Integer id, @Valid @RequestBody Usuario update){
		Optional<Usuario> persist = usuarioRepository.findById(id);
		if (persist.isPresent()) {
			Usuario usuario = persist.get();
			usuario.setNombreUsuario(update.getNombreUsuario());
			usuario.setContrasena(update.getContrasena());
			usuario.setTipoUsuario(update.getTipoUsuario());
			usuario = usuarioRepository.save(usuario);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
