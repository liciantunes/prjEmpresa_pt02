package com.alicie.prjEmpresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alicie.prjEmpresa.entities.Departamento;
import com.alicie.prjEmpresa.servicies.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
private final DepartamentoService departamentoService;
	
	@Autowired
	public DepartamentoController (DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	@PostMapping
	public Departamento creatDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);
	}
	
	@GetMapping("/{depcodigo}")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable Long depcodigo){
		Departamento departamento = departamentoService.getDepartamentoByid(depcodigo);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	
	@DeleteMapping("/{depcodigo}")
	public void deleteDepartamento(@PathVariable Long depcodigo) {
		departamentoService.deleteDepartamento(depcodigo);
	}
	
	@GetMapping
	public ResponseEntity<List<Departamento>> getAllDepartamento(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Departamento> departamento = departamentoService.getAllDepartamento();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType).body(departamento);
	}
	
	@PutMapping("/{depcodigo}")
	public Departamento updateDepartamento(@PathVariable Long depcodigo, @RequestBody Departamento departamento) {
		return departamentoService.updateDepartamento(depcodigo, departamento);
	}
	
}
