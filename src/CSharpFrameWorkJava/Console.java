/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSharpFrameWorkJava;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabu
 */
public class Console {

    public static final String BLACK = "\033[30m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String WHITE = "\033[37m";

    public static void WriteLine(String text) {
        System.out.println(text);
        PosarColorPerDefecte();
    }

    private static void PosarColorPerDefecte() {
        System.out.print(BLACK);
    }

    public static void Write(String text) {
        System.out.print(text);
        PosarColorPerDefecte();
    }

    public static String ReadLine() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public static void WriteLine(Object obj) {
        WriteLine(obj.toString());
    }

    public static void Write(Object obj) {
        Write(obj.toString());
    }

    public static void WriteLine(FileReader fitxerTXT) throws IOException {

        int c = 0;
        while (c != -1) {
            c = fitxerTXT.read();
            if (c != -1) {
                Console.Write(Convert.ToChar(c));
            }
        }

    }

    public static void Clear() {
        for (int i = 0; i < 50; i++) {
            Console.WriteLine("");
        }

    }

    public static void ReadKey() {
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
