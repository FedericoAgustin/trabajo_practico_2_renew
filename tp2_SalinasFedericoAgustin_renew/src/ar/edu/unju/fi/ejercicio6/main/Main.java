package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombreFelinoDomestico(),
				x.getEdadFelinoDomestico(), x.getPesoFelinoDomestico());
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjeto(felino1);

		FelinoSalvaje gatoSalvaje = new FelinoSalvaje("Tanner", (byte) 20, 186f);

		boolean noNulo = Converter.isNotNull(gatoSalvaje);
		if (noNulo) {
			Converter<FelinoSalvaje, FelinoDomestico> converter1 = k -> new FelinoDomestico(k.getNombreFelinoSalvaje(),
					k.getEdadFelinoSalvaje(), k.getPesoFelinoSalvaje());
			FelinoDomestico gato1 = converter1.convert(gatoSalvaje);
			converter1.mostrarObjeto(gato1);
		} else
			System.out.println("El objeto esta vacío");

	}

}
