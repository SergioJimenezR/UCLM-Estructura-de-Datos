package Practica3;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Pr�ctica de Listas. Curso acad�mico 2019/2020.
 * @author David Gonz�lez Berm�de, Lucas Guti�rrez Dur�n, Sergio Jim�nez Roncero.
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
			
			// Declaraci�n y generaci�n de listas, o reinicio
			List<Vecino> listaA = new ArrayList<Vecino>();
			List<Vecino> listaB = new ArrayList<Vecino>();

			for (int i = 1; i <= 20; i++) {
				listaA.add(new Vecino(i));
				listaB.add(new Vecino(i));
			}
			
			// Visualizaci�n de sendas listas
			System.out.println("\nLista A:\n" + obtenerLista(listaA) + "\nLista B:\n" + obtenerLista(listaB) + "\n");
			
			// Este bucle recorre las 2 vueltas
			for(int vuelta = 1; vuelta <= 2 && seguir; vuelta++) {
				System.out.println("Realizando intento "+ intento +" (vuelta "+vuelta+"):");
				listaMesa = new ArrayList<Vecino>(); // Reinicio de listaMesa por cada vuelta
				
				if(vuelta == 1) { // Primera vuelta (intentos impares)
					// Se recorren antiparalelamente las listas, comparando el �ltimo d�gito de sendos DNI
					for (int i = 0; i < 20; i++) {
						if (listaA.get(i).devolverUltimoNumeroDNI() == listaB.get(19 - i).devolverUltimoNumeroDNI()) {
							listaMesa.add(listaA.get(i));
							listaMesa.add(listaB.get(19 - i));
						}
					}
					
				} else { // Segunda vuelta (intentos pares)
					Iterator<Vecino> iterA = listaA.iterator();
					Iterator<Vecino> iterB = listaB.iterator();
					
					// Se recorren paralelamente las listas con ayuda de la interfaz iterador, comparando el �ltimo d�gito de sendos DNI
					while(iterA.hasNext() && iterB.hasNext()) {
						Vecino auxA = iterA.next();
						Vecino auxB = iterB.next();
						
						if(auxA.devolverUltimoNumeroDNI() == auxB.devolverUltimoNumeroDNI()) {
							listaMesa.add(auxA);
							listaMesa.add(auxB);
						}
					}
				}
				
				// Si tras escoger los �rbitros, en dicha vuelta han aparecido al menos 4, la b�squeda termina.
				if (listaMesa.size() >= 4) {
					seguir = false; // Fin
				} else {
					// Sino, se muestra un mensaje de error,
					// y como seguir sigue siendo true, se realiza la siguiente vuelta o generaci�n de siguientes listas.
					System.out.println("Intento "+ intento++ +" fallido.\n");
				}
				
				// En este momento, se itera la siguiente vuelta o se sale del bucle, generando nuevas listas.
			} // Fin del for
			// En el caso de haber transcurrido las 2 vueltas, y seguir siendo seguir == true, se generan nuevas listas.
		} // Fin del while
		
		// En el momento en que seguir se pone a true, no se sigue iterando, y muestra la lista de la mesa y su tama�o.
		System.out.println("Intento "+ intento +" correcto.\n\nLista de la Mesa:\n" + obtenerLista(listaMesa) + "\nTama�o de la Mesa: " + listaMesa.size() + " miembros.");
	}

	
	/**
	 * El m�todo devuelve una cadena de texto con la Lista, para imprimirse,
	 * habi�ndosela introducido por par�metro de entrada,
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
