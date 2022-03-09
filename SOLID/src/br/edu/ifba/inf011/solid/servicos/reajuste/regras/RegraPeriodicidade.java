package br.edu.ifba.inf011.solid.servicos.reajuste.regras;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.edu.ifba.inf011.solid.ValidacaoException;
import br.edu.ifba.inf011.solid.model.Funcionario;

public class RegraPeriodicidade implements Regra{
	
	public void validar(Funcionario funcionario, BigDecimal indice) throws ValidacaoException {
		LocalDate ultimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate now = LocalDate.now();
		if (ChronoUnit.MONTHS.between(ultimoReajuste, now) < 2)
			throw new ValidacaoException("Menos de Dois meses do ultimo aumento");
	}

}
