
package projectphone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Alessandro
 */
public class ProjectPhone {
    private int idDipendente;
    private int codiceSegreto;
    private int tipologia;   // 1 per manager, 2 per dipendente semplice

    public ProjectPhone(int idDipendente, int codiceSegreto, int tipologia) {
        this.idDipendente = idDipendente;
        this.codiceSegreto = codiceSegreto;
        this.tipologia = tipologia;
    }

    public ProjectPhone() {
    }

    public int getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(int idDipendente) {
        this.idDipendente = idDipendente;
    }

    public int getCodiceSegreto() {
        return codiceSegreto;
    }

    public void setCodiceSegreto(int codiceSegreto) {
        this.codiceSegreto = codiceSegreto;
    }

    public int getTipologia() {
        return tipologia;
    }

    public void setTipologia(int tipologia) {
        this.tipologia = tipologia;
    }
    

    private static ProjectPhone istance; //per il singletone (projectphone deve essere unico)
    //ArrayList listaIdDipendentiSemplici;
    HashMap<Integer,DipSemplice> mappaDipendentiSemplici = new HashMap();
    HashMap<Integer,ManagerPhone> mappaManagerPhone = new HashMap();
    HashMap<Integer,Manager> mappaManager = new HashMap();
    HashMap<Integer,Progetto> mappaProgetti = new HashMap();
    HashMap<Integer,DipSemplice> mappaDipSempliciScelti = new HashMap();
    HashMap<Integer,StandardPhone> mappaStandardPhone = new HashMap();
    HashMap<Integer,Rubrica> mappaRubriche = new HashMap();
    HashMap<Integer,Integer> mappaOre;
    HashMap<Integer,Float> mappaCosto;
    int y=1,z=1,idProgettoDaAggiornare;  
    int oreLavorateTotali = 0;
    Float costoTotaleDelProgetto;
    
    public static ProjectPhone getIstance(){
        if(istance==null) 
            istance = new ProjectPhone();
        return istance;
    }
    
    public void Initialize() {
		Initialize init = new Initialize();
                // --- Inizializzo la mappa dei dipendenti semplici --- //

		ArrayList<DipSemplice> listaDipSemplici;
		listaDipSemplici = init.InitializeDipendenti();

                for(int i=0;i<listaDipSemplici.size();i++){
			this.mappaDipendentiSemplici.put(listaDipSemplici.get(i).getIdDipendente(), listaDipSemplici.get(i));
		}
                
                
                // --- Inizializzo la mappa dei manager --- //
                
                
                ArrayList<Manager> listaManager;
                listaManager = init.InitializeManager();
                
                for(int i=0;i<listaManager.size();i++){
			this.mappaManager.put(listaManager.get(i).getIdDipendente(),listaManager.get(i));
		}
                
          
                // --- Inizializzo la mappa dei managerPhone --- //
                
                ArrayList<ManagerPhone> listaManagerPhone;
                listaManagerPhone = init.InitializeManagerPhone();
                
                for(int i=0;i<listaManagerPhone.size();i++){
			this.mappaManagerPhone.put(listaManagerPhone.get(i).getIdDipendente(), listaManagerPhone.get(i));
		}
                
                // --- Inizializzo la mappa degli standardPhone --- //
                
                ArrayList<StandardPhone> listaStandardPhone;
                listaStandardPhone = init.InitializeStandardPhone();
                
                for(int i=0;i<listaStandardPhone.size();i++){
			this.mappaStandardPhone.put(listaStandardPhone.get(i).getIdDipendente(), listaStandardPhone.get(i));
		}
                
                // --- Inizializzo la mappa delle rubriche --- //
                
                ArrayList<Rubrica> listaRubriche;
                listaRubriche = init.InitializeRubriche();
                
                for(int i=0;i<listaRubriche.size();i++){
			this.mappaRubriche.put(listaRubriche.get(i).getIdRubrica(), listaRubriche.get(i));
		}
    }
    
    public boolean controllaNumero(Integer numero){
        Boolean x = false;

        for(Integer k: mappaDipendentiSemplici.keySet()){		
            if (mappaDipendentiSemplici.get(k).getNumero() == numero)
                   x=true; 
        }
        return x;
    }

