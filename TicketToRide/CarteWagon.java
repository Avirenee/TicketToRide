/**
 * La classe CarteWagon représente une carte "wagon" du jeu. Une carte "wagon"
 * dispose d'une couleur parmis les huit couleurs du jeu (
 * {@link Donnees#COULEURS_WAGON}) ou {@code null} si c'est une locomotive.
 * 
 * @before Incrément 5
 * @ACOMPLETER
 */
class CarteWagon {
	/**
	 * La couleur de la carte "wagon"
	 */
	String couleur;
	
	/**
	 * Crée une carte de la couleur spécifiée
	 * @param couleur la couleur de la carte
	 */
	CarteWagon(String couleur)
	{
		this.couleur = couleur;
	}

	// ACCESSEURS
	// TODO déclarer les accesseurs en lecture pour les attributs
	String getCouleur()
	{
		return couleur;
	}
	
	/**
	 * @return {@code vrai} si la carte n'a pas de couleur, {@code faux} sinon
	 */
	// TODO déclarer la méthode estLocomotive
	boolean estLocomotive()
	{
		if (getCouleur()==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @return une représentation textuelle de la carte
	 */
	// TODO déclarer la méthode versChaine
	String versChaine()
	{
		if(!estLocomotive())
		{
		return "Wagon " + getCouleur();
		}
		else
		{
			return "Locomotive";
		}
	}
	
	/**
	 * Indique si la couleur de la carte est égale à la couleur passée en
	 * paramètre
	 * @param couleur la couleur à tester
	 * @return {@code vrai} si la couleur de la carte est égale à la couleur
	 *         passée en paramètre, {@code faux} sinon.
	 */
	// TODO déclarer la méthode estDeCouleur
	boolean estDeCouleur(String verif)
	{
		if (getCouleur()==verif)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
