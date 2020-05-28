package fr.montage;

import fr.film.Film;
import fr.film.FilmCopie;
import fr.film.Films;

/**
 * La classe Incruster hérite de la classe Montage. 
 * Cette classe modifie un film en incrustant un autre film dans ce film à une position précise. <br>
 * _ Le numéro de la ligne et de la colonne où le film doit être incrusté ne doivent pas être
 * 	 supérieur à la taille de l'écran du film recevant l'incrustation. 
 * 	 La numérotation des lignes et colonnes commence à 1 <br>
 * _ Si le numéro de la ligne et/ou de la colonne est négatif, alors sa valeur est remplacée par 0
 * _ Il est conseillé d'éviter d'incruster un film ayant un nombre d'image illimité
 */
public class Incruster extends Montage {
	/** 
	 * le film à inscruter dans le film original 
	 */
	private Film filmIncruste;
	/** 
	 * l'indice de la ligne où le film doit être incrusté 
	 */
	private int idxRow;
	/** 
	 * l'indice de la colonne où le film doit être incrusté 
	 */
	private int idxCol;
	/**
	 * l'indice de la ligne que le filmIncruste ne doit pas dépasser dans l'écran du filmOriginal
	 */
	private int filmInHauteurMax;
	/**
	 * l'indice de la colonne que le filmIncruste ne doit pas dépasser dans l'écran du filmOriginal
	 */
	private int filmInLargeurMax;
	/** 
	 * l'écran du film à incruster 
	 */
	private char[][] ecranIn;
	
	/**
	 * Constructeur de la class Incruster
	 * @param f1 : le film recevrant l'incrustation
	 * @param f2 : le film devant être inscruter
	 * @param row : le numéro de la ligne où le film doit être incrusté (la 1ère ligne porte le numéro 1)
	 * @param col : le numéro de la colonne où le film doit être incrusté (la 1ère colonne porte le numéro 1)
	 */
	public Incruster(Film f1, Film f2, int row, int col) {
		assert(f1 != null && f2 != null) : "Les films entrées ont des références null";
		assert(row <= f1.hauteur() && col <= f1.largeur())
			: "le numéro de la ligne/colonne où le film doit être incrusté est invalide";
		
		super.filmOriginal = f1;
		this.filmIncruste = new FilmCopie(f2); //crée une copie du film à incruster
		this.idxRow = (row <= 0) ? 0 : row - 1;
		this.idxCol = (col <= 0) ? 0 : col - 1;
		
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
