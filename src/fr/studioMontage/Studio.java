package fr.studioMontage;

import fr.film.Film;
import fr.montage.*;

public class Studio {
	
	public static Film encadrement(Film filmOriginal) {
		return new Encadrer(filmOriginal);
	}
	
	public static Film repetition(Film filmOriginal, int nbRep) {
		return new Repeter(filmOriginal, nbRep);
	}
	
	public static Film extraction(Film filmOriginal, int NumDeb, int NumFin) {
		return new Extraire(filmOriginal, NumDeb, NumFin);
	}
	
	public static Film collage(Film filmOriginal, Film f2) {
		return new Coller(filmOriginal, f2);
	}
	
	public static Film incrustation(Film filmOriginal, Film f2, int numLigne, int numColonne) {
		return new Incruster(filmOriginal, f2, numLigne, numColonne);
	}
}
