package fr.montageVersion2;

import fr.film.Film;
import fr.film.FilmCopie;

public abstract class Montage2 implements Film{
	/**
	 * Le copie du film original dont on souhaite modifier
	 */
	protected Film filmOriginal;
	
	public Montage2(Film f) {
		assert(f != null ): "Le film entré a un réfèrence null";
		filmOriginal = new FilmCopie(f); //Copie profonde du film original
	}
	
	@Override
	public int hauteur() {
		return filmOriginal.hauteur();
	}

	@Override
	public int largeur() {
		return filmOriginal.largeur();
	}
}
