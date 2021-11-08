package org.complex.kimp;

import java.io.PrintStream;

public class Main {
    private static PrintStream out = new PrintStream(System.out);

    public static void main(String[] args) {
	    Complex a = new Complex();
        out.println(a + "\t" + a.eString());

        a = new Complex(-10, 0);
        out.println(a + "\t" + a.eString());

        a = new Complex(0, -10);
        out.println(a + "\t" + a.eString());

        Complex b = new Complex(a);
        out.println(b + "\t" + b.eString());

        a = new Complex(5, 12);
        b = new Complex(3, 4);
        out.println(a + "\t" + a.eString());
        out.println(b + "\t" + b.eString());

        out.println(Complex.sum(a, b) + "\t" + Complex.sum(a, b).eString());
        out.println(Complex.sub(a, b) + "\t" + Complex.sub(a, b).eString());
        out.println(Complex.div(a, b) + "\t" + Complex.div(a, b).eString());
        out.println(Complex.mul(a, b) + "\t" + Complex.mul(a, b).eString());

        out.println(a.pow(2) + "\t" + a.pow(2).eString());
        out.println(a.sqrt() + "\t" + a.sqrt().eString());
        out.println(b.pow(2) + "\t" + b.pow(2).eString());
        out.println(b.sqrt() + "\t" + b.sqrt().eString());

        Complex [] arr = new Complex[30];
        for (int i = 0; i < 30; i++) {
            arr[i] = new Complex(i, i * 2);
        }
    }
}
