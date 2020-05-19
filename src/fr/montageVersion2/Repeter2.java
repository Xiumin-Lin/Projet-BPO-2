package fr.montageVersion2;

import fr.film.Film;

/**
 * La classe Repeter hérite de la classe Montage. 
 * Cette classe modifie un film en le repetant autant de fois qu'on le souhaite.
 */
public class Repeter2 extends Montage2{
	/**
	 * nbRep : Le nombre de répétition du film
	 */
	private int nbRep;
	/**
	 * cptRep : Compte le nombre de répétition effectué
	 */
	private int cptRep = 0;
	
	/**
	 * Constructeur de la class Repeter
	 * @param f : le film original à repeter
	 * @param nb : le nombre de repetition à faire
	 */
	public Repeter2(Film f, int nb) {
		super(f); //Copie profonde du film original à repeter
		nbRep = (nb <= 0)? 0 : nb;
	}
	
	@Override
	public boolean suivante(char[][] écran) {
		if(cptRep >= nbRep) {
			return false;
		}
		if(!filmOriginal.suivante(écran)) {
			++cptRep;
			if(cptRep >= nbRep) {
				return false;
			}
			filmOriginal.rembobiner();
			return filmOriginal.suivante(écran);
		}
		return true;
	}

	@Override
	public void rembobiner() {
		filmOriginal.rembobiner();
		cptRep = 0;
	}
}
