package com.example.LDC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody Carro carro) {
        Carro novoCarro = carroRepository.save(carro);
        return new ResponseEntity<>(novoCarro, HttpStatus.CREATED);
   }

    
    @PutMapping
    public ResponseEntity<Carro> atualizarProduto(@PathVariable Long id, @RequestBody Carro novoCarro) {
        if (carroRepository.existsById(id)) {
            novoCarro.setId(id); 
            Carro carroAtualizado = carroRepository.save(novoCarro);
            return new ResponseEntity<>(carroAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        if (carroRepository.existsById(id)) {
        	carroRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
