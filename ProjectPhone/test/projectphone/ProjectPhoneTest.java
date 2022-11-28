
package projectphone;

import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

/**
 *
 * @author Alessandro
 */
@DisplayName("TEST PROJECTPHONE")
public class ProjectPhoneTest {

    public ProjectPhoneTest() {
    }
    
    

    ProjectPhone projectPhone= new ProjectPhone();
    
    
    @Test
    @DisplayName("Test Costruttore ProjectPhone")
    public void testProjectPhone() {		
    	assertNotNull(projectPhone); 
    }

    @Test
    @DisplayName("Test controlla numero")
    public void testControllaNumero() throws ParseException {
        projectPhone.Initialize();
    	boolean actual = projectPhone.controllaNumero(1111);
        assertTrue(actual);
        
    }    

    // L'errore che potrebbe esistere è la non esistenza di un id che in un caso di telefono reale non può accadere
    @Test
    @DisplayName("Test accesso al telefono")
    public void testAccessoAlTelefono() throws ParseException {
        projectPhone.Initialize();
    	boolean actual = projectPhone.AccessoAlTelefono(111,1605,"b");
        assertTrue(actual);
        
    }    
    
    @Test
    @DisplayName("Crea un progetto")
    public void creaProgetto() throws ParseException {
        projectPhone.Initialize();
    	projectPhone.creaProgetto("IDS",1000,23,111);
        assertNotEquals(projectPhone.mappaProgetti.size(),0);
        
    }   
    
    @Test
    @DisplayName("Aggiornamento lista progetti manager")
    public void aggiornaListaProgettiManager() throws ParseException {
        projectPhone.Initialize();
    	projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.creaProgetto("IDS2",2000,30,111);
        assertEquals(projectPhone.mappaManagerPhone.get(111).getListaProgetti().size(),2);
        
    }   
    
