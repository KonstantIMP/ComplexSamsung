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
}
