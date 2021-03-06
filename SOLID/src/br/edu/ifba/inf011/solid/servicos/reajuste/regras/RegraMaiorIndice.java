package br.edu.ifba.inf011.solid.servicos.reajuste.regras;

import java.math.BigDecimal;

import br.edu.ifba.inf011.solid.ValidacaoException;
import br.edu.ifba.inf011.solid.servicos.reajuste.Reajustavel;

public class RegraMaiorIndice implements Regra{
	
	public void validar(Reajustavel funcionario, BigDecimal indice) throws ValidacaoException {
		if(indice.compareTo(new BigDecimal("0.3")) > 0)
			throw new ValidacaoException("Indice superior ao permitido");
	}
	

}
