package br.edu.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FichaFuncional {
	
	private String nome;
	private String matricula;
	private String cpf;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;
	
	public FichaFuncional(String nome, String matricula, String cpf, BigDecimal salario, LocalDate dataUltimoReajuste) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.salario = salario;
		this.dataUltimoReajuste = dataUltimoReajuste;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}
	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

}
