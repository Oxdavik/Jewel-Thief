

import java.util.ArrayList;

public class TestGrille {

	public static void main(String[] args){
		Grille t = new Grille(4,5);
		
		t.affiche(2);
		

		System.out.println("Informations sur la grille:\n"+t);		
		

		Contenu e1 = new Contenu("Cepe",5);
		

		try {
			t.setCase(7,41,e1);
			System.out.println("Ajout de " +e1+" valide !");
		}
		catch (CoordonneesIncorrectesException e) {
			System.out.println("Erreur:" +e.getMessage());
		}
	

		try {
			t.setCase(2,3,e1);
			e1.setPosition(2, 3);
			System.out.println("Ajout de " +e1+" valide !");
		}
		catch (CoordonneesIncorrectesException e) {
			System.out.println("Erreur: "+e.getMessage());
		}
		

		t.affiche(6);

		System.out.println("Informations sur la grille:\n"+t);
		
try {
			System.out.println("Dans la case (1,4): "+t.getCase(1,4));
			System.out.println("Liste de tous les Contenus présents actuellement:");
		}
		catch (CoordonneesIncorrectesException e) {
			System.out.println("Erreur: "+e.getMessage());
		}
				
	 	ArrayList<Contenu> liste = t.lesContenus();
		for (Contenu r : liste) {
			System.out.println(r);
		}
		
	}

}
