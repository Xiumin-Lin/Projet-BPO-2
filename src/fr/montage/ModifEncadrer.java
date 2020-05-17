package fr.montage;

import fr.film.Film;
import fr.film.Films;

/**
 * La classe ModifEncadrer hérite de la classe Montage. 
 * Cette classe encadre chaque image d'un film.
 */
public class ModifEncadrer extends Montage {
	private static final char CADRE = '*';
	/**
	 * Constructeur de la class ModifEncadrer
	 * @param film : le film à encadrer
	 */
	public ModifEncadrer(Film film) {
		assert(film != null ): "Les films entrées ont des références null";
		super.filmOriginal = film;
	}

	@Override
	public int hauteur() {
		return filmOriginal.hauteur() + 2;
	}

	@Override
	public int largeur() {	
		return filmOriginal.largeur() + 2;
	}

	@Override
	public boolean suivante(char[][] écran) {
		char[][] écran2 = Films.getEcran(this.filmOriginal);;
		if(!filmOriginal.suivante(écran2))
			return false;
		
		for(int i = 0; i < hauteur(); i++) {
				écran[i][0] = CADRE;
				écran[i][largeur() -1] = CADRE ;
		}
		for(int j = 0; j < largeur(); j++) {
				écran[0][j] = CADRE;
				écran[hauteur() -1][j] = CADRE;
		}
		
		for(int i = 1; i <= filmOriginal.hauteur(); i++) {
			for(int j = 1; j <= filmOriginal.largeur(); j++) {
				écran[i][j] = écran2[i-1][j-1];
			}
		}
		return true;
			
	}

	@Override
	public void rembobiner() {
		super.filmOriginal.rembobiner();
	}
}