package fr.montage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.exemple.TriangleDroiteBas;
import fr.film.*;

class TestModifExtraire {
	Film film = new TriangleDroiteBas(); // 24 frames, 12x11
	Film filmExt = new ModifExtraire(film, 5, 16); // 24 frames, 12x11
	char[][] ecran = Films.getEcran(filmExt);
	
	@Test
	void testHauteurLargeur() {
		assertEquals(film.hauteur(), filmExt.hauteur());
		assertEquals(film.largeur(), filmExt.largeur());
	}
	
	@Test
	void testSuivante() {
		//Le nouveau film a autant de frames que le film1, c'est-à-dire 24 frames (numéroté de 0 à 23)
		for(int i = 0; i < 24; ++i) {
			assertTrue(film.suivante(ecran));
			Films.effacer(ecran);
		}
		// Donc le frame numero 24 n'existe pas
		assertFalse(filmExt.suivante(ecran));
		// On rembobine le film pour revenir au frame numero 0
		filmExt.rembobiner();
		assertTrue(filmExt.suivante(ecran));
		Films.effacer(ecran);
	}
	
	@Test
	void testParametreErreur() {
		filmExt = new ModifExtraire(film, 5, -6); //Extrait Vide
		assertFalse(filmExt.suivante(ecran));
		Films.effacer(ecran);
		filmExt.rembobiner();
		
		filmExt = new ModifExtraire(film, -6, 10); //Extrait des frames 0 à 10
		for(int i = 0; i < 11; ++i) {
			assertTrue(filmExt.suivante(ecran));
			Films.effacer(ecran);
		}
		assertFalse(filmExt.suivante(ecran)); // le 11e frame n'existe pas
		filmExt.rembobiner();
		
		filmExt = new ModifExtraire(film, 15, 50); //Extrait des frames 15 à 23
		for(int i = 0; i < 9; ++i) {
			assertTrue(filmExt.suivante(ecran));
			Films.effacer(ecran);
		}
		assertFalse(filmExt.suivante(ecran)); // le 11e frame n'existe pas
		filmExt.rembobiner();
	}
}
