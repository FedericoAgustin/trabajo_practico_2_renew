package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		int codigoEfemeride;
		byte mesNumero = 0;
		byte diaEfemeride = 0;
		String nombreMes = null;
		String detalleEfemeride = null;
		int opcion;

		List<Efemeride> listaEfemeride = new ArrayList<>();

		Efemeride efemeride = new Efemeride();

		Scanner teclado = new Scanner(System.in);
		do {
			System.out.println("-----------------------");
			System.out.println("---MENU---");
			System.out.println("1-Crear Efeméride");
			System.out.println("2-Mostrar Efemérides");
			System.out.println("3-Eliminar Efeméride");
			System.out.println("4-Modificar Efeméride");
			System.out.println("5-Salir");
			try {// control menu principal
				System.out.print("Ingrese opcion: ");
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 5) {
					opcion = 0;
					throw new IllegalArgumentException("Debe seleccionar una opción valida que sea del 1 al 5");
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
						System.out.print("Ingrese codigo de efeméride: ");
						codigoEfemeride = teclado.nextInt();
					} catch (Exception e) {
						System.out.println("Error: Ingrese un formato válido");
						codigoEfemeride = 0;
						teclado.nextLine();
					}
				} while (codigoEfemeride == 0);
				do {
					try {
						System.out.print("Ingrese número del mes: ");
						mesNumero = teclado.nextByte();
						if (mesNumero < 1 || mesNumero > 12) {
							throw new IllegalArgumentException("Opción incorrecta, los meses deben ser del 1 al 12.");
						} else {
							for (Mes mes : Mes.values()) {
								if (mes.getNUMERO_MES() == mesNumero) {
									nombreMes = mes.name();
								}
							}
						}
					} catch (Exception e) {
						System.out.println("Error: Ingrese un formato válido.");
						mesNumero = 0;
						teclado.nextLine();
					}
				} while (mesNumero == 0);

				do {
					try {
						System.out.print("Ingrese el dia: ");
						diaEfemeride = teclado.nextByte();
						if (diaEfemeride < 1 || diaEfemeride > 31) {
							throw new IllegalArgumentException("Ingrese una opción de día válido que sea del 1 al 31");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						teclado.nextLine();
						diaEfemeride = 0;
					}
				} while (diaEfemeride == 0);
				teclado.nextLine();
				do {
					try {
						System.out.print("Ingrese el detalle: ");
						detalleEfemeride = teclado.nextLine();
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						codigoEfemeride = 0;
						teclado.nextLine();
					}
				} while (codigoEfemeride == 0);

				listaEfemeride.add(new Efemeride(codigoEfemeride, nombreMes, diaEfemeride, detalleEfemeride));
				System.out.println("Registro creado exitosamente");
				break;
			case 2:
				if (listaEfemeride.isEmpty()) {
					System.out.println("La lista de efemerides esta vacia");
				} else {
					listaEfemeride.forEach(e -> System.out.println("efemeride: " + e));
				}
				break;
			case 3:
				if (listaEfemeride.isEmpty()) {
					System.out.println("La lista de efemerides esta vacia");
				} else {
					System.out.print("Ingrese codigo efimeride a eliminar:");
					codigoEfemeride = teclado.nextInt();
					for (int i = 0; i < listaEfemeride.size(); i++) {
						efemeride = listaEfemeride.get(i);
						if (efemeride.getCodigo().equals(codigoEfemeride)) {
							listaEfemeride.remove(i);
							System.out.println("Se elimino el registro con exito");
							break;
						} else {
							System.out.println(
									"El codigo " + codigoEfemeride + " no pertenece a ningúna efemeride de la lista");
						}
					}
				}
				break;
			case 4:
				if (listaEfemeride.isEmpty()) {
					System.out.println("La lista de efemerides esta vacia");
				} else {
					System.out.print("Ingrese codigo de efemeride a modificar:");
					codigoEfemeride = teclado.nextInt();
					for (int i = 0; i < listaEfemeride.size(); i++) {
						efemeride = listaEfemeride.get(i);
						if (efemeride.getCodigo().equals(codigoEfemeride)) {
							System.out.println("Modificar producto " + efemeride.getCodigo());
							do {
								try {
									System.out.print("Ingrese número del mes: ");
									mesNumero = teclado.nextByte();
									if (mesNumero < 1 || mesNumero > 12) {
										throw new IllegalArgumentException(
												"Opción incorrecta, los meses van del 1 al 12.");
									} else {
										for (Mes mes : Mes.values()) {
											if (mes.getNUMERO_MES() == mesNumero) {
												nombreMes = mes.name();
											}
										}
									}
								} catch (Exception e) {
									System.out.println("Error: " + e.getMessage());
									mesNumero = 0;
									teclado.nextLine();
								}
							} while (mesNumero == 0);
							do {
								try {
									System.out.print("Ingrese dia: ");
									diaEfemeride = teclado.nextByte();
									if (diaEfemeride < 1 || diaEfemeride > 31) {
										throw new IllegalArgumentException(
												"Ingrese una opción de día válido que sea del 1 al 31");
									}
								} catch (Exception e) {
									System.out.println("Error: " + e.getMessage());
									teclado.nextLine();
									diaEfemeride = 0;
								}
							} while (diaEfemeride == 0);
							teclado.nextLine();
							do {
								try {
									System.out.print("Ingrese detalle: ");
									detalleEfemeride = teclado.nextLine();
								} catch (Exception e) {
									System.out.println("Error: " + e.getMessage());
									codigoEfemeride = 0;
									teclado.nextLine();
								}
							} while (codigoEfemeride == 0);

							efemeride.setMes(nombreMes);
							efemeride.setDía(diaEfemeride);
							efemeride.setDetalle(detalleEfemeride);
							System.out.println("Efemeride modificada con exito");
							break;
						} else {
							System.out.println(
									"El codigo " + codigoEfemeride + " no pertenece a ningúna efemeride de la lista");
						}
					}
				}
				break;
			case 5:
				System.out.println("Saliste del menú.");
				break;
			default:
				break;
			}
		} while (opcion != 5);
		teclado.close();

	}

}
