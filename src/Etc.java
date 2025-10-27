import java.util.ArrayList;

public class Etc {
    ArrayList<Mesures> mesures;
    public Etc() {
        mesures = new ArrayList<>();
    }
    public void normaliserMesures() {
        if (mesures.isEmpty()) {
            System.out.println("Aucune mesure a normaliser");
            return;
        }

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (Mesures m : mesures) {
            double val = m.valeur;
            if (val < min) min = val;
            if (val > max) max = val;
        }

        for (Mesures m : mesures) {
            if (max != min) {
                double valNorm = (m.valeur - min) / (max - min);
                m.valeur=valNorm;
            } else {
                m.valeur=0.5;
            }
        }

        System.out.println("Normalisation effectuee");
    }
}
