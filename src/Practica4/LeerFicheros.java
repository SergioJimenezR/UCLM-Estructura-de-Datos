package Practica4;

import graphsDSESIUCLM.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Esta clase se encarga de asuntos relacionados con la lectura de ficheros.
 * 
 * @author David González, Lucas Gutiérrez y Sergio Jiménez
 * @version 1.0
 */


public class LeerFicheros {
	
	/**
	 * El método se encargará de la lectura del fichero indicado con el objetivo de crear
	 * aristas en base a los datos leidos con el empleo de StringTokenizer.
	 * 
	 * @param rutaFicheroAristas será la ruta en la que esta ubicado el fichero donde se encuentran 
	 * los datos de las aristas.
	 * @param g será un grafo.
	 * @return 
	 */

	public static void leerAristas(String rutaFicheroAristas, Graph g) {

		String cadenaV1 = "";
		String cadenaV2 = "";
		String cadenaValor = "";
		int valor = 0;
		ElementoDecorado<String> v1;
		ElementoDecorado<String> v2;
		ElementoDecorado<Integer> ed;

		try (BufferedReader br = new BufferedReader(new FileReader(rutaFicheroAristas));) {
			String linea;
			if ((linea = br.readLine()) != null) {
			}

			while ((linea = br.readLine()) != null) {
				// Se declara la variable tokenizer que se encargará de partir las lineas de
				// texto
				StringTokenizer tokenizer = new StringTokenizer(linea);

				// Se van introduciendo en cada variable los tokens que salen de partir
				// cada línea por el carácter ",".

				//cadenaV1 es el vertice origen.
				cadenaV1 = tokenizer.nextToken(",");
				//cadenaV2 es el vertice destino.
				cadenaV2 = tokenizer.nextToken(",");
				//cadenaValor es el peso de la arista.
				cadenaValor = tokenizer.nextToken(",");

				//Convertimos el String cadenaValor en un Int valor 
				valor = Integer.parseInt(cadenaValor);

				// De los String generados a partir de la lectura se crean elementos decorados
				// y se inserta un arista
				v1 = new ElementoDecorado<String>(cadenaV1, cadenaV1);
				v2 = new ElementoDecorado<String>(cadenaV2, cadenaV2);
				//Hemos empleado un identificador String en lugar de un identificador númerico con el 
				//el fin de poder localizar las aristas que son la misma para indicar solamente una de ellas.
				//De modo que si la concatenacion de los 3 String coincide con otro elemento creado significa
				//que la arista se esta repitiendo ya que es imposible que se de el caso y no sea la misma arista.
				ed = new ElementoDecorado<Integer>(cadenaV1 + cadenaV2 + cadenaValor, valor);

				g.insertEdge(v1, v2, ed);

			}
			//Se controlan las excepciones de más excluyente a más general.
		} catch (FileNotFoundException FNFE) {
			System.out.println(FNFE.toString());
		} catch (IOException IOE) {
			System.out.println(IOE.toString());
		} catch (Exception E) {
			System.out.println(E.toString());
		}
	}
}
