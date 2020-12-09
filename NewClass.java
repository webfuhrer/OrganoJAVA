/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.organo_java;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author FPMananaA
 */
public class NewClass {
    public static void main(String[] args) {
        try{
        AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
            SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
             sdl.open();
            sdl.start();
        byte[] nota_LA=fabricarNota(440, 100);
        byte[] nota_DO=fabricarNota(261.63f, 100);
        
//261.63
            sdl.write( nota_LA, 0, nota_LA.length );
            sdl.write( nota_DO, 0, nota_DO.length );
            
            sdl.drain();
            sdl.stop();
        }
        catch(Exception e)
        {
            
        }
            
    }
        
        public static  byte[] fabricarNota(float freq, int tiempo)
        {
            byte[] nota=new byte[44100*tiempo/1000];
            try{
            byte[] buf = new byte[ 1 ];
            
           for( int i = 0; i < tiempo * (float )44100 / 1000; i++ ) {
                double angle = i / ( (float )44100 / freq ) * 2.0 * Math.PI;
                nota[i]= (byte )( Math.sin( angle ) * 100 );
               // buf[ 0 ] = (byte )( Math.sin( angle ) * 100 );
                
            }
           
        } catch (Exception ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
            return nota;
       }
}
