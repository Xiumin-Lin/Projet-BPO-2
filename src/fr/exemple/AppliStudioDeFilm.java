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
		//Répetition sur 3 couches
//		Film film = Studio2.repetition(FILM_2, 1);
//		Film film2 = Studio2.repetition(film, 3);
//		Film film3 = Studio2.repetition(film2, 4);
		
		//Collage sur 3 couches
//		Film film = Studio2.collage(FILM_2, FILM_2);
//		Film film2 = Studio2.collage(film, FILM_2);
//		Film film3 = Studio2.collage(film2, FILM_3);
//		
		//Encadrement sur 3 couches
//		Film film = Studio2.encadrement(FILM_2);
//		Film film2 = Studio2.encadrement(film);
//		Film film3 = Studio2.encadrement(film2);
		
		//Extraction sur 3 couches
//		Film film = Studio2.extraction(FILM_2, 2, 15);
//		Film film2 = Studio2.extraction(film, 1, 7);
//		Film film3 = Studio2.extraction(film2, 5, 20);
		
		//Incrustation sur 3 couches
//		Film film = Studio2.incrustation(FILM_2, FILM_3, 2, 5);
//		Film film2 = Studio2.incrustation(film, FILM_3, 4, 2);
//		Film film3 = Studio2.incrustation(film, film2, 6, 8);
		
//		Film film = Studio.collage(FILM_2, FILM_2);
//		Film film2 = Studio.collage(film, FILM_2);
//		Film film3 = Studio.collage(film2, FILM_2);
//		Film film4 = Studio.encadrement(film3);
//		Film film5 = Studio.encadrement(film4);
//		Film film6 = Studio.encadrement(film5);
//		Film film7 = Studio.extraction(film6, 24, 40);
//		Film film8 = Studio.extraction(film7, 2, 15);
//		Film film1 = Studio.extraction(film8, 3, 9);
		
		Film film = Studio.collage(FILM_2, FILM_2);
		Film filmC = Studio.collage(FILM_2, FILM_2);
		
		Film film2 = Studio.collage(film, FILM_2);
		Film film2C = Studio.collage(filmC, FILM_2);
		
		Film film3 = Studio.collage(film2, FILM_2);
		Film film3C = Studio.collage(film2C, FILM_2);
		
		Film film4 = Studio.encadrement(film3);
		Film film4C = Studio.encadrement(film3C);
		
		Film film5 = Studio.encadrement(film4);
		Film film5C = Studio.encadrement(film4C);
		
		Film film6 = Studio.encadrement(film5);
		Film film6C = Studio.encadrement(film5C);
		
		Film film7 = Studio.extraction(film6, 8, 40);
		Film film7C = Studio.extraction(film6C, 8, 40);
		
		Film film8 = Studio.extraction(film7, 2, 30);
		Film film8C = Studio.extraction(film7C, 2, 30);
		
		Film film9 = Studio.extraction(film8, -5, 9);
		Film film9C = Studio.extraction(film8C, -5, 9);
		
		Film film1 = Studio.incrustation(film8, film9, 9, 6);
		
//		Film film = Studio2.collage(FILM_2, FILM_2);
//		Film film2 = Studio2.collage(film, FILM_2);
//		Film film3 = Studio2.collage(film2, FILM_2);
//		Film film4 = Studio2.encadrement(film3);
//		Film film5 = Studio2.encadrement(film4);
//		Film film6 = Studio2.encadrement(film5);
//		Film film7 = Studio2.extraction(film6, 8, 40);
//		Film film8 = Studio2.extraction(film7, 2, 30);
//		Film film9 = Studio2.extraction(film8, -5, 9);
//		Film film1 = Studio2.incrustation(film8, film9, 9, 6);
		
//		Films.projeter(film1);
//		film1.rembobiner();
		
		try {
			Films.sauvegarder(film1, "ggg.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film.txt' n'a pas pu être créé.");
		}
		System.out.println("OK");
	}
	
}
