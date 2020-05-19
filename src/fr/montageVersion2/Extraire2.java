package fr.montageVersion2;

import fr.film.Film;
import fr.film.Films;

/**
 * La classe Extraire hérite de la classe Montage. <br>
 * Cette classe permet d'extraire une partie d'un film désigné par les numéros de la
 * premieres et dernieres images (frames) à inclure du film. <br>
 * La 1ere image d'un film porte le numéro 0. <br>
 * 	_ Si le num de la 1ere images à extraire est negatif, l'extrait démarre 
 * 		alors au début du film original.
 * 	_ Si le num de la derniere images à extraire est superireur au nombre d'image 
 * 		total du film, l'extrait va alors s'arreter à la fin du film original.
 */
public class Extraire2 extends Montage2{
	private int numFrame = -1;
	/**
	 * Numero du 1er image à inclure
	 */
	private int numDebut;
	/**
	 * Numero du dernier image à inclure
	 */
	private int numFin;
	/**
	 * Indique si l'extrait est vide ou pas
	 */
	private boolean estVide;
	
	/**
	 * Constructeur de la class Extraire
	 * @param f : le film à extraire
	 * @param numD : numero de la 1ere image à inclure
	 * @param numF : numero de la derniere image à inclure
	 */
	public Extraire2(Film f, int numD, int numF) {
		super(f); //Copie profonde du film original à extraire
		this.numDebut = (numD < 0)? 0 : numD;
		this.numFin = numF;
		this.estVide = (numDebut > numFin)? true : false;
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(this.estVide)
			return false;
		do {
			++numFrame;
			Films.effacer(écran);
			if(!filmOriginal.suivante(écran))
				return false;
		} while(numFrame < numDebut);
		return (numFrame > numFin)? false : true;
	}

	@Override
	public void rembobiner() {
		this.filmOriginal.rembobiner();
		this.numFrame = -1;
	}
}