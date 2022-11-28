
package projectphone;

/**
 *
 * @author Alessandro
 */
public class StandardPhone extends ProjectPhone{
    Integer idRubrica;

    public StandardPhone(Integer idRubrica, int idDipendente, int codiceSegreto, int tipologia) {
        super(idDipendente, codiceSegreto, tipologia);
        this.idRubrica = idRubrica;
    }

    public Integer getIdRubrica() {
        return idRubrica;
    }

    public void setIdRubrica(Integer idRubrica) {
        this.idRubrica = idRubrica;
    }
    
}
