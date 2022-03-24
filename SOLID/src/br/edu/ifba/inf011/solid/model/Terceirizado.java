package br.edu.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Terceirizado{

	private String empresa;
	private FichaFuncional ficha;
	
	public Terceirizado(String nome, String matricula, String cpf,
			   BigDecimal salario, String empresa) {
			this(nome, matricula, cpf, salario, LocalDate.now(), empresa);
	}

	public Terceirizado(String nome, String matricula, String cpf,
	   BigDecimal salario, LocalDate dataUltimoReajuste, String empresa) {
		this.ficha = new FichaFuncional(nome, matricula, cpf,
									salario, dataUltimoReajuste);
		this.empresa = empresa;
	}	


	public String getNome() {
		return this.ficha.getNome();
	}
	public String getCpf() {
		return this.ficha.getCpf();
	}
	public BigDecimal getSalario() {
		return this.ficha.getSalario();
	}
	public LocalDate getDataUltimoReajuste() {
		return this.ficha.getDataUltimoReajuste();
	}

	public void setSalario(BigDecimal salario) {
		this.ficha.setSalario(salario);
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.ficha.setDataUltimoReajuste(dataUltimoReajuste);
	}

	public String getMatricula() {
		return this.ficha.getMatricula();
	}
	
	

	public String getEmpresa() {
		return empresa;
	}

	@Override
	public String toString() {
		return "Terceiro [nome=" + this.getNome() + ", cpf=" + this.getCpf() + ", salario=" + this.getSalario() + ", dataUltimoReajuste="
		+ this.getDataUltimoReajuste() + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getCpf());
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terceirizado other = (Terceirizado) obj;
		return Objects.equals(this.getCpf(), other.getCpf());
	}	
	
}	

