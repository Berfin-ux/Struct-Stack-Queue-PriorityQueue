import java.util.ArrayList;
import java.util.List;

public class PriorityQ {
    List<Musteri> priorityList;
    List<Musteri> priorityList2;

    public PriorityQ(int maxSize) {
        this.priorityList = new ArrayList<>(maxSize);
        this.priorityList2 = new ArrayList<>(maxSize);
    }

    public void ekle(Musteri mt) {  //Oluşturulan listelere nesneler ekleniyor.
        priorityList.add(mt);
        priorityList2.add(mt);
    }

    public Musteri artanSil() {
        int minIndex=0;
        for (int i=0;i<priorityList2.size();i++) {
            //Listenin içine eklenen nesnelerin ürün sayıları karşılaştırılıyor.
            //Eklenen nesnenin ürün sayısı 0. indexdekinden ya da önceden minIndex'e atanmış indexteki
            //ürün sayısından küçükse indexi minIndex'e eşitleniyor.
            if (priorityList2.get(minIndex).compareTo(priorityList2.get(i)) == -1) {
                minIndex = i;
            }
        }
        Musteri removed = priorityList2.get(minIndex);
        priorityList2.remove(removed);
        return removed; //Silinen müşteri nesne döndürülüyor.
    }

    public void sil() {
        int maxIndex=0;

        for (int i=0;i<priorityList.size(); i++) {

            //Listenin içine eklenen nesnelerin ürün sayıları karşılaştırılıyor.
            //Eklenen nesnenin ürün sayısı 0. indexdekinden ya da önceden maxIndex'e atanmış indexteki
            //ürün sayısından büyükse indexi maxIndex'e eşitleniyor.
            if (priorityList.get(maxIndex).compareTo(priorityList.get(i)) == 1) {
                maxIndex = i;
            }
        }
        Musteri deleted = priorityList.get(maxIndex);
        priorityList.remove(deleted);
        System.out.println(deleted.toString()); //Silinen müşteri nesnesi yazdırılıyor.
    }

    public boolean bosMu() {
        return (priorityList.isEmpty());
    }

    public boolean bosMu2() {
        return (priorityList2.isEmpty());
    }

    public static void main(String[] args) {
        String[] ad = {"Ali", "Merve", "Veli", "Gülay", "Okan", "Zekiye", "Kemal", "Banu", "İlker", "Songül", "Nuri", "Deniz" };
        int[] urun = {8, 11, 16, 5, 15, 14, 19, 3, 18, 17, 13, 15};

        PriorityQ priority = new PriorityQ(ad.length); //İlk öncelikli kuyruk azalan sırayla eleman siliyor.
        PriorityQ priority2 = new PriorityQ(ad.length); //İkinci öncelikli kuyruk artan sırayla eleman siliyor.
        PriorityQ priority3 = new PriorityQ(ad.length);
        //Üçüncü öncelikli kuyruk artan sırayla silinen elemanların ürün sayılarını almak için kullanılıyor.

        for (int i =0; i<ad.length; i++) {
            Musteri mt = new Musteri(ad[i], urun[i]);
            priority.ekle(mt);    //İlk öncelikli kuyruğa nesneler ekleniyor.
        }

        System.out.println("Azalan sırayla eleman çıkartma: ");

        while (!priority.bosMu()) {
            priority.sil();   //İlk öncelikli kuyruğun elemanları azalan sırayla siliniyor.
        }

        System.out.println();
        System.out.println("Artan sırayla eleman çıkartma: ");

        for (int b=0;b<ad.length; b++) {
            Musteri m = new Musteri(ad[b], urun[b]);
            priority2.ekle(m);  //İkinci öncelikli kuyruğa nesneler ekleniyor.

        }

        while (!priority2.bosMu2()) {
            System.out.println(priority2.artanSil()); //İkinci öncelikli kuyruğun elemanları artan sırayla siliniyor.

        }

        int time=0;
        int totalTime=0;
        System.out.println();
        System.out.println("Her bir müşteri için işlem tamamlanma süresi: ");

        for (int b=0;b<ad.length; b++) {
            Musteri m = new Musteri(ad[b], urun[b]);
            priority3.ekle(m);  //Üçüncü öncelikli kuyruğa nesneler ekleniyor.
        }

        for (int k=0;k<ad.length;k++) {
            time += priority3.artanSil().urunSay; //Artan sırayla silinen nesnelerin ürün sayıları birikimli olarak time değişkenine ekleniyor.
            System.out.println(priority.artanSil().musteriAd + "-->" + time);
            totalTime += time;  //time değişkeninin değerleri birikimli olarak totalTime değişkenine ekleniyor.
        }

        float musteriSay = ad.length;
        float t = totalTime;
        float ort = t/musteriSay;  //Ortalama işlem süresi hesaplanıyor.

        System.out.println();
        System.out.print("Ortalama işlem tamamlanma süresi: ");
        System.out.println(ort);


    }
}
