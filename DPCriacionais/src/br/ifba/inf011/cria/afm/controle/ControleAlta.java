package br.ifba.inf011.cria.afm.controle;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.cria.afm.atuadores.AtuadorFactory;
import br.ifba.inf011.cria.afm.atuadores.AtuadorIF;
import br.ifba.inf011.cria.afm.atuadores.TipoAtuador;
import br.ifba.inf011.cria.afm.termometros.TermometroFactory;
import br.ifba.inf011.cria.afm.termometros.TermometroIF;
import br.ifba.inf011.cria.afm.termometros.TipoTermometro;

public class ControleAlta implements ControleIF {
	
	private double maxima;
	
	public ControleAlta(double maxima){
			this.maxima = maxima;
	}

	@Override
	public TermometroIF getTermometro() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return 	TermometroFactory
				.getFactory(TipoTermometro.ALTA, Double.NaN, maxima)
				.getTermometro();		
	}

	@Override
	public AtuadorIF getAtuador() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return AtuadorFactory
				.getFactory(TipoAtuador.RESFRIADOR, Double.NaN, maxima)
				.getAtuador();
	}

}
