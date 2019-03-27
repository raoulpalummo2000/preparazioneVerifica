/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circolariscuola;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Raoul Palummo
 */
public class ValidateXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List albo = null;
        Parser dom = new Parser();
        try {
            albo = dom.parseDocument("ricevimento.xml");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ValidateXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ValidateXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidateXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        // iterazione della lista e visualizzazione degli oggetti
        System.out.println("Numero dei docenti: " + albo.size());
        Iterator iterator = albo.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
    
     private static void scriviFile(List corsi){
        try {
            
            File file = new File("corsi.txt");
            Writer writer = new FileWriter(file.getPath());
            String s="";
            
            for(int i=0;i<corsi.size();i++)
                s+=corsi.get(i).toString()+"\n";
                
            writer.write(s);
            writer.close();
            
        }
             catch (IOException ex) {
                ex.printStackTrace();
            }
    }
    
}
