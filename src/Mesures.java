import java.util.ArrayList;
public class Mesures {
    ArrayList<Mesures>mesures;
    String capteur;
    int id;
    double valeur;
    public Mesures(String capteur, int id, double valeur) {
        this.mesures= new ArrayList<>();
        this.capteur= capteur;
        this.id= id;
        this.valeur= valeur;
    }
    public void ajouterMesures(Mesures mesures) {
        this.mesures.add(mesures);
    }
    public void SupprimerMesures(Mesures mesures) {
        this.mesures.remove(mesures);
    }
    public void modifierMesure(int index, String nvcapteur, int nvid, double nvvaleur) {
        if (index >= 0 && index < mesures.size()) {
            Mesures m= mesures.get(index);
            m.capteur= nvcapteur;
            m.id= nvid;
            m.valeur= nvvaleur;
            System.out.println("Mesure changee");
        } else {
            System.out.println("Erreur : index ou ne pas pas");
        }
    }
}
