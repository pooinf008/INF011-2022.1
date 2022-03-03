package br.edu.ifba.inf011.solid.servicos;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.ifba.inf011.solid.ValidacaoException;
import br.edu.ifba.inf011.solid.model.Funcionario;

public class ReajustadorSalario {
	
	public void reajustar(Funcionario funcionario, BigDecimal indice) throws ValidacaoException {
		if(indice.compareTo(new BigDecimal("0.3")) > 0)
			throw new ValidacaoException("Indice superior ao permitido");
		BigDecimal salarioCorrigido = funcionario.getSalario().multiply(indice);
		salarioCorrigido = salarioCorrigido.add(funcionario.getSalario());
		funcionario.setSalario(salarioCorrigido);
		funcionario.setDataUltimoReajuste(LocalDate.now());		
	}

}
