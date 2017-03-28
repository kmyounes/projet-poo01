import java.util.*;


public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stockage de villes dans un tableau dynamique
		ArrayList<Ville> villes = new ArrayList<Ville>(5);
		
		
		Ville v, s, k, t, b;
		
		v = new Ville("Babez", "", 0, 0);
		villes.add(v);
		
		v = new Ville("Alger", "", 0, 0, 1, Ville.types.ordinaire); 
		s = new Ville("Blida", "", 0, 0);
		s.addVilleSort(new Ville("Oran", "", 0, 0));
		k = new Ville("Telemcen", "", 0, 0);
		k.addVilleSort(new Ville("Mostghanem", "", 0, 0));
		t = new Ville("Medeia", "", 0, 0);
		k.addVilleSort(t);
		s.addVilleSort(k);
		v.addVilleSort(s);
		v.addVilleSort(new Ville("Boumerdess", "", 0, 0));
		
		v.addVilleSort(new Ville("Setif", "", 0, 0));
		v.addVilleSort(new Ville("Tizi", "", 0, 0));
		
		//afficheReseauVille(v);
		
		villes.add(v);
		
		/*
		 * //This isnt working
	       public boolean existeChemin(Ville debut,Ville fin){
	       System.out.println(v.existeChemin(v, t));
	       
		 */
		
		b = new Ville("Bouira", "", 0, 0); 
		b.addVilleSort(new Ville("Setif", "", 0, 0));
		b.addVilleSort(new Ville("Tizi", "", 0, 0));
		villes.add(b);
		

		
		//afficheReseauVille(v);
		afficheReseauArray(villes);
		
		System.out.println();
		System.out.println();
		
		afficherListeVilles(villes);
		
		System.out.println(rechListe(villes, "Medeia"));
		
		//System.out.println(v.existeChemin(s));
		
		
	}
	
	public static Ville rechListe(Collection<Ville> villes, String nom){
		/*
		for(Ville v : liste){
			if(v.getNom().equals(nom))
				return v;
		}
		*/
		Ville temp;
		
		for(Ville v: villes){
			temp = v.recherche(nom);
			if(temp != null)
				return temp;
			
		}
		
		return null;
		
	}
	
	
	public static void modifieVille(Ville v){
		int choice = 1;
		Scanner in = new Scanner(System.in);
		
		do{
			System.out.printf("What do you want to change?: %n 1) Nom 2) Wilaya 3) Superficie 4) Type de ville 0) Abort.%n Votre choix: ");
			choice = in.nextInt();
			
			if(choice < 0 || choice > 4)
				System.out.println("Erreur!! Please enter a valide choice!");
			
		}while(choice < 0 || choice > 4);
			
		switch(choice){
		case 1: 
			System.out.println("Enter the new name:  ");
			v.setNom(in.next());
			break;
		case 2: 
			System.out.println("Enter the new wilaya:  ");
			v.setWilaya(in.next());
			break;
		case 3: 
			System.out.println("Enter the new :  ");
			v.setSuperficie(in.nextDouble());
			break;
		case 4: 
			int type = 1;
			do{
				System.out.printf("Enter the new type:  1) Agricole, 2) Touristique, 3) Industrielle, 4) Ordinaire.%n Votre choix: ");
				type = in.nextInt();
				if(type < 1 || type >4)
					System.out.println("Error!! Enter a valid type!");
			}while(type < 1 || type >4);
			
			switch(type){
			case 1:
				v.setType("agricole");
				break;
			case 2:
				v.setType("touristique");
				break;
			case 3:
				v.setType("industrielle");
				break;	
			case 4:
				v.setType("ordinaire");
				break;
			}
			break;
		}
		
		System.out.println("Done!");
		in.close();
	}
	
	static public boolean supprime(ArrayList<Ville> liste, Ville v){
		
		if(liste.indexOf(v) == -1){
			System.out.println("Ville n'existe pas dans la liste!");
			return false;
		}
				
		liste.remove(v);
		System.out.println("Operation terminee");
		return true;
		
		
	}
	
	public static void afficheReseauArray(ArrayList<Ville> liste){
			
		for(Ville v: liste){
			afficheReseauVille(v, 0, 0);
		}
	}
	
	public static void afficheReseauVille(Ville v){
		afficheReseauVille(v, 0, 0);
	}
	
	public static void afficheReseauVille(Ville v, int numSpace, int i){
		
		System.out.print(v.getNom());
		
		numSpace += v.getNom().length();
		//numSpace += 5;
				
		if( ! v.pasChemin()){
			
			boolean space = false;
			
			//for(Ville temp : v.getVoisinsSortants()){
			for(Ville temp : v.getVoisSort()){
				
				if(temp != null){
					if(space){
						
						//make a string of ' ' numSpaces time.
						char[] chars = new char[ numSpace + i*4 ];
						Arrays.fill(chars, ' ');
						String result = new String(chars);
						System.out.print(result);
						
						
					} else {
						space = !space;
						
					}
					
					System.out.print(" => ");
					
					afficheReseauVille(temp, numSpace ,i+1);
					
				}
			}
		}
		
		System.out.println();
	}
	
	public static void afficherListeVilles(ArrayList<Ville> liste){
		String vert = "", rouge = "", orange= "";
		
		for(Ville v: liste){
			if(v.getCouleur().equalsIgnoreCase("vert"))
				vert = vert + " " + v.getNom();			
			if(v.getCouleur().equalsIgnoreCase("rouge"))
				rouge = rouge + " " + v.getNom();
			if(v.getCouleur().equalsIgnoreCase("orange"))
				orange = orange + " " + v.getNom();
		}
		
		System.out.println("La liste des villes: ");
		System.out.println("Vert:  " + vert);
		System.out.println("Rouge:  " + rouge);
		System.out.println("Orange:  " + orange);
		
	}

}
