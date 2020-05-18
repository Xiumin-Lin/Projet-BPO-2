package fr.exemple;

import java.io.FileNotFoundException;

import fr.film.Film;
import fr.film.Films;
import fr.studioMontage.*;

public class AppliStudioDeFilm {
//	private static final Film FILM_1 = new LaDiagonaleDuFou();
		private static final Film FILM_2 = new ImageFull();
		private static final Film FILM_3 = new TriangleGaucheHaut();
	
	public static void main(String[] args) {
		Film film = Studio.incrustation(FILM_2, FILM_3, 2, 6);
		Film film1 = Studio.incrustation(film, FILM_3, 5, 7);
		Films.projeter(film1);
		film1.rembobiner(); 
		
		
		try {
			Films.sauvegarder(film1, "IncrustationBON.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film.txt' n'a pas pu être créé.");
		}
	}
	
}
