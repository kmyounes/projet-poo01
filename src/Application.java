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
		Ville.afficheReseauArray(villes);
		
		System.out.println();
		System.out.println();
		
		Ville.afficherListeVilles(villes);
		
		System.out.println(Ville.rechListe(villes, "Medeia"));
		
		//System.out.println(v.existeChemin(s));
		
		
	}
	
	
	
	
}
	
	