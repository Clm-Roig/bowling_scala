import java.util.ArrayList;


public class Graphe {
	String name;

	ArrayList<Sommet> sommets = new ArrayList<Sommet>();
	ArrayList<Arete> aretes = new ArrayList<Arete>();

	// Ces deux listes ne sont jamais modifiées par les fonctions (contrairement à
	// sommets et aretes qui sont vidées par colorier())
	ArrayList<Arete> aretesFixes = new ArrayList<Arete>();
	ArrayList<Sommet> sommetsFixes = new ArrayList<Sommet>();

	// Constructeur de base d'un GRaphe
	public Graphe(String n, ArrayList<Sommet> listSom, ArrayList<Arete> listAr) {
		this.name = n;

		for(Sommet s : listSom) {
			sommets.add(s);
			sommetsFixes.add(s);
		}
		for(Arete a : listAr) {
			aretes.add(a);
			aretesFixes.add(a);
		}

	}

	// Constructeur de Graphe par recopie
	public Graphe(Graphe g) {
		this.name = g.name;
		this.sommets = new ArrayList<Sommet>(g.sommets);
		this.sommetsFixes = new ArrayList<Sommet>(g.sommetsFixes);
		this.aretes = new ArrayList<Arete>(g.aretes);
		this.aretesFixes = new ArrayList<Arete>(g.aretesFixes);
	}

	public String toString() {
		String res = "\n---- GRAPHE " + this.name + " ---\nSommets : ";
		for(Sommet s : this.sommetsFixes) {
			res += s.toString() + "  ";
		}
		res += "\nAretes : \n";

		for(Arete ar : this.aretesFixes) {
			res += ar.toString() + "  \n";
		}
		return res;
	}
	
	public ArrayList<Arete> getAretes() {
		return this.aretes;
	}
	
	public ArrayList<Sommet> getSommets() {
		return this.sommets;
	}

	// Supprime toutes les aretes qui concernent un sommet
	public void removeAretesSom(Sommet s) {
		ArrayList<Arete> aretesToRemove = new ArrayList<Arete>();
		for(Arete ar : this.aretes) {
			if(ar.s1.equals(s) || ar.s2.equals(s)) {
				aretesToRemove.add(ar);
			}
		}
		this.aretes.removeAll(aretesToRemove);
	}
}
