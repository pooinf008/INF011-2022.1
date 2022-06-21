package br.ifba.inf011.estrut.decorator.report;

public class LinhaId implements Linha{

	private Integer id;
	private double energia;
	private double setpoint;
	private double temperatura;
	
	public LinhaId(int id, double energia, double setpoint, double temperatura) {
		this.id = id;
		this.energia = energia;
		this.setpoint = setpoint;
		this.temperatura = temperatura;
	}

	@Override
	public String content() {
		return id.toString();
	}

	@Override
	public double getEnergia() {
		return this.energia;
	}

	@Override
	public double getSetpoint() {
		return this.setpoint;
	}

	@Override
	public double getTemperatura() {
		return this.temperatura;
	}

}