    public boolean AccessoAlTelefono(Integer i,Integer codiceSegreto,String tipologia){
        Boolean b = false;
        if(tipologia.equals("a")) {
            if (mappaStandardPhone.get(i).getCodiceSegreto()== codiceSegreto)
                b=true; 
        } 
        else {
            if (mappaManagerPhone.get(i).getCodiceSegreto()== codiceSegreto)
                b=true; 
            }
        /*
        for(Integer k: mappaManagerPhone.keySet()){		
            if (mappaManagerPhone.get(k).getCodiceSegreto()== codiceSegreto)
                   b=true; 
        }
        */
        
        return b;
    }
    
    
    public void CercaDipendente(Integer numero){
        DipSemplice d = new DipSemplice();
        for(Integer k: mappaDipendentiSemplici.keySet()){		
            if (mappaDipendentiSemplici.get(k).getNumero()== numero) {
                   d=mappaDipendentiSemplici.get(k); 
                   System.out.println(d);
            }
            
        }
    }
    
    public void VisualizzaProgettiDipendente(Integer numero){
        DipSemplice d = new DipSemplice();
        for(Integer k: mappaDipendentiSemplici.keySet()){		
            if (mappaDipendentiSemplici.get(k).getNumero()== numero) {
                   d=mappaDipendentiSemplici.get(k); 
                   if (d.getElencoProgettiAssegnati().isEmpty())
                       System.out.println("Il dipendente cercato non ha progetti assegnati");
                   else
                       for(int i=1;i<=d.getElencoProgettiAssegnati().size();i++)
                       System.out.println(mappaProgetti.get(i));
            }
            
        }
    }
    
    public void creaProgetto(String nomeProgetto,Integer budget,Integer deadline,Integer id){
        Progetto p = new Progetto(mappaProgetti.size()+1,budget,0,deadline,0,nomeProgetto);
        mappaProgetti.put(mappaProgetti.size()+1, p);
        mappaManagerPhone.get(id).setListaProgetti(mappaProgetti.size());
    }
    
    public void mostraProgetti(){
        for(Integer k: mappaProgetti.keySet()){		
            System.out.println(mappaProgetti.get(k));
            
        }
    }
    
    public boolean controllaNomeProgettoDaAssegnare(String nome){
        int h=0;

        for(Integer k: mappaProgetti.keySet()){
            if (mappaProgetti.get(k).getNomeProgetto().equals(nome)){
                h=1;
                if(mappaProgetti.get(k).getNumDipendenti()>0) {
                    System.out.println("Il progetto ha già dipendenti assegnati\n");
                    return false; 
                }
                else {
                    return true;
                }
            }
        }
        if(h==0){
            System.out.println("Il progetto non esiste\n");
            return false;
        }
        else
            return true;
    }
    public boolean controllaNomeProgetto(String nome){

        for(Integer k: mappaProgetti.keySet()){
            if (mappaProgetti.get(k).getNomeProgetto().equals(nome)){
                    return true; 
                }
            }

            return false;

    }
    
