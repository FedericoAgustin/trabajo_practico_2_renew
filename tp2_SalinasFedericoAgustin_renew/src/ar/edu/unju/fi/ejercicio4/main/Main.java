package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		int opcion;
		String nombreJugador = null;
		String apellidoJugador = null;
		LocalDate fechaNacimientoJugador = null;
		String fechaNacimientoString;
		String nacionalidadJugador = null;
		double estaturaJugador = 0;
		double pesoJugador = 0;
		Posicion posicionJugador = null;
		String posicionString;

		List<Jugador> listaJugadores = new ArrayList<>();

		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("---------------------------");
			System.out.println("Menú Jugadores");
			System.out.println("");
			System.out.println("1 – Alta de jugador");
			System.out.println("2 – Mostrar todos los jugadores ");
			System.out.println("3 – Modificar posición del jugador");
			System.out.println("4 – Eliminar un jugador ");
			System.out.println("5 – Salir");
			do {
				try {
					System.out.print("Ingrese opción: ");
					while (!teclado.hasNextInt()) {
						System.out.println("Error: Debe ingresar un numero del 1 al 5.");
						System.out.print("Ingrese opción: ");
						teclado.next();
					}
					opcion = teclado.nextInt();
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					opcion = -1;
				}
			} while (opcion == -1);
			switch (opcion) {
			case 1:
				do {
					try {
						System.out.print("Ingrese nombre del jugador: ");
						nombreJugador = teclado.next();
						if (!nombreJugador.matches("[a-zA-Z]+")) {
							throw new IllegalArgumentException("El nombre debe contener solo letras.");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						nombreJugador = "";
					}
				} while (nombreJugador.isEmpty());
				do {
					try {
						System.out.print("Ingrese apellido del jugador: ");
						apellidoJugador = teclado.next();
						if (!apellidoJugador.matches("[a-zA-Z]+")) {
							throw new IllegalArgumentException("El apellido debe contener solo letras.");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						apellidoJugador = "";
					}
				} while (apellidoJugador.isEmpty());
				do {
					try {
						System.out.print("Ingrese fecha de nacimento (formato: dd-MM-yyyy): ");
						fechaNacimientoString = teclado.next();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						fechaNacimientoJugador = LocalDate.parse(fechaNacimientoString, formatter);
					} catch (Exception e) {
						System.out.println("Formato de fecha incorrecto. Utilice el formato dd-MM-yyyy.");
						fechaNacimientoJugador = null;
					}
				} while (fechaNacimientoJugador == null);
				do {
					try {
						System.out.print("Ingrese nacionalidad del jugador: ");
						nacionalidadJugador = teclado.next();
						if (!nacionalidadJugador.matches("[a-zA-Z]+")) {
							throw new IllegalArgumentException("La nacionalidad debe contener solo letras.");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						nacionalidadJugador = "";
					}
				} while (nacionalidadJugador.isEmpty());
				do {
					try {
						System.out.print("Ingrese estatura del jugador (separador decimal \",\"): ");
						estaturaJugador = teclado.nextDouble();
						if (estaturaJugador <= 0) {
							throw new IllegalArgumentException("El número debe ser positivo.");
						}
					} catch (Exception e) {
						System.out.println("Error: Debe ingresar un número real válido.");
						estaturaJugador = 0;
						teclado.nextLine();
					}
				} while (estaturaJugador == 0);
				do {
					try {
						System.out.print("Ingrese peso del jugador (separador decimal \",\"): ");
						pesoJugador = teclado.nextDouble();
						if (pesoJugador <= 0) {
							throw new IllegalArgumentException("El número debe ser positivo.");
						}
					} catch (Exception e) {
						System.out.println("Error: Debe ingresar un número real válido.");
						pesoJugador = 0;
						teclado.nextLine();
					}
				} while (pesoJugador == 0);
				do {

					try {
						System.out.print("Ingrese posicion del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
						posicionString = teclado.next().toUpperCase();
						posicionJugador = Posicion.valueOf(posicionString);
					} catch (IllegalArgumentException e) {
						System.out.println("La posicion ingresada no es valida.");
					}
				} while (posicionJugador == null);
				Jugador jugador = new Jugador(nombreJugador, apellidoJugador, fechaNacimientoJugador,
						nacionalidadJugador, estaturaJugador, pesoJugador, posicionJugador);
				listaJugadores.add(jugador);
				System.out.println("El agregó el jugador con exito");
				break;
			case 2:
				boolean jugadorEncontrado = false;
				if (listaJugadores.isEmpty()) {
					System.out.println("La lista de jugadores esta vacia");
				} else {
					listaJugadores.forEach(e -> System.out.println("jugadores: " + e));
					jugadorEncontrado = true;
				}
				break;
			case 3:
				if (listaJugadores.isEmpty()) {
					System.out.println("El ArrayList no tiene ningún jugador");
				} else {
					System.out.print("Ingrese nombre: ");
					nombreJugador = teclado.next();
					System.out.print("Ingrese apellido: ");
					apellidoJugador = teclado.next();
					jugadorEncontrado = false;
					for (Jugador j : listaJugadores) {
						if (j.getNombre().equalsIgnoreCase(nombreJugador)
								&& j.getApellido().equalsIgnoreCase(apellidoJugador)) {
							System.out.println("Jugador encontrado. Proporcione los nuevos datos:");
							try {
								System.out.print(
										"Ingrese nueva posicion del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
								posicionString = teclado.next().toUpperCase();
								posicionJugador = Posicion.valueOf(posicionString);
								j.setPosicion(posicionJugador);
								jugadorEncontrado = true;
								break;
							} catch (DateTimeParseException | IllegalArgumentException e) {
								System.out.println("Error: " + e.getMessage());
								teclado.nextLine();
							}
						}
					}
					if (!jugadorEncontrado) {
						System.out.println("El jugador no existe.");
					}
				}
				break;
			case 4:
				if (listaJugadores.isEmpty()) {
					System.out.println("El ArrayList no tiene ningún jugador");
				}
				System.out.print("Ingrese nombre: ");
				nombreJugador = teclado.next();
				System.out.print("Ingrese apellido: ");
				apellidoJugador = teclado.next();
				jugadorEncontrado = false;
				Iterator<Jugador> iterador = listaJugadores.iterator();
				while (iterador.hasNext()) {
					jugador = iterador.next();
					if (jugador.getNombre().equalsIgnoreCase(nombreJugador)
							&& jugador.getApellido().equalsIgnoreCase(apellidoJugador)) {
						iterador.remove();
						jugadorEncontrado = true;
						System.out.println("Jugador eliminado con exito");
						break;
					}
				}
				if (!jugadorEncontrado) {
					System.out.println("El jugador no existe.");
				}
				break;
			case 5:
				System.out.println("Saliste del menú.");
				break;
			default:
				System.out.println("OPCION INVALIDA");
				break;
			}
		} while (opcion != 8);
		teclado.close();

	}

}
