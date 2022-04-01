package br.ifba.inf011.cria.afm.atuadores;

import java.lang.reflect.InvocationTargetException;

public abstract class AtuadorFactory {
	
	protected double temperaturaMaxima;
	protected double temperaturaMinima;


 	public static AtuadorFactory getFactory(TipoAtuador tipo, 
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
 		AtuadorFactory factory  = (AtuadorFactory) Class.forName(factoryName).getConstructor().newInstance();
 		factory.setTemperaturaMinima(temperaturaMinima);
 		factory.setTemperaturaMaxima(temperaturaMaxima);
		return factory;
	}	
 
	public AtuadorFactory() {
		this(0, 0);
	}
	
	
	
	public AtuadorFactory(double temperaturaMinima, double temperaturaMaxima) {
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}
	
	public void setTemperaturaMinima(double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}
	
	public void setTemperaturaMaxima(double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}	

	public abstract AtuadorIF criaAtuador(); 

	public AtuadorIF getAtuador() {
		AtuadorIF termometro = this.criaAtuador();
		return termometro;
	}
	
}
