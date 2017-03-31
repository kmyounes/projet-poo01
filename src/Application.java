import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Stockage de villes dans un tableau dynamique

		menuPrincipal();

		System.out.println("TERMINATED");

	}

	private static void menuPrincipal() {
		int choix = 1;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		System.out.println("\t\t Gestion de villes");
		System.out.println("\t\t Bonjour et binevenue!");

		do {
			System.out.println("\n\n\tQue voulez-vous faire?:\n" + " 1) Ajouter une Ville.\n"
					+ " 2) Rechercher une ville\n" + " 3) Afficher les villes.\n"
					+ " 4) Afficher la liste des villes par couleur.\n" + " 5) Afficher les villes fortement liées.\n" + " 0) Quitter\n"
					+ "Votre choix est: ");

			choix = in.nextInt();

			switch (choix) {
			case 1:
				VilleV2.ajouterVilleV2();
				System.out.println("\n\n");
				break;
			case 2:
				String nom;
				VilleV2 v;
				System.out.println("Entrez le nom de la ville: ");
				nom = in.next();

				v = VilleV2.rechListe(nom);

				if (v != null) {
					System.out.println("La ville a été trouvée :\n " + v);
				} else {
					System.out.println("\n\n\t La ville sous le nom de : \"" + nom + "\" n'existe pas!!");
				}

				break;
			case 3:
				VilleV2.afficheReseau();
				break;
			case 4:
				VilleV2.afficherListeVilles();
				break;
			case 5:
				if(VilleV2.villes.isEmpty())
					System.out.println("\n\nAucune ville!!");
				else
					VilleV2.Partitions();
				break;
			}

		} while (choix != 0);
	}

}
