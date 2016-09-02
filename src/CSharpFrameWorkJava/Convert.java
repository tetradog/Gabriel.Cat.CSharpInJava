/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSharpFrameWorkJava;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

/**
 *
 * @author Gabu
 */
public class Convert {

    public static int ToInt32(String numero) {
        return Integer.parseInt(numero);
    }

    public static double ToDouble(String numero) {
        return Double.parseDouble(numero);
    }

    public static double OperaString(String operacio) {
        double resultat = 0;

        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            resultat = (double) (engine.eval(operacio));
        } catch (Exception e) {
        }
        return resultat;
    }

    public static char ToChar(int numC) {
        return (char) numC;
    }

}
