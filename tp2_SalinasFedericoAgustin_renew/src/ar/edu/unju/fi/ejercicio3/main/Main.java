package ar.edu.unju.fi.ejercicio3.main;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		List<Provincia> listaProvincias = new ArrayList<>();
		listaProvincias.add(Provincia.JUJUY);
		listaProvincias.add(Provincia.SALTA);
		listaProvincias.add(Provincia.TUCUMAN);
		listaProvincias.add(Provincia.CATAMARCA);
		listaProvincias.add(Provincia.LA_RIOJA);
		listaProvincias.add(Provincia.SANTIAGO_DEL_ESTERO);

		System.out.println("***PROVINCIAS***");
		System.out.println("");
		for (Provincia provincia : listaProvincias) {
			System.out.println(provincia.name());
			System.out.println("Cantidad de Habitantes por provincia: " + provincia.getCANTIDAD_POBLACION());
			System.out.println("Superficie de la provincia: " + provincia.getSUPERFICIE() + " m2");
			System.out.println("Densidad poblacional: " + provincia.densidadPoblacional() + " hab/km²");
			System.out.println("");
		}

	}

}
