package br.ifba.inf011.cria.fm.termometros;

import java.lang.reflect.InvocationTargetException;

public abstract class TermometroFactory {
	
	public static final int BASICO = 0;
	public static final int ALTA = 1;
	
	
	
	protected double temperaturaMaxima;
	protected double temperaturaMinima;


 	public static TermometroFactory getFactory(TipoTermometro tipo, 
 											   double temperaturaMinima,
 											   double temperaturaMaxima) 
 													   throws InstantiationException, 
 													   		  IllegalAccessException, 
 													   		  ClassNotFoundException, 
 													   		  IllegalArgumentException, 
 													   		  InvocationTargetException, 
 													   		  NoSuchMethodException, 
 													   		  SecurityException {
 		String factoryName = tipo.getFactoryName();
 		TermometroFactory factory  = (TermometroFactory) Class.forName(factoryName).getConstructor().newInstance();
 		factory.setTemperaturaMinima(temperaturaMinima);
 		factory.setTemperaturaMaxima(temperaturaMaxima);
		return factory;
	}	
 
	public TermometroFactory() {
		this(0, 0);
	}
	
	
	
	public TermometroFactory(double temperaturaMinima, double temperaturaMaxima) {
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}
	
	public void setTemperaturaMinima(double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}
	
	public void setTemperaturaMaxima(double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}	

	public abstract TermometroIF criaTermometro(); 

	public TermometroIF getTermometro() {
		TermometroIF termometro = this.criaTermometro();
		return termometro;
	}
	
}
