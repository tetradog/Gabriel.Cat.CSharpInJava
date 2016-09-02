/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSharpFrameWorkJava;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pingu
 */
public class StreamReader {

    BufferedReader buffer;
    String ultimaLinea = null;
    DataInputStream entrada;
    File fitxer;
    String nomFile;
    boolean acabat = false;

    public StreamReader(String path) throws FileNotFoundException {
        fitxer = new File(path);
        nomFile = fitxer.getPath();
        acabat = false;
        if (fitxer.exists()) {
            FileInputStream fStream = null;

            fStream = new FileInputStream(path);
            entrada = new DataInputStream(fStream);
            buffer = new BufferedReader(new InputStreamReader(entrada));
            try {
                ultimaLinea = buffer.readLine();
            } catch (IOException e) {
                ultimaLinea = null;
                acabat = true;
            }
        }

    }

    public boolean getExisteix() {
        return fitxer.exists();
    }

    public boolean EndOfStream() {
        return ultimaLinea == null;
    }

    public String getNameFile() {
        return nomFile;
    }

    public void Delete() {
        fitxer.delete();
    }

    public String ReadLine() throws IOException {
        String lineaVella = ultimaLinea;
        if (!acabat) {
            ultimaLinea = buffer.readLine();
            if (ultimaLinea == null) {
                entrada.close();
                acabat = true;
            }

        }
        return lineaVella;

    }

}
