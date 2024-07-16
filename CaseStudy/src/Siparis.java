
public class Siparis {

    private int siparisNo;
    private int malNumarasi;
    private int miktar;
    private double birimFiyat;

    // Siparis sınıfına constructor metodu ekleniyor.
    public Siparis(int siparisNo, int malNumarasi, int miktar, double birimFiyat) {

        this.siparisNo = siparisNo;
        this.malNumarasi = malNumarasi;
        this.miktar = miktar;
        this.birimFiyat = birimFiyat;
    }

    // Getter ve setter metodları ekleniyor.
    public int getSiparisNo() {
        return siparisNo;
    }
    public int getMalNumarasi() {
        return malNumarasi;
    }
    public int getMiktar() {
        return miktar;
    }
    public double getBirimFiyat() {
        return birimFiyat;
    }
    public void setSiparisNo(int siparisNo) {
        this.siparisNo = siparisNo;
    }
    public void setMalNumarasi(int malNumarasi) {
        this.malNumarasi = malNumarasi;
    }
    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }
    public void setBirimFiyat(double birimFiyat) {
        this.birimFiyat = birimFiyat;
    }


}
