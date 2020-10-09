// Fecha 16/10/2019
package Practica1;

import java.util.Scanner;
import java.util.Stack;

/**
* Es la clase que llama al resto del programa.
* @author David Gonz�lez, Lucas Guti�rrez y Sergio Jim�nez 
* @version 2.0
*/

public class Principal_Pilas {
	/**
	 * M�todo Scanner que ser� utilizado para leer por teclado la categor�a de la
	 * noticia.
	 */
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		String ruta = "D:\\feeds.txt"; // Archivo sin ordenar
		String rutaOrdenado = "D:\\feeds_seq.txt"; // Archivo ordenado
		String eleccion = "";
		Stack<Noticia> p = new Stack<Noticia>();
		String c = "";
		
		System.out.println("Elija que fichero quiere procesar: [ordenado/noOrdenado]");
		eleccion = sc.next();
		// Se verifica que eleccion coincide con una de las cadenas de texto "ordenado" o "noOrdenado"
		while (!eleccion.equals("ordenado") && !eleccion.equals("noOrdenado")) {
			System.out.println("Error de formato:[ordenado/noOrdenado]");
			eleccion = sc.next();
		}
		// Se lee el fichero y las noticias se introducen en una pila.
		if(eleccion.equals("ordenado")) {
			p = LeerFicheros.leerNoticias(ruta, p);
		}
		else {
			p = LeerFicheros.leerNoticias(rutaOrdenado, p);
		}
		
		
		// Se ordenan las noticias seg�n la fecha de la misma pasando unicamente la 
		// pila con las noticias.
		Funciones.ordenarPila(p);
		
		System.out.println("Introduzca la categor�a de noticias a imprimir:\n" +
				"[deporte, politica, economia, cultura, tecnologia]");
		
		// Se verifica si se ha introducido una categor�a correcta
		c = sc.next();
		while (!c.equals("deporte") && !c.equals("politica") && !c.equals("economia") &&
				!c.equals("cultura") && !c.equals("tecnologia")) {
			System.out.println("Error. Categoria[deporte, politica, economia, cultura, tecnologia]");
			c = sc.next();
		}
		 
		// Se le da un valor temporal a la noticia para poder invocar el m�todo sin problema
		Noticia temporal = p.peek();
		Funciones.imprimirNoticias(p, c, temporal);
	}

}

