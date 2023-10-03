package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements;
	public Romain(String nom, int force) {
		assert force > 0 : "La force d'un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert force > 0 : "La force d'un Romain est toujours positive";
		int ancienneForce = force;
		force -= forceCoup;
		assert ancienneForce > force : "La force d'un Romain a diminué";
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	public void sEquiper(Equipement nouvelEquip) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("Le soldat " + nom + " est déjà bien protégé !" );
			break;
		}
		case 1:{
			if (equipements[0]== nouvelEquip) {
				System.out.println("Le soldat " + nom + " possède déjà un " + nouvelEquip +  "!");
			}else {
				equipements[1] = nouvelEquip;
				nbEquipement ++;
				System.out.println("Le soldat " + nom + " s'équipe avec un "+ nouvelEquip + ".");
			}
			break;
		}
		default:
			equipements[0]=nouvelEquip;
			nbEquipement ++;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + nouvelEquip + ".");
			break;
		}
		
			
	}
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		System.out.println(minus);
	    minus.sEquiper(Equipement.CASQUE);
	    minus.sEquiper(Equipement.CASQUE);
	    minus.sEquiper(Equipement.BOUCLIER);
	    minus.sEquiper(Equipement.CASQUE);
	}
}

