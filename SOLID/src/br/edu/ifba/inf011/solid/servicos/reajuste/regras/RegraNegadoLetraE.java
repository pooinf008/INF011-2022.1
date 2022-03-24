package br.edu.ifba.inf011.solid.servicos.reajuste.regras;

import java.math.BigDecimal;

import br.edu.ifba.inf011.solid.ValidacaoException;
import br.edu.ifba.inf011.solid.servicos.reajuste.Reajustavel;

public class RegraNegadoLetraE implements Regra {

	@Override
	public void validar(Reajustavel funcionario, BigDecimal indice) throws ValidacaoException {
		if(funcionario.getNome().startsWith("E"))
			throw new ValidacaoException("Quem come�a com E n�o pode ter aumento");
	}

}
