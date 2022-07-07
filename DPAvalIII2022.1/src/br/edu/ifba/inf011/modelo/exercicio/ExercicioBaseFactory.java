package br.edu.ifba.inf011.modelo.exercicio;

import br.edu.ifba.inf011.modelo.Equipamento;
import br.edu.ifba.inf011.modelo.GrupoMuscular;
import br.edu.ifba.inf011.modelo.TipoExercicio;

public interface ExercicioBaseFactory {
	public ExercicioBaseFactory clear();
	public ExercicioBaseFactory descricao(String descricao);
	public ExercicioBaseFactory withTipo(TipoExercicio tipo);
	public ExercicioBaseFactory withGrupoMuscular(GrupoMuscular grupo);
	public ExercicioBaseFactory withEquipamento(Equipamento equipamento);	
	public Exercicio build(String id);
}
