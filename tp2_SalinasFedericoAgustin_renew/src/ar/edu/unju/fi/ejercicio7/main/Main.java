package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.categoriaProducto;
import ar.edu.unju.fi.ejercicio5.model.Producto.origenFabricacionProducto;

public class Main {

	public static void main(String[] args) {
		byte opcion;

		Scanner leer = new Scanner(System.in);

		List<Producto> listaProductos = new ArrayList<>();

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
				categoriaProducto.ELECTROHOGAR, true));
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
			System.out.println("------MENÚ------");
			System.out.println("1-Mostrar productos");
			System.out.println("2-Mostrar productos faltantes");
			System.out.println("3-Incrementar los precios de los productos en un 20%");
			System.out.println("4-Mostrar productos de la categoria ElectroHogar que esten disponibles");
			System.out.println("5-Ordenar los productos por precio (descendente)");
			System.out.println("6-Mostrar productos con nombres en mayúsculas");
			System.out.println("7-Salir");
			try {
				System.out.print("Ingrese opcion: ");
				opcion = leer.nextByte();
				if (opcion < 1 || opcion > 7) {
					opcion = 0;
					throw new IllegalArgumentException("Opcion incorrecta debe elegir entre 1 y 7");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				leer.nextLine();
				opcion = 0;
			}
			switch (opcion) {
			case 1:
				Consumer<Producto> printConsumer = p -> {
					if (p.isEstado()) {
						System.out.println(p);
					}
				};
				listaProductos.forEach(printConsumer);
				break;
			case 2:
				Predicate<Producto> filterEstadoFalse = p -> !p.isEstado();
				listaProductos.stream().filter(filterEstadoFalse).forEach(System.out::println);
				break;
			case 3:
				Function<Producto, Producto> funcionIncrementar = (p) -> {
					double resultado = p.getPrecioUnitatioProducto() + (p.getPrecioUnitatioProducto() * 0.2);
					p.setPrecioUnitatioProducto(resultado);
					return p;
				};
				List<Producto> productosIncrementados = new ArrayList<>();
				productosIncrementados = listaProductos.stream().map(funcionIncrementar).collect(Collectors.toList());
				productosIncrementados.forEach(System.out::println);
				break;
			case 4:
				Predicate<Producto> filterCategoriaDisponible = p -> p.getCategoria()
						.equals(Producto.categoriaProducto.ELECTROHOGAR) && p.isEstado();
				listaProductos.stream().filter(filterCategoriaDisponible).forEach(System.out::println);
				break;
			case 5:
				listaProductos.sort(Comparator.comparing(Producto::getPrecioUnitatioProducto).reversed());
				listaProductos.forEach(System.out::println);
				break;
			case 6:
				Function<Producto, Producto> funcionMayuscula = (p) -> {//
					if (p.getDescripcionProducto().toUpperCase().equals(p.getDescripcionProducto().toUpperCase())) {
						return p;
					}
					return null;
				};
				List<Producto> productosNombreMayuscula = new ArrayList<>();
				productosNombreMayuscula = listaProductos.stream().map(funcionMayuscula).filter(p -> p != null)
						.collect(Collectors.toList());
				productosNombreMayuscula.forEach(System.out::println);
				break;
			case 7:
				System.out.println("Saliste del menú");
				break;
			default:
				System.out.println("Opción Incorrecta");
				break;
			}
		} while (opcion != 7);
		leer.close();

	}

}
