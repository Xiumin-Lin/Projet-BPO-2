package fr.montage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.exemple.LaDiagonaleDuFou;
import fr.film.*;

class TestRepeter {
	private Film film = new LaDiagonaleDuFou(); //20 Frames, 10x10
	private int nbFrame = 0;
	
	private int getNbFrame(Film f) {
		int n = 0;
		char[][] ecran = Films.getEcran(f);
		while(f.suivante(ecran)) {
			++n;
			Films.effacer(ecran);
		}
		f.rembobiner();
		return n;
	}
	
	@Test
	void testHauteurLargeur() {
		Film filmRep2X = new Repeter(film, 2);
		assertEquals(film.hauteur(), filmRep2X.hauteur());
		assertEquals(film.largeur(), filmRep2X.largeur());
	}
	
	@Test
	void testFilmRep() {
		Film filmRep2X = new Repeter(film, 2);
		//Film a au départ 20 frames, en répétant 2x, elle passe à 40 frames
		nbFrame = getNbFrame(filmRep2X);
		assertEquals(40, nbFrame);
	}
	
	@Test
	void testFilmRepRep() { //Répétition d'un film déjà répété
		Film filmRep2X = new Repeter(film, 2); // 40 frames
		Film filmRep6X = new Repeter(filmRep2X, 3); //120 frames
		nbFrame = getNbFrame(filmRep6X);
		assertEquals(120, nbFrame);
	}
	
	@Test
	void testFilmRepVide() {
		Film filmRep0X = new Repeter(film, 0); //répété 0 fois
		nbFrame = getNbFrame(filmRep0X);
		assertEquals(0, nbFrame);
		
		Film filmRepNegatifX = new Repeter(film, -10); // répété n < 0 fois
		nbFrame = getNbFrame(filmRepNegatifX);
		assertEquals(0, nbFrame);
	}
}