public class Rational {
    private int nominator;
    private int denominator;

    public Rational(int nominator, int denominator) {
        if (isMinus(nominator, denominator)) {
            this.nominator = Math.abs(nominator / gcd(nominator, denominator)) * -1;
            this.denominator = Math.abs(denominator / gcd(nominator, denominator));
        } else {
            this.nominator = Math.abs(nominator / gcd(nominator, denominator));
            this.denominator = Math.abs(denominator / gcd(nominator, denominator));
        }
    }

    public int getNominator() {
        return this.nominator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public boolean isMinus(int nominator, int denominator) {
        if (nominator < 0 ^ denominator < 0) {
            return true;
        }
        return false;
    }

    public Rational add(Rational r1, Rational r2) {
        return new Rational(r1.getNominator() * r2.getDenominator() + r1.getDenominator() * r2.getNominator(), r1.getDenominator() * r2.getDenominator());
    }
    
    public Rational add(Rational other) {
        return new Rational(this.getNominator() * other.getDenominator() + this.getDenominator() * other.getNominator(), this.getDenominator() * other.getDenominator());
    }

    public Rational add(int i) {
        return new Rational(i * this.getDenominator() + this.getNominator(), this.getDenominator());
    }
    
    public Rational substract(Rational r1, Rational r2) {
        return new Rational(r1.getNominator() * r2.getDenominator() - r1.getDenominator() * r2.getNominator(), r1.getDenominator() * r2.getDenominator());
    }
    
    public Rational substract(Rational other) {
        return new Rational(this.getNominator() * other.getDenominator() - this.getDenominator() * other.getNominator(), this.getDenominator() * other.getDenominator());
    }

    public Rational substract(int i) {
        return new Rational(this.nominator - this.getDenominator() * i, this.getDenominator());
    }

    public Rational multiply(Rational r1, Rational r2) {
        return new Rational(r1.getNominator() * r2.getNominator(), r1.getDenominator() * r2.getDenominator());
    }

    public Rational multiply(Rational other) {
        return new Rational(this.getNominator() * other.getNominator(), this.getDenominator() * other.getDenominator());
    }

    public Rational multiply(int i) {
        return new Rational(this.getNominator() * i, this.getDenominator());
    }

    public Rational divide(Rational r1, Rational r2) {
        return new Rational(r1.getNominator() * r2.getDenominator(), r1.getDenominator() * r2.getNominator());
    }
    
    public Rational divide(Rational other) {
        return new Rational(this.getNominator() * other.getDenominator(), this.getDenominator() * other.getNominator());
    }

    public Rational divide(int i) {
        return new Rational(this.getNominator(), this.getDenominator() * i);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static void test() {
        Rational r1 = new Rational(5, 8);
        Rational r2 = new Rational(7, 16);
        System.out.printf("%s + %s = %s\n", r1, r2, r1.add(r2));
        System.out.printf("%s - %s = %s\n", r1, r2, r1.substract(r2));
        System.out.printf("%s * %s = %s\n",r1, r2, r1.multiply(r2));
        System.out.printf("%s / %s = %s\n",r1, r2, r1.divide(r2));
    }

    public static void test2() {
        Rational r1 = new Rational(5, -8);
        int i = 5;
        System.out.printf("%s + %d = %s\n", r1, i, r1.add(i));
        System.out.printf("%s - %d = %s\n", r1, i, r1.substract(i));
        System.out.printf("%s * %d = %s\n",r1, i, r1.multiply(i));
        System.out.printf("%s / %d = %s\n",r1, i, r1.divide(i));
    }

    @Override
    public String toString() {
        return this.getNominator() + "/" + this.getDenominator();
    }
}

class Test {
    public static void main(String[] args) {
        Rational.test2();
    }
}
