package br.ifba.inf011.cria.fm.termometros;

import java.lang.reflect.InvocationTargetException;

public abstract class TermometroFactory {
	
	public static final int BASICO = 0;
	public static final int ALTA = 1;
	
	
	
	private double temperatura;


 	public static TermometroFactory getFactory(TipoTermometro tipo, double temperatura) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
 		String factoryName = tipo.getFactoryName();
 		TermometroFactory factory  = (TermometroFactory) Class.forName(factoryName).getConstructor().newInstance();
		return factory;
	}	
 
	public TermometroFactory() {
		this(0);
	}
	
	
	
	public TermometroFactory(double temperatura) {
		this.temperatura = temperatura;
	}
	
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public abstract TermometroIF criaTermometro(); 

	public TermometroIF getTermometro() {
		return criaTermometro();
	}
	
}
