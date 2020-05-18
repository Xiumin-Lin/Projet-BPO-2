package fr.montage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.exemple.LaDiagonaleDuFou;
import fr.exemple.TriangleDroiteBas;
import fr.film.*;

class TestIncruster {
	Film film = new TriangleDroiteBas(); // 24 frames, 12x11
	Film film2 = new LaDiagonaleDuFou(); // 20 frames, 10x10
	Film filmInc = new Incruster(film, film2, 5, 3);
	char[][] ecran = Films.getEcran(filmInc);
	
	@Test
	void testHauteurLargeur() {
		assertEquals(film.hauteur(), filmInc.hauteur());
		assertEquals(film.largeur(), filmInc.largeur());
	}
	
	@Test
	void testSuivante() {
		//Le nouveau film a autant de frames que le film1, c'est-à-dire 24 frames
		for(int i = 0; i < 24; ++i) {
			assertTrue(film.suivante(ecran));
			Films.effacer(ecran);
		}
		// Donc le 25e frame n'existe pas
		assertFalse(filmInc.suivante(ecran));
		// On rembobine le film pour revenir au frame numero 0
		filmInc.rembobiner();
		assertTrue(filmInc.suivante(ecran));
		Films.effacer(ecran);
	}
	
	@Test 
	void testParametreInvalide() {
	}

}
