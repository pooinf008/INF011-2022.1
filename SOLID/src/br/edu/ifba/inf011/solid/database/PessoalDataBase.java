package br.edu.ifba.inf011.solid.database;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.solid.model.Cargo;
import br.edu.ifba.inf011.solid.model.Funcionario;
import br.edu.ifba.inf011.solid.model.Terceirizado;

public class PessoalDataBase {
	
	private Map<String, Funcionario> funcionarios;
	private Map<String, Terceirizado> terceiros;
		
	public PessoalDataBase() {
			this.funcionarios = new HashMap<String, Funcionario>();
			this.terceiros = new HashMap<String, Terceirizado>();
			this.carregar();
	}
		
		
	public void carregar() {
		Funcionario erich = new Funcionario("ERICH GAMMA", "001", "11111111111", new BigDecimal(10000), LocalDate.of(2020, 12, 01), Cargo.TRAINEE);
		Funcionario helm = new Funcionario("RICHARD HELM", "002", "22222222222", new BigDecimal(12000), LocalDate.of(2020, 12, 01), Cargo.SENIOR);
		Funcionario ralph = new Funcionario("RALPH JOHNSON", "003", "33333333333", new BigDecimal(11000));
		Funcionario john = new Funcionario("JOHN VLISSIDES", "004", "44444444444", new BigDecimal(15000));
		Terceirizado bob = new Terceirizado("UNCLE BOB", "005", "55555555555", new BigDecimal(20000), LocalDate.of(2020, 12, 01), "OO COMPANY");		
		this.funcionarios.put(erich.getCpf(), erich);
		this.funcionarios.put(helm.getCpf(), helm);
		this.funcionarios.put(ralph.getCpf(), ralph);
		this.funcionarios.put(john.getCpf(), john);
		this.terceiros.put(bob.getCpf(), bob);
	}

	public Funcionario findFuncionario(String cpf) {
		return this.funcionarios.get(cpf);
	}
	
	public Terceirizado findTerceirizado(String cpf) {
		return this.terceiros.get(cpf);
	}
	

	public Collection<Funcionario> findAllFuncionarios() {
		List<Funcionario> todos = new ArrayList<Funcionario>(this.funcionarios.values());
		return todos;
	}
	
	public Collection<Terceirizado> findAllTerceirizado() {
		List<Terceirizado> todos = new ArrayList<Terceirizado>(this.terceiros.values());
		return todos;
	}
	

}
