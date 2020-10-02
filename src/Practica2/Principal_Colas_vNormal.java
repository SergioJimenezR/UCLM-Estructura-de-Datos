// Fecha 16/10/2019
package Practica2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue; 

/**
 * Es la clase principal que se encarga de llamar a todo el programa.
* @author David González, Lucas Gutiérrez y Sergio Jiménez 
* @version 1.0
*/

public class Principal_Colas_vNormal {
	
	public static void main(String [] args) {
		
		// Declaracion de variables empleadas en el programa
		int maxDelincuentes = 50;
		int maxProcesados = 0;
		int contador = 0;
		String cadenaFichados = "";
		
		Comparator<Delincuente> comparador = new Ordenar();
		// Cola de llegada de los delincuentes
		Queue<Delincuente> llegada = new LinkedList<Delincuente>();
		// Cola de procesado de delincuentes
		PriorityQueue<Delincuente> salida = new PriorityQueue<Delincuente>(50, comparador);
		// Delincuente auxiliar
		Delincuente delincuente;
		
		System.out.println("Cola según la hora de llegada de los delincuentres.");
		
		for(int t = 60; contador < maxDelincuentes; t++) {
			if(t % 60 == 0) {
				delincuente = new Delincuente();
				llegada.add(delincuente);
				
				System.out.print("Hora de llegada: " + (t - 60) + " segundos, ");
				System.out.print(delincuente.toString() + ".");		
				System.out.println(" Su indice de peligrosidad es: " + delincuente.getNPeligrosidad()+". ");
				
				salida.add(delincuente);
				contador++;
			}
		}
		
		System.out.println("\nCola según la hora de fichado de los delincuentes.");
		
		for(int t = 60; maxProcesados < maxDelincuentes; t++) {
			if (t % 90 == 0 && !salida.isEmpty()) {
				
				delincuente = salida.poll();
				
				cadenaFichados += "Hora de procesado: " + t + " segundos, " + 
				"El último deliencuente fichado es: " + delincuente.toString() + "\n";		
				
				maxProcesados++;
			}
			
		}
		System.out.println(cadenaFichados);
	}
}
