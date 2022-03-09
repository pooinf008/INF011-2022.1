package br.edu.ifba.inf011.solid.servicos.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.ifba.inf011.solid.ValidacaoException;

public interface Reajustavel {
	public void reajustar(BigDecimal salarioCorrigido, LocalDate now) throws ValidacaoException;
	public String getNome();
	public LocalDate getDataUltimoReajuste();
	public BigDecimal getSalario();
}
