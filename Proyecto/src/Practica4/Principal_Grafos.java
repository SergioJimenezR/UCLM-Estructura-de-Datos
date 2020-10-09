package Practica4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

import graphsDSESIUCLM.*;

/**
 * Práctica de Grafos. Curso académico 2019/2020.
 * @author David González Bermúdez, Lucas Gutiérrez Durán, Sergio Jiménez Roncero.
 * @version 1.0
 * 
 */

public class Principal_Grafos {
	
	public static void main(String[] args) {
		String ruta = "D:\\marvel-unimodal-edges.csv";
		Graph grafo = new TreeMapGraph<>();
		LeerFicheros.leerAristas(ruta, grafo);
		
		PriorityQueue<Vertex<ElementoDecorado<String>>> colaOrdenadaG;
		PriorityQueue<Vertex<ElementoDecorado<String>>> colaOrdenadaI;
		
		System.out.println("Bienvenido al programa.");
		int opcion = 0;
		do {
			switch(opcion = elegirOpcionMenu()) {
				case 1:
					// APARTADO A
					System.out.println("Apartado A:");
					System.out.println("Número de personajes: " + grafo.getN());
					System.out.println("Número de relaciones: " + grafo.getM());
					
					colaOrdenadaG = masSociable(grafo);
					imprimirSuperheroeMasSociable(colaOrdenadaG);
					colaOrdenadaI = menosInteracciones(grafo);
					imprimirSuperheroeMenosInteracciones(colaOrdenadaI);
					break;
					
				case 2:
					// APARTADO B
					imprimirRecorrido(grafo);
					break;
				
				case 3:
					// APARTADO C
					imprimirCaminoInedito(grafo);
					break;
			}
		} while (opcion != 4);
		System.out.print("Fin del programa.");
	}

	/**
	 * El método masSociable se encarga de ordenar los vertices de un grafo dado de forma que 
	 * se genera una PriorityQueue en el que el vertice más sociable aparece el primero y el menos
	 * sociable el último de la cola.
	 * @param grafo que será el grafo cuyos vertices van a ser ordenados
	 * @return PriorityQueue con los vertices ordenados de más sociable a menos sociable
	 */
	public static PriorityQueue<Vertex<ElementoDecorado<String>>> masSociable(Graph grafo) {

		Vertex<ElementoDecorado<String>> vertice;
		Iterator<Edge<ElementoDecorado<Integer>>> iterador;
		Iterator<Vertex<ElementoDecorado<String>>> iteradorVertices = grafo.getVertices();

		Comparator<Vertex<ElementoDecorado<String>>> comparador = new OrdenarGrado();
		PriorityQueue<Vertex<ElementoDecorado<String>>> colaOrdenada = new PriorityQueue<Vertex<ElementoDecorado<String>>>(
				50, comparador);

		while (iteradorVertices.hasNext()) {
			int grado = 0;
			vertice = iteradorVertices.next();
			iterador = grafo.incidentEdges(vertice);

			while (iterador.hasNext()) {
				iterador.next();
				grado++;
			}
			vertice.getElement().setGrado(grado);
			colaOrdenada.add(vertice);
		}
		return colaOrdenada;
	}

	/**
	 * El método imprimirSuperheroeMasSociable se encargará de mostrar por pantalla el superheroe
	 * más sociable de la PriorityQueue pasada
	 * @param colaOrdenada será un PriorityQueue con vertices
	 */
	public static void imprimirSuperheroeMasSociable(PriorityQueue<Vertex<ElementoDecorado<String>>> colaOrdenada) {
		Vertex<ElementoDecorado<String>> vertice;
		Vertex<ElementoDecorado<String>> verticeAux;
		int mayorGrado = 0;
		int grado = 0;
		vertice = colaOrdenada.peek();
		mayorGrado = vertice.getElement().getGrado();
		verticeAux = colaOrdenada.poll();
		grado = verticeAux.getElement().getGrado();
		while (grado == mayorGrado) {
			System.out.println("El superhéroe más sociable es " + verticeAux.getID() + " con " + grado + " relaciones.");
			verticeAux = colaOrdenada.poll();
			grado = verticeAux.getElement().getGrado();
		}
	}

