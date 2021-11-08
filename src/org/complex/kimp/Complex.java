package org.complex.kimp;

/**
 * Describes complex number
 */
public class Complex {
    private double real;
    private double imag;

    private static final double E = 0.001;

    public Complex() {
        real = imag = 0.0;
    }

    public Complex(double real, double imag) {
        this.real = real; this.imag = imag;
    }

    public Complex(Complex c){
        this.real = c.real;
        this.imag = c.imag;
    }

    public double getImaginary() {
        return imag;
    }

    public double getReal() {
        return real;
    }

    public void add(Complex c){
        this.real += c.real;
        this.imag += c.imag;
    }

    public static Complex sum(Complex c1, Complex c2){
        return new Complex(c1.real + c2.real, c1.imag + c2.imag);
    }

    public static Complex sub(Complex c1, Complex c2){
        return new Complex(c1.real - c2.real, c1.imag - c2.imag);
    }

    public static Complex mul(Complex c1, Complex c2){
        double r = c1.real * c2.real - c1.imag * c2.imag;
        double i = c1.imag * c2.real + c2.imag * c1.real;
        return new Complex(r, i);
    }

    public Complex conjugate() {
        return new Complex(this.real, -this.imag);
    }

    public static Complex div(Complex c1, Complex c2){
        double r = c1.real * c2.real + c1.imag * c2.imag;
        r = r / (c2.real * c2.real + c2.imag * c2.imag);
        double i = c1.imag * c2.real - c2.imag * c1.real;
        i = i / (c2.real * c2.real + c2.imag * c2.imag);
        return new Complex(r, i);
    }

    public double abs(){
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Double) {
            return Math.abs((Double)obj - this.real) < E;
        }
        else if (obj instanceof Complex){
            return Math.abs(((Complex)obj).real - this.real) < E && Math.abs(((Complex)obj).imag - this.imag) < E;
        }
        else return false;
    }

    public Complex neg() {
        return new Complex(-this.real, -this.imag);
    }

    public String toString(){
        if (this.real != 0 && this.imag != 0) {
            if(this.imag < 0) return Double.toString(this.real) + Double.toString(this.imag) + "i";
            else return Double.toString(this.real) + "+" + Double.toString(this.imag) + "i";
        }
        else if (this.real == 0) return Double.toString(this.imag) + "i";
        return Double.toString(this.real);
    }

    public static Complex parse(String c){
        double r = 0, i = 0;

        if (!c.contains("i")) r = Double.parseDouble(c);
        else if (!c.contains("+") && !c.contains("-")) i = Double.parseDouble(c.split("i")[0]);
        else {
            String sec = c.contains("+") ? "+" : "-";
            r = Double.parseDouble(c.split(sec)[0]);
            i = Double.parseDouble(c.split(sec)[1].split("i")[0]);
            if (sec.equals("-")) i = -i;
        }

        return new Complex(r, i);
    }

    public double getArgument() {
        if (this.imag == 0) return 0;
        return (Math.atan(this.imag / this.real) + Math.PI) % Math.PI;
    }

    public String eString() {
        String a = Double.toString(this.getArgument());
        return this.abs() + "(cos(" + a + ") + sin(" + a + ")i)";
    }

    public Complex pow(double n) {
        double r = Math.pow(this.abs(), n);
        double arg = this.getArgument() * n;
        return new Complex(r * Math.cos(arg), r * Math.sin(arg));
    }

    public Complex sqrt() {
        return this.pow(0.5);
    }

    public boolean checkReal() {
        return this.imag == 0;
    }

    public boolean checkImaginary() {
        return this.real == 0;
    }
}
