package br.ifba.inf011.estrut.proxy.servico;

public class CategoriaServico {
	
	public char getCategoria(double energia, double setpoint, double temperatura) {
		
		double diferenca = Math.abs(temperatura - setpoint) / setpoint;
		if(temperatura >= 0.75) {
			if(diferenca < 0.05)
				return 'A';
			else if (diferenca < 0.1)
				return 'B';
			else 
				return 'C';
		}else if(temperatura >= 0.5) {
			if(diferenca < 0.05)
				return 'B';
			else if (diferenca < 0.1)
				return 'C';
			else if (diferenca < 0.15)
				return 'D';
			else 
				return 'E';
		}else if(temperatura >= 0.25) {	
			if(diferenca < 0.05)
				return 'B';
			else if (diferenca < 0.1)
				return 'D';
			else 
				return 'E';
		}else {
			if(diferenca < 0.05)
				return 'B';
			else
				return 'E';
		}
	}	
		

}
