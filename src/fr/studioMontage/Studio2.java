package fr.studioMontage;

import fr.film.Film;
import fr.montageVersion2.*;

public class Studio2 {
	public static Film encadrement(Film filmOriginal) {
		return new Encadrer2(filmOriginal);
	}
	
	public static Film repetition(Film filmOriginal, int nbRep) {
		return new Repeter2(filmOriginal, nbRep);
	}
	
	public static Film extraction(Film filmOriginal, int NumDeb, int NumFin) {
		return new Extraire2(filmOriginal, NumDeb, NumFin);
	}
	
	public static Film collage(Film filmOriginal, Film f2) {
		return new Coller2(filmOriginal, f2);
	}
	
	public static Film incrustation(Film filmOriginal, Film f2, int numLigne, int numColonne) {
		return new Incruster2(filmOriginal, f2, numLigne, numColonne);
	}
}
