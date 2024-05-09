package ar.edu.unju.fi.ejercicio5.model;

import java.util.Scanner;

public class Producto {
	private Integer codigoProducto;
	private String descripcionProducto;
	private double precioUnitatioProducto;
	private origenFabricacionProducto origenFabricacion;
	private categoriaProducto categoria;
	private boolean estado;

	public enum origenFabricacionProducto {
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}

	public enum categoriaProducto {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto() {
		super();
	}

	public Producto(Integer codigoProducto, String descripcionProducto, double precioUnitatioProducto,
			origenFabricacionProducto origenFabricacion, categoriaProducto categoria, boolean estado) {
		super();
		this.codigoProducto = codigoProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioUnitatioProducto = precioUnitatioProducto;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", descripcionProducto=" + descripcionProducto
				+ ", precioUnitatioProducto=" + precioUnitatioProducto + ", origenFabricacion=" + origenFabricacion
				+ ", categoria=" + categoria + ", estado=" + estado + "]";
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public double getPrecioUnitatioProducto() {
		return precioUnitatioProducto;
	}

	public void setPrecioUnitatioProducto(double precioUnitatioProducto) {
		this.precioUnitatioProducto = precioUnitatioProducto;
	}

	public origenFabricacionProducto getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(origenFabricacionProducto origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public categoriaProducto getCategoria() {
		return categoria;
	}

	public void setCategoria(categoriaProducto categoria) {
		this.categoria = categoria;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public origenFabricacionProducto menuOrigenDeFabricacion(Scanner teclado) {
		byte opc = 0;
		origenFabricacionProducto origen = null;
		do {
			System.out.println("-----------------------");
			System.out.println("----Origen de fabricación----");
			System.out.println("1 - Argentina");
			System.out.println("2 - China");
			System.out.println("3 - Brasil");
			System.out.println("4 - Uruguay");
			try {
				System.out.print("Elija una opción: ");
				opc = teclado.nextByte();
				if (opc < 1 || opc > 4) {
					throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 4");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				teclado.nextLine();
				opc = 0;
			}
			switch (opc) {
			case 1:
				origen = origenFabricacionProducto.ARGENTINA;
				break;
			case 2:
				origen = origenFabricacionProducto.CHINA;
				break;
			case 3:
				origen = origenFabricacionProducto.BRASIL;
				break;
			case 4:
				origen = origenFabricacionProducto.URUGUAY;
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		} while (opc == 0);
		return origen;
	}

	public categoriaProducto menuCategoriaProducto(Scanner teclado) {
		byte opc = 0;
		categoriaProducto categoria = null;
		do {
			System.out.println("-----------------------");
			System.out.println("----Categoría----");
			System.out.println("1 - Telefonía");
			System.out.println("2 - Informática");
			System.out.println("3 - Electro Hogar");
			System.out.println("4 - Herramientas");
			try {
				System.out.print("Elija una opción: ");
				opc = teclado.nextByte();
				if (opc < 1 || opc > 4) {
					throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 4");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				teclado.nextLine();
				opc = 0;
			}
			switch (opc) {
			case 1:
				categoria = categoriaProducto.TELEFONIA;
				break;
			case 2:
				categoria = categoriaProducto.INFORMATICA;
				break;
			case 3:
				categoria = categoriaProducto.ELECTROHOGAR;
				break;
			case 4:
				categoria = categoriaProducto.HERRAMIENTAS;
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		} while (opc == 0);
		return categoria;
	}
}