    @Test
    @DisplayName("Elimina progetto esistente")
    public void eliminaProgetto() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",2000,30,111);
    	projectPhone.eliminaProgetto("IDS",111);
        assertEquals(projectPhone.mappaProgetti.size(),0);
        
    }   
    
    @Test
    @DisplayName("Aggiornamento lista progetti assegnati dopo rimozione progetto")
    public void aggiornaListaProgettiManagerDopoRimozione() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",2000,30,111);
    	projectPhone.eliminaProgetto("IDS",111);
        assertEquals(projectPhone.mappaManagerPhone.get(111).getListaProgetti().size(),0);
        
    }  
    
    
    @Test
    @DisplayName("Elimina progetto non esistente")
    public void eliminaProgettoNonEsistente() throws ParseException {
        projectPhone.Initialize();
    	projectPhone.eliminaProgetto("IDS",111);
        assertEquals(projectPhone.mappaProgetti.size(),0);
        
    } 
    
    @Test
    @DisplayName("Aggiornamento ore disponibili dipendente dopo rimozione progetto già assegnato")
    public void aggiornaOreDisponibiliDipendenteDopoRimozione() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","a");
    	projectPhone.aggiornaDipendenti();
    	projectPhone.eliminaProgetto("IDS",111);
        assertEquals(projectPhone.mappaDipendentiSemplici.get(13).getOreDisponibili(),19);
        
    }  
    
    
    @Test
    @DisplayName("Aggiornamento ore disponibili dipendente dopo assegnazione progetto basato su costo")
    public void aggiornaOreDisponibiliDipendenteDopoAssegnazioneEconomica() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","a");
    	projectPhone.aggiornaDipendenti();
        assertEquals(projectPhone.mappaDipendentiSemplici.get(13).getOreDisponibili(),0);
        
    }  
    
    @Test
    @DisplayName("Aggiorna elenco progetti assegnati di un dipendente per assegnazione basata su costo")
    public void aggiornaElencoProgettiAssegnatiDipendentiEconomica() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","a");
    	projectPhone.aggiornaDipendenti();
        assertEquals(projectPhone.mappaDipendentiSemplici.get(13).getElencoProgettiAssegnati().size(),1);
        
    } 
    
    
    @Test
    @DisplayName("Aggiornamento numero dipendenti assegnati ad un progetto per assegnazione basata su costo")
    public void aggiornaNumDipendentiProgettoEconomica() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","a");
    	projectPhone.aggiornaProgetto();
        assertEquals(projectPhone.mappaProgetti.get(1).getNumDipendenti(),2);
        
    } 
    
    
    @Test
    @DisplayName("Aggiornamento del costo totale effettivo di un progetto dopo l'assegnazione basato su costo")
    public void aggiornaCostoTotaleProgettoEconomica() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","a");
    	projectPhone.aggiornaProgetto();
        assertEquals(projectPhone.mappaProgetti.get(1).getCostoTotale(),117.0);
        
    } 
    

    
    
    @Test
    @DisplayName("Aggiornamento ore disponibili dipendente dopo assegnazione progetto basata su distribuzione oraria")
    public void aggiornaOreDisponibiliDipendenteDopoAssegnazioneOraria() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","b");
    	projectPhone.aggiornaDipendenti();
        assertEquals(projectPhone.mappaDipendentiSemplici.get(7).getOreDisponibili(),33);
        
    }  
    
    @Test
    @DisplayName("Aggiorna elenco progetti assegnati di un dipendente per assegnazione basata su distribuzione oraria")
    public void aggiornaElencoProgettiAssegnatiDipendentiOraria() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","b");
    	projectPhone.aggiornaDipendenti();
        assertEquals(projectPhone.mappaDipendentiSemplici.get(7).getElencoProgettiAssegnati().size(),1);
        
    } 
    
    
    @Test
    @DisplayName("Aggiornamento numero dipendenti assegnati ad un progetto per assegnazione basata su distribuzione oraria")
    public void aggiornaNumDipendentiProgettoOraria() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","b");
    	projectPhone.aggiornaProgetto();
        assertEquals(projectPhone.mappaProgetti.get(1).getNumDipendenti(),3);
        
    } 
    
    
    @Test
    @DisplayName("Aggiornamento del costo totale effettivo di un progetto dopo l'assegnazione basata su distribuzione oraria")
    public void aggiornaCostoTotaleProgettoOraria() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","b");
    	projectPhone.aggiornaProgetto();
        assertEquals(projectPhone.mappaProgetti.get(1).getCostoTotale(),319.0);
        
    }
    
    
    @Test
    @DisplayName("Costo totale progetti manager")
    public void controllaCostoTotaleProgettiManager() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",1000,23,111);
        projectPhone.cercaDipendenti("IDS","b");
        projectPhone.aggiornaProgetto();
        projectPhone.creaProgetto("IDS2",2000,45,111);
        projectPhone.cercaDipendenti("IDS2","a");
    	projectPhone.aggiornaProgetto();
        Float costoTotale = projectPhone.mostraCostoProgettiManager(111);
        assertEquals(costoTotale,559.0f);
        
    }
    
    
    @Test
    @DisplayName("Salario dipendente")
    public void controlloSalarioDipendente() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",5000,90,111);
        projectPhone.cercaDipendenti("IDS","b");
        projectPhone.aggiornaDipendenti();
        projectPhone.aggiornaProgetto();
        projectPhone.creaProgetto("IDS2",4000,65,111);
        projectPhone.cercaDipendenti("IDS2","a");
    	projectPhone.aggiornaDipendenti();
        projectPhone.aggiornaProgetto();
        Float costoTotale = projectPhone.visualizzaSalarioDipendente(2222);
        assertEquals(costoTotale,500.0f);
        
    }
    
    @Test
    @DisplayName("Salario dipendente con 3 progetti assegnati")
    public void controlloSalarioDipendenteConTreProgettiAssegnati() throws ParseException {
        projectPhone.Initialize();
        projectPhone.creaProgetto("IDS",5000,90,111);
        projectPhone.cercaDipendenti("IDS","b");
        projectPhone.aggiornaDipendenti();
        projectPhone.aggiornaProgetto();
        projectPhone.creaProgetto("IDS2",4000,65,111);
        projectPhone.cercaDipendenti("IDS2","b");
    	projectPhone.aggiornaDipendenti();
        projectPhone.aggiornaProgetto();
        projectPhone.creaProgetto("IDS3",4000,65,111);
        projectPhone.cercaDipendenti("IDS3","b");
    	projectPhone.aggiornaDipendenti();
        projectPhone.aggiornaProgetto();
        Float costoTotale = projectPhone.visualizzaSalarioDipendente(2222);
        assertEquals(costoTotale,630.0f);
        
    }
    
    
        @Test
    @DisplayName("Aggiunta persona in rubrica")
    public void controlloAggiuntaInRubrica() throws ParseException {
        projectPhone.Initialize();
        projectPhone.AggiungiDipendenteInRubrica(1,2222);
        assertEquals(projectPhone.VisualizzaRubrica(1),1);
        
    }

    
}
