package fr.exemple;

import fr.film.Film;

public class TriangleDroiteBas extends TriangleGaucheHaut implements Film{

	@Override
	public boolean suivante(char[][] écran) {
		if (num == NB_IMAGES)
			return false;
		if(num%(NB_IMAGES/2) == 0) {}
		else {
			int k = 0;
			for(int i = hauteur() - 1; i >= hauteur() - 1 - ((num -1)% hauteur()); --i) {
				for(int j = 0 + k; j < largeur(); ++j) {
					écran[i][j] = 'A';
					//System.out.println(i + " " + j);
				}
				++k;
			}
		}
		++num;
		return true;
	}

}
