
package projectphone;

import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class ManagerPhone extends ProjectPhone {
    ArrayList<Integer> listaProgetti = new ArrayList<>();

    public ArrayList<Integer> getListaProgetti() {
        return listaProgetti;
    }



    public ManagerPhone(int idDipendente, int codiceSegreto, int tipologia) {
        super(idDipendente, codiceSegreto, tipologia);
    }


    public void setListaProgetti(Integer idProgetto) {
        listaProgetti.add(idProgetto);
    }
    
    public void setListaProgetti(Integer idProgetto, Integer remove) {
        listaProgetti.remove(idProgetto);
    }



    



    
    
}