	/**
	 * El método menosInteracciones se encargará de ordenar los vertices de un grafo dado de forma que 
	 * se genera una PriorityQueue en el que el vertice con menos interraciones aparece el primero y el que más 
	 * interacciones tiene aparece en último lugar.
	 * @param grafo que será el grafo cuyos vertices van a ser ordenados
	 * @return PriorityQueue con los vertices ordenados segun su numero de interacciones
	 */
	public static PriorityQueue<Vertex<ElementoDecorado<String>>> menosInteracciones(Graph grafo) {

		Vertex<ElementoDecorado<String>> vertice;
		Edge<ElementoDecorado<Integer>> arista;
		Iterator<Edge<ElementoDecorado<Integer>>> iterador;
		Iterator<Vertex<ElementoDecorado<String>>> iteradorVertices = grafo.getVertices();

		Comparator<Vertex<ElementoDecorado<String>>> comparador = new OrdenarInteracciones();
		PriorityQueue<Vertex<ElementoDecorado<String>>> colaOrdenada = new PriorityQueue<Vertex<ElementoDecorado<String>>>(
				50, comparador);

		while (iteradorVertices.hasNext()) {
			int interacciones = 0;
			vertice = iteradorVertices.next();
			iterador = grafo.incidentEdges(vertice);

			while (iterador.hasNext()) {
				arista = iterador.next();
				interacciones += arista.getElement().getElement();
			}
			vertice.getElement().setInteracciones(interacciones);
			colaOrdenada.add(vertice);
		}
		return colaOrdenada;
	}
	
	/**
	 * El método imprimirSuperheroeMenosInteracciones se encargará de mostrar por pantalla el superheroe
	 * con menos interacciones de la PriorityQueue pasada
	 * @param colaOrdenada será una PriorityQueue con vertices
	 */
	public static void imprimirSuperheroeMenosInteracciones(PriorityQueue<Vertex<ElementoDecorado<String>>> colaOrdenada) {
		Vertex<ElementoDecorado<String>> vertice;
		Vertex<ElementoDecorado<String>> verticeAux;
		int menosInteracciones = 0;
		int interacciones = 0;
		vertice = colaOrdenada.peek();
		menosInteracciones = vertice.getElement().getInteracciones();
		verticeAux = colaOrdenada.poll();
		interacciones = verticeAux.getElement().getInteracciones();
		while (interacciones == menosInteracciones) {
			System.out.println("El superhéroe con menos interacciones " + verticeAux.getID() + " con " + interacciones
					+ " interacciones.\n");
			verticeAux = colaOrdenada.poll();
			interacciones = verticeAux.getElement().getInteracciones();
		}
	}

	// Apartado B
	/**
	 * El método imprimirRecorrido se encargará de imprimir por pantalla el recorrido entre
	 * dos nodos indicados por teclado. La caracteristica de este recorrido será que cada arista
	 * tendrá un peso mayor de 15.
	 * @param Grafo será el grafo del cual se imprimirá el recorrido
	 */
	public static void imprimirRecorrido(Graph grafo) {
		ElementoDecorado<String> nodoInicial, nodoFinal, nx, nodo = null;
		boolean bool1 = true, bool2 = true;
		int tamano;
		Vertex<ElementoDecorado<String>> verticeAux, verticeS = null, verticeT = null;
		Stack<ElementoDecorado<String>> pila = new Stack();
		Iterator<Vertex<ElementoDecorado<String>>> iterador;

		sc.nextLine(); // A causa del Buffer
		String nombreNodo = introducirNodo("nodo inicial (BFS)");
		nodoInicial = new ElementoDecorado<String>(nombreNodo, nombreNodo); // "Zeus", "Zeus"
		nombreNodo = introducirNodo("nodo final (BFS)");
		nodoFinal = new ElementoDecorado<String>(nombreNodo, nombreNodo); // "Zabu", "Zabu"
		
		if(nodoInicial.equals(nodoFinal)) {
			System.out.println("Ha elegido usted el mismo nodo de inicio y de final.\n");
		} else {
			iterador = grafo.getVertices();
			while (iterador.hasNext() && (bool1 || bool2)) {
				verticeAux = iterador.next();
				nx = verticeAux.getElement();
				nx.setVisitado(false);
				nx.setPadre(null);
				nx.setDistancia(0);
				if (nx.equals(nodoInicial)) {
					verticeS = verticeAux;
					bool1 = false;
				}
				if (nx.equals(nodoFinal)) {
					verticeT = verticeAux;
					bool2 = false;
				}
			}
			if (!(bool1 || bool2)) {
				nodo = caminoBFS(grafo, verticeS, verticeT);

				if (nodo.getPadre() == null) {
					System.out.println("No hay ningún camino.\n");
				} else {
					System.out.print("Camino: ");
					while (nodo.getPadre() != null) {
						pila.push(nodo);
						nodo = nodo.getPadre();
					}
					pila.push(nodo);

					tamano = pila.size();
					for (int i = 0; i < tamano - 1; i++) {
						nodo = pila.pop();
						System.out.print(nodo.getElement().toString() + " (" + nodo.getDistancia() + ")" + " - ");
					}
					nodo = pila.pop();
					System.out.println(nodo.getElement().toString() + " (" + nodo.getDistancia() + ").\n");
				}
			} else {
				System.out.println("Al menos uno de los nodos no se encuentra en el grafo.\n");
			}
		}

	}

