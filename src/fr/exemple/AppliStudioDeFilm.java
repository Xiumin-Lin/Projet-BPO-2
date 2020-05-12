package fr.exemple;

import java.io.FileNotFoundException;

import fr.film.Film;
import fr.film.Films;
import fr.montage.ModifColler;
import fr.montage.ModifEncadrer;
import fr.montage.ModifExtraire;
import fr.montage.ModifIncruster;
import fr.montage.ModifRepeter;

public class AppliStudioDeFilm {
	private static final Film FILM_1 = new LaDiagonaleDuFou();
	private static final Film FILM_2 = new LaDiagonaleDuFouDroite();
	private static final Film FILM_3 = new TriangleGaucheHaut();
	private static final Film FILM_4 = new TriangleDroiteBas();
	
	public static void FilmRepeter() {
		Film filmRep2X = new ModifRepeter(FILM_4, 2);
		Film filmRep2X2X = new ModifRepeter(filmRep2X, 2);
		Films.projeter(filmRep2X2X);
		filmRep2X2X.rembobiner(); 
		try {
			Films.sauvegarder(filmRep2X2X, "TriangleIncExt-Rep4X.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film1-Rep4X.txt' n'a pas pu être créé.");
		}
	}
	
	public static void FilmExtraire() {
		Film filmExtrait4A9 = new ModifExtraire(FILM_3, 5, 24);
		Films.projeter(filmExtrait4A9);
		filmExtrait4A9.rembobiner(); 
		try {
			Films.sauvegarder(filmExtrait4A9, "Triangle-.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film-Ext-5-24' n'a pas pu être créé.");
		} 
	}
	
	public static void FilmEncadrer() {
		Film filmEnc = new ModifEncadrer(FILM_2);
		Films.projeter(filmEnc);
		filmEnc.rembobiner(); 
		try {
			Films.sauvegarder(filmEnc, "Film2-Enc.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film2-Enc.txt' n'a pas pu être créé.");
		}
	}
	
	public static void FilmColler() {
		Film filmCol = new ModifColler(FILM_1, FILM_2);
		Films.projeter(filmCol);
		filmCol.rembobiner(); 
		try {
			Films.sauvegarder(filmCol, "Film1-Col-Film2.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film1-Col-Film2.txt' n'a pas pu être créé.");
		}
	}
	
	public static void FilmIncruster() {
		Film filmInc = new ModifIncruster(FILM_3, FILM_3, 3, 5);
		Films.projeter(filmInc);
		filmInc.rembobiner(); 
		try {
			Films.sauvegarder(filmInc, "TriangleNumInc2.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film3-Inc-Film4.txt' n'a pas pu être créé.");
		}
	}
	
	public static void main(String[] args) {
		AppliStudioDeFilm.FilmExtraire();
	}
	
}
