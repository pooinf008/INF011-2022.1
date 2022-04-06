package br.ifba.inf011.cria.afm.controle;

import java.lang.reflect.InvocationTargetException;

public abstract class ControleFactory {
	
	protected double temperaturaMaxima;
	protected double temperaturaMinima;


 	public static ControleFactory getFactory(TipoControle tipo, 
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
 		ControleFactory factory  = (ControleFactory) Class.forName(factoryName).getConstructor().newInstance();
 		factory.setTemperaturaMinima(temperaturaMinima);
 		factory.setTemperaturaMaxima(temperaturaMaxima);
		return factory;
	}	
 
	public ControleFactory() {
		this(0, 0);
	}
	
	
	
	public ControleFactory(double temperaturaMinima, double temperaturaMaxima) {
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}
	
	public void setTemperaturaMinima(double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}
	
	public void setTemperaturaMaxima(double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}	

	public abstract ControleIF criaControle(); 

	public ControleIF getControle() {
		ControleIF termometro = this.criaControle();
		return termometro;
	}
	
}
