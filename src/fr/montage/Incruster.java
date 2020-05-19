package fr.montage;

import fr.film.Film;
import fr.film.Films;

/**
 * La classe Incruster hérite de la classe Montage. 
 * Cette classe modifie un film en incrustant un autre film dans ce film à une position précise.
 */
public class Incruster extends Montage {
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
	 * @param film1 : le film recevrant l'incrustation
	 * @param film2 : le film devant être inscruter
	 * @param row : le numéro de la ligne où le film doit être incrusté
	 * @param col : le numéro de la colonne où le film doit être incrusté
	 */
	public Incruster(Film film1, Film film2, int row, int col) {
		assert(film1 != null && film2 != null) : "Les films entrées ont des réfèrences null";
		assert(row > 0 && row <= film1.hauteur() && col > 0 && col <= film1.largeur())
			: "le numéro de la ligne/colonne est invalide";
		
		super.filmOriginal = film1;
		this.filmIncruste = film2;
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
			if(filmOriginal.equals(filmIncruste)) {
				for(int i = 0; i < filmOriginal.hauteur(); ++i) {
					for(int j = 0; j < filmOriginal.largeur(); ++j) {
						ecranIn[i][j] = écran[i][j]; //on crée une copie de l'écran original
					}
				}
				incrustation(écran,ecranIn);
			}
			else {
				if(filmIncruste.suivante(ecranIn))
					incrustation(écran,ecranIn); //Incrustation
			}
			return true;
		}
	}

	@Override
	public void rembobiner() {
		super.filmOriginal.rembobiner();
		this.filmIncruste.rembobiner();
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