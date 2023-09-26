package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
		
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois g) {
		if (villageois.length > nbVillageois) {
			villageois[nbVillageois] = g;
			nbVillageois++;
		}
	}
	public Gaulois trouverHabitant(int nbHabitants) {
		return villageois[nbHabitants];
	}
	public void afficherVillageois() {
		System.out.println("Dans village du chef " +chef.getNom()+" vivent les légendaires gaulois :");
		System.out.println("-" + trouverHabitant(0).getNom());
		System.out.println("-" + trouverHabitant(1).getNom() );
	}
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
//      Il affiche une exception "ArrayIndexOutOfBoundsException" car le numéro est hors des limites qui vont de 0 à 29.
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//      Il affiche "null" car il n'y a qu'un seul habitant(Astérix)qui est en position 0 du tableau villageois.	
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}

