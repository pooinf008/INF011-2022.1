package br.edu.ifba.inf011;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

import br.edu.ifba.inf011.exception.TipoIncompativelException;
import br.edu.ifba.inf011.modelo.Equipamento;
import br.edu.ifba.inf011.modelo.GrupoMuscular;
import br.edu.ifba.inf011.modelo.TipoExercicio;
import br.edu.ifba.inf011.modelo.exercicio.Exercicio;
import br.edu.ifba.inf011.modelo.exercicio.ExercicioBaseBuilder;
import br.edu.ifba.inf011.modelo.exercicio.ExercicioBaseFactory;
import br.edu.ifba.inf011.modelo.exercicio.ExercicioCombinadoBuilder;
import br.edu.ifba.inf011.modelo.exercicio.flyweight.ExercicioBaseFlyBuilder;
import br.edu.ifba.inf011.modelo.programa.Programa;
import br.edu.ifba.inf011.modelo.programa.ProgramaBuilder;
import br.edu.ifba.inf011.modelo.programa.Serie;
import br.edu.ifba.inf011.observer.FimProgramaEvento;
import br.edu.ifba.inf011.observer.FimProgramaSubscriber;
import br.edu.ifba.inf011.singleton.CatalogoEquipamentos;
import br.edu.ifba.inf011.strategy.ABCD;
import br.edu.ifba.inf011.strategy.Cardio;
import br.edu.ifba.inf011.strategy.FullWorkout;
import br.edu.ifba.inf011.strategy.TipoPrograma;

public class Aval3 implements FimProgramaSubscriber{
	
	private  CatalogoEquipamentos ce;
	
	public Aval3(String fileName) throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, IOException {
		this.ce = CatalogoEquipamentos.getCatalogo(fileName);
	}
	
	public Programa createPrograma(ExercicioBaseFactory factoryBase) throws TipoIncompativelException {
		
		Equipamento barra = this.ce.newInstance("Acessorio", "Barra", 1);
		Equipamento peso = this.ce.newInstance("Halteres", "20Kg", 2);
		Equipamento esteira = this.ce.newInstance("Maquina", "Esteira", 1);
		Equipamento cadeira = this.ce.newInstance("Maquina", "Cadeira Extensora", 1);
		Equipamento mesa = this.ce.newInstance("Maquina", "Mesa Flexora", 1);
		
		Exercicio supino = factoryBase
				  .clear().descricao("Supino")
				  .withEquipamento(barra)
				  .withEquipamento(peso)
				  .withGrupoMuscular(GrupoMuscular.Peito)
				  .withGrupoMuscular(GrupoMuscular.Triceps)
				  .withTipo(TipoExercicio.Resistido).build("SUP01");

		Exercicio barraFixa = factoryBase
				  .clear().descricao("Barra")
				  .withEquipamento(barra)
				  .withGrupoMuscular(GrupoMuscular.Costa)
				  .withGrupoMuscular(GrupoMuscular.Biceps)
				  .withTipo(TipoExercicio.Resistido).build("BAR01");

		Exercicio corrida5 = factoryBase
				  .clear().descricao("Corrida em Esteira 5Km")
				  .withEquipamento(esteira)
				  .withTipo(TipoExercicio.Cardiovascular).build("EST12");

		Exercicio quadCadeira = factoryBase
				  .clear().descricao("Quadriceps na Cadeira")
				  .withEquipamento(cadeira)
				  .withGrupoMuscular(GrupoMuscular.Inferiores)
				  .withTipo(TipoExercicio.Resistido).build("QUAD01");

		Exercicio postMesa = factoryBase
				  .clear().descricao("Posteriores na Mesa")
				  .withEquipamento(mesa)
				  .withGrupoMuscular(GrupoMuscular.Inferiores)
				  .withTipo(TipoExercicio.Resistido).build("POS01");
		
		Exercicio apoio = factoryBase
				  .clear().descricao("Apoio")
				  .withGrupoMuscular(GrupoMuscular.Peito)
				  .withGrupoMuscular(GrupoMuscular.Triceps)
				  .withTipo(TipoExercicio.Resistido).build("APO01");

		Exercicio apoSup = ExercicioCombinadoBuilder.getFactory()
				  .clear().descricao("BiSet Apoio-Supino")
				  .withExercicio(apoio)
				  .withExercicio(supino).build("APO-SUP");
		
		Exercicio apoSupCor12 = ExercicioCombinadoBuilder.getFactory()
							  .clear().descricao("BiSet Apoio-Supino + Descanso Ativo Esteira ate 12Km")
							  .withExercicio(apoSup)
							  .withExercicio(corrida5).build("APO-SUP+5K");
		
		Programa programa = ProgramaBuilder.getFactory().clear()
							.withSerie(supino, 4, 15)
							.withSerie(barraFixa, 4, 10)
							.withSerie(corrida5, 1, 1)
							.withSerie(quadCadeira, 4, 12)
							.withSerie(postMesa, 4, 12)
							.withSerie(apoio, 4, 8)
							.withSerie(apoSup, 4, 8)
							.withSerie(apoSupCor12, 4, 6)
							.build();
		return programa;
	}
	
	
	
	public void questao(ExercicioBaseFactory factory, TipoPrograma tipoPrograma, LocalDate data) throws TipoIncompativelException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Programa programa = this.createPrograma(factory);
		programa.addFimProgramaSubscriber(this);
		programa.setProgramaStrategy(tipoPrograma);
		programa.init(data);
		while(programa.temProximo()) {
			Serie serie = programa.proximo();
			serie.executar(System.out);
		}
		
	}	
	
	public void run() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, TipoIncompativelException {
		TipoPrograma tipoPrograma = TipoPrograma.ABCD;
		LocalDate data = LocalDate.of(2022, 7, 7);
		System.out.println("Questão 01");
		this.questao(ExercicioBaseBuilder.getFactory(), tipoPrograma, data);
		System.out.println("Questão 02");
		this.questao(ExercicioBaseFlyBuilder.getFactory(), tipoPrograma, data);
	}
	
	@Override
	public void fimDePrograma(FimProgramaEvento evento) {
		System.out.println(evento);
	}	
	
	public static void main(String[] args) throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, TipoIncompativelException, IOException {
		(new Aval3(args[0])).run();
	}



}
