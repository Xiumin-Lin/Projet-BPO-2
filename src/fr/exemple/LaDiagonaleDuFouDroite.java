package fr.exemple;

public class LaDiagonaleDuFouDroite extends LaDiagonaleDuFou{
	
	@Override
	public boolean suivante(char[][] écran) {
		if (super.num == LaDiagonaleDuFou.NB_IMAGES)
			return false;
		écran[super.num % hauteur()][hauteur() - 1 - super.num % hauteur()] = 'b'; 
		// un 'a' se balade sur la diagonale
		++super.num;
		return true;
	}
}
