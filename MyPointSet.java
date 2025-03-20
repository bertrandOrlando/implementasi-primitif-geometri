import java.util.ArrayList;
import java.util.List;

public class MyPointSet {
    /**  */
    List<MyPoint> Points;

    /**
     * konstruktor
     * 
     * @return
     */
    public MyPointSet() {
        this.Points = new ArrayList<MyPoint>();
    }

    /**
     * [8a] masukin titik
     * 
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        this.Points.add(p); // Memasukan titik ke dalam himpunan/arraylist

        return true;
    }

    /*
     * Mendapatkan titik yang paling bawah kiri
     */
    MyPoint getTitikAcuan() {
        int indexTitikAcuan = 0;// Mengasumsikan titik pertama ialah titik acuan

        for (int i = 0; i < Points.size(); i++) {
            // Menguji apakah ada titik yang posisinya lebih bawah(y) dari titik acuan
            // sekarang
            // Jika nilai y nya sama, cek apakah titik tersebut lebih kiri
            if (Points.get(i).y < Points.get(indexTitikAcuan).y ||
                    (Points.get(i).y == Points.get(indexTitikAcuan).y &&
                            Points.get(i).x < Points.get(indexTitikAcuan).x)) {
                indexTitikAcuan = i;
            }
        }

        // Mengembalikan titik paling bawah kiri
        return Points.get(indexTitikAcuan);
    }

    void sort() {
        MyPoint titikAcuan = getTitikAcuan(); // Mendapatkan titik paling bawah kiri

        // Menggunakan sort dari class ArrayList
        Points.sort((a, b) -> {
            // Mengabaikan titik yang merupakan titik acuan
            if (a == titikAcuan)
                return -1;
            if (b == titikAcuan)
                return 1;

            // Membuat segment garis sebagai acuan nantinya lebih besar/kecil dengan
            // belok kiri/belok kanan
            MyLineSegment l = new MyLineSegment(titikAcuan, a);

            // System.out.printf("%.3f %f %f\n", l.leftTurnToPoint(b), a.x, b.x);

            // Jika belok kiri berarti a lebih kecil dari b
            if (l.leftTurnToPoint(b) >= 0) {
                return -1;
            } else {
                return 1;
            }
        });
    }

    void printPoints() {
        // Menampilkan posisi dari setiap titik di arraylist
        for (MyPoint point : Points) {
            System.out.println(point.x + " " + point.y);
        }
    }
}