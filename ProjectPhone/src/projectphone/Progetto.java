
package projectphone;

/**
 *
 * @author Alessandro
 */
public class Progetto {
    private int idProgetto;
    private int budget;
    private int numDipendenti;
    private int deadlineInOre;
    private int oreDiLavoro;
    private float costoTotale;
    private String nomeProgetto;

    public int getIdProgetto() {
        return idProgetto;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getDeadlineInOre() {
        return deadlineInOre;
    }

    public void setDeadlineInOre(int deadlineInOre) {
        this.deadlineInOre = deadlineInOre;
    }

    public void setIdProgetto(int idProgetto) {
        this.idProgetto = idProgetto;
    }

    public float getCostoTotale() {
        return costoTotale;
    }

    public void setCostoTotale(float costoTotale) {
        this.costoTotale = costoTotale;
    }



    public int getNumDipendenti() {
        return numDipendenti;
    }

    public void setNumDipendenti(int numDipendenti) {
        this.numDipendenti = numDipendenti;
    }

    public int getOreDiLavoro() {
        return oreDiLavoro;
    }

    public void setOreDiLavoro(int oreDiLavoro) {
        this.oreDiLavoro = oreDiLavoro;
    }

    public String getNomeProgetto() {
        return nomeProgetto;
    }

    public void setNomeProgetto(String nomeProgetto) {
        this.nomeProgetto = nomeProgetto;
    }

    public Progetto(int idProgetto, int budget, int numDipendenti, int deadlineInOre, int costoTotale, String nomeProgetto) {
        this.idProgetto = idProgetto;
        this.budget = budget;
        this.numDipendenti = numDipendenti;
        this.deadlineInOre = deadlineInOre;
        this.costoTotale = costoTotale;
        this.nomeProgetto = nomeProgetto;
    }

    @Override
    public String toString() {
        return "\nNome del progetto: " + nomeProgetto + "\n"
             + "Budget del progetto: " + budget + "\n"
             + "Numero di dipendenti del progetto: " + numDipendenti + "\n"
             + "Deadline in ore del progetto: " + deadlineInOre + "\n"
             + "Costo totale del progetto: " + costoTotale + "\n";
    }




    
    

}
