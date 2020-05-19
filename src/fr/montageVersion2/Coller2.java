package fr.montageVersion2;

import fr.film.Film;
import fr.film.FilmCopie;

/**
 * La classe Coller hérite de la classe Montage.
 * Celles-ci colle deux films l'un à la suite de l'autre
 */
public class Coller2 extends Montage2{
	/**
	 * Le copie du film qui s'ajoute à la suite du premier
	 */
	private Film filmCo;
	
	/**
	 * Constructeur de la class Coller
	 * @param f1 : le premier film
	 * @param f2 : le film qui s'ajoute à la suite du premier
	 */
	public Coller2(Film f1, Film f2) {
		super(f1); //Copie Profonde du film original
		assert(f2 != null) : "Le film à coller a une référence null";
		this.filmCo = new FilmCopie(f2); //Copie Profonde du film à coller
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
		filmOriginal.rembobiner();
		this.filmCo.rembobiner();
	}
}
