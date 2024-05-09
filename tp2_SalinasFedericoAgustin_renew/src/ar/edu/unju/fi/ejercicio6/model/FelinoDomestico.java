package ar.edu.unju.fi.ejercicio6.model;

public class FelinoDomestico {

	private String nombreFelinoDomestico;
	private byte edadFelinoDomestico;
	private float pesoFelinoDomestico;

	public FelinoDomestico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FelinoDomestico(String nombreFelinoDomestico, byte edadFelinoDomestico, float pesoFelinoDomestico) {
		super();
		this.nombreFelinoDomestico = nombreFelinoDomestico;
		this.edadFelinoDomestico = edadFelinoDomestico;
		this.pesoFelinoDomestico = pesoFelinoDomestico;
	}

	public String getNombreFelinoDomestico() {
		return nombreFelinoDomestico;
	}

	public void setNombreFelinoDomestico(String nombreFelinoDomestico) {
		this.nombreFelinoDomestico = nombreFelinoDomestico;
	}

	public byte getEdadFelinoDomestico() {
		return edadFelinoDomestico;
	}

	public void setEdadFelinoDomestico(byte edadFelinoDomestico) {
		this.edadFelinoDomestico = edadFelinoDomestico;
	}

	public float getPesoFelinoDomestico() {
		return pesoFelinoDomestico;
	}

	public void setPesoFelinoDomestico(float pesoFelinoDomestico) {
		this.pesoFelinoDomestico = pesoFelinoDomestico;
	}

	@Override
	public String toString() {
		return "FelinoDomestico [nombreFelinoDomestico=" + nombreFelinoDomestico + ", edadFelinoDomestico="
				+ edadFelinoDomestico + ", pesoFelinoDomestico=" + pesoFelinoDomestico + "]";
	}
}
