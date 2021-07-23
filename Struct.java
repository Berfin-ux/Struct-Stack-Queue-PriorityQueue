import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Struct {
    public static void main(String[] args) {


        String[] ad = {"Ali", "Merve", "Veli", "Gülay", "Okan", "Zekiye", "Kemal", "Banu", "İlker", "Songül", "Nuri", "Deniz" };
        int[] urun = {8, 11, 16, 5, 15, 14, 19, 3, 18, 17, 13, 15};

        //GenericList oluşturuluyor.
        List<Musteri> generic = new ArrayList<>();

        //Oluşturulan genericLİst'e Musteri sınıfı nesneleri sırasıyla ekleniyor.
        for (int i=0;i<ad.length;i++) {
            Musteri mt = new Musteri(ad[i], urun[i]);
            generic.add(mt);
        }

        //GenericListlerden oluşan bir ArrayList tanımlanıyor.
        ArrayList<List<Musteri>> arrayList = new ArrayList<>();

        Random random = new Random();
        int objSay = generic.size(); //GenericList'in boyutu int tipinde değişkene atılıyor.

        while (objSay != 0) {
            //While döngüsü içinde yeni bir GenericList tanımlanıyor.
            List<Musteri> generic1 = new ArrayList<>();
            int k = 0;
            int r = random.nextInt(5) +1;

            /*Random sayı ilk oluşturulan genericList içinde kalan
            eleman sayısından küçükse if içine giriyor.*/
            if (r<=objSay) {
                for (int a=0;a<r;a++) {
                    generic1.add(generic.get(k)); //random sayı kadar nesne while döngüsü içinde oluşturulan genericList'e ekleniyor.
                    generic.remove(k);            //İlk oluşturulan GenericList'ten ise aynı nesne siliniyor.
                    objSay--;                     //int tipindeki değişkenin değeri 1 azaltılıyor.
                }

            }
            /*Eğer random sayı objSay'dan büyükse geri kalan
            tüm nesneler tek bir genericList'e atanıyor.*/
            else {
                for (int b=0;b<objSay;b++) {
                    generic1.add(generic.get(k));
                    generic.remove(k);
                    objSay--;
                }
            }
            arrayList.add(generic1); //Oluşturulan her genericList ArrayList'e ekleniyor.

        }



        for (int x=0;x<arrayList.size();x++) {
            System.out.println(arrayList.get(x)); //ArrayList yazdırılıyor.
        }

        double r = ad.length;
        double d = arrayList.size();
        double ortEleman = (r/d); //ortalama eleman sayısı hesaplanıyor.
        System.out.println();
        System.out.println("ArrayList Eleman Sayısı: " + arrayList.size());  //ArrayList'in eleman sayısı yazdırılıyor.
        System.out.print("Ortalama Eleman Sayısı: " );
        System.out.println(ortEleman);                       //Ortalama eleman sayısı yazdırılıyor.

    }
}