	/**
	 * El método caminoBFS se encargará de buscar un camino entre dos vertices dados. La condicion
	 * de ese camino será que el peso de las aristas del camino debe ser mayor de 15 en cada una de ellas.
	 * @param grafo será un objeto del tipo Graph, y será el grafo a recorrer
	 * @param VerticeS será el vertice inicial
	 * @return VerticeT será el vertice destino
	 */
	public static ElementoDecorado<String> caminoBFS(Graph grafo, Vertex<ElementoDecorado<String>> verticeS,
			Vertex<ElementoDecorado<String>> verticeT) {
		Queue<Vertex<ElementoDecorado<String>>> cola = new LinkedList();
		boolean noFinal = true;
		Vertex<ElementoDecorado<String>> verticeU, verticeV = null;
		Edge<ElementoDecorado<Integer>> arista;
		Iterator<Edge<ElementoDecorado<Integer>>> iterador;

		verticeS.getElement().setVisitado(true);
		cola.offer(verticeS);
		while (!cola.isEmpty() && noFinal) {
			verticeU = cola.poll();
			iterador = grafo.incidentEdges(verticeU);
			while (iterador.hasNext() && noFinal) {
				arista = iterador.next();
				verticeV = grafo.opposite(verticeU, arista);
				if (!(verticeV.getElement()).getVisitado() && (arista.getElement().getElement() >= 15)) {
					(verticeV.getElement()).setVisitado(true);
					(verticeV.getElement()).setPadre(verticeU.getElement());
					(verticeV.getElement()).setDistancia(((verticeU.getElement()).getDistancia()) + 1);
					cola.offer(verticeV);
					noFinal = !(verticeV.getElement().equals(verticeT.getElement()));
				}
			}
		}
		if (noFinal) {
			verticeV.getElement().setPadre(null);
		}
		return verticeV.getElement();
	}

	// Apartado C
	
