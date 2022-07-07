package br.edu.ifba.inf011.modelo.exercicio;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;

import br.edu.ifba.inf011.modelo.GrupoMuscular;
import br.edu.ifba.inf011.modelo.TipoExercicio;

public class ExercicioCombinado implements Exercicio{
	
	private List<Exercicio> exercicios; 
	private String descricao;
	private String id; 
	
	protected ExercicioCombinado(String id, String descricao, List<Exercicio> exercicios){
		this.id = id;
		this.descricao = descricao;
		this.exercicios = exercicios;
	}
	
	public String getId() {
		return this.id;
	}

	@Override
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public boolean isTipo(TipoExercicio tipo) {
		for(Exercicio exercicio : this.exercicios)
			if(exercicio.isTipo(tipo))
				return true;
		return false;
	}

	@Override
	public boolean isTipo(Collection<TipoExercicio> tipos) {
		for(Exercicio exercicio : this.exercicios)
			if(exercicio.isTipo(tipos))
				return true;
		return false;
	}

	@Override
	public boolean isGrupo(GrupoMuscular grupo) {
		for(Exercicio exercicio : this.exercicios)
			if(exercicio.isGrupo(grupo))
				return true;
		return false;
	}

	@Override
	public boolean isGrupo(Collection<GrupoMuscular> grupos) {
		for(Exercicio exercicio : this.exercicios)
			if(exercicio.isGrupo(grupos))
				return true;
		return false;
	}

	@Override
	public void reproduzir(PrintStream out, int qtde, int numRepeticoes) {
		for(Exercicio exercicio : this.exercicios)
			exercicio.reproduzir(out, qtde, numRepeticoes);
	}
	

}
