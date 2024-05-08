package ar.edu.unju.fi.ejercicio2.model;

public class Efemeride {
	private Integer codigo;
	private String mes;
	private byte día;
	private String detalle;

	public Efemeride() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Efemeride(Integer codigo, String mes, byte día, String detalle) {
		super();
		this.codigo = codigo;
		this.mes = mes;
		this.día = día;
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Efemeride [codigo=" + codigo + ", mes=" + mes + ", día=" + día + ", detalle=" + detalle + "]";
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public byte getDía() {
		return día;
	}

	public void setDía(byte día) {
		this.día = día;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
