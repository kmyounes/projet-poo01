import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Stockage de villes dans un tableau dynamique

		// pour le testing
		VilleV2 alg = new VilleV2("alg"), bouira = new VilleV2("Bouira"), telemcen = new VilleV2("Telemcen"),
				oran = new VilleV2("Oran"), babez = new VilleV2("babez"), medeia = new VilleV2("Medeia");

		VilleV2.villes.add(alg);
		VilleV2.villes.add(babez);

		alg.addVilleSort(bouira);
		alg.addVilleSort(telemcen);
		telemcen.addVilleSort(oran);
		telemcen.addVilleSort(medeia);
		telemcen.addVilleSort(alg);

		menuPrincipal();

		System.out.println("Terrminé");

	}

	private static void menuPrincipal() {
		int choix = 1, stop = 4;
		VilleV2 tmp = null, v;
		String nom;
		Scanner in = new Scanner(System.in);
		

		System.out.println("\t\t Gestion de villes");
		System.out.println("\t\t Bonjour et binevenue!");

		do {
			System.out.println(
					"\n\n\tQue voulez-vous faire?:\n" + " 1) Ajouter une Ville.\n" + " 2) Rechercher une ville\n"
							+ " 3) Afficher les villes.\n" + " 4) Afficher la liste des villes par couleur.\n"
							+ " 5) Afficher les villes fortement liées.\n" + " 0) Quitter\n" + "Votre choix est: ");

			choix = in.nextInt();

			switch (choix) {
			case 1:
				VilleV2.ajouterVilleV2();
				System.out.println("\n\n");
				break;
			case 2:

				if (VilleV2.villes.isEmpty()) {
					System.out.println("\n\nAucune ville!!");
				} else {

					System.out.println("Entrez le nom de la ville: ");
					nom = in.next();

					v = VilleV2.rechListe(nom);

					if (v != null) {

						int menu = 0;

						System.out.println("La ville a été trouvée :\n " + v);

						do {
							System.out.println(
									"\n\n Que voulez vous faire?:\n" + "1) Changer les informations de la ville.\n"
											+ "2) Ajouter une autre ville comme voisine\n"
											+ "3) Ajouter commme voisine d'une autre ville\n" + "0) Quitter");

							menu = in.nextInt();

							if (menu < 0 || menu > 3)
								System.out.println("Erreur!! choix incorect!");

						} while (menu < 0 || menu > 3);

						switch (menu) {
						case 1:
							v.modifieVille();
							break;

						case 2:

							do {
								do{
									System.out.println("Entrer le nom de la ville a ajouter: ");
									nom = in.next();
									if(nom.equalsIgnoreCase(v.getNom()))
										System.out.println("Erreur: Ville ne peut pas etre voisin d'elle meme");
									
								}while(nom.equalsIgnoreCase(v.getNom()));

								tmp = VilleV2.rechListe(nom);

								if (tmp == null) {
									System.out.println("\n\n\t La ville sous le nom de : \"" + nom
											+ "\" n'existe pas!!\n" + "Ressayer? :  0) Non. Autre) Oui.");
									stop = in.nextInt();
								}
							} while (stop != 0 && tmp == null);

							if (tmp == null) {
								System.out.println("Ville n'existe pas. Exiting...");
							} else {
								v.addVilleSort(tmp);
							}
							break;

						case 3:

							do {
								do{
									System.out.println("Entrer le nom de la ville a ajouter: ");
									nom = in.next();
									if(nom.equalsIgnoreCase(v.getNom()))
										System.out.println("Erreur: Ville ne peut pas etre voisin d'elle meme!!!\n");
									
								}while(nom.equalsIgnoreCase(v.getNom()));

								tmp = VilleV2.rechListe(nom);

								if (tmp == null) {
									System.out.println("\n\n\t La ville sous le nom de : \"" + nom
											+ "\" n'existe pas!!\n" + "Ressayer? :  0) Non. Autre) Oui.");
									stop = in.nextInt();
								}
							} while (stop != 0 && tmp == null);

							if (tmp == null) {
								System.out.println("Ville n'existe pas. Exiting...");
							} else {
								tmp.addVilleSort(v);
							}
							break;
						}

					} else {
						System.out.println("\n\n\t La ville sous le nom de : \"" + nom + "\" n'existe pas!!");
					}
				}

				break;
			case 3:
				if (VilleV2.villes.isEmpty())
					System.out.println("\n\nAucune ville!!");
				else
					VilleV2.afficheReseau();
				break;
			case 4:
				if (VilleV2.villes.isEmpty())
					System.out.println("\n\nAucune ville!!");
				else
					VilleV2.afficherListeVilles();
				break;
			case 5:
				if (VilleV2.villes.isEmpty())
					System.out.println("\n\nAucune ville!!");
				else
					System.out.println("Liste des villes fortement liee: \n");
				for (ArrayList<VilleV2> array : VilleV2.Partitions()) {
					for (VilleV2 ville : array) {
						System.out.println(ville);
					}
					System.out.println();
				}
				break;

			}
			/*
			 * System.out.
			 * println("Veuillez appuyer sur une touche pour contirnuer");
			 * in.nextLine(); in.nextLine(); for (int i = 0; i <50 ; i++) {
			 * System.out.println();
			 * 
			 * }
			 */

		} while (choix != 0);

		// in.close();
	}

}
