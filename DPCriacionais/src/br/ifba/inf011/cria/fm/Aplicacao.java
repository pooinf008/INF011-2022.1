package br.ifba.inf011.cria.fm;

public class Aplicacao {
	
	public void rodar() throws InterruptedException, InstantiationException{
		Ambiente ambiente = new Ambiente();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			ambiente.randomizar();
//			System.out.println("TEMPERATURA: " + ambiente.getTemperatura());
			Thread.sleep(100);
		}
		
	}
	
	
	public static void main(String[] args) throws InstantiationException, InterruptedException {
		(new Aplicacao()).rodar();
	}

}
