/*
 * ScrollTextPanel.java
 *
 * Created on 29 de diciembre de 2004, 02:05 AM
 */

package common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JPanel;

/**
 *
 * @author  Mauricio Gracia Guti�rrez
 */
public class ScrollTextPanel 
extends JPanel 
implements LicenseString
{
    Font fontLog = new Font("Arial",Font.PLAIN,12) ;
    /** Creates new panel that scroll text */

    public String getLicenseString() {
    	return "This file is covered by the GNU GENERAL PUBLIC LICENSE, Version 2, June 1991";
    }
    public ScrollTextPanel() {
        super() ;
        initComponents();
        
    }
    public void setFont(java.awt.Font f) {
        if(f != null) {
            if(this.jTextArea1 != null) {
                this.jTextArea1.setFont(f) ;
            }
        }
    }
    public void setDisabledColor() {
        //this codes set the background to the "WINDOWS DISABLED GRAY"
        
        //this line below not always work, on MAC (BLACKBOX) this becomes BLACK
        //background with BLACK text !!
        //jTextArea1.setBackground(java.awt.SystemColor.inactiveCaptionText);

        jTextArea1.setBackground(new Color(168,152,144)) ;
    }
    public void setEditable(boolean b) {
        this.jTextArea1.setEditable(b) ;
    }
    public void setText(String str) {
        this.jTextArea1.setText(str) ;
    }
    public void append(String str) {
        this.jTextArea1.append(str) ;
    }
    public boolean displayFile(String str) {
        FileReader FR ;
        BufferedReader BR ;
        String line ;
        boolean success ;
        
        success = true ;
        this.setEditable(false) ;
        
        if(str != null) {
            try {
                FR = new FileReader(str) ;
                BR = new BufferedReader(FR) ;
                do {
                    line = BR.readLine() ;
                    if(line != null) {
                        this.append(line + "\n") ;
                    }
                } while (line != null) ;
            } catch (Exception e) {
                success = false ;
                e.printStackTrace() ;
            }
        }
        //TODO call scrollRectToVisible(Rectangle) to set the file at the begining.
        javax.swing.JViewport JV = this.jScrollPane1.getViewport() ;
        JV.scrollRectToVisible(new Rectangle(0,0,10,10)) ;
        
/* DIFFERENT ATTEMPTS TO SCROLL THE BAR TO THE TOP
  this.jScrollPane1.setViewportView(this.jTextArea1) ;
 
        javax.swing.JViewport JV = this.jScrollPane1.getViewport() ;
        javax.swing.JScrollBar JSB = this.jScrollPane1.getVerticalScrollBar() ;
         JSB.setMinimum(0) ;
        JSB.setMaximum(contLines) ;
        
        JSB.setValue(0) ;
       JV.setViewPosition(new java.awt.Point(-1000,-5000)) ;
       this.jScrollPane1.setViewport(JV) ;
 
        this.jScrollPane1.validate() ;
 */
        return success ;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(200, 200));
        jScrollPane1.setAutoscrolls(true);
        jTextArea1.setFont(fontLog);
        jTextArea1.setTabSize(4);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
}