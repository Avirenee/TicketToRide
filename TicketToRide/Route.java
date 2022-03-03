// D but du code d'origine
/**
 * La classe Route repr sente une route dans le jeu des Aventuriers du Rail.
 * Une route dispose d'une ville de d part, d'une ville d'arriv e et d'une couleur.
 * A partir de l'incr ment 3, une route pourra  tre poss d e par un joueur.
 * @since Incr ment 1
 * @ACOMPLETER
 */
class Route {

	/**
	 * La ville de d part de la route
	 */
	Ville villeDepart;
	
	/**
	 * La ville d'arriv e de la route
	 */
	Ville villeArrivee;
	
	/**
	 * La couleur de la route
	 */
	String couleur;
	
	/**
	 * Cr e une route
	 * @param ville1 la ville de d part
	 * @param ville2 la ville d'arriv e
	 * @param couleur la couleur de la route
	 */
	Route(Ville villeDepart, Ville villeArrivee, String couleur)
	{
		this.villeDepart=villeDepart;
		this.villeArrivee=villeArrivee;
		this.couleur = couleur;
	}

	// ACCESSEURS
	Ville getVilleDepart() 
	{
		return villeDepart;
	}

	Ville getVilleArrivee() 
	{
		return villeArrivee;
	}

	String getCouleur() 
	{
		return couleur;
	}

	/**
	 * G n re le nom de la route   partir des noms des villes reli es, s par s
	 * par un tiret '-'
	 * @return le nom de la route
	 */
	String getNom() 
	{
		return villeDepart.getNom() +" - "+ villeArrivee.getNom();
	}
	
	/**
	 * Le calcul de la longueur de la route d pend des coordonn es des villes
	 * sur l' cran. Pour respecter le ratio pr sent sur le plateau de jeu
	 * original, on propose d'impl menter l'algorithme suivant : 1. on calcule
	 * la distance entre la ville de d part et la ville d'arriv e (longueur du
	 * segment) 2. on utilise la valeur 33 pour appliquer ratio sur la distance
	 * calcul e 3. on conserve le minimum entre la longueur obtenue apr s ratio
	 * et la valeur maximale 6.
	 * 
	 * @return la longueur de la route (entre 1 et 6), calcul e en fonction de
	 *         la position des villes
	 */
	int getLongueur() 
	{
		double longu = Math.pow(((Math.pow(villeDepart.getX()-villeArrivee.getX(), 2)+Math.pow(villeDepart.getY()-villeArrivee.getY(),2))),0.5);
		int max = 6;
		if (longu/33 < max)
		{
			max = (int)(longu/33);
		}
		return max;
	}
	
	/**
	 * Transforme la longueur de la route en un nombre de points qu'elle
	 * rapporte au joueur qui en devient propri taire
	 * @return une valeur enti re entre 1 et 15; une autre valeur indique une
	 *         erreur dans les donn es de la route
	 */
	/**
	 * @return une repr sentation textuelle de la route. On indique le nom de la
	 *         route puis sa couleur et sa longueur s par es par un tiret '-'.
	 */
	 
	 int getNombrePoints()
	{
		int[] listePoints = {0,1,2,4,7,10,15};
		return listePoints[getLongueur()];
	}
	
	String versChaine()
	{//Probl me
		return villeDepart.getNom() +" - "+ villeArrivee.getNom() + " /" + couleur + "-" + getLongueur();
	}

// Fin du code d'origine

// Code import  :
/**
 * La classe Route repr sente une route dans le jeu des Aventuriers du Rail.
 * Une route dispose d'une ville de d part, d'une ville d'arriv e et d'une couleur.
 * A partir de l'incr ment 3, une route pourra  tre poss d e par un joueur.
 * @since Incr ment 1
 * @ACOMPLETER
 */
	/**
	 * Le joueur propri taire d'une route lorsque cet attribut est
	 *        renseign , {@code null} sinon.
	 * @since Incr ment 3
	 * 
	 */
	 Joueur proprietaire;
	// TODO d clarer le proprietaire de la route
	
	/**
	 * @return le propri taire de la route s'il existe, {@code null} sinon.
	 * @since Incr ment 3
	 */
	 Joueur getProprietaire()
	 {
	 	return proprietaire;
	 }

	
	/**
	 * Affecte un joueur en tant que propri taire de la route
	 * @param proprietaire l'objet {@link Joueur} qui devient propri taire de la route
	 * @since Incr ment 3
	 */
	// TODO accesseur en  criture du proprietaire de la route
	void setProprietaire(Joueur newJoueur)
	{
		this.proprietaire = newJoueur;
	}
}
