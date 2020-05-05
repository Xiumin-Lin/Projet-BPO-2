package fr.montage;

import fr.film.Film;

public class ModifRepeter extends Montage {
	/**
	 * nbRep : Le nombre de répétition du film
	 */
	private int nbRep;
	/**
	 * cptRep : Compte le nombre de répétition effectué
	 */
	private int cptRep = 0;

	public ModifRepeter(Film film, int i) {
		super.filmOriginal = film;
		nbRep = i;
	}
	
	@Override
	public boolean suivante(char[][] écran) {
		if(nbRep <= 0)
			return false;
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