package br.edu.ifba.inf011.solid.servicos.reajuste.regras;

import java.math.BigDecimal;

import br.edu.ifba.inf011.solid.ValidacaoException;
import br.edu.ifba.inf011.solid.model.Funcionario;

public class RegraNegadoLetraE implements Regra {

	@Override
	public void validar(Funcionario funcionario, BigDecimal indice) throws ValidacaoException {
		if(funcionario.getNome().startsWith("E"))
			throw new ValidacaoException("Quem come�a com E n�o pode ter aumento");
	}

}
