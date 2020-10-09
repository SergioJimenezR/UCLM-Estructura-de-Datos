package Practica3;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Práctica de Listas. Curso académico 2019/2020.
 * @author David González Bermúde, Lucas Gutiérrez Durán, Sergio Jiménez Roncero.
 * 
 */

public class Principal_Listas {

	public static void main(String[] args) {

		int intento = 1;
		List<Vecino> listaMesa = new ArrayList<Vecino>();
		boolean seguir = true;
		
		while (seguir) {
			
			if (intento == 1)
				System.out.println("Comienzo del programa. Generando listas:");
			else
				System.out.println("Listas fallidas en las 2 vueltas. Generando nuevas listas.");
			
			// Declaración y generación de listas, o reinicio
			List<Vecino> listaA = new ArrayList<Vecino>();
			List<Vecino> listaB = new ArrayList<Vecino>();

			for (int i = 1; i <= 20; i++) {
				listaA.add(new Vecino(i));
				listaB.add(new Vecino(i));
			}
			
			// Visualización de sendas listas
			System.out.println("\nLista A:\n" + obtenerLista(listaA) + "\nLista B:\n" + obtenerLista(listaB) + "\n");
			
			// Este bucle recorre las 2 vueltas
			for(int vuelta = 1; vuelta <= 2 && seguir; vuelta++) {
				System.out.println("Realizando intento "+ intento +" (vuelta "+vuelta+"):");
				listaMesa = new ArrayList<Vecino>(); // Reinicio de listaMesa por cada vuelta
				
				if(vuelta == 1) { // Primera vuelta (intentos impares)
					// Se recorren antiparalelamente las listas, comparando el último dígito de sendos DNI
					for (int i = 0; i < 20; i++) {
						if (listaA.get(i).devolverUltimoNumeroDNI() == listaB.get(19 - i).devolverUltimoNumeroDNI()) {
							listaMesa.add(listaA.get(i));
							listaMesa.add(listaB.get(19 - i));
						}
					}
					
				} else { // Segunda vuelta (intentos pares)
					Iterator<Vecino> iterA = listaA.iterator();
					Iterator<Vecino> iterB = listaB.iterator();
					
					// Se recorren paralelamente las listas con ayuda de la interfaz iterador, comparando el último dígito de sendos DNI
					while(iterA.hasNext() && iterB.hasNext()) {
						Vecino auxA = iterA.next();
						Vecino auxB = iterB.next();
						
						if(auxA.devolverUltimoNumeroDNI() == auxB.devolverUltimoNumeroDNI()) {
							listaMesa.add(auxA);
							listaMesa.add(auxB);
						}
					}
				}
				
				// Si tras escoger los árbitros, en dicha vuelta han aparecido al menos 4, la búsqueda termina.
				if (listaMesa.size() >= 4) {
					seguir = false; // Fin
				} else {
					// Sino, se muestra un mensaje de error,
					// y como seguir sigue siendo true, se realiza la siguiente vuelta o generación de siguientes listas.
					System.out.println("Intento "+ intento++ +" fallido.\n");
				}
				
				// En este momento, se itera la siguiente vuelta o se sale del bucle, generando nuevas listas.
			} // Fin del for
			// En el caso de haber transcurrido las 2 vueltas, y seguir siendo seguir == true, se generan nuevas listas.
		} // Fin del while
		
		// En el momento en que seguir se pone a true, no se sigue iterando, y muestra la lista de la mesa y su tamaño.
		System.out.println("Intento "+ intento +" correcto.\n\nLista de la Mesa:\n" + obtenerLista(listaMesa) + "\nTamaño de la Mesa: " + listaMesa.size() + " miembros.");
	}

	
	/**
	 * El método devuelve una cadena de texto con la Lista, para imprimirse,
	 * habiéndosela introducido por parámetro de entrada,
	 * y utilizando respectivos toString de los Vecinos de la Lista.
	 * @param lista Reclama una lista para devolver el String correspondiente.
	 * @return Una cadena que representa la lista.
	 */
	public static String obtenerLista(List<Vecino> lista) {
		Iterator<Vecino> iter = lista.iterator();
		String cadena = "";
		
		while (iter.hasNext()) {
			Vecino v = iter.next();
			cadena += "Vecino " + v.getPosicion() + ": " + v.toString() + "\n";
		}
		return cadena;
	}

}
