
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VilleV2 {

	// =====================Types=============================
	public enum types {
		agricole, touristique, industrielle, ordinaire
	}

	// =====================Variables========================

	// La liste des 1ere villes
	public static ArrayList<VilleV2> villes = new ArrayList<VilleV2>(5);

	// La liste de toutes les villes
	private static ArrayList<VilleV2> allVilles = new ArrayList<VilleV2>();
	private static int numero = 0;
	private String nom, wilaya;
	private double superficie;
	private int nombreFleurs, habitants;
	private ArrayList<VilleV2> voisSort;
	private types typeV;
	private String couleur;

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

	public VilleV2(String nom, String wilaya, double superficie, int habitants, int nombreFleurs, types type) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
		this.nombreFleurs = nombreFleurs;
		this.typeV = type;
		this.voisSort = new ArrayList<VilleV2>();

		if (!VilleV2.allVilles.contains(this)) {
			VilleV2.allVilles.add(this);
		}

		numero++;

		// Initialisation couleur
		initCouleur();
	}

	public VilleV2(String nom, String wilaya, double superficie, int habitants, int nombreFleurs, types typeV,
			String couleur) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.nombreFleurs = nombreFleurs;
		this.habitants = habitants;
		this.typeV = typeV;
		this.couleur = couleur;

		this.voisSort = new ArrayList<VilleV2>();

		if (!VilleV2.allVilles.contains(this)) {
			VilleV2.allVilles.add(this);
		}

		numero++;
	}

	private void initCouleur() {

		if (this.typeV == types.valueOf("ordinaire") && (this.nombreFleurs <= 1)) {
			this.couleur = "Rouge";
		} else if ((this.typeV == types.valueOf("ordinaire") && this.nombreFleurs > 1)
				|| (this.typeV != types.valueOf("ordinaire") && this.nombreFleurs <= 1)) {
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
		this.nom = nom;
	}

	public String getWilaya() {
		return wilaya;
	}

	public void setWilaya(String wilaya) {
		this.wilaya = wilaya;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public int getHabitants() {
		return habitants;
	}

	public void setHabitants(int habitants) {
		this.habitants = habitants;
	}

	public String getType() {
		return typeV.name();
	}

	public void setType(String type) {
		this.typeV = types.valueOf(type);

	}

	public int getNombreFleurs() {
		return nombreFleurs;
	}

	public void setNombreFleurs(int nombreFleurs) {
		this.nombreFleurs = nombreFleurs;
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

	public types getTypeV() {
		return typeV;
	}

	public void setTypeV(types typeV) {
		this.typeV = typeV;
	}

	public String toString() {
		return "Ville [nom=" + nom + ", wilaya=" + wilaya + ", superficie=" + superficie + ", nombreFleurs="
				+ nombreFleurs + ", habitants=" + habitants + ", typeV=" + typeV + ", couleur=" + couleur + "]";
	}

	// =====================Méthodes========================

	public void addVilleSort(VilleV2 v) {
		this.voisSort.add(v);
	}

	// *Made by Legend: Verifie si v appartient au liste des voisins Sortant
	public boolean voisinSort(VilleV2 v) {

		return this.voisSort.contains(v);
	}

	// =====================

	// *Reworked by Legend
	public void couleurAffiche() {

		System.out.println("Ville de couleur: " + this.couleur);

	}

	/*
	 * I edited this method since we should look for the number of cities that
	 * we go to!
	 *
	 */
	public boolean pasChemin() {

		for (VilleV2 v : this.voisSort) {
			if (v != null)
				return false;
		}
		return true;
	}

	public boolean existe3Chemin() {
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

	// *Reworked by Legend: Added villes between them
	public boolean voisinDifferents() {

		for (int i = 0; i < this.voisSort.size(); i++) {
			for (int j = 0; j < this.voisSort.size(); i++) {
				if (this.voisSort.get(i).equals(this.voisSort.get(j)))
					return false;
			}
		}

		return true;
	}

	// *Reworked by Legend: Added villes sortant
	public boolean plusFleurie() {

		for (VilleV2 v : this.voisSort) {
			if (this.getNombreFleurs() < v.getNombreFleurs())
				return false;
		}

		return true;
	}

	// *Reworked by Legend: Use method equals with strings!
	public boolean methodeBizzare() {
		// if (this.typeV !=types.valueOf("ordinaire") &&
		// this.couleur.equalsIgnoreCase("Vert")){
		if (!this.typeV.equals(types.valueOf("ordinaire")) && this.couleur.equalsIgnoreCase("Vert")) {

			for (VilleV2 v : this.voisSort) {
				if (!v.getCouleur().equalsIgnoreCase("Rouge"))
					return false;
			}

			return true;
		} else
			return false;

	}

	public boolean cheminExiste(VilleV2 fin, VilleV2... chemin) {
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

	// Returns an ArrayList
	private ArrayList<VilleV2> ToutVoisins() {

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

	public boolean exixsteCheminFinal(VilleV2 fin) {

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
						"Enter the new type:  1) Agricole, 2) Touristique, 3) Industrielle, 4) Ordinaire.%n Votre choix: ");
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
					if (element.exixsteCheminFinal(v))
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

}