    public boolean eliminaProgetto(String nome,Integer id){
        Boolean x = false;
        Integer idProgettoDaEliminare=0;
        for(Integer k: mappaProgetti.keySet()){		
            if (mappaProgetti.get(k).getNomeProgetto().equals(nome)){
                idProgettoDaEliminare = mappaProgetti.get(k).getIdProgetto();
                mappaProgetti.remove(k);
                x=true; 
            }
        }
        
        for(Integer k: mappaDipendentiSemplici.keySet()){		
            if (mappaDipendentiSemplici.get(k).getElencoProgettiAssegnati().containsKey(idProgettoDaEliminare)){
                mappaProgetti.remove(k);
                Integer oreDaAggiungere = mappaDipendentiSemplici.get(k).getElencoProgettiAssegnati().get(idProgettoDaEliminare);
                mappaDipendentiSemplici.get(k).setOreDisponibili(mappaDipendentiSemplici.get(k).getOreDisponibili()+oreDaAggiungere);
                mappaDipendentiSemplici.get(k).setElencoProgettiAssegnati(idProgettoDaEliminare);
                x=true; 
            }
        }
        
        mappaManagerPhone.get(id).setListaProgetti(idProgettoDaEliminare,1);
        
        return x;
    }
 
    
    public void aggiornaDipendenti(){
        // Aggiorno l'elenco dei progetti assegnati ad un dipendente
        ArrayList<Integer> listaKeyMappaDipScelti = new ArrayList<Integer>();
        listaKeyMappaDipScelti.addAll(mappaOre.keySet());
        ArrayList<Integer> listaKeyMappaOre = new ArrayList<Integer>();
        listaKeyMappaOre.addAll(mappaOre.keySet());
        
        for(int i=0;i<listaKeyMappaDipScelti.size();i++)  {
            for(Integer k: mappaDipendentiSemplici.keySet()){		
                if (mappaDipendentiSemplici.get(k).getIdDipendente()==listaKeyMappaDipScelti.get(i))
                       mappaDipendentiSemplici.get(k).setElencoProgettiAssegnati(idProgettoDaAggiornare,mappaOre.get(k));
            }
        }
        
        
        for(int i=0;i<listaKeyMappaDipScelti.size();i++)  {
        // Aggiorno le ore disponibili dei dipendenti
            for(Integer k: mappaOre.keySet()){		
                if (mappaDipendentiSemplici.get(k).getIdDipendente()==listaKeyMappaOre.get(i))
                       mappaDipendentiSemplici.get(k).setOreDisponibili(mappaDipendentiSemplici.get(k).getOreDisponibili()-mappaOre.get(k));
            }
        }
    }
    
    
    public void aggiornaProgetto(){
        // Aggiorno il costo totale del progetto
        for(Integer k: mappaProgetti.keySet()){		
            if (mappaProgetti.get(k).getIdProgetto()==idProgettoDaAggiornare)
                   mappaProgetti.get(k).setCostoTotale(costoTotaleDelProgetto);
        }
        // Aggiorno le ore totali richieste dal progetto
        for(Integer k: mappaProgetti.keySet()){		
            if (mappaProgetti.get(k).getIdProgetto()==idProgettoDaAggiornare)
                   mappaProgetti.get(k).setOreDiLavoro(oreLavorateTotali);
        }
        
        // Aggiorno il numero dei dipendenti assegnati al progetto
        for(Integer k: mappaProgetti.keySet()){		
            if (mappaProgetti.get(k).getIdProgetto()==idProgettoDaAggiornare)
                   mappaProgetti.get(k).setNumDipendenti(mappaDipSempliciScelti.size());
        }        
    }
   
    
    public Boolean cercaDipendenti(String nome,String modalita){
        if(modalita.equals("a")) {
        LinkedHashMap<Integer,DipSemplice> mappaDipSempliciPerCosto = new LinkedHashMap<>();
        ArrayList<Float> list = new ArrayList<>();
        costoTotaleDelProgetto = 0.0f;
        mappaOre=new HashMap<>();
        mappaCosto=new HashMap<>();
        Integer budget=0,deadline=0;
        oreLavorateTotali = 0;
        
        // Inserisco in una lista i valori del costoAdOra e li ordino
        for (Integer k: mappaDipendentiSemplici.keySet()) {
            list.add(mappaDipendentiSemplici.get(k).getCostoAdOra());
        }
        Collections.sort(list); 
      
        // Creo una mappa ordinata in base ai valori della lista ordinata
        for (float num : list) {

            for (Integer k: mappaDipendentiSemplici.keySet()) {
                if (mappaDipendentiSemplici.get(k).getCostoAdOra() == num) {
                    mappaDipSempliciPerCosto.put(y, mappaDipendentiSemplici.get(k));
                    y++;
                }
            }
        }
        // Salvo le informazioni del budget del progetto e della deadline
        for(Integer k: mappaProgetti.keySet()){		
            if (mappaProgetti.get(k).getNomeProgetto().equals(nome)){
                budget = mappaProgetti.get(k).getBudget();
                deadline = mappaProgetti.get(k).getDeadlineInOre();
                idProgettoDaAggiornare = mappaProgetti.get(k).getIdProgetto();
            }
        }

        // Creo la combinazione di dipendenti
        for(Integer k: mappaDipSempliciPerCosto.keySet()){

            Integer oreLavoratePerDip=0;
            Float costoPerDip=0.0f;

            for(Integer i=0;i<mappaDipSempliciPerCosto.get(k).getOreDisponibili();i++){
                costoPerDip = costoPerDip + mappaDipSempliciPerCosto.get(k).getCostoAdOra();
                costoTotaleDelProgetto = costoTotaleDelProgetto + mappaDipSempliciPerCosto.get(k).getCostoAdOra();
                oreLavorateTotali = oreLavorateTotali + 1;
                oreLavoratePerDip = oreLavoratePerDip + 1;

                mappaOre.put(mappaDipSempliciPerCosto.get(k).getIdDipendente(), oreLavoratePerDip);
                mappaCosto.put(mappaDipSempliciPerCosto.get(k).getIdDipendente(), costoPerDip);
                mappaDipSempliciScelti.put(mappaDipSempliciPerCosto.get(k).getIdDipendente(), mappaDipSempliciPerCosto.get(k));
                //System.out.println(mappaOre);
                //System.out.println(mappaCosto);
                if(deadline.equals(oreLavorateTotali)) {
                    if (costoTotaleDelProgetto>budget) {
                        System.out.println("Non si riesce a trovare una combinazione disponibile. Si pensi ad aumentare il budget\n");
                        return false;
                    }
                    else {
                        System.out.println("La combinazione trovata è: \n");
                        for(Integer j: mappaDipSempliciScelti.keySet()){
                        //System.out.println(mappaDipSempliciPerCosto.get(j).getNome());
                        System.out.println(
                            "Dipendente: "+mappaDipSempliciScelti.get(j).getNome()+" "+mappaDipSempliciScelti.get(j).getCognome()+
                            "\nNumero di telefono: "+mappaDipSempliciScelti.get(j).getNumero()+
                            "\nOre occupate: "+mappaOre.get(j)+
                            "\nCosto per questo dipendente: "+mappaCosto.get(j)+"\n"
                            );
                        }
                        return true;
                    }
                }
            }
        }  
        return true;
        }
        else {
            LinkedHashMap<Integer,DipSemplice> mappaDipSempliciPerOre = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        costoTotaleDelProgetto = 0.0f;
        mappaOre=new HashMap<>();
        mappaCosto=new HashMap<>();
        Integer budget=0,deadline=0;
        oreLavorateTotali = 0;
        
        // Inserisco in una lista i valori del costoAdOra e li ordino
        for (Integer k: mappaDipendentiSemplici.keySet()) {
            list.add(mappaDipendentiSemplici.get(k).getOreDisponibili());
        }
        Collections.sort(list, Collections.reverseOrder());
      
        // Creo una mappa ordinata in base ai valori della lista ordinata
        for (float num : list) {

            for (Integer k: mappaDipendentiSemplici.keySet()) {
                if (mappaDipendentiSemplici.get(k).getOreDisponibili() == num) {
                    mappaDipSempliciPerOre.put(z, mappaDipendentiSemplici.get(k));
                    z++;
                }
            }
        }
        // Salvo le informazioni del budget del progetto e della deadline
        for(Integer k: mappaProgetti.keySet()){		
            if (mappaProgetti.get(k).getNomeProgetto().equals(nome)){
                budget = mappaProgetti.get(k).getBudget();
                deadline = mappaProgetti.get(k).getDeadlineInOre();
                idProgettoDaAggiornare = mappaProgetti.get(k).getIdProgetto();
            }
        }

        // Creo la combinazione di dipendenti
        for(Integer k: mappaDipSempliciPerOre.keySet()){

            Integer oreLavoratePerDip=0;
            Float costoPerDip=0.0f;

            for(Integer i=0;i<mappaDipSempliciPerOre.get(k).getOreDisponibili();i++){
                if(i == 10)
                    break;
                costoPerDip = costoPerDip + mappaDipSempliciPerOre.get(k).getCostoAdOra();
                costoTotaleDelProgetto = costoTotaleDelProgetto + mappaDipSempliciPerOre.get(k).getCostoAdOra();
                oreLavorateTotali = oreLavorateTotali + 1;
                oreLavoratePerDip = oreLavoratePerDip + 1;

                mappaOre.put(mappaDipSempliciPerOre.get(k).getIdDipendente(), oreLavoratePerDip);
                mappaCosto.put(mappaDipSempliciPerOre.get(k).getIdDipendente(), costoPerDip);
                mappaDipSempliciScelti.put(mappaDipSempliciPerOre.get(k).getIdDipendente(), mappaDipSempliciPerOre.get(k));
                //System.out.println(mappaOre);
                //System.out.println(mappaCosto);
                //System.out.println(mappaDipSempliciScelti);
                if(deadline.equals(oreLavorateTotali)) {
                    if (costoTotaleDelProgetto>budget) {
                        System.out.println("Non si riesce a trovare una combinazione disponibile. Si pensi ad aumentare il budget\n");
                        return false;
                    }
                    else {
                        System.out.println("La combinazione trovata è: \n");
                        for(Integer j: mappaDipSempliciScelti.keySet()){
                        //System.out.println(mappaDipSempliciPerCosto.get(j).getNome());
                        System.out.println(
                            "Dipendente: "+mappaDipSempliciScelti.get(j).getNome()+" "+mappaDipSempliciScelti.get(j).getCognome()+
                            "\nNumero di telefono: "+mappaDipSempliciScelti.get(j).getNumero()+
                            "\nOre occupate: "+mappaOre.get(j)+
                            "\nCosto per questo dipendente: "+mappaCosto.get(j)+"\n"
                            );
                        }
                        return true;
                    }
                }
            }
        }  
        return true;
        }
    }
    
        
        
        
        
