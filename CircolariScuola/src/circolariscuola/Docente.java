/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circolariscuola;

/**
 *
 * @author palummo_raoul
 */
public class Docente {
   private String ID;
    private String nome;
    private String giorno;
    private String ora;

    public Docente() {
        
    }

    public Docente(String ID, String nome, String giorno, String ora) {
        this.ID = ID;
        this.nome = nome;
        this.giorno = giorno;
        this.ora = ora;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }
    
    public String toString()
    {
        String s = ID+";"+nome+";"+giorno+";"+ora;
        return s;
    }
    
    
}