	/**
	 * 
	 * El método imprimirRecorrido se encargará de imprimir por pantalla el camino entre
	 * dos nodos indicados por teclado. La caracteristica de este camino será que cada arista
	 * tendrá un peso menor de 10.
	 * @param Grafo será el grafo del cual se imprimirá el camino
	 */
	public static void imprimirCaminoInedito(Graph grafo) {

		ElementoDecorado<String> nodoInicial, nodoFinal, nx;
		boolean bool1 = true, bool2 = true, sinCamino;
		Vertex<ElementoDecorado<String>> verticeAux, verticeS = null, verticeT = null;
		Vertex<ElementoDecorado<String>>[] vectorVertices;
		Stack<Edge<ElementoDecorado<Integer>>> pila1 = new Stack(), pila2 = new Stack();
		Iterator<Vertex<ElementoDecorado<String>>> iterador;

		sc.nextLine(); // A causa del Buffer
		String nombreNodo = introducirNodo("nodo inicial (DFS)");
		nodoInicial = new ElementoDecorado<String>(nombreNodo, nombreNodo); // "Captain America", "Captain America"
		nombreNodo = introducirNodo("nodo final (DFS)");
		nodoFinal = new ElementoDecorado<String>(nombreNodo, nombreNodo); // "Black Panther / T'chal", "Black Panther / T'chal"

		if(nodoInicial.equals(nodoFinal)) {
			System.out.println("Ha elegido usted el mismo nodo de inicio y de final.\n");
		} else {
			iterador = grafo.getVertices();
			while (iterador.hasNext() && (bool1 || bool2)) {
				verticeAux = iterador.next();
				nx = verticeAux.getElement();
				nx.setVisitado(false);
				if (nx.equals(nodoInicial)) {
					verticeS = verticeAux;
					bool1 = false;
				}
				if (nx.equals(nodoFinal)) {
					verticeT = verticeAux;
					bool2 = false;
				}
			}
			if (!(bool1 || bool2)) {
				sinCamino = caminoDFS(grafo, verticeS, verticeT, pila1);
				if (!sinCamino) {
					while (!pila1.isEmpty()) {
						pila2.push(pila1.pop());
					}
					System.out.print("Camino: ");
					while (!pila2.isEmpty()) {
						vectorVertices = grafo.endVertices(pila2.pop());
						System.out.print(vectorVertices[0].getElement().toString() + " - ");
						System.out.print(vectorVertices[1].getElement().toString() + ".");
					}
				} else {
					System.out.println("No hay camino posible entre los dos nodos.\n");
				}
			} else {
				System.out.println("Al menos uno de los nodos no se encuentra en el grafo.\n");
			}
		}
	}

	/**
	 * El método caminoDFS tendrá como objetivo buscar un camino entre dos vertices dados.
	 * El grafo se recorrerá por medio del uso de un recorrido en profundidad y es necesario que
	 * todas las aristas del camino tengan como maximo un peso de 10 cada una.
	 * @param grafo será el grafo donde se buscará el camino
	 * @param verticeV es un vertice inicial
	 * @param verticeZ es un vertice destino
	 * @return boolean 
	 */
	public static boolean caminoDFS(Graph grafo, Vertex<ElementoDecorado<String>> verticeV, Vertex<ElementoDecorado<String>> verticeZ,
			Stack<Edge<ElementoDecorado<Integer>>> pila) {

		boolean noFinal = !verticeV.equals(verticeZ);
		Edge<ElementoDecorado<Integer>> arista;
		Vertex<ElementoDecorado<String>> verticeW;
		
		Iterator<Edge<ElementoDecorado<Integer>>> iterador;
		
		verticeV.getElement().setVisitado(true);
		iterador = grafo.incidentEdges(verticeV);
		while (iterador.hasNext() && noFinal) {
			arista = iterador.next();
			verticeW = grafo.opposite(verticeV, arista);
			if (!verticeW.getElement().getVisitado() && arista.getElement().getElement() <= 10) {
				pila.push(arista);
				noFinal = caminoDFS(grafo, verticeW, verticeZ, pila);
				if (noFinal)
					pila.pop();
			}
		}
		return noFinal;
	}
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * El método introducirNodo se encargará de recoger por teclado el nombre de un nodo
	 * deseado para el funcionamiento de otros metodos del programa
	 * @param cadena con información sobre lo que habrá que indicar por teclado a continuación
	 * @return String con el nodo indicado por teclado
	 */
	public static String introducirNodo(String cadena) {
		//sc.nextLine();
		System.out.println("Introduzca el nombre del "+cadena+":");
		return sc.nextLine();
	}
	
	public static int elegirOpcionMenu() {
		System.out.println("Elija una opción:\n"
				+ "1. Apartado A.\n"
				+ "2. Apartado B. Búsqueda en anchura (BFS).\n"
				+ "3. Apartado C. Búsqueda en profundidad (DFS).\n"
				+ "4. Salir del programa.");
		int opcion = 0;
		do {
			try {
				opcion = sc.nextInt();
				if(opcion < 1 || opcion > 4) {
					System.out.println("Opción incompatible (número excedido). El número debe de estar comprendido entre 1 y 4. Vuelva a introducirlo.");
				}
			} catch (InputMismatchException exc) {
				System.out.println("Opción incompatible (letra). Debe de introducir un valor numérico comprendido entre 1 y 4. Vuelva a introducirlo.");
				sc.nextLine();
			}
		} while (opcion < 1 || opcion > 4);
		return opcion;
	}
	
}

