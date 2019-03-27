/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circolariscuola;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Raoul Palummo
 */
class Parser {
    
    private List corsi,consigli,albo;

    public Parser() {
        albo = new ArrayList();
    }

    public List parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Docente p;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        
        nodelist = root.getElementsByTagName("tr");
        int count=0;
        if (nodelist != null && nodelist.getLength() > 0) {
            
            boolean trovato=false;
            
            while(!trovato){
                if(nodelist.item(count).getFirstChild().getTextContent().contains("DOCENTE"))
                    trovato=true;
                count++;
            }
            for (int i = count; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                p = getProf(element);
                System.out.println(p.toString());
                if (p != null) 
                    albo.add(p);               
            }
        }
        return albo;
    }
    
    

    private Docente getProf(Element el) {
        Docente p = null;

        // cerco il primo elemento nel primo tr
        //Element elementParent = (Element) el.getParentNode();
        ArrayList a=new ArrayList();
        for(int i=0;i<el.getChildNodes().getLength();i++){
            String bambino = el.getChildNodes().item(i).getTextContent(); //getTextValue(elementParent, "td", 0);
            if(!bambino.equals(""))
                a.add(bambino);
        }
        String ID=(String)a.get(0);
        String nome=(String)a.get(1);  
        String giorno="";
        String ora ="";
        //creo l'oggetto del prof 
        if(a.size()>2)
            giorno=(String)a.get(2);
        else if(a.size()>3)
            ora= (String)a.get(3);
        
        p = new Docente(ID,nome,giorno,ora);
        return p;
    }
    
    

    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element, String tag, int child) {
        String value = null;
        NodeList nodelist;
        nodelist = element.getElementsByTagName(tag);
        if (nodelist != null && nodelist.getLength() > child) {
            Node nodeChild = nodelist.item(child).getFirstChild();
            if ((nodeChild != null) && nodeChild.hasChildNodes()) {
                value = nodeChild.getFirstChild().getNodeValue();
            }
        }
        return value;
    }
    
}