    public void mostraProgettiManager(Integer idManager){
        ArrayList<Integer> listaProgettiManager = new ArrayList<>();
        listaProgettiManager = mappaManagerPhone.get(idManager).getListaProgetti();
        for(Integer k: mappaProgetti.keySet()){		
            if(listaProgettiManager.contains(mappaProgetti.get(k).getIdProgetto()))
            System.out.println(mappaProgetti.get(k));
        }
    }
    
    public void mostraManager(Integer idManager){
        System.out.println(mappaManager.get(idManager).toString());
    }
    
    
    
    public Float mostraCostoProgettiManager(Integer idManager){
        Float costoTotaleProgettiManager = 0.0f;
        ArrayList<Integer> listaProgettiManager = new ArrayList<>();
        listaProgettiManager = mappaManagerPhone.get(idManager).getListaProgetti();
        for(Integer k: mappaProgetti.keySet()){		
            if(listaProgettiManager.contains(mappaProgetti.get(k).getIdProgetto()))
                costoTotaleProgettiManager = costoTotaleProgettiManager + mappaProgetti.get(k).getCostoTotale();
        }
        if (costoTotaleProgettiManager == 0.0f)
            System.out.println("Non gestisci nessun progetto");
        else
            System.out.println("Il costo totale dei progetti da te gestiti è di: " + costoTotaleProgettiManager + "€\n");
        return costoTotaleProgettiManager;
    }
    
    
        public Float visualizzaSalarioDipendente(Integer numero){
        Integer oreLavorateDipendente = 0, idDipendente = 0;
        int i = 1;
        Float salario = 0.0f;
        
            for(Integer k: mappaDipendentiSemplici.keySet()){		
               if (mappaDipendentiSemplici.get(k).getNumero()== numero) {
                   idDipendente = k;
                   if (mappaDipendentiSemplici.get(k).getElencoProgettiAssegnati().isEmpty())
                        System.out.println("Il dipendente cercato non ha progetti assegnati");
                   else {
                        for(i=1;i<=mappaDipendentiSemplici.get(k).getElencoProgettiAssegnati().size();i++) {
                            oreLavorateDipendente = oreLavorateDipendente + mappaDipendentiSemplici.get(k).getElencoProgettiAssegnati().get(i);
                        }
                    }
                }
            }
            
            if (i>3) {
                salario = oreLavorateDipendente * mappaDipendentiSemplici.get(idDipendente).getCostoAdOra() * 105 / 100;
                if (salario<500.0f)
                    System.out.println("Il salario del dipendente cercato è: 500 €\n");
                else {
                    if (salario>3000.0f) {
                        System.out.println("Il salario del dipendente cercato sfora il limite aziendale di 3000€. Al momento il salario mensile è di: "+salario);
                        System.out.println("\nRivedere l'assegnazione dei progetti\n");     
                        return salario;
                    }
                    else {
                        System.out.println("Il salario del dipendente cercato è: " +salario+ "€\n");   
                        return salario;
                    }
                }
            }
            else {
                salario = oreLavorateDipendente * mappaDipendentiSemplici.get(idDipendente).getCostoAdOra();
                if (salario<500.0f) {
                    System.out.println("Il salario del dipendente cercato è: 500 €\n");
                    return 500.0f;
                }
                else {
                    if (salario>3000.0f) {
                        System.out.println("Il salario del dipendente cercato sfora il limite aziendale di 3000€. Al momento il salario mensile è di: "+salario);
                        System.out.println("\nRivedere l'assegnazione dei progetti\n");       
                    }
                    else {
                    System.out.println("Il salario del dipendente cercato è: " +salario+ "€\n"); 
                    return salario;
                    }
                }
                    
            }
            return salario;
        }
        
    
    
    
    public void AggiungiDipendenteInRubrica(Integer id,Integer numero){
        for(Integer k: mappaDipendentiSemplici.keySet()){		
               if (mappaDipendentiSemplici.get(k).getNumero()== numero) {
                   if (mappaDipendentiSemplici.get(k).getIdDipendente() == id)
                       System.out.println("Non puoi aggiungere te stesso alla rubrica");
                   else {
                   mappaRubriche.get(id).setListaDipendenti(k);
                   System.out.println("Contatto aggiunto");
                   }
                }
            }
    }
    
