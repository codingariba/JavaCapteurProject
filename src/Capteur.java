import java.util.Date;
public class Capteur {
    int id;
    String type;
    String region;
    Date date;
    Capteur(int id, String type, String region, Date date) {
        this.id= id;
        this.type= type;
        this.region= region;
        this.date= date;
    }
}
