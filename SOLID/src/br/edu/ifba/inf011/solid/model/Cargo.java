package br.edu.ifba.inf011.solid.model;

public enum Cargo {
	
	TRAINEE {
		@Override
		public Cargo proximo() {
			return Cargo.JUNIOR;
		}
	},
	JUNIOR {
		@Override
		public Cargo proximo() {
			return Cargo.PLENO;
		}
	},
	PLENO {
		@Override
		public Cargo proximo() {
			return Cargo.SENIOR;
		}
	},
	SENIOR {
		@Override
		public Cargo proximo() {
			return Cargo.SENIOR;
		}
	};

	public abstract Cargo proximo();

}
