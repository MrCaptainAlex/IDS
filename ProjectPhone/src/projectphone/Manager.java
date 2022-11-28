
package projectphone;


/**
 *
 * @author Alessandro
 */

public class Manager extends Dipendente {

    public Manager(int idDipendente, String Nome, String Cognome, int numero, int tipologia) {
        super(idDipendente, Nome, Cognome, numero, tipologia);
    }

    public Manager() {
    }





    @Override
    public String toString() {
        return "Manager: "+super.getNome()+" "+super.getCognome()+
                "\nNumero di telefono: "+super.getNumero()+"\n";
    }



}
