package fr.montage;

import fr.film.Film;
import fr.film.Films;

/**
 * La classe Extraire hérite de la classe Montage. <br>
 * Cette classe permet d'extraire une partie d'un film désigné par les numéros
 * de la premieres et dernieres images (frames) à inclure du film. <br>
 * La 1ère image d'un film porte le numéro 0. <br>
 * _ Si le num de la 1ère image à extraire est négatif, l'extrait démarre 
 * 		alors au début du film original. <br>
 * _ Si le num de la dernière image à extraire est supérieur au nombre d'image 
 * 		total du film, l'extrait va alors s'arrêter à la fin du film original. <br>
 * _ Si le num de la dernière image est supérireur à la première, 
 *  	l'extrait sera alors vide. 
 */
public class Extraire extends Montage {
	/**
	 * Le num du frame actuel (-1 signifie que le film n'est pas lancé)
	 */
	private int numFrame = -1;
	/**
	 * Num du 1er image à inclure
	 */
	private int numDebut;
	/**
	 * Num du dernier image à inclure
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
	public Extraire(Film f, int numD, int numF) {
		assert(f != null ): "Le film entré a une référence null";
		super.filmOriginal = f;
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
			if(!filmOriginal.suivante(écran))
				return false;
			if(numFrame < numDebut)
				Films.effacer(écran);
		} while(numFrame < numDebut);
		return (numFrame > numFin)? false : true;
	}

	@Override
	public void rembobiner() {
		filmOriginal.rembobiner();
		numFrame = -1;
	}

}
