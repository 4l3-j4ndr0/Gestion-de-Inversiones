/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esperas;

import javax.swing.JProgressBar;

/**
 *
 * @author 4L3
 */
public class cargarGuardado_contrato extends Thread{
    JProgressBar progreso;
    public cargarGuardado_contrato(JProgressBar progreso){
        super();
        this.progreso=progreso;
    }
    @Override
    public void run(){
        for(int i=1;i<=100;i++){
            progreso.setValue(i);
            pausa(30);
        }
    }
    public void pausa(int mlSeg){
        try{
            Thread.sleep(mlSeg);
        }
        catch(Exception e){
            
        }
    }
}
