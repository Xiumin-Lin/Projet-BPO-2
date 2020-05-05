package fr.montage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.exemple.LaDiagonaleDuFou;
import fr.film.Film;
import fr.film.Films;

class TestModifRepeter {
	Film film = new LaDiagonaleDuFou();
	
	@Test
	void testHauteurLargeur() {
		Film filmRep2X = new ModifRepeter(film, 2);
		assertEquals(film.hauteur(), filmRep2X.hauteur());
		assertEquals(film.largeur(), filmRep2X.largeur());
	}
	@Test
	void testSuivante() {
		Film filmRep2X = new ModifRepeter(film, 2);
		char[][] ecran = Films.getEcran(filmRep2X);
		//Film a au départ 20 frames, en répétant 2x, elle passe à 40 frames
		for(int i = 0; i < 40; ++i) {
			assertTrue(filmRep2X.suivante(ecran));
			Films.effacer(ecran);
		}
		//Le 41e frame n'existe donc pas
		assertFalse(filmRep2X.suivante(ecran));
		// On rembobine le film revenir au frame numero 0
		filmRep2X.rembobiner();
		assertTrue(filmRep2X.suivante(ecran));
	}
	@Test
	void testSuivanteNonRep() {
		Film filmRep0X = new ModifRepeter(film, 0); //répété 0 fois
		Film filmRepNegatifX = new ModifRepeter(film, -10); // répété -10 fois
		char[][] ecran = Films.getEcran(filmRep0X);
		assertFalse(filmRep0X.suivante(ecran));
		Films.effacer(ecran);
		assertFalse(filmRepNegatifX.suivante(ecran));
		Films.effacer(ecran);
	}

}
