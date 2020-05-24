package fr.montage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fr.exemple.LaDiagonaleDuFou;
import fr.film.*;

class TestEncadrer {
	private Film film = new LaDiagonaleDuFou(); //20 frames, 10x10
	private int nbFrame;
	
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
		Film filmEnc = new Encadrer(film); //10x10 -> 12x12
		assertEquals(film.hauteur() + 2, filmEnc.hauteur());
		assertEquals(film.largeur() + 2, filmEnc.largeur());
	}
	@Test
	void testFilmEncadrer(){
		Film filmEnc = new Encadrer(film);
		nbFrame = getNbFrame(filmEnc);
		assertEquals(20, nbFrame); //Encadrer ne modifie pas le nb de frame
	}
}
