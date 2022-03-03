package br.edu.ifba.inf011.solid;

import java.math.BigDecimal;

import br.edu.ifba.inf011.solid.model.Funcionario;
import br.edu.ifba.inf011.solid.servicos.ReajustadorSalario;

public class App {
	public void run() {
		ReajustadorSalario reajustador = new ReajustadorSalario();
		Funcionario gamma = new Funcionario("Erich Gamma", "0001",
											"00000000000",
											new BigDecimal(1000));
		System.out.println(gamma);
		try {
			reajustador.reajustar(gamma, new BigDecimal(0.1));
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
