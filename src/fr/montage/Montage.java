package fr.montage;

import fr.film.Film;

/**
 * La classe Montage est une classe abstraite qui implément l'interface Film. 
 * C'est une base pour toutes les classes permettant de modifier un film existant
 */
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
