package com.alicie.prjEmpresa.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alicie.prjEmpresa.entities.Departamento;
import com.alicie.prjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public DepartamentoService (DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
	
	public Departamento saveDepartamento (Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	public List<Departamento> getAllDepartamento(){
		return departamentoRepository.findAll();
	}
	
	public Departamento getDepartamentoByid(Long depcodigo) {
		return departamentoRepository.findById(depcodigo).orElse(null);
	}
	
	public void deleteDepartamento(Long depcodigo) {
		departamentoRepository.deleteById(depcodigo);
	}
	
	public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
        Optional<Departamento> departamentoOptional = departamentoRepository.findById(depcodigo);
        if (departamentoOptional.isPresent()) {
        	Departamento departamentoExistente = departamentoOptional.get();
           	departamentoExistente.setDepnome(novoDepartamento.getDepnome());
            return departamentoRepository.save(departamentoExistente); 
        } else {
            return null; 
        }
	}
}


