package fr.montage;

import fr.film.Film;

/**
 * La classe Repeter hérite de la classe Montage. 
 * Cette classe modifie un film en le repetant autant de fois qu'on le souhaite.
 */
public class Repeter extends Montage {
	/**
	 * nbRep : Le nombre de répétition du film
	 */
	private int nbRep;
	/**
	 * cptRep : Compte le nombre de répétition effectué
	 */
	private int cptRep = 0;
	
	/**
	 * Constructeur de la class Repeter
	 * @param film : le film original à repeter
	 * @param nb : le nombre de repetition à faire
	 */
	public Repeter(Film film, int nb) {
		assert(film != null) : "Le film entré a une références null";
		super.filmOriginal = film;
		nbRep = (nb <= 0)? 0 : nb;
	}
	
	@Override
	public boolean suivante(char[][] écran) {
		if(cptRep >= nbRep) {
			return false;
		}
		if(!filmOriginal.suivante(écran)) {
			++cptRep;
			if(cptRep >= nbRep) {
				return false;
			}
			filmOriginal.rembobiner();
			return filmOriginal.suivante(écran);
		}
		return true;
	}

	@Override
	public void rembobiner() {
		filmOriginal.rembobiner();
		cptRep = 0;
	}
}