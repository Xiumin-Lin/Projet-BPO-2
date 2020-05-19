package fr.montageVersion2;

import fr.film.Film;
import fr.film.FilmCopie;
import fr.film.Films;

/**
 * La classe Incruster hérite de la classe Montage. 
 * Cette classe modifie un film en incrustant un autre film dans ce film à une position précise.
 */
public class Incruster2 extends Montage2{
	/**
	 * le film a inscruter dans le film original
	 */
	private Film filmIncruste;
	
	private int idxRow;
	private int idxCol;
	private int filmInHauteurMax;
	private int filmInLargeurMax;
	private char[][] ecranIn;
	
	/**
	 * Constructeur de la class Incruster
	 * @param f1 : le film recevrant l'incrustation
	 * @param f2 : le film devant être inscruter
	 * @param row : le numéro de la ligne où le film doit être incrusté
	 * @param col : le numéro de la colonne où le film doit être incrusté
	 */
	public Incruster2(Film f1, Film f2, int row, int col) {
		super(f1);
		assert(f1 != null && f2 != null) : "Les films entrés ont des réfèrences null";
		assert(row > 0 && row <= f1.hauteur() && col > 0 && col <= f1.largeur())
			: "le numéro de la ligne/colonne est invalide";
		
		this.filmIncruste = new FilmCopie(f2); //Copie Profonde du film devant être incruster
		this.idxRow = row - 1;
		this.idxCol = col - 1;
		
		filmInHauteurMax = (filmOriginal.hauteur() >= (filmIncruste.hauteur() + idxRow)) ? 
				filmIncruste.hauteur() + idxRow : filmOriginal.hauteur() ;
		filmInLargeurMax = (filmOriginal.largeur() >= (filmIncruste.largeur() + idxCol)) ? 
				filmIncruste.largeur() + idxCol : filmOriginal.largeur() ;
		this.ecranIn = Films.getEcran(filmIncruste);
	}
	
	@Override
	public boolean suivante(char[][] écran) {
		if(!filmOriginal.suivante(écran))
			return false;
		else {
			Films.effacer(ecranIn);
			if(filmIncruste.suivante(ecranIn))
				incrustation(écran,ecranIn); //Incrustation
			return true;
		}
	}

	@Override
	public void rembobiner() {
		filmOriginal.rembobiner();
		filmIncruste.rembobiner();
	}
	
	/**
	 * Incruste l'écran numéro 2 dans l'écran numéro 1
	 * @param ecranOrigine : l'écran recevant l'incrustation
	 * @param ecranIn : l'écran devant être incruster
	 */
	private void incrustation(char[][] ecranOrigine, char[][] ecranIn) {
		for(int i = 0; idxRow + i < filmInHauteurMax; ++i) {
			for(int j = 0; idxCol + j < filmInLargeurMax; ++j) {
				ecranOrigine[idxRow + i][idxCol + j] = ecranIn[i][j];
			}
		}
	}
}
