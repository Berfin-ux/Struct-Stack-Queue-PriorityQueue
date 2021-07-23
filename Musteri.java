
public class Musteri implements Comparable<Musteri>  {

    String musteriAd;
    int urunSay;

    public Musteri(String musteriAd, int urunSay) {

        this.musteriAd = musteriAd;
        this.urunSay = urunSay;

    }

    @Override
    public String toString() {
        return "(" + musteriAd + ", "
                + urunSay + ")";
    }

    @Override
    public int compareTo(Musteri o) {
        return o.urunSay>this.urunSay? 1:-1;  //Ürün sayıları karşılaştırılıyor.
    }
}
