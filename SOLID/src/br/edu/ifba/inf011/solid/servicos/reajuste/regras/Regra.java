package br.edu.ifba.inf011.solid.servicos.reajuste.regras;

import java.math.BigDecimal;

import br.edu.ifba.inf011.solid.ValidacaoException;
import br.edu.ifba.inf011.solid.model.Funcionario;

public interface Regra {
	public void validar(Funcionario funcionario, BigDecimal indice) throws ValidacaoException;
}
