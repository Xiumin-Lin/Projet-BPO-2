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
	
	public static void FilmRepeter() {
		Film filmRep2X = new ModifRepeter(FILM_1, 2);
		Film filmRep2X2X = new ModifRepeter(filmRep2X, 2);
		Films.projeter(filmRep2X2X);
		filmRep2X2X.rembobiner(); 
		try {
			Films.sauvegarder(filmRep2X2X, "Film1-Rep4X.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film1-Rep4X.txt' n'a pas pu être créé.");
		}
	}
	
	public static void FilmExtraire() {
		Film filmExtrait4A9 = new ModifExtraire(FILM_2, 4, 9);
		Films.projeter(filmExtrait4A9);
		filmExtrait4A9.rembobiner(); 
		try {
			Films.sauvegarder(filmExtrait4A9, "Film2-Ext4A9.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film2-Ext4A9' n'a pas pu être créé.");
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
		Film filmInc = new ModifIncruster(FILM_1, FILM_2);
		Films.projeter(filmInc);
		filmInc.rembobiner(); 
		try {
			Films.sauvegarder(filmInc, "Film1-Inc-Film2.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film1-Inc-Film2.txt' n'a pas pu être créé.");
		}
	}
	
	public static void main(String[] args) {
		AppliStudioDeFilm.FilmRepeter();
	}
	
}
