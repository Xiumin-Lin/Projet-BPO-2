package fr.montage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fr.exemple.*;
import fr.film.*;

class TestColler {
	private Film film1 = new LaDiagonaleDuFou(); // 20 frames, 10x10
	private Film film2 = new ImageFull(); // 10 frames, 10x16
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
		Film FilmCol = new Coller(film1, film2);
		assertEquals(10, FilmCol.hauteur()); //la hauteur la plus grande en film1 et film2
		assertEquals(16, FilmCol.largeur()); //la largeur la plus grande en film1 et film2
	}
	@Test
	void testFilmCol() {
		Film FilmCol = new Coller(film1, film2);
		nbFrame = getNbFrame(FilmCol);
		assertEquals(20 + 10, nbFrame);// 20 frames du film1 + 10 frames du film2
	}
}
