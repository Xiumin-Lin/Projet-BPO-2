package fr.montage;

import fr.film.Film;
import fr.film.Films;
/**
 * La classe ModifIncruster hérite de la classe Montage. 
 * Cette classe modifie un film en incrustant un autre film dans ce film à une position précise.
 */
public class ModifIncruster extends Montage {
	/**
	 * le film a inscruter dans le film original
	 */
	private Film filmIn;
	private int idxRow; 
	private int idxCol;
	private int filmInHauteurMax; 
	private int filmInLargeurMax;
	private char[][] ecranIn;
	/**
	 * Constructeur de la class ModifIncruster
	 * @param film1 : le film recevrant l'incrustation
	 * @param film2 : le film devant être inscruter
	 * @param row : le numéro de la ligne où le film doit être incrusté
	 * @param col : le numéro de la colonne où le film doit être incrusté
	 */
	public ModifIncruster(Film film1, Film film2, int row, int col) {
		assert(row > 0 && row <= film1.hauteur() && col > 0 && col <= film1.largeur())
			: "le numéro de la ligne/colonne est invalide";
		super.filmOriginal = film1;
		this.filmIn = film2;
		this.idxRow = row - 1;
		this.idxCol = col - 1;
		filmInHauteurMax = (filmOriginal.hauteur() >= (filmIn.hauteur() + idxRow)) ? 
				filmIn.hauteur() + idxRow : filmOriginal.hauteur() ;
		filmInLargeurMax = (filmOriginal.largeur() >= (filmIn.largeur() + idxCol)) ? 
				filmIn.largeur() + idxCol : filmOriginal.largeur() ;
		this.ecranIn = Films.getEcran(filmIn);
	}
	
	@Override
	public boolean suivante(char[][] écran) {
		if(!filmOriginal.suivante(écran))
			return false;
		else {
			if(filmOriginal.equals(filmIn)) {
				for(int i = 0; i < filmOriginal.hauteur(); ++i) {
					for(int j = 0; j < filmOriginal.largeur(); ++j) {
						ecranIn[i][j] = écran[i][j]; //on crée une copie de l'écran original
					}
				}
				incrustation(écran,ecranIn);
			}
			else {
				Films.effacer(ecranIn);
				if(filmIn.suivante(ecranIn)) {
					//Incrustation
					incrustation(écran,ecranIn);
				}
			}
			return true;
		}
	}

	@Override
	public void rembobiner() {
		super.filmOriginal.rembobiner();
		this.filmIn.rembobiner();
	}
	
	/**
	 * Incruste l'écran numéro 2 dans l'écran numéro 1
	 * @param ecran1 : l'écran recevant l'incrustation
	 * @param ecran2 : l'écran devant être incruster
	 */
	private void incrustation(char[][] ecran1, char[][] ecran2) {
		for(int i = 0; idxRow + i < filmInHauteurMax; ++i) {
			for(int j = 0; idxCol + j < filmInLargeurMax; ++j) {
				ecran1[idxRow + i][idxCol + j] = ecran2[i][j];
			}
		}
	}
}
