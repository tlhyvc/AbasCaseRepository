import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Service {

    ArrayList<Siparis> siparisler = new ArrayList<Siparis>();

    // Siparis ekleme metodu
    public void siparisEkle(Siparis siparis) {
        siparisler.add(siparis);
    }

    // Siparişteki malların toplam tutarı
    public double toplamTutar() {
        double toplamTutar = 0;
        for (Siparis siparis : siparisler) {
            toplamTutar += siparis.getMiktar() * siparis.getBirimFiyat();
        }
        return toplamTutar;
    }

    // Siparişteki bütün malların ortalama tutarı
    public double ortalamaTutar() {
        double toplamTutar = toplamTutar();
        double toplamMiktar = 0;
        for (Siparis siparis : siparisler) {
            toplamMiktar += siparis.getMiktar();
        }
        if (toplamMiktar == 0) {
            return 0;
        }
        return toplamTutar / toplamMiktar;
    }

    // Siparişteki bütün malların tek tek mal bazlı ortalama fiyatı
    public Map<Integer, Double> malBazliOrtalamaTutar() {
        Map<Integer, Double> toplamFiyatlar = new HashMap<>();
        Map<Integer, Integer> toplamMiktarlar = new HashMap<>();

        // Siparişdeki her malın toplam fiyatını ve miktarını hesaplama
        for (Siparis siparis : siparisler) {
            int malNumarasi = siparis.getMalNumarasi();
            double toplamFiyat = siparis.getMiktar() * siparis.getBirimFiyat();
            int miktar = siparis.getMiktar();

            toplamFiyatlar.put(malNumarasi, toplamFiyatlar.getOrDefault(malNumarasi, 0.0) + toplamFiyat);
            toplamMiktarlar.put(malNumarasi, toplamMiktarlar.getOrDefault(malNumarasi, 0) + miktar);
        }

        // Her malın ortalama fiyatını hesaplama
        Map<Integer, Double> ortalamaFiyatlar = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : toplamFiyatlar.entrySet()) {
            int malNumarasi = entry.getKey();
            double toplamFiyat = entry.getValue();
            int toplamMiktar = toplamMiktarlar.get(malNumarasi);

            if (toplamMiktar > 0) {
                ortalamaFiyatlar.put(malNumarasi, toplamFiyat / toplamMiktar);
            }
        }

        return ortalamaFiyatlar;
    }

    // Tek tek mal bazlı, malların hangi siparişte kaç adet olduğu
    public Map<Integer, Map<Integer, Integer>> malBazliSiparisDetaylari() {
        Map<Integer, Map<Integer, Integer>> malSiparisDetaylari = new HashMap<>();

        for (Siparis siparis : siparisler) {
            int malNumarasi = siparis.getMalNumarasi();
            int siparisNo = siparis.getSiparisNo();
            int miktar = siparis.getMiktar();

            // Eğer bu mal numarası daha önce eklenmemişse, yeni bir giriş oluştur
            malSiparisDetaylari.putIfAbsent(malNumarasi, new HashMap<>());

            // Sipariş numarasına göre miktarı güncelle
            Map<Integer, Integer> siparisDetaylari = malSiparisDetaylari.get(malNumarasi);
            siparisDetaylari.put(siparisNo, siparisDetaylari.getOrDefault(siparisNo, 0) + miktar);
        }

        return malSiparisDetaylari;
    }

    // Sipariş ekleme Methodu
    public void siparisEkle(int siparisNo, int malNo, int miktar, double birimFiyat) {
        Siparis siparis = new Siparis(siparisNo, malNo, miktar, birimFiyat);
        siparisler.add(siparis);
    }

    // Sipariş veri ekleme
    public void veriEkle() {

        siparisEkle(1000, 2000, 12, 100.51);
        siparisEkle(1000, 2001, 31, 200);
        siparisEkle(1000, 2002, 22, 150.86);
        siparisEkle(1000, 2003, 41, 250);
        siparisEkle(1000, 2004, 55, 244);

        siparisEkle(1001, 2001, 88, 44.531);
        siparisEkle(1001, 2002, 121, 88.11);
        siparisEkle(1001, 2004, 74, 211);
        siparisEkle(1001, 2002, 14, 88.11);

        siparisEkle(1002, 2003, 2, 12.1);
        siparisEkle(1002, 2004, 3, 22.3);
        siparisEkle(1002, 2003, 8, 12.1);
        siparisEkle(1002, 2002, 16, 94);
        siparisEkle(1002, 2005, 9, 44.1);
        siparisEkle(1002, 2006, 19, 90);
    }
}
