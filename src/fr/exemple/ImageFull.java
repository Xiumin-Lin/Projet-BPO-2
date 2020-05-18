package fr.exemple;

import fr.film.Film;

public class ImageFull implements Film{
	private int num = 0;
	private final int NB_IMAGES = 20;
	
	@Override
	public int hauteur() {
		return 10;
	}

	@Override
	public int largeur() {
		return 16;
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(num == NB_IMAGES)
			return false;
		for(int i = 0; i < (num)%hauteur() + 1; ++i) {
			for(int j = 0; j < largeur(); ++j) {
				écran[i][j] = String.valueOf(i).charAt(0);
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
