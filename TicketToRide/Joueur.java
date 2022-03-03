// D but du code d'origine
// D?but du code d'origine
/**
 * La classe Joueur repr?sente un joueur des Aventuriers du Rail.
 * Un joueur dispose d'un num?ro, d'une couleur, d'un nombre de wagon et d'un score.
 * A partir de l'incr?ment 7, le joueur est associ? ? une liste de cartes qui constituent sa main. 
 * @since Incr?ment 2
 * @ACOMPLETER
 */
class Joueur {
	/**
	 * le num?ro du joueur
	 */
	int numero;

	/**
	 * la couleur du joueur
	 */
	String couleur;
	
	/**
	 * le nombre de wagons restants au joueur
	 */
	int nbWagon = 45;
	
	/**
	 * le score du joueur
	 */
	int score = 0;
	
	/**
	 * Cr?e un joueur et initialise son score ? 0 et son nombre de wagon ? 45, suivant
	 * les r?gles du jeu.
	 * A partir de l'incr?ment 7, initialise la main du joueur.
	 * @param numero le num?ro du joueur
	 * @param couleur la couleur du joueur
	 */
	Joueur(int numero , String couleur)
	{
		this.numero = numero;
		this.couleur = couleur;
		this.nbWagon = nbWagon;
		this.score = score;
	}

	// ACCESSEURS
	int getNumero()
	{
		return numero;
	}

	String getCouleur()
	{
		return couleur;
	}

	int getNombreWagons()
	{
		return nbWagon;
	}

	int getScore()
	{
		return score;
	}
	void setCouleur(String couleur)
	{
		this.couleur = couleur;
	}

	/**
	 * Ajoute un nombre de points au score du joueur.
	 * Le nombre de points ? ajouter peut ?tre n?gatif.
	 * @param nombrePoints le nombre de points ? ajouter au score du joueur
	 * @since Incr?ment 4
	 */
	void ajouteAuScore(int ajout)
	{
		this.score += ajout;
	}
	
	/**
	 * Retire des wagons au joueur
	 * @param nombreWagons le nombre de wagon ? retirer
	 * @since Incr?ment 4
	 */
	void enleveWagons(int nbWagonNeg)
	{
		if (nbWagonNeg >= 0)
		{
			if (this.nbWagon < nbWagonNeg)
			{
				this.nbWagon = 0;
			}
			else
			{
				this.nbWagon -= nbWagonNeg;
			}
		}
	}
/**
 * La classe Joueur repr sente un joueur des Aventuriers du Rail.
 * Un joueur dispose d'un num ro, d'une couleur, d'un nombre de wagon et d'un score.
 * A partir de l'incr ment 7, le joueur est associ    une liste de cartes qui constituent sa main. 
 * @since Incr ment 2
 * @ACOMPLETER
 */
	/**
	 * L'objet {@link ListeCartesWagon} qui repr sente la main du joueur.
	 * @since Incr ment 7 
	 */
	// TODO d clarer la main du joueur
	ListeCartesWagon mainCartesWagon = ListeCartesWagon.VIDE;

	/**
	 * @return la main (liste de cartes "wagon") du joueur
	 * @since Incr ment 7
	 */
	// TODO d clarer l'accesseur en lecture de la main du joueur
	ListeCartesWagon getMainCartesWagon()
	{
		return this.mainCartesWagon;
	}

	/**
	 * Associe une liste de cartes "wagon" au joueur
	 * @param mainCartesWagon l'objet {@link ListeCartesWagon} qui correspond  
	 *            la liste de cartes "wagon"
	 * @since Incr ment 7
	 */
	// TODO d clarer l'accesseur en  criture de la main du joueur
	void setMainCartesWagon(ListeCartesWagon newTruc)
	{
		this.mainCartesWagon = newTruc;
	}

	/**
	 * Ajoute une carte "wagon"   la main du joueur
	 * @param carte l'objet {@link CarteWagon}   ajouter
	 * @since Incr ment 7
	 */
	// TODO d clarer la m thode prendCarteWagon
	void prendsCarteWagon(CarteWagon carteWagon)
	{
		this.mainCartesWagon = this.mainCartesWagon.ajoute(carteWagon);
	}
}
