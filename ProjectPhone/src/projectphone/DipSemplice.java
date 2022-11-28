
package projectphone;

import java.util.HashMap;

/**
 *
 * @author Alessandro
 */
public class DipSemplice extends Dipendente {
    private HashMap<Integer,Integer> elencoProgettiAssegnati;
    private int oreDisponibili;
    private float costoAdOra;

    public HashMap<Integer, Integer> getElencoProgettiAssegnati() {
        return elencoProgettiAssegnati;
    }

    public void setElencoProgettiAssegnati(Integer idProgetto, Integer orePerProgetto) {
        this.elencoProgettiAssegnati.put(idProgetto, orePerProgetto);
    }
    
    public void setElencoProgettiAssegnati(Integer idProgetto) {
        this.elencoProgettiAssegnati.remove(idProgetto);
    }

    public int getOreDisponibili() {
        return oreDisponibili;
    }

    public void setOreDisponibili(int oreDisponibili) {
        this.oreDisponibili = oreDisponibili;
    }

    public float getCostoAdOra() {
        return costoAdOra;
    }

    public void setCostoAdOra(float costoAdOra) {
        this.costoAdOra = costoAdOra;
    }

    public DipSemplice(int idDipendente, String Nome, String Cognome, int numero, int tipologia,int oreDisponibili, float costoAdOra) {
        super(idDipendente, Nome, Cognome, numero, tipologia);
        this.oreDisponibili = oreDisponibili;
        this.costoAdOra = costoAdOra;
        this.elencoProgettiAssegnati = new HashMap<Integer, Integer>(); 
    }

    public DipSemplice() {
    }

    @Override
    public String toString() {
        return "Dipendente: "+super.getNome()+" "+super.getCognome()+
                "\nNumero di telefono: "+super.getNumero()+
                "\nOre disponibili: "+oreDisponibili+
                "\nCosto ad ora: "+costoAdOra+"€\n";
    }




       
}
