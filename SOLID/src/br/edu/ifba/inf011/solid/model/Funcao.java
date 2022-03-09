package br.edu.ifba.inf011.solid.model;

public enum Funcao {
	
	SUPERVISOR {
		@Override
		public int getSalario() {
			// TODO Auto-generated method stub
			return 5000;
		}
	}, GERENTE {
		@Override
		public int getSalario() {
			// TODO Auto-generated method stub
			return 1000;
		}
	};
	
	public abstract int getSalario();
	
	
}
