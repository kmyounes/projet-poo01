
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VilleV2 {

	// =====================Types=============================
	public enum types {
		agricole, touristique, industrielle, ordinaire
	}

	// =====================Variables========================

	// Liste contenant les villes principales
	public static ArrayList<VilleV2> villes = new ArrayList<VilleV2>();

	// Liste contenant toute les villes
	private static ArrayList<VilleV2> allVilles = new ArrayList<VilleV2>();
	

	private static int numero = 0; //numéro séquentiel de la ville
	private String nom, wilaya, couleur;
	private double superficie;
	private int nombreFleurs, habitants;
	private ArrayList<VilleV2> voisSort;   //voisins sortants
	private types typeVille; //le type de la ville (agricoles, touristique....)
	

	// =====================Constructeurs========================

	public VilleV2(String nom, String wilaya, double superficie, int habitants) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
		this.voisSort = new ArrayList<VilleV2>();

		if (!VilleV2.allVilles.contains(this)) {
			VilleV2.allVilles.add(this);
		}

		numero++;

		// Initialisation couleur
		initCouleur();
	}

	public VilleV2(String nom, String wilaya, double superficie, int habitants, int nombreFleurs, types typeVille) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
		this.nombreFleurs = nombreFleurs;
		this.typeVille = typeVille;
		this.voisSort = new ArrayList<VilleV2>();

		if (!VilleV2.allVilles.contains(this)) {
			VilleV2.allVilles.add(this);
		}

		numero++;

		// Initialisation couleur
		initCouleur();
	}

	public VilleV2(String nom, String wilaya, double superficie, int habitants, int nombreFleurs, types typeVille,
			String couleur) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.nombreFleurs = nombreFleurs;
		this.habitants = habitants;
		this.typeVille = typeVille;
		this.couleur = couleur;

		this.voisSort = new ArrayList<VilleV2>();

		if (!VilleV2.allVilles.contains(this)) {
			VilleV2.allVilles.add(this);
		}

		numero++;
	}
       //Fonction qui initialise la couleur de la ville suivant le nombre de fleurs
	private void initCouleur() {

		if (this.typeVille == types.valueOf("ordinaire") && (this.nombreFleurs <= 1)) {
			this.couleur = "Rouge";
		} else if ((this.typeVille == types.valueOf("ordinaire") && this.nombreFleurs > 1)
				|| (this.typeVille != types.valueOf("ordinaire") && this.nombreFleurs <= 1)) {
			// afficher en orange
			this.couleur = "Orange";
		} else {
			// afficher en vert
			this.couleur = "Vert";
		}
	}

	// =====================Geters/Seters========================

	public static int getNumero() {
		return numero;
	}

	public static void setNumero(int numero) {
		VilleV2.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if (!nom.isEmpty())		this.nom = nom;
		else System.out.println("Erreur le nom est vide!");
	}

	public String getWilaya() {
		return wilaya;
	}

	public void setWilaya(String wilaya) {
		if(!wilaya.isEmpty())		this.wilaya = wilaya;
		else System.out.println("Erreur Le champ wilaya est vide");
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		if(superficie>0) this.superficie = superficie;
		else System.out.println("Erreur, la superficie ne peut etre négative");
	}

	public int getHabitants() {
		return habitants;
	}

	public void setHabitants(int habitants) {

		if (habitants>0)this.habitants = habitants;
		else System.out.println("Erreur, le nombre d'habitant ne peut etre négatif");
	}

	public String getType() {
		return typeVille.name();
	}

	public void setType(String type) {
		this.typeVille = types.valueOf(type);

	}

	public int getNombreFleurs() {
		return nombreFleurs;
	}

	public void setNombreFleurs(int nombreFleurs) {

		if(nombreFleurs >0 )this.nombreFleurs = nombreFleurs;
		else System.out.println("Erreur le nombre de fleurs ");
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public ArrayList<VilleV2> getVoisSort() {
		return voisSort;
	}

	public void setVoisSort(ArrayList<VilleV2> voisSort) {
		this.voisSort = voisSort;
	}

	public types getTypeVille() {
		return typeVille;
	}

	public void setTypeVille(types typeVille) {
		this.typeVille = typeVille;
	}
    //===== méthode Tostring
	public String toString() {
		return "Ville [nom=" + nom + ", wilaya=" + wilaya + ", superficie=" + superficie + ", nombreFleurs="
				+ nombreFleurs + ", habitants=" + habitants + ", typeVille=" + typeVille + ", couleur=" + couleur + "]";
	}

	// =====================Méthodes========================

	public void addVilleSort(VilleV2 v) {  //ajouter un voisin
		this.voisSort.add(v);
	}

	public boolean voisinSort(VilleV2 v) {  // fonction qui vérifie si v est une ville voisine

		return this.voisSort.contains(v);
	}

	// =====================


	public void couleurAffiche() {   //permet d'afficher la couleur de la ville courante

		System.out.println("Ville de couleur: " + this.couleur);

	}

	/*
	 * I edited this method since we should look for the number of cities that
	 * we go to!
	 *
	 */
	public boolean pasChemin() { // Fonction qui vérifie si la ville courante ne mene a aucune autre ville

		for (VilleV2 v : this.voisSort) {
			if (v != null)
				return false;
		}
		return true;
	}

	public boolean existe3Chemin() { // Fonction qui vérifie si la ville actuelle a éxactement 3 voisins
		int cpt = 0;

		for (VilleV2 v : this.voisSort) {
			if (v != null) {
				if (cpt == 3)
					return false;
				else
					cpt++;
			}
		}

		return cpt == 3;
	}

	public boolean voisinDifferents() { // Fonction qui vérifie si les voisins directes sont différents entre eux

		for (int i = 0; i < this.voisSort.size(); i++) {
			for (int j = 0; j < this.voisSort.size(); i++) {
				if (this.voisSort.get(i).equals(this.voisSort.get(j)))
					return false;
			}
		}

		return true;
	}

	public boolean plusFleurie() { // Fonction qui vérifie si la ville actuelle est plus fleurie que les villes voisines

		for (VilleV2 v : this.voisSort) {
			if (this.getNombreFleurs() < v.getNombreFleurs())
				return false;
		}

		return true;
	}

	// *Reworked by Legend: Use method equals with strings!
	public boolean methodeBizzare() {
		/*Fonction qui vérifie si la ville actuelle est de type Ordinaire et est de
		 *couleur verte et toute ses  voisines sont de couleur rouge
		 */
		if (!this.typeVille.equals(types.valueOf("ordinaire")) && this.couleur.equalsIgnoreCase("Vert")) {

			for (VilleV2 v : this.voisSort) {
				if (!v.getCouleur().equalsIgnoreCase("Rouge"))
					return false;
			}

			return true;
		} else
			return false;

	}

	public boolean cheminExiste(VilleV2 fin, VilleV2... chemin) { //Fonction qui vérifie l'existence d'un chemin
		VilleV2 tampon = this;

		for (int i = 0; i < chemin.length; i++) {
			if (tampon.voisinSort(chemin[i])) {
				tampon = chemin[i];
			} else {
				return false;
			}
		}

		if (tampon.voisinSort(fin))
			return true;

		return false;

	}

	private ArrayList<VilleV2> ToutVoisins() { //Fonction qui retourne toute les villes accessibles depuis la ville courante

		ArrayList<VilleV2> visite = new ArrayList<>();
		ArrayList<VilleV2> restants = new ArrayList<>();
		visite.add(this);
		restants.add(this);
		VilleV2 a;

		while (!restants.isEmpty()) {
			a = restants.get(0);
			for (VilleV2 v : a.voisSort) {
				if (!visite.contains(v)) {
					visite.add(v);
					restants.add(v);
				}
			}
			restants.remove(0);
		}

		return visite;

	}

	public boolean exixsteChemin(VilleV2 fin) { // Fonction qui vérifie l'existence d'un chemin vers une ville, depuis la ville courante

		if (this.ToutVoisins().contains(fin))
			return true;
		return false;
	}

	public static VilleV2 rechListe(String nom) {

		for (VilleV2 v : VilleV2.allVilles) {

			if (v.getNom().equalsIgnoreCase(nom))
				return v;

		}

		return null;

	}

	// Recherche dans la ville et ses voisins directs seulement.
	public VilleV2 rechVois(String nom) {

		if (this.getNom().equals(nom))
			return this;

		for (VilleV2 v : this.voisSort) {

			if (v.getNom().equals(nom))
				return v;

		}

		return null;
	}

	// This one????
	public boolean supprime() {

		if (VilleV2.villes.indexOf(this) == -1) {
			System.out.println("Ville n'existe pas dans la liste!");
			return false;
		}

		VilleV2.villes.remove(this);
		System.out.println("Operation terminee");
		return true;
	}

	public void modifieVille() {
		int choice = 1;
		Scanner in = new Scanner(System.in);

		do {
			System.out.printf(
					"What do you want to change?: %n 1) Nom 2) Wilaya 3) Superficie 4) Type de ville 0) Abort.%n Votre choix: ");
			choice = in.nextInt();

			if (choice < 0 || choice > 4)
				System.out.println("Erreur!! Please enter a valide choice!");

		} while (choice < 0 || choice > 4);

		switch (choice) {
		case 1:
			System.out.println("Enter the new name:  ");
			this.setNom(in.next());
			break;
		case 2:
			System.out.println("Enter the new wilaya:  ");
			this.setWilaya(in.next());
			break;
		case 3:
			System.out.println("Enter the new :  ");
			this.setSuperficie(in.nextDouble());
			break;
		case 4:
			int type = 1;
			do {
				System.out.printf(
						"Enter the new type:  1) Agricole, 2) Touristique, 3) Industrielle, 4) Ordinaire.\n Votre choix: ");
				type = in.nextInt();
				if (type < 1 || type > 4)
					System.out.println("Error!! Enter a valid type!");
			} while (type < 1 || type > 4);

			switch (type) {
			case 1:
				this.setType("agricole");
				break;
			case 2:
				this.setType("touristique");
				break;
			case 3:
				this.setType("industrielle");
				break;
			case 4:
				this.setType("ordinaire");
				break;
			}
			break;
		}
		System.out.println("Done!");
		in.close();
	}

	public void afficheReseauVille() {
		int lvl = 0;
		ArrayList<VilleV2> liste = new ArrayList<VilleV2>();
		ArrayList<VilleV2> tampon = new ArrayList<VilleV2>();
		VilleV2 tmp = this;
		tampon.add(this);

		while (!tampon.isEmpty()) {
			tmp = tampon.get(0);
			tampon.remove(0);

			if (tmp != null) {
				// make a string of ' ' numSpaces time.
				char[] chars = new char[lvl * 5];
				Arrays.fill(chars, ' ');
				String result = new String(chars);
				System.out.print(result);

				if (liste.contains(tmp)) {
					System.out.print(" => " + tmp.getNom() + " # ");
					System.out.println();

					continue;
				} else {
					System.out.println(" => " + tmp.getNom());
					liste.add(tmp);
				}

				if (!tmp.getVoisSort().isEmpty()) {
					tampon.addAll(0, tmp.getVoisSort());
					tampon.add(tmp.getVoisSort().size(), null);
					lvl++;
				}
			} else {

				lvl = lvl > 0 ? lvl - 1 : 0;
			}
		}
	}
	
	public static void afficheReseau(){
		for(VilleV2 v : VilleV2.villes){
			v.afficheReseauVille();
		}
	}

	public static void afficherListeVilles() {
		String vert = "", rouge = "", orange = "";

		for (VilleV2 v : VilleV2.allVilles) {
			if (v.getCouleur().equalsIgnoreCase("vert"))
				vert = vert + " " + v.getNom();
			if (v.getCouleur().equalsIgnoreCase("rouge"))
				rouge = rouge + " " + v.getNom();
			if (v.getCouleur().equalsIgnoreCase("orange"))
				orange = orange + " " + v.getNom();
		}

		System.out.println("La liste des villes: ");
		System.out.println("Vert:  " + vert);
		System.out.println("Rouge:  " + rouge);
		System.out.println("Orange:  " + orange);

	}

	public static ArrayList<ArrayList<VilleV2>> Partitions() {
		ArrayList<ArrayList<VilleV2>> partitions = new ArrayList<>();
		ArrayList<VilleV2> tmp;
		ArrayList<VilleV2> tampon;
		for (VilleV2 v : VilleV2.allVilles) {
			if (!VilleV2.existe(partitions, v)) {
				tmp = new ArrayList<VilleV2>();
				// tmp.add(v);
				tampon = v.ToutVoisins();
				for (VilleV2 element : tampon) {
					if (element.exixsteChemin(v))
						tmp.add(element);
				}

				partitions.add(tmp);
			}
		}

		return partitions;
	}

	private static boolean existe(ArrayList<ArrayList<VilleV2>> a, VilleV2 b) {
		for (ArrayList<VilleV2> c : a) {
			if (c.contains(b))
				return true;
		}
		return false;
	}
	
	//==================================================
	
	//Add a new city
	
	public static VilleV2 ajouterVilleV2(){
		VilleV2 v;
		String nom = "", wilaya = "";
		double superficie = 0;
		int nombreFleurs = 0, habitants = 0;
		types typeV = types.agricole;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int choix = 1;
		
		
			System.out.println("Donner le nom de la ville");
			nom = in.next();
		
		
		
			System.out.println("Donner la wilaya de la ville");
			wilaya = in.next();
		
		
		do {
			System.out.println("Donner la superficie de la ville");
			superficie = in.nextDouble();
			if (superficie <= 0)
				System.out.println("Erreur!! valeur incorect!");
		} while(superficie <= 0 );
		
		do {
			System.out.println("Donner le nombre de fleur(s) de la ville");
			nombreFleurs = in.nextInt();
			if (nombreFleurs <= 0)
				System.out.println("Erreur!! valeur incorect!");
		} while(nombreFleurs <=0 );
		
		do {
			System.out.println("Donner le nombre habitants de la ville");
			habitants = in.nextInt();
			if (habitants <= 0)
				System.out.println("Erreur!! valeur incorect!");
		} while(habitants <=0 );

		do {
			System.out.println("Donner le type de la ville\n"
					+ " 1) Agricole, 2) Touristique, 3) Industrielle, 4) Ordinaire.");
			choix = in.nextInt();

			switch (choix) {
			case 1:
				typeV = types.agricole;
				break;
			case 2:
				typeV = types.touristique;
				break;
			case 3:
				typeV = types.industrielle;
				break;
			case 4:
				typeV = types.ordinaire;
				break;
			}

			if (choix < 1 || choix > 4)
				System.out.println("Erreur!! choix incorect!");
		} while (choix < 1 || choix > 4);
		
		v = new VilleV2( nom,  wilaya,  superficie,  habitants,  nombreFleurs,  typeV);
		System.out.println("\n" + "City Created:\n  " + v);
		
		return v;
	}

}