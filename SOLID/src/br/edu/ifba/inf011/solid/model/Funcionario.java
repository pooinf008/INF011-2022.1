package br.edu.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario {
	
	private String nome;
	private String matricula;
	private String cpf;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;
	
	public Funcionario(String nome, String matricula, String cpf,
					   BigDecimal salario) {
		this(nome, matricula, cpf, salario, LocalDate.now());
	}
	
	public Funcionario(String nome, String matricula, String cpf,
			   BigDecimal salario, LocalDate dataUltimoReajuste) {
			this.setNome(nome);
			this.setMatricula(matricula);
			this.setCpf(cpf);
			this.setSalario(salario);
			this.setDataUltimoReajuste(dataUltimoReajuste);
	}	
	
	
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}
	

	public String getMatricula() {
		return matricula;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + ", dataUltimoReajuste="
				+ dataUltimoReajuste + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	
	
	
	

}
