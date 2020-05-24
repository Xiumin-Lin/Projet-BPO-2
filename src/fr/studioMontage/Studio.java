package fr.studioMontage;

import fr.film.Film;
import fr.montage.*;

/**
 * La classe Studio réunit l'ensemble de méthodes de classe 
 * permettant de recréer un film existant avec des modifications.
 */
public class Studio {
	
	/**
	 * Encadre un film avec le caratère '*'
	 * @param filmOriginal : le film à encadrer
	 * @return un nouveau film représentant le film encadré
	 */
	public static Film encadrement(Film filmOriginal) {
		return new Encadrer(filmOriginal);
	}
	
	/**
	 * Répète un film un nombre donné de fois
	 * @param filmOriginal : le film à faire repéter
	 * @param nbRep : le nombre de répétition
	 * @return un nouveau film représentant le film répété nbRep fois
	 */
	public static Film repetition(Film filmOriginal, int nbRep) {
		return new Repeter(filmOriginal, nbRep);
	}
	
	/**
	 * Extrait une partie d'un film désigné par les numéros
	 * de la premieres et dernieres images (frames) à inclure du film. <br>
	 * La 1ère image d'un film porte le numéro 0. <br>
	 * _ Si le num de la 1ère image à extraire est négatif, l'extrait démarre 
	 * 	 alors au début du film original. <br>
	 * _ Si le num de la dernière image à extraire est supérieur au nombre d'image 
	 * 	 total du film, l'extrait va alors s'arrêter à la fin du film original. <br>
	 * _ Si le num de la dernière image est supérireur à la première, 
	 * 	 l'extrait sera alors vide. 
	 * @param filmOriginal : le film à extraire
	 * @param NumDeb : le numéro de la 1ère images à extraire 
	 * @param NumFin : le numéro de la dernière images à extraire
	 * @return un nouveau film représentant l'extrait du film souhaité
	 */
	public static Film extraction(Film filmOriginal, int NumDeb, int NumFin) {
		return new Extraire(filmOriginal, NumDeb, NumFin);
	}
	
	/**
	 * Colle deux films l'un à la suite de l'autre.
	 * @param filmOriginal : le 1er film
	 * @param f2 : Le film qui s'ajoute à la suite du premier
	 * @return un nouveau film représentant le collage des 2 films entrés
	 */
	public static Film collage(Film filmOriginal, Film f2) {
		return new Coller(filmOriginal, f2);
	}
	
	/**
	 * Incruste un film dans un autre film à une position précise. <br>
	 * _ Le numéro de la ligne et de la colonne où le film doit être incrusté ne doivent pas être
	 * 	 en dehors de la taille de l'écran du film recevrant l'incrustation. 
	 * 	 La numérotation des lignes et colonnes commence à 1. <br>
	 * _ Si le numéro de la ligne et/ou de la colonne est négatif, alors sa valeur est remplacée par 0
	 * @param filmOriginal : le film recevant l'incrustation
	 * @param f2 : le film à incruster
	 * @param numLigne : le numéro de la ligne où le film doit être incrusté (la 1ère ligne porte le numéro 1)
	 * @param numColonne : le numéro de la colonne où le film doit être incrusté (la 1ère colonne porte le numéro 1)
	 * @return un nouveau film avec l'incrustation souhaité
	 */
	public static Film incrustation(Film filmOriginal, Film f2, int numLigne, int numColonne) {
		return new Incruster(filmOriginal, f2, numLigne, numColonne);
	}
}
