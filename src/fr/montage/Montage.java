package fr.montage;

import fr.film.Film;

public abstract class Montage implements Film{
	/**
	 * Le film original dont on souhaite modifier
	 */
	protected Film filmOriginal;

	@Override
	public int hauteur() {
		return filmOriginal.hauteur();
	}

	@Override
	public int largeur() {
		return filmOriginal.largeur();
	}
}
