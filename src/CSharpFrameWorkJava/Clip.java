package CSharpFrameWorkJava;

import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.io.IOException;
//sacado de https://suarezdeveloper.wordpress.com/2012/04/05/como-leerescribir-en-el-portapapeles-clipboard-con-java/#comment-1750

public class Clip implements ClipboardOwner {

    static Clip clip = new Clip();

    // M�todo que recupera una cadena del portapapeles.
    public String getClipboard() {
        // Obtenemos el contenido del portapapeles del sistema.
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        try {
            // Comprobamos que la informaci�n sea de tipo cadena, lo recuperamos y lo devolvemos.
            if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String text = (String) t.getTransferData(DataFlavor.stringFlavor);
                return text;
            }
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Si lo copiado no es un texto, devolvemos null
        return null;
    }

    // M�todo que inserta en el portapapeles una cadena.
    public void setClipboard(String str) {
        StringSelection ss = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, this);
    }

    // Necesario para poder implementar la interfaz ClipboardOwner. Para nosotros no tendr� uso, pero es obligatorio "implementarlo".
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        // TODO Auto-generated method stub
    }

    public static String GetClip() {
        return clip.getClipboard();
    }

    public static void SetClip(String str) {
        clip.setClipboard(str);
    }
}
