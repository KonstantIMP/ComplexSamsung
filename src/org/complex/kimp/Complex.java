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

    public double getImag() {
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
}
