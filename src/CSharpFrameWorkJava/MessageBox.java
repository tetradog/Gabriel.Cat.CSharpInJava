/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSharpFrameWorkJava;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class MessageBox {
    public enum MessageBoxIcon
    {
        None,Error,Informacion,Pregunta,Alerta,
    }
    public enum MessageBoxButtons
    {
       Cancel, No,OkCancel,Yes,YesNo,Ok,YesNoCancel
    }
    public enum MessageBoxResult
    {
        None,Yes,No,Ok,Cancel
    }
    
    public static Component DefaultParentComponent=null;
        public static MessageBoxResult ShowDialog(String contenido,MessageBoxButtons buttons,MessageBoxIcon icon)
    {
        return ShowDialog(DefaultParentComponent, "", contenido, buttons, icon);
    }
     
    public static MessageBoxResult ShowDialog(String contenido,MessageBoxButtons buttons)
    {
      return  ShowDialog(DefaultParentComponent, "", contenido, buttons);
    }
    public static void ShowDialog(String contenido,MessageBoxIcon ico)
    {
        ShowDialog(DefaultParentComponent, "", contenido, ico);
    }
    public static void ShowDialog(String contenido)
    {
        ShowDialog(DefaultParentComponent, "", contenido);
    }
    public static void ShowDialog(String titulo,String contenido)
    {
        ShowDialog(DefaultParentComponent, titulo, contenido, MessageBoxIcon.None);
    }
    public static void ShowDialog(String titulo,String contenido,MessageBoxIcon ico)
    {
        ShowDialog(DefaultParentComponent, titulo, contenido,MessageBoxButtons.Ok, ico);
    }
    public static MessageBoxResult ShowDialog(String titulo,String contenido,MessageBoxButtons buttons)
    {
        return ShowDialog(DefaultParentComponent, titulo, contenido, buttons, MessageBoxIcon.None);
    }
    public static MessageBoxResult ShowDialog(String titulo,String contenido,MessageBoxButtons buttons,MessageBoxIcon ico)
    {
        return ShowDialog(DefaultParentComponent, titulo, contenido, buttons, ico);
    }
    public static MessageBoxResult ShowDialog(Component parentComponent,String contenido,MessageBoxButtons buttons,MessageBoxIcon icon)
    {
        return ShowDialog(parentComponent, "", contenido, buttons, icon);
    }
    public static MessageBoxResult ShowDialog(Component parentComponent,String contenido,MessageBoxButtons buttons)
    {
      return  ShowDialog(parentComponent, "", contenido, buttons);
    }
    public static void ShowDialog(Component parentComponent,String contenido,MessageBoxIcon ico)
    {
        ShowDialog(parentComponent, "", contenido, ico);
    }
    public static void ShowDialog(Component parentComponent,String contenido)
    {
        ShowDialog(parentComponent, "", contenido);
    }
    public static void ShowDialog(Component parentComponent,String titulo,String contenido)
    {
        ShowDialog(parentComponent, titulo, contenido, MessageBoxIcon.None);
    }
    public static void ShowDialog(Component parentComponent,String titulo,String contenido,MessageBoxIcon ico)
    {
        ShowDialog(parentComponent, titulo, contenido,MessageBoxButtons.Ok, ico);
    }
    public static MessageBoxResult ShowDialog(Component parentComponent,String titulo,String contenido,MessageBoxButtons buttons)
    {
        return ShowDialog(parentComponent, titulo, contenido, buttons, MessageBoxIcon.None);
    }
    public static MessageBoxResult ShowDialog(Component parentComponent,String titulo,String contenido,MessageBoxButtons buttons,MessageBoxIcon ico)
    {
       
        int icoMsg=0;
        int btns=0;
        int resultadoInt;
        MessageBoxResult resultado;
        switch(ico)
        {
            case None:
                icoMsg=JOptionPane.PLAIN_MESSAGE;
                break;
            case Error:
                icoMsg=JOptionPane.ERROR_MESSAGE;
                break;
            case Informacion:
                icoMsg=JOptionPane.INFORMATION_MESSAGE;
                break;
            case Pregunta:
                icoMsg=JOptionPane.QUESTION_MESSAGE;
                break;
            case Alerta:
                icoMsg=JOptionPane.WARNING_MESSAGE;
                break;
            default:
                throw new AssertionError(ico.name());
        
        }
        switch(buttons)
        {
            case Cancel:
                btns=JOptionPane.CANCEL_OPTION;
                break;
            case No:
                btns=JOptionPane.NO_OPTION;
                break;
            case OkCancel:
                btns=JOptionPane.OK_CANCEL_OPTION;
                break;
            case Yes:
                btns=JOptionPane.YES_OPTION;
                break;
            case YesNo:
                btns=JOptionPane.YES_NO_OPTION;
                break;
            case Ok:
                btns=JOptionPane.OK_OPTION;
                break;
            case YesNoCancel:
                btns=JOptionPane.YES_NO_CANCEL_OPTION;
                break;
            default:
                throw new AssertionError(buttons.name());
        }
        resultadoInt=javax.swing.JOptionPane.showConfirmDialog(parentComponent, contenido, titulo,btns,icoMsg );
        switch(resultadoInt)
        {
            case JOptionPane.CANCEL_OPTION:resultado=MessageBoxResult.Cancel;break;
            case JOptionPane.YES_OPTION:
                if(buttons!=MessageBoxButtons.Ok&&buttons!=MessageBoxButtons.OkCancel)
                   resultado=MessageBoxResult.Yes;
                else resultado=MessageBoxResult.Ok;
                break;
            case JOptionPane.NO_OPTION:resultado=MessageBoxResult.No;break;
            default:
               resultado=MessageBoxResult.None;break;
        }
        return resultado;
    }
}
