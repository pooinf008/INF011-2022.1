package br.edu.ifba.inf011.modelo.exercicio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.modelo.Equipamento;
import br.edu.ifba.inf011.modelo.GrupoMuscular;
import br.edu.ifba.inf011.modelo.TipoExercicio;

public class ExercicioBaseBuilder implements ExercicioBaseFactory{

	private String descricao;	
	private List<TipoExercicio> tipos;
	private List<GrupoMuscular> gruposMusculares;
	private List<Equipamento> equipamentos;	
	
	
	public static ExercicioBaseBuilder getFactory() {
		return new ExercicioBaseBuilder();
	}
	
	@Override
	public ExercicioBaseFactory clear() {
		this.descricao = null;
		this.tipos = new ArrayList<TipoExercicio>();
		this.gruposMusculares = new ArrayList<GrupoMuscular>();
		this.equipamentos = new ArrayList<Equipamento>();
		return this;
	}

	@Override
	public ExercicioBaseFactory descricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	@Override
	public ExercicioBaseFactory withTipo(TipoExercicio tipo) {
		this.tipos.add(tipo);
		return this;
	}

	@Override
	public ExercicioBaseFactory withGrupoMuscular(GrupoMuscular grupo) {
		this.gruposMusculares.add(grupo);
		return this;
	}

	@Override
	public ExercicioBaseFactory withEquipamento(Equipamento equipamento) {
		this.equipamentos.add(equipamento);
		return this;
	}

	@Override
	public ExercicioBase build(String id) {
		return new ExercicioBase(id, this.descricao, tipos, gruposMusculares, equipamentos);
	}

}
