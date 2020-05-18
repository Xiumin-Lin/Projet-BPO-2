package fr.exemple;

public class TriangleDroiteBas extends TriangleGaucheHaut{

	@Override
	public boolean suivante(char[][] écran) {
		if (num == NB_IMAGES)
			return false;
		if(num%(NB_IMAGES/2) == 0) {}
		else {
			int k = 0;
			for(int i = hauteur() - 1; i >= hauteur() - 1 - ((num -1)% hauteur()); --i) {
				for(int j = 0 + k; j < largeur(); ++j) {
					//écran[i][j] = 'A';
					écran[i][j] = String.valueOf(num%10).charAt(0);
				}
				++k;
			}
		}
		++num;
		return true;
	}

}
