package fr.exemple;

import fr.film.Film;

public class TriangleGaucheHaut implements Film {
	protected int num = 0;
	protected static final int NB_IMAGES = 24;
	protected int vide = 0;
	@Override
	public int hauteur() {
		return 12;
	}

	@Override
	public int largeur() {
		return 11;
	}

	@Override
	public boolean suivante(char[][] écran) {
		if (num == NB_IMAGES)
			return false;
		if(num%(NB_IMAGES/2) == 0) {}
		else {
			for(int i = 0; i < (num % hauteur()); ++i) {
				for(int j = largeur() - 1 - i; j >= 0; --j) {
					//écran[i][j] = 'V';
					écran[i][j] = String.valueOf(num%10).charAt(0);
				}
			}
		}
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		num = 0;
	}

}
