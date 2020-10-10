/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Manjarrez
 */

import java.io.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Gestion {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    
    public Gestion(){
        
    }
    
    /*Abrir un archivo de texto*/
    public String abrirTexto(File archivo){
        String contenido="";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!= -1){
                char carcater = (char)ascci;
                contenido += carcater;
            }
        } catch (Exception e) {
            showMessageDialog(null, "No se pudo abrir el archivo de texto" + e);
        }
        return contenido;
    }
    
    /*Guardar archivo de texto*/
    public String guardarTexto(File archivo, String contenido){
        String respuesta=null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Se guardo con exito el archivo";
        } catch (Exception e) {
            showMessageDialog(null, "No se pudo guardar el archivo de texto" + e);
        }
        return respuesta;
    }
    
    /*Abrir una imagen*/
    public byte[] abrirImagen(File archivo){
        byte[] bytesImg = new byte[16384*100];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(bytesImg);
        } catch (Exception e) {
            showMessageDialog(null, "No se pudo abrir la imagen" + e);
        }
        return bytesImg;
    }
    
       
    /*Guardar imagen*/
    public String guardarImagen(File archivo, byte[] bytesImg){
        String respuesta=null;
        try {
            salida = new FileOutputStream(archivo);
            salida.write(bytesImg);
            respuesta = "La imagen se guardo con exito.";
        } catch (Exception e) {
            showMessageDialog(null, "No se pudo guardar la imagen" + e);
        }//catch
        return respuesta;
    }//guardarImagen
    
}//Gestion class.