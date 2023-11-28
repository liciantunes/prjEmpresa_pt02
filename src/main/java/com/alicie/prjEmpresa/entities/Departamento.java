package com.alicie.prjEmpresa.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_Departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depcodigo;

	private String depnome;
	
	
	
	public Long getDepcodigo() {
		return depcodigo;
	}


	public void setDepcodigo(Long depcodigo) {
		this.depcodigo = depcodigo;
	}


	public String getDepnome() {
		return depnome;
	}


	public void setDepnome(String depnome) {
		this.depnome = depnome;
	}
	public Departamento() {
	       
	   }    

	   public Departamento(Long depcodigo, String depnome, List<Funcionario> funcionarios) {
	       super();
	       this.depcodigo = depcodigo;
	       this.depnome = depnome;        
	   }

}
