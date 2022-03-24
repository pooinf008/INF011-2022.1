package br.edu.ifba.inf011.solid.servicos.reajuste.regras;

import java.math.BigDecimal;

import br.edu.ifba.inf011.solid.ValidacaoException;
import br.edu.ifba.inf011.solid.servicos.reajuste.Reajustavel;

public interface Regra {
	public void validar(Reajustavel funcionario, BigDecimal indice) throws ValidacaoException;
}
