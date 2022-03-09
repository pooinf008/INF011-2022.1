package br.edu.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import br.edu.ifba.inf011.solid.ValidacaoException;
import br.edu.ifba.inf011.solid.servicos.reajuste.Reajustavel;

public class Funcionario implements Reajustavel{

	
	private FichaFuncional ficha;
	private Cargo cargo;

	public Funcionario(String nome, String matricula, String cpf,
					   BigDecimal salario) {
		this(nome, matricula, cpf, salario, LocalDate.now(), Cargo.TRAINEE);
	}
	
	public Funcionario(String nome, String matricula, String cpf,
			   BigDecimal salario, LocalDate dataUltimoReajuste, Cargo cargo) {
			this.ficha = new FichaFuncional(nome, matricula, cpf,
											salario, dataUltimoReajuste);
			this.cargo = cargo;
	}	
	
	public void promover() {
		this.cargo = this.cargo.proximo();
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
	
	public void reajustar(BigDecimal salario, LocalDate dataUltimoReajuste) throws ValidacaoException {
		this.setSalario(salario);
		this.setDataUltimoReajuste(dataUltimoReajuste);
	}
	
	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.ficha.setDataUltimoReajuste(dataUltimoReajuste);
	}

	public String getMatricula() {
		return this.ficha.getMatricula();
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + this.getNome() + ", cpf=" + this.getCpf() + ", salario=" + this.getSalario() + ", dataUltimoReajuste="
				+ this.getDataUltimoReajuste() + ", cargo= " + this.getCargo() + "]";
	}

	private Cargo getCargo() {
		return this.cargo;
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(this.getCpf(), other.getCpf());
	}
	
	
	

}
