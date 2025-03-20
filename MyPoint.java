public class MyPoint {
    /** komen di sini */
    public double x;
    /** komen di sini */
    public double y;

    /**
     * konstruktor
     * 
     * @param x
     * @param y
     */
    MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * [1] jarak ke titik laen
     * 
     * @param o
     * @return
     */
    double distanceToOtherPoints(MyPoint o) {
        double dist = 0.0;

        // Hitung jarak euclidean
        dist = Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));

        return dist;
    }

    /**
     * [2b] jarak ke segmen garis
     * 
     * @param l
     * @return
     */
    double distanceToLineSegment(MyLineSegment l) {
        double res = 0.0;
        // panggil aja dari l, l.distanceToPoint(this);
        res = l.distanceToPoint(this); // Memanggil fungsi dari MyLineSegment
        return res;
    }
}
