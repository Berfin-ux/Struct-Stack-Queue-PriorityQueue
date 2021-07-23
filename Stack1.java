
public class Stack1 {
    private int maxSize;
    private int top;
    Object[] stackArray;

    public Stack1(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        top = -1;
    }

    public void ekle(Object o) { //Yığıta ekleme yapan metod yazılıyor.
        stackArray[++top] = o;   //Eklenen nesne dizinin en başına yerleştiriliyor.
    }

    public Object sil() {
        return stackArray[top--];
    } //Yığıtın en başındaki nesne siliniyor.

    public boolean bosMu() {
        return (top==-1);
    } //Yığıtın bos olup olmadığını döndürür.

    public static void main(String[] args) {

        String[] ad = {"Ali", "Merve", "Veli", "Gülay", "Okan", "Zekiye", "Kemal", "Banu", "İlker", "Songül", "Nuri", "Deniz" };
        int[] urun = {8, 11, 16, 5, 15, 14, 19, 3, 18, 17, 13, 15};

        Stack1 stack = new Stack1(ad.length); //Stack1 sınıfından nesne oluşturuluyor.


        for (int i=0;i<ad.length;i++) {
            Musteri mt = new Musteri(ad[i], urun[i]);
            stack.ekle(mt); //Musteri sınıfı tipindeki her nesne yığıta ekleniyor.
        }

        System.out.println("Yığıt yapısında eleman çıkarma: ");

        while (!stack.bosMu()) {
            System.out.println(stack.sil()); //Yığıt boş olana kadar elemanlar son girenden başlanarak siliniyor.
        }



    }
}
