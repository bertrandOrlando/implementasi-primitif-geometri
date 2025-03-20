public class MyLineSegment {
    /** Titik awal dari segmen garis */
    MyPoint start;
    /** Titik akhir dari segmen garis */
    MyPoint end;

    /**
     * konstruktor
     * 
     * @param start
     * @param end
     */
    MyLineSegment(MyPoint start, MyPoint end) {
        this.start = start;
        this.end = end;
    }

    /**
     * [2a] jarak ke titik
     * 
     * @param p
     * @return
     */
    double distanceToPoint(MyPoint p) {
        double dist = 0.0; // menyimpan jarak

        // Titik p ada di tengah start dan end
        if (CG.dot(this.start, this.end, p) < 0 && CG.dot(this.end, this.start, p) < 0) {// tengah
            double cross = CG.cross(this.start, this.end, p); // luas pallalelogram
            dist = Math.abs(cross) / this.start.distanceToOtherPoints(this.end); // bagi dengan panjang segment garis
        }
        // Titik p berada di kiri segment (dekat ke start)
        else if (CG.dot(this.start, this.end, p) < 0 && CG.dot(this.end, this.start, p) > 0) { // kiri
            dist = this.start.distanceToOtherPoints(p);
        }
        // Titik p berada di kanan segment (dekat ke end)
        else if (CG.dot(this.start, this.end, p) > 0 && CG.dot(this.end, this.start, p) < 0) { // kanan
            dist = end.distanceToOtherPoints(p);
        }

        return dist;
    }

    /**
     * [3] dari start ke end ke target belok kiri, kanan, atao lurus
     * 
     * @param target
     * @return > 0 jika belok kiri, < 0 jika belok kanan, 0 jika lurus
     */
    double leftTurnToPoint(MyPoint target) {
        double res = 0.0;
        res = CG.ccw(this.start, this.end, target);
        return res; // return 0 jika lurus, plus/minus jika belok kanan/kiri,
    }

    /**
     * [4] motong segmen laen?
     * 
     * @param other
     * @return
     */
    boolean isIntersect(MyLineSegment other) {
        boolean potong = false;

        // Dua segmen memotong jika 2 titik dari segment dengan 1 segment lainnya berada
        // di sisi yang berlawanan / 1 belok kiri dan 1 belok kanan
        if (CG.ccw(this.start, this.end, other.start) * CG.ccw(this.start, this.end, other.end) < 0
                && CG.ccw(other.start, other.end, this.start) * CG.ccw(other.start, other.end, this.end) < 0) {
            potong = true;
        }
        return potong;
    }

}