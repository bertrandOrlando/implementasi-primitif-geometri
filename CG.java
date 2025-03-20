public class CG {

    /**
     * Memeriksa apakah dari p ke q ke r berlawanan arah jarum jam atau tidak
     * 
     * @return >0 jika berlawanan arah jarum jam (belok kiri),
     *         <0 jika searah jarum jam (belok kanan), dan 0 jika lurus (kolinear)
     */
    public static double ccw(MyPoint p, MyPoint q, MyPoint r) {
        MyPoint pq = new MyPoint((q.x - p.x), (q.y - p.y)); // Vektor dari p ke q
        MyPoint pr = new MyPoint((r.x - p.x), (r.y - p.y));// Vektor dari p ke r
        double res = ((pq.x * pr.y) - (pq.y * pr.x)); // Hasil cross product
        if (Math.abs(res) <= 0.00000001)
            res = 0;
        return res;
    }

    /**
     * 
     * 
     * @return
     */
    public static double dot(MyPoint p, MyPoint q, MyPoint r) {
        MyPoint pq = new MyPoint((q.x - p.x), (q.y - p.y));// Vektor dari p ke q
        MyPoint qr = new MyPoint((r.x - q.x), (r.y - q.y));// Vektor dari p ke r
        double res = ((pq.x * qr.x) + (pq.y * qr.y));// Hasil dot product
        if (Math.abs(res) <= 0.00000001)
            res = 0;

        // System.out.println("DOT : " + res);
        return res;
    }

    /**
     * jika perlu
     * 
     * @return
     */
    public static double cross(MyPoint p, MyPoint q, MyPoint r) {
        MyPoint pq = new MyPoint((q.x - p.x), (q.y - p.y));// Vektor dari p ke q
        MyPoint pr = new MyPoint((r.x - p.x), (r.y - p.y));// Vektor dari p ke r
        double res = ((pq.x * pr.y) - (pq.y * pr.x));// Hasil cross product
        if (Math.abs(res) <= 0.00000001)
            res = 0;
        // System.out.println("Cross : " + res);
        return res;
    }

}
