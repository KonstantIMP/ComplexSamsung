package org.complex.kimp;

/**
 * Describes complex number
 */
public class Complex {
    private double real;
    private double imag;

    public Complex() {
        real = imag = 0.0;
    }

    public Complex(double real, double imag){
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
        double i = - c1.imag * c2.real + c2.imag * c1.real;
        i = i / (c2.real * c2.real + c2.imag * c2.imag);
        return new Complex(r, i);
    }

    public double abs(){
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public static boolean equals(Complex c1, Complex c2){
        return c1.real == c2.real && c2.imag == c1.imag;
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
}
