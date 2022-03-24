package br.edu.ifba.inf011.solid;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.solid.database.PessoalDataBase;
import br.edu.ifba.inf011.solid.model.Funcionario;
import br.edu.ifba.inf011.solid.servicos.reajuste.ReajustadorSalario;
import br.edu.ifba.inf011.solid.servicos.reajuste.regras.Regra;
import br.edu.ifba.inf011.solid.servicos.reajuste.regras.RegraMaiorIndice;
import br.edu.ifba.inf011.solid.servicos.reajuste.regras.RegraMenorIndice;
import br.edu.ifba.inf011.solid.servicos.reajuste.regras.RegraPeriodicidade;

public class App {
	
	private PessoalDataBase database;
	
	public App() {
		this.database = new PessoalDataBase();
		
	}
	
	//acetilcisteína
	public void run() {
		
		List<Regra> regras = new ArrayList<Regra>();
		regras.add(new RegraMaiorIndice());
		regras.add(new RegraMenorIndice());
		regras.add(new RegraPeriodicidade());
		
		ReajustadorSalario reajustador = new ReajustadorSalario(regras);
		Funcionario gamma = this.database.findFuncionario("11111111111");
		System.out.println(gamma);
		try {
			reajustador.reajustar(gamma, new BigDecimal(0.2));
		} catch (ValidacaoException e) {
			System.err.println("Reajuste não pode ser aplicado " + e.getMessage());
		}finally {
			System.out.println(gamma);
		}
		
		
	}
	
	
	public static void main(String[] args){
		(new App()).run();	
	}

}