    public void cercaDipendenteInRubrica(Integer id,Integer numero){
        for(Integer k: mappaDipendentiSemplici.keySet()){		
               if (mappaDipendentiSemplici.get(k).getNumero()== numero) {
                   if ( mappaRubriche.get(id).getListaDipendenti().contains(k))
                       System.out.println(mappaDipendentiSemplici.get(k).toString());
                   else
                       System.out.println("Utente non presente in rubrica");
                }
            }
    }
    
    public void RimuoviDipendenteDallaRubrica(Integer id,Integer numero){
        for(Integer k: mappaDipendentiSemplici.keySet()){		
               if (mappaDipendentiSemplici.get(k).getNumero()== numero) {
                   mappaRubriche.get(id).setListaDipendenti(k,0);
                   System.out.println("Contatto rimosso\n");
                }
            }
    }
    
    
    public void mostraDipendente(Integer idDipendente){
        System.out.println(mappaDipendentiSemplici.get(idDipendente).toString());
    }
    
    
    
    
    public void VisualizzaProgettiContatto(Integer id,Integer numero){
        for(Integer k: mappaDipendentiSemplici.keySet()){		
            if (mappaDipendentiSemplici.get(k).getNumero()== numero) {
                if ( mappaRubriche.get(id).getListaDipendenti().contains(k)) {
                   if(mappaDipendentiSemplici.get(k).getElencoProgettiAssegnati().isEmpty()==true)
                       System.out.println("Il contatto non ha progetti assegnati\n");
                   else {
                        for(int i=1;i<=mappaDipendentiSemplici.get(k).getElencoProgettiAssegnati().size();i++)
                        System.out.println(mappaProgetti.get(i));
                   }
                }
            }
        }
    }
    
    
    
    public void VisualizzaProgettiAssegnati(Integer id){
        if(mappaDipendentiSemplici.get(id).getElencoProgettiAssegnati().isEmpty()==true)
                       System.out.println("Non hai progetti assegnati\n");
                   else {
                        for(int i=1;i<=mappaDipendentiSemplici.get(id).getElencoProgettiAssegnati().size();i++)
                        System.out.println(mappaProgetti.get(i));
                   }
    }
    
    
    public Integer VisualizzaRubrica(Integer id){
        Integer idRubrica = mappaStandardPhone.get(id).getIdRubrica(),x=0;
        System.out.println(idRubrica);
        for(Integer k: mappaDipendentiSemplici.keySet()){
            if (mappaRubriche.get(idRubrica).getListaDipendenti().contains(mappaDipendentiSemplici.get(k).getIdDipendente())) {
                System.out.println(mappaDipendentiSemplici.get(k));
                x++;
            }
        }
        return x;
    }  
}


