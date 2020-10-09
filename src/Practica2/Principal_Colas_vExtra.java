/*
 * Segunda opción para este ejercicio.
 * Esta vez los criminales van siendo procesador desde el momento 0
 * (desde que llega el primer delincuente) 
 * Se puede apreciar ya que el orden de peligrosidad no es constante,
 * es decir, no salen primero todos los altamente peligrosos ya que si 
 * aún no están dentro de la cola no pueden salir y tendrá que salir uno
 * de peligrosidad inferior.
 * Creemos que con esta variación se asemeja bastante más al funcionamiento
 * real de una comisaría.
 * Fecha 16/10/2019
 */
package Practica2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue; 
/**
 * Es la clase principal que se encarga de llamar a todo el programa.
* @author David González, Lucas Gutiérrez y Sergio Jiménez 
* @version 2.0
*/
public class Principal_Colas_vExtra {
	
	public static void main(String [] args) {
		
		// Declaracion de variables empleadas en el programa
		int maxDelincuentes = 50;
		int maxProcesados = 0;
		int contador = 0;
		String cadenaFichados = "\n";
		
		Comparator<Delincuente> comparador = new Ordenar();
		// Cola de llegada de los delincuentes
		Queue<Delincuente> llegada = new LinkedList<Delincuente>();
		// Cola de procesado de delincuentes
		PriorityQueue<Delincuente> salida = new PriorityQueue<Delincuente>(50, comparador);
		// Delincuente auxiliar
		Delincuente delincuente;
		
		System.out.println("Cola según la hora de llegada de los delincuentres.");
		
		for(int t = 60; !(maxProcesados == maxDelincuentes); t++) {
			// Cada 60 segundos entra un delincuente
			if(t % 60 == 0 && contador < maxDelincuentes) {
				// Se crea un delincuente y entra en la cola de llegada
				delincuente = new Delincuente();
				llegada.add(delincuente);
				
				System.out.print("Hora de llegada: " + (t - 60) + " segundos, ");
				System.out.print(delincuente.toString() + ".");		
				System.out.println(" Su indice de peligrosidad es: " + delincuente.getNPeligrosidad()+". ");
				// El delincuente entra en la cola de prioridad
				salida.add(delincuente);
				contador++;
			}
			// Cada 90 segundos entra un delincuente
			if (t % 90 == 0 && !salida.isEmpty()) {
				
				delincuente = salida.poll();
				
				cadenaFichados += "Hora de procesado: " + t + " segundos, " + 
				"El último delincuente fichado es: " + delincuente.toString() + "\n";		
				
				maxProcesados++;
			}
			
		}
		System.out.println(cadenaFichados);
	}
}
