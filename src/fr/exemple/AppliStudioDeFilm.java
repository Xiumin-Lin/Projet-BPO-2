package fr.exemple;

import java.io.FileNotFoundException;

import fr.film.Film;
import fr.film.Films;
import fr.studioMontage.*;

public class AppliStudioDeFilm {
	private static final Film FILM_1 = new LaDiagonaleDuFou();
	private static final Film FILM_2 = new ImageFull();
	
	public static void main(String[] args) {
		//Répetition sur 3 couches
//		Film film = Studio.repetition(FILM_2, 1);
//		Film film2 = Studio.repetition(film, 3);
//		Film filmFinal = Studio.repetition(film2, 4);
		
		//Collage sur 3 couches
//		Film film = Studio.collage(FILM_2, FILM_2);
//		Film film2 = Studio.collage(film, FILM_2);
//		Film filmFinal = Studio.collage(film2, FILM_3);
//		
		//Encadrement sur 3 couches
//		Film film = Studio.encadrement(FILM_2);
//		Film film2 = Studio.encadrement(film);
//		Film filmFinal = Studio.encadrement(film2);
		
		//Extraction sur 3 couches
//		Film film = Studio.extraction(FILM_2, 2, 15);
//		Film film2 = Studio.extraction(film, 1, 7);
//		Film filmFinal = Studio.extraction(film2, 5, 20);
		
		//Incrustation sur 3 couches
//		Film film = Studio.incrustation(FILM_2, FILM_3, 2, 5);
//		Film film2 = Studio.incrustation(film, FILM_3, 4, 2);
//		Film filmFinal = Studio.incrustation(film, film2, 6, 8);
		
		//Film avec de mutiple modification
//		Film film = Studio.collage(FILM_2, FILM_2);
//		Film film2 = Studio.collage(film, FILM_2);
//		Film film3 = Studio.collage(film2, FILM_2);
//		Film film4 = Studio.encadrement(film3);
//		Film film5 = Studio.encadrement(film4);
//		Film film6 = Studio.encadrement(film5);
//		Film film7 = Studio.extraction(film6, 24, 40);
//		Film film8 = Studio.extraction(film7, 2, 15);
//		Film filmFinal = Studio.extraction(film8, 3, 9);
		
		//Film avec de mutiple modification
		Film film = Studio.collage(FILM_2, FILM_2);
		Film film2 = Studio.collage(film, FILM_2);
		Film film3 = Studio.collage(film2, FILM_2);
		Film film4 = Studio.encadrement(film3);
		Film film5 = Studio.encadrement(film4);
		Film film6 = Studio.encadrement(film5);
		Film film7 = Studio.extraction(film6, 8, 40);
		Film film8 = Studio.extraction(film7, 2, 30);
		Film film9 = Studio.extraction(film8, -5, 9);
		Film film10 = Studio.incrustation(film8, film9, 9, 6);
		Film filmFinal = Studio.incrustation(film10, FILM_1, 5, 3);

		Films.projeter(filmFinal);
		filmFinal.rembobiner();
		
		try {
			Films.sauvegarder(filmFinal, "filmFinal.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Film.txt' n'a pas pu être créé.");
		}
		System.out.println("Fini");
	}
	
}
