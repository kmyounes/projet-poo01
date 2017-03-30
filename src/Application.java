import com.sun.media.sound.SoftTuning;

import java.util.*;


public class Application {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stockage de villes dans un tableau dynamique
		
		/*
        Ville v, s, k, t, b;
		
		v = new Ville("Babez", "", 0, 0);
		Ville.villes.add(v);
		
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
		
		
		
		Ville.villes.add(v);
		
		
		b = new Ville("Bouira", "", 0, 0); 
		b.addVilleSort(new Ville("Setif", "", 0, 0));
		b.addVilleSort(new Ville("Tizi", "", 0, 0));
		Ville.villes.add(b);
		
		*/
		
		VilleV2 v, s, k, t, b, d;
		
		d = new VilleV2("Babez", "", 0, 0);
		VilleV2.villes.add(d);
		
		v = new VilleV2("Alger", "", 0, 0, 1, VilleV2.types.ordinaire); 
		s = new VilleV2("Blida", "", 0, 0);
		s.addVilleSort(new VilleV2("Oran", "", 0, 0));
		k = new VilleV2("Telemcen", "", 0, 0);
		k.addVilleSort(v);
				VilleV2 j=(new VilleV2("Mostghanem", "", 0, 0));
		k.addVilleSort(j);
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

		System.out.println(v.exixsteCheminFinal(s));
		//VilleV2.afficherListeVilles();

		
		//System.out.println(VilleV2.rechListe( "Medeia"));
		
		
		
	}
	
	
	
	
	
	
}
	
	