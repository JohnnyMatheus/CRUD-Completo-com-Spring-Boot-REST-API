package br.com.alunoti.curso_dev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alunoti.curso_dev_treinamento.model.Usuario;
import br.com.alunoti.curso_dev_treinamento.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	
	@Autowired /* IC/CD OU CDI - injeção de dependencia*/
	private UsuarioRepository usuarioRepository;
	

	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 */
	@RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Curso Spring Boot API " + name + "!";
	}

	@RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String retornaOlaMundo(@PathVariable String nome) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		
		usuarioRepository.save(usuario);/*grava no banco de dados*/
		return "Ola mundo " + nome;
	}
	
	@GetMapping(value = "listatodos")
	@ResponseBody /*Retorna os dados para o corpo da resposta -> retorna JSON*/
	public ResponseEntity<List<Usuario>> listaUsuario(){
		
		List<Usuario> usuario = usuarioRepository.findAll();/*EXECUTA A CONSULTA NO BANCO DE DADOS*/
		
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);/*Retorna a lista em JSON*/
	}
	
	

}
