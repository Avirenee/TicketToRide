/**
 * La classe ListeCartesWagon est l'implémentation d'une liste chaînée de cartes
 * "wagon" dans sa version récursive.
 * @since Incrément 7
 * @ACOMPLETER
 */
class ListeCartesWagon {
	/**
	 * Représentation d'une liste vide
	 */
	// TODO déclarer la liste vide
	static final ListeCartesWagon VIDE = new ListeCartesWagon(null,null);
	/**
	 * l'objet {@link CarteWagon} en tête de la liste de cartes wagon
	 */
	// TODO déclarer la tête de la liste
	CarteWagon tete;
	

	/**
	 * l'objet {@link ListeCartesWagon} qui constitue le reste de la liste de
	 * cartes wagon
	 */
	// TODO déclarer le reste de la liste
	ListeCartesWagon reste;

	/**
	 * Crée une liste de cartes "wagon"
	 * @param tete l'objet {@link CarteWagon} à insérer en tête
	 * @param reste l'objet {@link ListeCartesWagon} qui constitue le reste
	 */
	// TODO déclarer le constructeur
	ListeCartesWagon(CarteWagon tete , ListeCartesWagon reste)
	{
		this.tete = tete;
		this.reste = reste;
		// this.cartes = new CarteWagon[110]; // Pas sûr de ça
	}

	// ACCESSEURS
	
	// TODO déclarer les accesseurs en lecture pour les attributs
	CarteWagon getTete()
	{
		return this.tete;
	}

	ListeCartesWagon getReste()
	{
		return this.reste;
	}


	/**
	 * @return {@code vrai} si la liste est la liste vide, {@code faux} sinon
	 */
	// TODO déclarer la méthode estVide
	boolean estVide()
	{
		if(this.tete == null && this.reste == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Ajoute une carte "wagon" en tête de la liste
	 * @param tete l'objet {@link CarteWagon} à ajouter
	 * @return une nouvelle liste dont la tête est {@code tete}
	 */
	// TODO déclarer la méthode ajoute
	ListeCartesWagon ajoute(CarteWagon newCarte)
	{
		return new ListeCartesWagon(newCarte,this);
	}

	/**
	 * @return une représentation textuelle de la liste. Chaque élement de la
	 *         liste est séparé par une virgule.
	 */
	// TODO déclarer la méthode versChaine

	String versChaine()
	{
		if(this.estVide())
		{
			return "";
		}
		else if(this.getReste().estVide())
		{
			return this.getTete().versChaine();
		}
		else
		{
			return this.getTete().versChaine() + ", " + this.getReste().versChaine();
		}
	}

	/**
	 * Recherche le nombre d'occurrences d'une couleur donnée.
	 * @param couleur la couleur recherchée; la valeur {@code null} correspond
	 *            aux locomotives
	 * @return le nombre de cartes "wagon" correspondant à la couleur
	 * @since Incrément 7
	 */

	int getNombreOccurrences(String couleur)
	{
		if(this.estVide())
		{
			return 0;
		}
		else if(this.getReste().estVide())
		{
			if(this.getTete().getCouleur() == couleur)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		else
		{
			if(this.getTete().getCouleur() == couleur)
			{
				return 1 + this.getReste().getNombreOccurrences(couleur);
			}
			else
			{
				return this.getReste().getNombreOccurrences(couleur);
			}
		}
	}
}
