// Algorithme de coloriage de graphes
// AUTEURS : Clément ROIG & Adrien ROUX

import java.util.ArrayList;

public class AlgoGraphe {
	
	private Graphe graphe;
		
	public AlgoGraphe(Graphe g) {
		this.graphe = g;
	}
	
	public ArrayList<Sommet> vertexCover() {
		ArrayList<Sommet> vp = new ArrayList<Sommet>();
		ArrayList<Arete> a = graphe.getAretes();
		Arete x;
		
		while(!a.isEmpty()) {
			x = a.get(0);
			vp.add(x.getS1());
			vp.add(x.getS2());
		}
		
		return vp;
	}
	
	
	// ===== MAIN ===== //

	public static void main(String[] args) {

		/* ===== GRAPHE1 ===== */
		/*
			A ---------	B
			  \		   /|
	    		\	 /	|
				  \/    |
			     / \	|
			   /  	 \	|
			 /		   \|
			D			C

		*/

		ArrayList<Sommet> listSom1 = new ArrayList<Sommet>();
		Sommet A = new Sommet("A");
		Sommet B = new Sommet("B");
		Sommet C = new Sommet("C");
		Sommet D = new Sommet("D");
		listSom1.add(A);
		listSom1.add(B);
		listSom1.add(C);
		listSom1.add(D);

		ArrayList<Arete> listAr1 = new ArrayList<Arete>();
		listAr1.add(new Arete(B,C,1));
		listAr1.add(new Arete(D,B,1));
		listAr1.add(new Arete(A,C,1));
		listAr1.add(new Arete(A,B,1));

		Graphe graphe1 = new Graphe("1",listSom1,listAr1);
		System.out.println(graphe1);
	}
}
