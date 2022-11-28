
package projectphone;

import java.util.Scanner;

/**
 *
 * @author Alessandro
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		ProjectPhone projectPhone = ProjectPhone.getIstance();
                projectPhone.Initialize();

		Scanner input = new Scanner(System.in);
                Boolean accesso,controllo,checkNome,combinazioneTrovata,checkGiaAssegnato;
		Integer numeroDipendente,id,codiceSegreto,rubricaPiena;
                String azione,nomeProgetto,accettazione,simulazione;
                for(;;) {
                do {
		System.out.println("a.Simula smartphone standard");
		System.out.println("b.Simula smartphone manager");
		simulazione=input.next();
		
		
		System.out.println("Inserisci il tuo id (solo per testing, nella realtà avrò già il cellulare");
                id=input.nextInt();
                
                while(true){
                System.out.println("Inserisci il tuo codice segreto");
                codiceSegreto=input.nextInt();
                accesso=projectPhone.AccessoAlTelefono(id, codiceSegreto,simulazione);
                
                if(accesso)
                    break;
                else
                    System.out.println("Codice inserito non corretto, inseriscilo nuovamente");
                }
                
		//Thread.sleep(2000);
		switch(simulazione){
                        case "a":
                            do {
				System.out.println("\n");
				System.out.println("a: Aggiungi un contatto alla rubrica");
				System.out.println("b: Cerca un contatto nella rubrica");
				System.out.println("c: Rimuovi un contatto dalla rubrica");
				System.out.println("d: Visualizza i progetti di un contatto");
                                System.out.println("e: Visualizza i progetti a te assegnati");
                                System.out.println("f: Visualizza la rubrica");
                                System.out.println("j: Info personali");
				System.out.println("q: Blocca lo smartphone");
                                azione=input.next();
                                switch(azione){
                                    case "a":
                                        System.out.println("Inserisci il numero del dipendente\n");
					numeroDipendente = input.nextInt();
                                        controllo = projectPhone.controllaNumero(numeroDipendente);
					if(controllo) {
                                            projectPhone.AggiungiDipendenteInRubrica(id,numeroDipendente);
                                        }
                                        else 
                                            System.out.println("Il numero non esiste");      
                                        break;
                                    case "b":
                                        System.out.println("Inserisci il numero del dipendente da ricercare\n");
					numeroDipendente = input.nextInt();
                                        controllo = projectPhone.controllaNumero(numeroDipendente);
					if(controllo) {
                                            projectPhone.cercaDipendenteInRubrica(id,numeroDipendente);
                                        }
                                        else 
                                            System.out.println("Il numero non esiste");      
                                        break;
                                        
                                    case "c":
                                        System.out.println("Inserisci il numero del dipendente da ricercare\n");
					numeroDipendente = input.nextInt();
                                        controllo = projectPhone.controllaNumero(numeroDipendente);
					if(controllo) {
                                            projectPhone.RimuoviDipendenteDallaRubrica(id,numeroDipendente);
                                        }
                                        else 
                                            System.out.println("Il numero non esiste");      
                                        break;
                                    case "d":
					System.out.println("\nInserisci il numero del dipendente\n");
					numeroDipendente = input.nextInt();
                                        controllo = projectPhone.controllaNumero(numeroDipendente);
                                        if(controllo) {
                                            projectPhone.VisualizzaProgettiContatto(id,numeroDipendente);
                                            }
                                        else 
                                            System.out.println("Il numero non esiste"); 
					break;
                                    case "e":
					projectPhone.VisualizzaProgettiAssegnati(id);
					break;
                                    case "f":
					rubricaPiena = projectPhone.VisualizzaRubrica(id);
                                        if (rubricaPiena ==0)
                                            System.out.println("Non hai contatti presenti in rubrica");
					break;
                                    case "j":
                                        projectPhone.mostraDipendente(id);
                                        break;
                                }
                            } while (!azione.equals("q"));
                        break;
			case "b":
				do {
				System.out.println("\n");
				System.out.println("a: Cerca un dipendente");
				System.out.println("b: Visualizza i progetti di un dipendente");
				System.out.println("c: Crea un progetto");
				System.out.println("d: Visualizza tutti i progetti");
                                System.out.println("e: Visualizza i progetti da te gestiti");
				System.out.println("f: Elimina un progetto");
				System.out.println("g: Cerca i dipendenti per un progetto");
                                System.out.println("h: Visualizza il costo totale dei progetti da te gestiti");
                                System.out.println("i: Visualizza il salario di un dipendente");
                                System.out.println("j: Info personali");
				System.out.println("q: Blocca lo smartphone");
				azione=input.next();
					switch(azione){
						case "a":
							System.out.println("Inserisci il numero del dipendente\n");
							numeroDipendente = input.nextInt();
                                                        controllo = projectPhone.controllaNumero(numeroDipendente);
							if(controllo) {
                                                            projectPhone.CercaDipendente(numeroDipendente);
                                                        }
                                                        else 
                                                        System.out.println("Numero non esistente");                                                        

						break;
						case "b":
							System.out.println("\nInserisci il numero del dipendente\n");
							numeroDipendente = input.nextInt();
                                                        controllo = projectPhone.controllaNumero(numeroDipendente);
                                                        if(controllo) {
                                                            projectPhone.VisualizzaProgettiDipendente(numeroDipendente);
                                                        }
                                                        else 
                                                        System.out.println("Numero non esistente");
						break;
                                                case "c":
                                                        System.out.println("Inserisci il nome del progetto\n");
                                                        nomeProgetto = input.next();
                                                        checkNome = projectPhone.controllaNomeProgetto(nomeProgetto);
                                                        if(!checkNome) {
                                                            System.out.println("Inserisci il budget del progetto\n");
                                                            Integer budget = input.nextInt();
                                                            System.out.println("Inserisci la deadline in ore\n");
                                                            Integer deadline = input.nextInt();
                                                            projectPhone.creaProgetto(nomeProgetto,budget,deadline,id);
                                                            System.out.println("Progetto inserito");
                                                        }
                                                        else {
                                                            System.out.println("Progetto già esistente");
                                                        }
                                                break;    
                                                case "d":
                                                        projectPhone.mostraProgetti();
                                                break;   
                                                case "e":
                                                        projectPhone.mostraProgettiManager(id);
                                                break;  
                                                case "f":
                                                        System.out.println("Inserisci il nome del progetto da rimuovere\n");
                                                        nomeProgetto = input.next();
                                                        checkNome = projectPhone.controllaNomeProgetto(nomeProgetto);
                                                        if(checkNome) {
                                                            projectPhone.eliminaProgetto(nomeProgetto,id);
                                                            System.out.println("Progetto rimosso");
                                                        }
                                                        else {
                                                            System.out.println("Progetto non esistente");
                                                        }
                                                break;   
                                                case "g":
                                                        System.out.println("Inserisci il nome del progetto per cui ricercare i dipendenti\n");
                                                        nomeProgetto = input.next();
                                                        checkNome = projectPhone.controllaNomeProgettoDaAssegnare(nomeProgetto);
                                                        if(checkNome) {
                                                            System.out.println("In base a cosa vuoi ricercare i dipendenti?");
                                                            System.out.println("a. Minimizzazione del costo\n");
                                                            System.out.println("b. Distribuzione equa del lavoro\n");
                                                            String scelta = input.next();
                                                            combinazioneTrovata = projectPhone.cercaDipendenti(nomeProgetto,scelta);
                                                            if (combinazioneTrovata) {
                                                                System.out.println("\nSi vuole procedere con la soluzione proposta? (y/n) \n");
                                                                accettazione = input.next();
                                                                if(accettazione.equals("n"))
                                                                    break;
                                                                else
                                                                {
                                                                    projectPhone.aggiornaDipendenti();
                                                                    projectPhone.aggiornaProgetto();
                                                                    System.out.println("Assegnazione avvenuta");
                                                                    break;
                                                                } 
                                                            }
                                                        }
                                                break;
                                                case "h":
                                                        projectPhone.mostraCostoProgettiManager(id);
                                                break; 
						case "i":
							System.out.println("\nInserisci il numero del dipendente\n");
							numeroDipendente = input.nextInt();
                                                        controllo = projectPhone.controllaNumero(numeroDipendente);
                                                        if(controllo) {
                                                            projectPhone.visualizzaSalarioDipendente(numeroDipendente);
                                                        }
                                                        else {
                                                            System.out.println("Numero non esistente\n");
                                                        }
                                                break;
                                                case "j":
                                                        projectPhone.mostraManager(id);
                                                break;  
                                        }
                                    } while (!azione.equals("q"));
			break;
		}
            } while (!simulazione.equals("a") && !simulazione.equals("b"));
        }
    }
}

