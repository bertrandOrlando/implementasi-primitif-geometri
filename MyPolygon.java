import java.util.ArrayList;
import java.util.List;

public class MyPolygon {
    /**  */
    List<MyPoint> Points;

    /**
     * konstruktor
     * 
     * @return
     */
    public MyPolygon() {
        this.Points = new ArrayList<MyPoint>();
    }

    /**
     * [5a,6a,7a] masukin titik
     * 
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        // Menambahkan titik ke dalam polygon
        this.Points.add(p);
        return true;
    }

    /**
     * [5b] konveks ato bukan
     * 
     * @return
     */
    boolean isConvex() {
        boolean convex = true;

        for (int i = 0; i < this.Points.size() - 2 && convex; i++) {
            // Membuat segment garis
            MyLineSegment l = new MyLineSegment(Points.get(i), Points.get(i + 1));

            // Menguji segment garis ke titik selanjutnya belok kiri(hal ini karna ccw)
            double direction = l.leftTurnToPoint(Points.get(i + 2));

            // Jika belok kanan hentikan loop dan polygon ini berbentuk concave
            if (direction <= 0)
                convex = false;
        }

        return convex;
    }

    /**
     * [6b] luas poligon ini
     * 
     * @return
     */
    double area() {
        // Variable untuk total luas polygon
        double area = 0.0;

        for (int i = 0; i < this.Points.size(); i++) {
            // untuk mendapatkan titik selanjutnya dan untuk menghindari out of bound
            int j = (i + 1) % this.Points.size();

            // Menambahkan setiap area yang baru
            area += (Points.get(i).x + Points.get(j).x) * (Points.get(j).y -
                    Points.get(i).y);
        }

        // Membagi 2 dari total area yang didapatkan
        area = Math.abs(area) / 2;

        return area;
    }

    /**
     * [7b] titik p di dalem ato luar,
     * jika berimpitan dengan titik atau segmen, di dalam
     * 
     * @param p
     * @return
     */
    boolean isPointInside(MyPoint p) { // menggunakan even odd rule

        int intersect = 0; // total segment yang berpotongan dengan laser

        // Membuat halfline/ laser horizontal dari titik p
        MyLineSegment l1 = new MyLineSegment(p, new MyPoint(Double.MAX_VALUE, p.y));

        for (int i = 0; i < this.Points.size(); i++) {
            // untuk mendapatkan titik selanjutnya dan untuk menghindari out of bound
            int j = (i + 1) % this.Points.size();

            // Membuat segment garis
            MyLineSegment l2 = new MyLineSegment(Points.get(i), Points.get(j));

            // Menguji apakah segment garis yang dibuat, berpotongan dengan laser
            if (l1.isIntersect(l2)) {
                intersect++;
            }
        }

        // System.out.println("Total Intersect : " + intersect);

        // Ganjil = didalam dan Genap == diluar
        boolean inside = intersect % 2 == 1;

        return inside;
    }

}
