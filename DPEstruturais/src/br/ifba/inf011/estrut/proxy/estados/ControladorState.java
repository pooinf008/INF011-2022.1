package br.ifba.inf011.estrut.proxy.estados;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.estrut.proxy.Sala;
import br.ifba.inf011.estrut.proxy.AmbienteIF;

public interface ControladorState {
	
	public ControladorState salvarEnergia() throws Exception;
	public ControladorState desligar() throws Exception;
	public ControladorState recarregar() throws Exception;
	public ControladorState ligar() throws Exception;
	public double controlar(AmbienteIF ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception;
	public TipoEstado quemSouEu();
}
