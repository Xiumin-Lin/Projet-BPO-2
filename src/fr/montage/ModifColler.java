package fr.montage;

import fr.film.Film;

/**
 * La classe ModifColler hérite de la classe Montage.
 * Celles-ci colle deux films l'un à la suite de l'autre
 */
public class ModifColler extends Montage {
	private Film filmCo;

	/**
	 * Constructeur de la class ModifColler
	 * @param film1 : le premier film
	 * @param film2 : le film qui s'ajoute à la suite du premier
	 */
	public ModifColler(Film film1, Film film2) {
		assert(film1 != null && film2 != null) : "Les films entrés ont des références null";
		super.filmOriginal = film1;
		this.filmCo = film2;
	}

	@Override
	public int hauteur() {
		if (filmOriginal.hauteur() > filmCo.hauteur())
			return filmOriginal.hauteur();
		else 
			return filmCo.hauteur();
	}

	@Override
	public int largeur() {
		if(filmOriginal.largeur() > filmCo.largeur())
			return filmOriginal.largeur();
		else 
			return filmCo.largeur();
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(!filmOriginal.suivante(écran)) {
			if(!filmCo.suivante(écran)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void rembobiner() {
		super.filmOriginal.rembobiner();
		this.filmCo.rembobiner();
	}
}