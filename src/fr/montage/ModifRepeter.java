package fr.montage;

import fr.film.Film;

/**
 * La classe ModifRepeter hérite de la classe Montage. 
 * Cette classe modifie un film en le repetant autant de fois qu'on le souhaite.
 */
public class ModifRepeter extends Montage {
	/**
	 * nbRep : Le nombre de répétition du film
	 */
	private int nbRep;
	/**
	 * cptRep : Compte le nombre de répétition effectué
	 */
	private int cptRep = 0;
	
	/**
	 * Constructeur de la class ModifRepeter
	 * @param film : le film original à repeter
	 * @param nb : le nombre de repetition à faire
	 */
	public ModifRepeter(Film film, int nb) {
		super.filmOriginal = film;
		if(nb <= 0)
			nbRep = 0;
		else 
			nbRep = nb;
	}
	
	@Override
	public boolean suivante(char[][] écran) {
		if(!filmOriginal.suivante(écran)) {
			++cptRep;
			if(cptRep == nbRep) {
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