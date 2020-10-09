package Practica3;

/**
 * Clase Vecino
 * @author David González Bermúdez, Lucas Gutiérrez Durán, Sergio Jiméne Roncero
 *
 */
public class Vecino {
	
	private int dni;
	private int posicion;
	
	/**
	 * Constructor de Vecino
	 * @param i
	 */
	public Vecino(int i) {
		this.dni = DNIaleatorio();
		this.posicion = i;
	}
	
	/**
	 * Get que devuelve el DNI.
	 * @return dni
	 */
	public int getDNI() {
		return dni;
	}
	
	/**
	 * Get que devuelve la posición del vecino en su lista
	 * @return posicion
	 */
	public int getPosicion() {
		return posicion;
	}
	
	/**
	 * Método que genera el DNI aleatorio para el constructor.
	 * @return dni
	 */
	private int DNIaleatorio() {
		return (int)(Math.random()*100000000);
	}
	
	/**
	 * Método que devuelve el último dígito del DNI al calcularse el resto de dividirse entre 10. Intervalo [0, 9]
	 * @return int
	 */
	public int devolverUltimoNumeroDNI() {
		return dni%10;
	}
	
	/**
	 * Método toString de Vecino
	 * @return String
	 */
	public String toString() {
		return "DNI: " + dni + letra();
	}
	
	/**
	 * Método que devuelve la letra correspondida a dicho DNI para completar.
	 * @return letra
	 */
	public char letra() {
		char[] v = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		return v[dni%23];
	}
	
}
