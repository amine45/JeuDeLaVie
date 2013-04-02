package JeuDeLaVie;

/**
 * ArgException est la classe permettant de gérer les erreurs d'arguments 
 * lors du choix des options du jeu.
 * 
 */

public class ArgException extends Exception {
	public ArgException(String message) {
		super(message);
	}
}