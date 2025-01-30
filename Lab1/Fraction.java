public class Fraction {
    private int numer;
    private int demon;

    public Fraction() {
        numer = 0;
        demon = 1;
    }

    public Fraction(int x, int y) {
        numer = x;
        demon = y;
    }

    public Fraction(Fraction f) {
        this.numer = f.numer;
        this.demon = f.demon;
    }

    public String toString() {
        return numer + "/" + demon;
    }

    public boolean equals(Object f) {
        if (f instanceof Fraction) {
            Fraction tmp = (Fraction) f;
            if (tmp.numer * demon == tmp.demon * numer)
                return true;
            return false;
        }
        return false;
    }
}
