package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.categoriaProducto;
import ar.edu.unju.fi.ejercicio5.model.Producto.origenFabricacionProducto;

public class Main {

	public static void main(String[] args) {
		byte opcion;
		Integer codigoProducto;
		String respuesta;
		boolean carga = false;
		double montoTotal = 0.0;
		Scanner teclado = new Scanner(System.in);

		List<Producto> listaProductos = new ArrayList<>();
		List<Producto> listaCompra = new ArrayList<>();

		Producto producto = new Producto();
		listaProductos.add(new Producto(1234, "Taladro", 1123.22, origenFabricacionProducto.ARGENTINA,
				categoriaProducto.HERRAMIENTAS, true));
		listaProductos.add(new Producto(5555, "Samsung A54", 10000.00, origenFabricacionProducto.ARGENTINA,
				categoriaProducto.TELEFONIA, true));
		listaProductos.add(new Producto(2211, "Lavaropas LG", 400000.22, origenFabricacionProducto.URUGUAY,
				categoriaProducto.ELECTROHOGAR, false));
		listaProductos.add(new Producto(4222, "Asus Notebook", 50000.22, origenFabricacionProducto.CHINA,
				categoriaProducto.INFORMATICA, true));
		listaProductos.add(new Producto(2636, "MotoSierra", 610000.22, origenFabricacionProducto.BRASIL,
				categoriaProducto.HERRAMIENTAS, false));
		listaProductos.add(new Producto(4121, "Mac Book", 4000000, origenFabricacionProducto.URUGUAY,
				categoriaProducto.INFORMATICA, true));
		listaProductos.add(new Producto(5688, "Heladera Samsung", 500000, origenFabricacionProducto.BRASIL,
				categoriaProducto.ELECTROHOGAR, false));
		listaProductos.add(new Producto(7896, "Smart Watch", 350000.99, origenFabricacionProducto.CHINA,
				categoriaProducto.TELEFONIA, true));
		listaProductos.add(new Producto(7496, "JBL Buds", 80000.01, origenFabricacionProducto.ARGENTINA,
				categoriaProducto.TELEFONIA, false));
		listaProductos.add(new Producto(5533, "Google ChromeCast", 200000, origenFabricacionProducto.URUGUAY,
				categoriaProducto.INFORMATICA, true));
		listaProductos.add(new Producto(3278, "Sony Pro", 1500000, origenFabricacionProducto.ARGENTINA,
				categoriaProducto.INFORMATICA, false));
		listaProductos.add(new Producto(9669, "Phillips Light", 800000, origenFabricacionProducto.BRASIL,
				categoriaProducto.INFORMATICA, true));
		listaProductos.add(new Producto(9889, "Martillo Sthil", 22500.00, origenFabricacionProducto.URUGUAY,
				categoriaProducto.HERRAMIENTAS, false));
		listaProductos.add(new Producto(7830, "Pinzas Caterpillar", 100000, origenFabricacionProducto.CHINA,
				categoriaProducto.HERRAMIENTAS, true));
		listaProductos.add(new Producto(4480, "Bujias Bosch", 40000, origenFabricacionProducto.ARGENTINA,
				categoriaProducto.HERRAMIENTAS, true));

		do {
			System.out.println("");
			System.out.println("---MENU DE COMPRAS---");
			System.out.println("1-Mostrar productos");
			System.out.println("2-Realizar compra");
			System.out.println("3-Salir");
			try {
				System.out.print("Elija una opcion: ");
				opcion = teclado.nextByte();
				if (opcion < 1 || opcion > 3) {
					opcion = 0;
					throw new IllegalArgumentException("Debe elegir un rango comprendido del 1 al 3");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				teclado.nextLine();
				opcion = 0;
			}
			switch (opcion) {
			case 1:
				for (Producto prod : listaProductos) {
					if (prod.isEstado() == true) {
						System.out.println(prod);
					}
				}
				break;
			case 2:
				do {
					try {
						System.out.print("Ingrese el código del producto: ");
						codigoProducto = teclado.nextInt();
						for (int i = 0; i < listaProductos.size(); i++) {
							producto = listaProductos.get(i);
							if (producto.getCodigoProducto() == (codigoProducto)) {
								listaCompra.add(producto);
								montoTotal += producto.getPrecioUnitatioProducto();
							}
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						codigoProducto = 0;
						teclado.nextLine();
					}
					try {
						do {
							System.out.print("Quiere cargar otro producto(S/N):  ");
							respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("S")) {
								carga = true;
							} else if (respuesta.equalsIgnoreCase("N")) {
								carga = false;
							} else {
								System.out.println("Respuesta no válida. Por favor, ingrese S o N.");
							}
						} while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						respuesta = "";
						teclado.nextLine();
					}
				} while (carga == true);
				System.out.println("----OPCIONES PARA EL PAGO----");
				System.out.println("1-Pago efectivo");
				System.out.println("2-Pago con tarjeta");
				do {
					try {
						System.out.print("Ingrese opción: ");
						opcion = teclado.nextByte();
						if (opcion < 1 || opcion > 2) {
							opcion = 0;
							throw new IllegalArgumentException("Debe elegir un rango comprendido del 1 al 2");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						teclado.nextLine();
						opcion = 0;
					}
				} while (opcion == 0);
				do {
					switch (opcion) {
					case 1:
						PagoEfectivo pagoEfectivo = new PagoEfectivo();
						pagoEfectivo.setMontoPagado(montoTotal);
						pagoEfectivo.imprimirRecibo();
						break;
					case 2:
						PagoTarjeta pagoTarjeta = new PagoTarjeta();
						pagoTarjeta.setNumeroTarjeta("4021123454786010l");
						pagoTarjeta.setMontoPagado(montoTotal);
						pagoTarjeta.imprimirRecibo();
						break;
					default:
						System.out.println("Opción invalida");
						break;
					}
				} while (opcion != 1 && opcion != 2);
				break;
			case 3:
				System.out.println("Saliste del menu.");
				break;
			default:
				System.out.println("Opción no valida.");
				break;
			}
		} while (opcion != 3);
		teclado.close();
	}

}
