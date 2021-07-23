
public class Queue1 {
    private int maxSize;
    Object[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue1(int maxSize) {
        this.maxSize = maxSize;
        this.queArray = new Musteri[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void ekle(Object o) {
        if(rear == maxSize-1){   //Kuyruk boşken ilk eleman ekleniyor.
            rear = 0;
            queArray[rear] = o;
        }else {
            queArray[++rear] = o;  //Geri kalan elemanlar ilk elemanın arkasına ekleniyor.
        }
        nItems++;
    }

    public Object sil() {
        Object temp = queArray[front];
        queArray[front] = null;           //En baştaki elemana null atanıyor.
        if (front == maxSize-1){
            front = 0;                   //Kuyruk boş olunca 0 döndürüyor.
        }else {
            front++;
        }
        nItems--;                       //Kuyruk eleman sayısı 1 azaltılıyor.
        return temp;                   //Silinen nesne döndürülüyor.
    }

    public boolean bosMu() {
        return (nItems == 0);
    }

    public static void main(String[] args) {
        String[] ad = {"Ali", "Merve", "Veli", "Gülay", "Okan", "Zekiye", "Kemal", "Banu", "İlker", "Songül", "Nuri", "Deniz" };
        int[] urun = {8, 11, 16, 5, 15, 14, 19, 3, 18, 17, 13, 15};

        Queue1 queue = new Queue1(ad.length);            //Queue1 sınıfı tipinde nesne oluşturuluyor.

        //Musteri sınıfı nesneleri for döngüsü içinde sırayla kuyruğa ekleniyor.
        for (int i=0;i<ad.length;i++) {
            Musteri mt = new Musteri(ad[i], urun[i]);
            queue.ekle(mt);
        }

        System.out.println("Kuyruk yapısında eleman çıkarma: ");

        //Kuyruk boş olana kadar ilk girenden başlanarak elemanlar siliniyor.
        while (!queue.bosMu()) {
            System.out.println(queue.sil());
        }

        System.out.println();
        System.out.println("Her bir müşteri için işlem tamamlanma süresi: ");

        int time=0;
        int totalTime =0;
        for (int i=0;i<ad.length;i++) {
            Musteri mt = new Musteri(ad[i], urun[i]);
            time += mt.urunSay;                         //Her ürün sayısı birikimli olarak int tpindeki time değişkenine ekleniyor.
            System.out.println(mt.musteriAd + "--> " + time);
            totalTime += time;                         //Her time değeri birikimli olarak int tipindeki totalTime değişkenine ekleniyor.
        }

        float mustSay = ad.length;
        float t = totalTime;
        float ort = t/mustSay;          //Ortalama işlem tamamlanma süresi hesaplanıyor.


        System.out.println();
        System.out.print("Ortalama işlem tamamlanma süresi: ");
        System.out.print(ort);
    }
}
