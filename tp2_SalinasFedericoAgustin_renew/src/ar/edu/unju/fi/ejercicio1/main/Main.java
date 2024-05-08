package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.categoriaProducto;
import ar.edu.unju.fi.ejercicio1.model.Producto.origenFabricacionProducto;

public class Main {

	public static void main(String[] args) {

		int opcion;
		int codigoProducto;
		String descripcionProducto;
		double precioUnitario;
		origenFabricacionProducto origenProducto = null;
		categoriaProducto categoriaProducto = null;
		Producto producto = new Producto();
		List<Producto> listaProductos = new ArrayList<>();

		Scanner teclado = new Scanner(System.in);
		do {
			System.out.println("-----------------------");
			System.out.println("---MENU---");
			System.out.println("1-Crear Producto");
			System.out.println("2-Mostrar Productos:");
			System.out.println("3-Modificar producto");
			System.out.println("4-Salir");

			try {// control menu principal
				System.out.println("Ingrese opción");
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 4) {
					opcion = 0;
					throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 4");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				teclado.nextLine();
				opcion = 0;
			}
			switch (opcion) {
			case 1:
				do {
					try {
						System.out.print("Ingrese codigo: ");
						codigoProducto = teclado.nextInt();
					} catch (Exception e) {
						System.out.println("Error: Ingrese un codigo con el formato válido");
						codigoProducto = 0;
						teclado.nextLine();
					}
				} while (codigoProducto == 0);
				teclado.nextLine();
				do {
					try {
						System.out.print("Ingrese Descripción: ");
						descripcionProducto = teclado.nextLine();
					} catch (Exception e) {
						System.out.println("Error: verifique que el campo no este vacío");
						descripcionProducto = "";
						teclado.nextLine();
					}
				} while (descripcionProducto.isBlank());
				do {
					try {
						System.out.print("Ingrese precio unitario: ");
						precioUnitario = teclado.nextDouble();
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						precioUnitario = 0.0;
						teclado.nextLine();
					}
				} while (precioUnitario == 0);
				teclado.nextLine();
				System.out.println("Ingrese origen de fabricacion: ");
				origenProducto = producto.menuOrigenDeFabricacion(teclado);
				System.out.println("Ingrese categoria: ");
				categoriaProducto = producto.menuCategoriaProducto(teclado);
				listaProductos.add(new Producto(codigoProducto, descripcionProducto, precioUnitario, origenProducto,
						categoriaProducto));
				System.out.println("Se creo el objeto con exito");
				break;
			case 2:
				if (listaProductos.isEmpty()) {
					System.out.println("La lista de productos esta vacia");
				} else {
					listaProductos.forEach(p -> System.out.println("Producto: " + p));
				}
				break;
			case 3:
				if (listaProductos.isEmpty()) {
					System.out.println("No existe un producto cargado	");
				} else {
					System.out.print("Ingrese codigo del producto a modificar:");
					codigoProducto = teclado.nextInt();
					for (int i = 0; i < listaProductos.size(); i++) {
						producto = listaProductos.get(i);
						if (producto.getCodigoProducto().equals(codigoProducto)) {
							System.out.println("Modificar producto " + producto.getCodigoProducto());
							do {
								teclado.nextLine();
								try {
									System.out.print("Ingrese descripcion: ");
									descripcionProducto = teclado.nextLine();
								} catch (Exception e) {
									System.out.println("Error: " + e.getMessage());
									descripcionProducto = "";
									teclado.nextLine();
								}
							} while (descripcionProducto.isEmpty());
							do {
								try {
									System.out.print("Ingrese precio unitario: ");
									precioUnitario = teclado.nextDouble();
									if (precioUnitario <= 0) {
										throw new IllegalArgumentException(
												"Debe colocar un precio que no sea negativo");
									}
								} catch (Exception e) {
									System.out.println("Error: debe ingresar numeros válidos");
									teclado.nextLine();
									precioUnitario = 0;
								}
							} while (precioUnitario <= 0);
							System.out.println("Ingrese origen de fabricacion: ");
							origenProducto = producto.menuOrigenDeFabricacion(teclado);
							System.out.println("Ingrese categoria: ");
							categoriaProducto = producto.menuCategoriaProducto(teclado);
							producto.setDescripcionProducto(descripcionProducto);
							producto.setPrecioUnitatioProducto(precioUnitario);
							producto.setOrigenFabricacion(origenProducto);
							producto.setCategoria(categoriaProducto);
							System.out.println("El producto se modifico con exito");
							break;
						} else {
							System.out.println(
									"El codigo " + codigoProducto + " no pertenece a ningún producto de la lista");
						}
					}
				}
				break;
			default:
				break;
			}

		} while (opcion != 4);
		System.out.println("Saliste del menu");

	}

}
