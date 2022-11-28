
package projectphone;

import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class Rubrica {
    Integer idRubrica;
    ArrayList<Integer> listaDipendenti = new ArrayList<>();

    public Integer getIdRubrica() {
        return idRubrica;
    }

    public void setIdRubrica(Integer idRubrica) {
        this.idRubrica = idRubrica;
    }

    public ArrayList<Integer> getListaDipendenti() {
        return listaDipendenti;
    }

    public void setListaDipendenti(Integer idDipendente) {
        listaDipendenti.add(idDipendente);
    }
    
    public void setListaDipendenti(Integer idDipendente,Integer remove) {
        listaDipendenti.remove(idDipendente);
    }

    public Rubrica(Integer idRubrica) {
        this.idRubrica = idRubrica;
    }
    
    
}
