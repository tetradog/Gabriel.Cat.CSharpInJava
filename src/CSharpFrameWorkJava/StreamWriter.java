/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSharpFrameWorkJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Pingu
 */
public class StreamWriter {

    PrintWriter fitxer;
    Stack<String> txt = null;

    public StreamWriter(String pathArxiu) throws IOException {
        fitxer = crearArchivo(pathArxiu);
        txt = new Stack<String>();

    }

    public void Write(String line) {
        txt.Push(line);

    }

    public void WriteLine(String line) {
        txt.Push(line);
        txt.Push("\n\r");
    }

    public void Close() {
        String text = "";
        String linea = "";
        while (linea != null) {
            text += linea;
            linea = txt.ToString();
        }
        fitxer.append(text);
        fitxer.close();
    }

    private PrintWriter crearArchivo(String path) throws IOException {
        //Las siguientes 3 líneas nos permite crear un archivo y escribir en el
        File archivo = new File(path);
        FileWriter writer = new FileWriter(archivo);
        PrintWriter salida = new PrintWriter(writer);
        return salida;
    }

    public static void InsertaText(String fitxer, String text, int linea) throws FileNotFoundException, IOException {
        StreamReader sr = new StreamReader(fitxer);
        File fs = new File("fitxer.temp");
        fs.createNewFile();
        StreamWriter sw = new StreamWriter("fitxer.temp");

        for (int i = 0; i < linea && !sr.EndOfStream(); i++) {
            sw.WriteLine(sr.ReadLine());
        }
        sw.WriteLine(text);
        while (!sr.EndOfStream()) {
            sw.WriteLine(sr.ReadLine());
        }
        sw.Close();
        (new File(fitxer)).delete();
        fs.renameTo(new File(fitxer));
    }

    public static void InsertaText(String fitxer, String text, boolean alPrincipi) throws FileNotFoundException, IOException {
        StreamReader sr = new StreamReader(fitxer);
        File fs = new File("fitxer.temp");
        fs.createNewFile();
        StreamWriter sw = new StreamWriter("fitxer.temp");

        if (alPrincipi) {
            sw.WriteLine(text);
        }
        while (!sr.EndOfStream()) {
            sw.WriteLine(sr.ReadLine());
        }
        if (!alPrincipi) {
            sw.WriteLine(text);
        }
        sw.Close();
        (new File(fitxer)).delete();
        fs.renameTo(new File(fitxer));
    }
}
