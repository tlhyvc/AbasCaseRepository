import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();

        service.veriEkle();
        System.out.println("-------------Toplam Tutar-------------------------------\n");
        System.out.println("Toplam Tutar: " + service.toplamTutar());
        System.out.println("\n-------------Ortalama Tutar-------------------------------\n");
        System.out.println("Ortalama Tutar: " + service.ortalamaTutar());
        System.out.println("\n-------------Mal Bazlı Ortalama Fiyat-------------------------------\n");
        Map<Integer, Double> ortalamaFiyatlar = service.malBazliOrtalamaTutar();

        for (Map.Entry<Integer, Double> entry : ortalamaFiyatlar.entrySet()) {
            System.out.println("Mal No: " + entry.getKey() + ", Ortalama Fiyat: " + entry.getValue());
        }
        System.out.println("\n-------------Mal bazlı hangi siparişte kaç tane olduğu-------------------------------\n");
        Map<Integer, Map<Integer, Integer>> malSiparisDetaylari = service.malBazliSiparisDetaylari();

        for (Map.Entry<Integer, Map<Integer, Integer>> entry : malSiparisDetaylari.entrySet()) {
            int malNo = entry.getKey();
            System.out.println("Mal No: " + malNo);
            for (Map.Entry<Integer, Integer> siparisEntry : entry.getValue().entrySet()) {
                int siparisNo = siparisEntry.getKey();
                int miktar = siparisEntry.getValue();
                System.out.println("  Sipariş No: " + siparisNo + ", Miktar: " + miktar);
            }
        }
    }
}