package fr.montage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fr.exemple.LaDiagonaleDuFou;
import fr.film.*;

class TestExtraire {
	private Film film = new LaDiagonaleDuFou(); // 20 frames, 10x10
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
		Film filmExt = new Extraire(film, 5, 16); // 12 frames, 10x10
		assertEquals(film.hauteur(), filmExt.hauteur());
		assertEquals(film.largeur(), filmExt.largeur());
	}
	@Test
	void testFilmExt() {
		Film filmExt = new Extraire(film, 5, 16); // 12 frames, 10x10
		nbFrame = getNbFrame(filmExt);
		assertEquals(12, nbFrame); //l'extrait possède 12 frames
	}
	@Test
	void testFilmExtExt() { //Extraction d'un extrait
		Film filmExt = new Extraire(film, 5, 16); // 12 frames, 10x10
		Film filmExtExt = new Extraire(filmExt, 4, 8); // 5 frames, 10x10
		nbFrame = getNbFrame(filmExtExt);
		assertEquals(5, nbFrame); //le nouvel extrait possède 5 frames
	}
	@Test
	void testExtraitVide() {
		Film filmExtVide = new Extraire(film, 5, -6); //Extrait Vide
		nbFrame = getNbFrame(filmExtVide);
		assertEquals(0, nbFrame);
	}
	@Test
	void testExtraitHorsLimite() {
		Film filmExtHL = new Extraire(film, -6, 10); //l'extrait commence au frame 0
		nbFrame = getNbFrame(filmExtHL);
		assertEquals(11, nbFrame);
		
		filmExtHL.rembobiner();
		
		filmExtHL = new Extraire(film, 0, 50); //l'extrait se fini lorsque film est fini
		nbFrame = getNbFrame(filmExtHL);
		assertEquals(20, nbFrame);
	}
}
