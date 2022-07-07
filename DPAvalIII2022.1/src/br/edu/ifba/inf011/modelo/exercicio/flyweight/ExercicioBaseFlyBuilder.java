package br.edu.ifba.inf011.modelo.exercicio.flyweight;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.modelo.Equipamento;
import br.edu.ifba.inf011.modelo.GrupoMuscular;
import br.edu.ifba.inf011.modelo.TipoExercicio;
import br.edu.ifba.inf011.modelo.exercicio.ExercicioBaseFactory;

public class ExercicioBaseFlyBuilder implements ExercicioBaseFactory{

	private String descricao;	
	private List<TipoExercicio> tipos;
	private List<GrupoMuscular> gruposMusculares;
	private List<Equipamento> equipamentos;	
	
	
	public static ExercicioBaseFlyBuilder getFactory() {
		return new ExercicioBaseFlyBuilder();
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
	public ExercicioBaseFly build(String id) {
		ExercicioVideo exercicioVideo = ExercicioVideoFactory.getExercicioVideoFactory().getExercicioVideo(descricao);
		return new ExercicioBaseFly(id, exercicioVideo, tipos, gruposMusculares, equipamentos);
	}

}
