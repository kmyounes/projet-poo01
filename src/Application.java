import java.util.*;


public class Application {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stockage de villes dans un tableau dynamique
		
		
		
		VilleV2 v, s, k, t, b;
		
		v = new VilleV2("Babez", "", 0, 0);
		VilleV2.villes.add(v);
		
		v = new VilleV2("Alger", "", 0, 0, 1, VilleV2.types.ordinaire); 
		s = new VilleV2("Blida", "", 0, 0);
		s.addVilleSort(new VilleV2("Oran", "", 0, 0));
		k = new VilleV2("Telemcen", "", 0, 0);
		v.addVilleSort(k);
		k.addVilleSort(new VilleV2("Mostghanem", "", 0, 0));
		t = new VilleV2("Medeia", "", 0, 0);
		k.addVilleSort(t);
		s.addVilleSort(k);
		v.addVilleSort(s);
		v.addVilleSort(new VilleV2("Boumerdess", "", 0, 0));
		
		v.addVilleSort(new VilleV2("Setif", "", 0, 0));
		v.addVilleSort(new VilleV2("Tizi", "", 0, 0));
		
		
		
		VilleV2.villes.add(v);
		
		
		b = new VilleV2("Bouira", "", 0, 0); 
		b.addVilleSort(new VilleV2("Setif", "", 0, 0));
		b.addVilleSort(new VilleV2("Tizi", "", 0, 0));
		VilleV2.villes.add(b);
		

		
		
		//VilleV2.afficheReseauArray();
		
		System.out.println(v.existeChemin(k));
		
		System.out.println();
		System.out.println();
		
		//VilleV2.afficherListeVilles();
		
		System.out.println(VilleV2.rechListe( "Medeia"));
		
		
		
	}
	
	
	
	
	
	
}
	
	