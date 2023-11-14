package com.example.LDC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
