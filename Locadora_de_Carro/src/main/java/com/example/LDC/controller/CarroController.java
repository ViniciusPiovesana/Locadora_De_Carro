package com.example.LDC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.LDC.model.Carro;
import com.example.LDC.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {
	
	@Autowired
	private CarroRepository carroRepository;
		
	@GetMapping
	public List<Carro> listar(){
		return carroRepository.findAll();	
	}

	@GetMapping("/{id}")
	public Carro listaCarroUnico(@PathVariable(value="id") long id){
		return carroRepository.findById(id);	
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Carro adicionarCarro(@RequestBody Carro carro) {
		return carroRepository.save(carro);
	}
	
	@PutMapping
	public Carro atualizaCarro(@RequestBody Carro carro) {
		return carroRepository.save(carro);
	}
		
	@DeleteMapping
		public void deletaCarro(@RequestBody Carro carro) {
		carroRepository.delete(carro);
	}
	
}
