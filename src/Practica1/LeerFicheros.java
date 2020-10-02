// Fecha 16/10/2019
package Practica1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Stack;
import java.util.StringTokenizer;

/**
* Esta clase se encarga de asuntos relacionados con leer y escribir
* de ficheros.
* @author David González, Lucas Gutiérrez y Sergio Jiménez
* @version 1.0
*/

public class LeerFicheros {
	/**
	 * Clase principal que lee las noticias de fichero.
	 * @param nombreFicheroNoticias es una cadena de texto que coincide con la dirección
	 * del fichero que contiene las noticias.
	 * @param p es una pila especializada para contener noticias
	 * @return Devolverá la pila p llenas de las noticias leidas
	 */
	public static Stack<Noticia> leerNoticias(String nombreFicheroNoticias, Stack<Noticia> p) {
		
		String titulo = "";
		String categoria = "";
		String descripcion = "";
		String autor = "";
		String fechaTemporal = "";
		Date fecha = new Date();
		
		try (BufferedReader br = new BufferedReader(new FileReader(nombreFicheroNoticias));) {
			String linea;

			while ((linea = br.readLine()) != null) {
				
				// Se declara la variable tokenizer que se encargará de partir las lineas de texto
				StringTokenizer tokenizer = new StringTokenizer(linea);
					
				
				// Se van introduciendo en cada variable los tokens que salen de partir
				// cada línea por el carácter ";".
				 
				titulo = tokenizer.nextToken(";");
				categoria = tokenizer.nextToken(";");
				descripcion = tokenizer.nextToken(";");
				autor = tokenizer.nextToken(";");
				
				fechaTemporal = tokenizer.nextToken();
				
				
				// Se llama a la función ParseFecha que transforma un String en Date
				
				fecha = Funciones.parseFecha(fechaTemporal);
				
				
				//  Se van creando las noticias añadiendolas a la pila
				
				Noticia n = new Noticia(titulo, categoria, descripcion, autor, fecha);
				p.push(n);
			}	
		// Se controlan las excepciones de más excluyente a más general.	
		} catch (ParseException PE) {
			System.out.println(PE.toString());
		} catch (FileNotFoundException FNFE) {
			System.out.println(FNFE.toString());
		} catch (IOException IOE) {
			System.out.println(IOE.toString());
		} catch (Exception E) {
			System.out.println(E.toString());
		}
		return p;
	}

}
