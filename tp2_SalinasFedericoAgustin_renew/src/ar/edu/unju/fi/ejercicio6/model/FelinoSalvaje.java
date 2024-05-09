package ar.edu.unju.fi.ejercicio6.model;

public class FelinoSalvaje {

	private String nombreFelinoSalvaje;
	private byte edadFelinoSalvaje;
	private float pesoFelinoSalvaje;

	public FelinoSalvaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FelinoSalvaje(String nombreFelinoSalvaje, byte edadFelinoSalvaje, float pesoFelinoSalvaje) {
		super();
		this.nombreFelinoSalvaje = nombreFelinoSalvaje;
		this.edadFelinoSalvaje = edadFelinoSalvaje;
		this.pesoFelinoSalvaje = pesoFelinoSalvaje;
	}

	public String getNombreFelinoSalvaje() {
		return nombreFelinoSalvaje;
	}

	public void setNombreFelinoSalvaje(String nombreFelinoSalvaje) {
		this.nombreFelinoSalvaje = nombreFelinoSalvaje;
	}

	public byte getEdadFelinoSalvaje() {
		return edadFelinoSalvaje;
	}

	public void setEdadFelinoSalvaje(byte edadFelinoSalvaje) {
		this.edadFelinoSalvaje = edadFelinoSalvaje;
	}

	public float getPesoFelinoSalvaje() {
		return pesoFelinoSalvaje;
	}

	public void setPesoFelinoSalvaje(float pesoFelinoSalvaje) {
		this.pesoFelinoSalvaje = pesoFelinoSalvaje;
	}

	@Override
	public String toString() {
		return "FelinoSalvaje [nombreFelinoSalvaje=" + nombreFelinoSalvaje + ", edadFelinoSalvaje=" + edadFelinoSalvaje
				+ ", pesoFelinoSalvaje=" + pesoFelinoSalvaje + "]";
	}
}
