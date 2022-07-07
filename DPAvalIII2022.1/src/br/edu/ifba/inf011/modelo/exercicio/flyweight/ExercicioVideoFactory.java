package br.edu.ifba.inf011.modelo.exercicio.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ExercicioVideoFactory {

	private static ExercicioVideoFactory factory;
	
	public static ExercicioVideoFactory getExercicioVideoFactory() {
		if(ExercicioVideoFactory.factory == null)
			ExercicioVideoFactory.factory = new ExercicioVideoFactory();
		return ExercicioVideoFactory.factory;
	}
	
	private Map <String, ExercicioVideo> exerciciosVideos;
	
	private ExercicioVideoFactory() {
		this.exerciciosVideos = new HashMap<String, ExercicioVideo>();
	}
	
	public ExercicioVideo getExercicioVideo(String descricao) {
		ExercicioVideo exercicioVideo = this.exerciciosVideos.get(descricao);
		if(exercicioVideo == null) {
			exercicioVideo = new ExercicioVideo(descricao);
			this.exerciciosVideos.put(descricao, exercicioVideo);
		}
		return exercicioVideo;
	}
	

}
