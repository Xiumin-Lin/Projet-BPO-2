package fr.montage;

import fr.film.Film;

/**
 * La classe Coller hérite de la classe Montage.
 * Celles-ci collent deux films l'un à la suite de l'autre.
 */
public class Coller extends Montage {
	/**
	 * Le film qui s'ajoute à la suite du premier
	 */
	private Film film2;
	/**
	 * Indique si l'affichage du premier film est fini
	 */
	private boolean premierEstFini = false;
	/**
	 * Constructeur de la class Coller
	 * @param f1 : le premier film
	 * @param f2 : le film qui s'ajoute à la suite du premier
	 */
	public Coller(Film f1, Film f2) {
		assert(f1 != null && f2 != null) : "Les films entrés ont des références null";
		super.filmOriginal = f1;
		this.film2 = f2;
	}

	@Override
	public int hauteur() {
		if (filmOriginal.hauteur() > film2.hauteur())
			return filmOriginal.hauteur();
		else 
			return film2.hauteur();
	}

	@Override
	public int largeur() {
		if(filmOriginal.largeur() > film2.largeur())
			return filmOriginal.largeur();
		else 
			return film2.largeur();
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(!premierEstFini) {
			if(!filmOriginal.suivante(écran)) {
				filmOriginal.rembobiner();
				premierEstFini = true;
			}
		}
		if(premierEstFini) {
			if(!film2.suivante(écran)) {
				film2.rembobiner();
				return false;
			}
		}
		return true;
	}

	@Override
	public void rembobiner() {
		super.filmOriginal.rembobiner();
		this.film2.rembobiner();
		premierEstFini = false;
	}
}