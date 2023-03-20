import java.util.Comparator;

public class Studentai implements Comparable<Studentai> {

    int pazymejimoId;
    String pavardeVardas;
    String gimimoData;
    String grupe;
    double vidurkis;

    public Studentai(){

    }
    public Studentai(int pazymejimoId, String pavardeVardas, String gimimoData, String grupe, double vidurkis) {
        this.pazymejimoId = pazymejimoId;
        this.pavardeVardas = pavardeVardas;
        this.gimimoData = gimimoData;
        this.grupe = grupe;
        this.vidurkis = vidurkis;
    }

    public void setGimimoData(String gimimoData) {
        this.gimimoData = gimimoData;
    }

    public void setGrupe(String grupe) {
        this.grupe = grupe;
    }

    public void setVidurkis(double vidurkis) {
        this.vidurkis = vidurkis;
    }

    public void setPazymejimoId(int pazymejimoId){
        this.pazymejimoId=pazymejimoId;
}
public void setPavardeVardas(String pavardeVardas){
        this.pavardeVardas = pavardeVardas;
}

    public String getPavardeVardas() {
        return pavardeVardas;
    }

    public String getGimimoData() {
        return gimimoData;
    }

    public String getGrupe() {
        return grupe;
    }

    public double getVidurkis() {
        return vidurkis;
    }

    @Override
    public String toString() {
        return "Studentai{" +
                "pazymejimoId=" + pazymejimoId +
                ", pavardeVardas='" + pavardeVardas + '\'' +
                ", gimimoData='" + gimimoData + '\'' +
                ", grupe='" + grupe + '\'' +
                ", vidurkis=" + vidurkis +
                '}';
    }

    public int getPazymejimoId() {
        return pazymejimoId;
    }

    @Override
    public int compareTo(Studentai studentai) {

        return Comparator
                .comparing(Studentai::getVidurkis)
                .reversed()
                .compare(this,studentai);
    }
}
