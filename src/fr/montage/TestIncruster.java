package fr.montage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fr.exemple.*;
import fr.film.*;

class TestIncruster {
	private Film film1 = new ImageFull(); // 10 frames, 10x16
	private Film film2 = new LaDiagonaleDuFou(); // 20 frames, 10x10
	int nbFrame;
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
		Film filmInc = new Incruster(film1, film2, 5, 3);
		assertEquals(film1.hauteur(), filmInc.hauteur());
		assertEquals(film1.largeur(), filmInc.largeur());
	}
	
	@Test
	void testFilmInc() {
		Film filmInc = new Incruster(film1, film2, 5, 3);
		nbFrame = getNbFrame(filmInc);
		assertEquals(10, nbFrame);
		//on inverse l'ordre des 2 films
		filmInc = new Incruster(film2, film1, 5, 3);
		nbFrame = getNbFrame(filmInc);
		assertEquals(20, nbFrame);
	}
}
