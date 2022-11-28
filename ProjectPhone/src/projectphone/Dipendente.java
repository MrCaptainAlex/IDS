
package projectphone;

/**
 *
 * @author Alessandro
 */
public class Dipendente {
    
    private int idDipendente;
    private String Nome;
    private String Cognome;
    private int numero;
    private int tipologia;  // 0 dipendente semplice, 1 manager, 2 manager broadcast

    public int getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(int idDipendente) {
        this.idDipendente = idDipendente;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return Nome;
    }



    public String getCognome() {
        return Cognome;
    }


    public int getTipologia() {
        return tipologia;
    }

    @Override
    public String toString() {
        return "Dipendente{" + "idDipendente=" + idDipendente + ", Nome=" + Nome + ", Cognome=" + Cognome + ", numero=" + numero + ", tipologia=" + tipologia + '}';
    }

    public Dipendente() {
    }


    public Dipendente(int idDipendente, String Nome, String Cognome, int numero, int tipologia) {
        this.idDipendente = idDipendente;
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.numero = numero;
        this.tipologia = tipologia;
    }

    

    
    
    
    
}
