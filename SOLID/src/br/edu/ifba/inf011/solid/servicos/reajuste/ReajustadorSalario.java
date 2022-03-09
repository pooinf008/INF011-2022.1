package br.edu.ifba.inf011.solid.servicos.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import br.edu.ifba.inf011.solid.ValidacaoException;
import br.edu.ifba.inf011.solid.model.Funcionario;
import br.edu.ifba.inf011.solid.servicos.reajuste.regras.Regra;
import br.edu.ifba.inf011.solid.servicos.reajuste.regras.RegraMaiorIndice;
import br.edu.ifba.inf011.solid.servicos.reajuste.regras.RegraMenorIndice;
import br.edu.ifba.inf011.solid.servicos.reajuste.regras.RegraPeriodicidade;

public class ReajustadorSalario {
	
	private List<Regra> regras;
	
	public ReajustadorSalario(List<Regra> regras) {
		this.regras = regras;
	}
	
	
	public void reajustar(Reajustavel funcionario, BigDecimal indice) throws ValidacaoException {
		 
		for(Regra r : this.regras)
			r.validar(funcionario, indice);
		
		BigDecimal salarioCorrigido = funcionario.getSalario().multiply(indice);
		salarioCorrigido = salarioCorrigido.add(funcionario.getSalario());
		
		funcionario.reajustar(salarioCorrigido, LocalDate.now());
		
	}


}
