import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Stockage de villes dans un tableau dynamique

		menuPrincipale();

		System.out.println("TERMINATED");

	}

	private static void menuPrincipale() {
		int choix = 1;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		System.out.println("\t\tHello!");

		do {
			System.out.println("\n\n\tWhat do you want to do:\n" + " 1) Add a city.\n"
					+ " 2) Search for a city (do some actions)\n" + " 3) Show cities.\n"
					+ " 4) Show cities list by color.\n" + " 5) Afficher les villes fortement connexe.\n" + " 0) Exit\n"
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
				System.out.println("Enter the city's name: ");
				nom = in.next();

				v = VilleV2.rechListe(nom);

				if (v != null) {
					System.out.println("Found city:\n " + v);
				} else {
					System.out.println("\n\n\tCity with name: \"" + nom + "\" does not exist!!");
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
					System.out.println("\n\nPas de villes!!");
				else
					VilleV2.Partitions();
				break;
			}

		} while (choix != 0);
	}

}
