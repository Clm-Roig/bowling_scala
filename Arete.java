public class Arete {
	int poids;
	Sommet s1;
	Sommet s2;

	public Arete(Sommet s1, Sommet s2, int p){
		this.s1 = s1; 
		this.s2 = s2; 
		this.poids = p;
	}
	
	public Sommet getS1() {
		return this.s1;
	}
	
	public Sommet getS2() {
		return this.s2;
	}

	public String toString() {
		String res = "" + s1.toString() + "---";
		res+=poids;
		res += "---" + s2.toString();
		return res;
	}
}
