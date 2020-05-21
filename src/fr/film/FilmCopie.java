package fr.film;

import java.util.ArrayList;

/**
 * La classe FilmCopie permet de créer une copie d'un film en stockant 
 * chaque image du film dans une ArrayList<char[][]> "filmCopie". <br>
 * Cette classe fonctionne comme un film normal (les méthodes de 
 * l'interface Film sont applicables).
 */
public class FilmCopie implements Film{
	/**
	 * Stock chaque frame du film copié
	 */
	protected ArrayList<char[][]> filmCopie;
	/**
	 * la hauteur de l'écran du film copié
	 */
	private int hauteur;
	/**
	 * la largeur de l'écran du film copié
	 */
	private int largeur;
	/**
	 * Le numéro du frame
	 */
	private int num = 0;
	
	/**
	 * Constructeur de la class FilmCopie
	 * @param f : le film à copier
	 */
	public FilmCopie(Film f) {
		filmCopie = new ArrayList<>();
		this.copie(f);
		this.hauteur = f.hauteur();
		this.largeur = f.largeur();
	}

	private void copie(Film f){
		filmCopie.clear();
		char[][] ecran = Films.getEcran(f);
		while (f.suivante(ecran)) {
			char[][] copieEcran = Films.getEcran(f);
			for(int i = 0; i < f.hauteur(); ++i) {
				for(int j = 0; j < f.largeur(); ++j) {
					copieEcran[i][j] = ecran[i][j]; //Copie profonde
				}
			}
			filmCopie.add(copieEcran);
			Films.effacer(ecran);
		}
		f.rembobiner();
	}
	
	@Override
	public int hauteur() {
		return hauteur;
	}

	@Override
	public int largeur() {
		return largeur;
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(num == filmCopie.size())
				return false;
		for(int i = 0; i < hauteur(); ++i) {
			for(int j = 0; j < largeur(); ++j) {
				écran[i][j] = filmCopie.get(num)[i][j]; //Copie profonde
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
