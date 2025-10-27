import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Capteur c1= new Capteur(1, "humidite", "Fes", new Date());
        Capteur c2= new Capteur(2, "temperature", "Rabat", new Date());
        Capteur c3= new Capteur(3, "temperature", "Fes", new Date());
        Capteur c4= new Capteur(4, "ph", "Casablanca", new Date());
        Mesures m1= new Mesures("temperature", 2, 35);
        Mesures m2= new Mesures("humidite", 1, 21);
        Mesures m3= new Mesures("temperature", 3, 25);
        Mesures m4= new Mesures("ph", 4, 7);
        Etc etc= new Etc();
        etc.mesures.add(m1);
        etc.mesures.add(m2);
        etc.mesures.add(m3);
        etc.mesures.add(m4);
        ArrayList<Double>humidite= new ArrayList<>();
        ArrayList<Double>temperature= new ArrayList<>();
        ArrayList<Double>ph= new ArrayList<>();

        for (Mesures m : etc.mesures) {
            if (m.capteur.equals("humidite")) {
                humidite.add(m.valeur);
            } else if (m.capteur.equals("temperature")) {
                temperature.add(m.valeur);
            } else if (m.capteur.equals("ph")) {
                ph.add(m.valeur);
            }
        }
        System.out.println("Liste Humidite");
        System.out.println(humidite);
        System.out.println("Liste Temperature");
        System.out.println(temperature);
        System.out.println("Liste Ph");
        System.out.println(ph);
        System.out.println("Mesures par capteur");
        for (Mesures m : etc.mesures) {
            System.out.println("Capteur " + m.id + " (" + m.capteur + ") : " + m.valeur);
        }
        System.out.println("Moyenne par type");
        System.out.println("Humidite : " + moyenne(humidite));
        System.out.println("Temperature : " + moyenne(temperature));
        System.out.println("PH : " + moyenne(ph));
        System.out.println("Moyenne par capteur");
        for (Mesures m : etc.mesures) {
            double s=0;
            int c=0;
            for (Mesures x : etc.mesures) {
                if (x.id == m.id) {
                    s+= x.valeur;
                    c++;
                }
            }
            System.out.println("Capteur " + m.id + " : " + (s/c));
        }
        System.out.println("Moyenne par region");

        double sumfes=0;
        double sumrabat=0;
        double sumcasa=0;
        int c_fes=0;
        int c_rabat=0;
        int c_casa=0;
        Capteur[] capteurs = {c1, c2, c3, c4};
        for (Mesures m : etc.mesures) {
            String region="";
            for (Capteur c : capteurs) {
                if (c.type.equals(m.capteur) && c.id == m.id) {
                    region= c.region;
                    break;
                }
            }
            if (region.equals("Fes")) {
                sumfes+= m.valeur;
                c_fes++;
            } else if (region.equals("Rabat")) {
                sumrabat+= m.valeur;
                c_rabat++;
            } else if (region.equals("Casablanca")) {
                sumcasa+= m.valeur;
                c_casa++;
            }
        }
        System.out.println("Fes: " + (sumfes/c_fes));
        System.out.println("Rabat: " + (sumrabat/c_rabat));
        System.out.println("Casablanca: " + (sumcasa/c_casa));
        etc.normaliserMesures();
    }
        public static double moyenne (ArrayList< Double >liste) {
            if (liste.isEmpty()) return 0;
            double s= 0;
            for (double v : liste) s+= v;
            return s/liste.size();
        }
    }