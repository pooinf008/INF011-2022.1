package br.edu.ifba.inf011.modelo.exercicio;

import java.io.PrintStream;
import java.util.Collection;

import br.edu.ifba.inf011.modelo.GrupoMuscular;
import br.edu.ifba.inf011.modelo.TipoExercicio;

public interface Exercicio {
	public String getDescricao();
	public boolean isTipo(TipoExercicio tipo);
	public boolean isTipo(Collection<TipoExercicio> tipos);	
	public boolean isGrupo(GrupoMuscular grupo);
	public boolean isGrupo(Collection<GrupoMuscular> grupos);
	public void reproduzir(PrintStream out, int qtde, int numRepeticoes);	
}
