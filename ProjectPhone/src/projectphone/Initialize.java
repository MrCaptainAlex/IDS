
package projectphone;

import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class Initialize {
   
    public ArrayList InitializeDipendenti(){
        DipSemplice d1 = new DipSemplice(1,"Marco","Ricci",1111,0,24, 6.5f);
        DipSemplice d2 = new DipSemplice(2,"Giulio","Padovani",2222,0,34,20.0f);
        DipSemplice d3 = new DipSemplice(3,"Roberto","Micci",3333,0,10,9.5f);
	DipSemplice d4 = new DipSemplice(4,"Giada","Foglio",4444,0,22,5.5f);
	DipSemplice d5 = new DipSemplice(5,"Giorgia","Rausa",5555,0,17,7.2f);
	DipSemplice d6 = new DipSemplice(6,"Guglielmo","Gagliano",6666,0,9,6.6f);
	DipSemplice d7 = new DipSemplice(7,"Paola","Castiglione",7777,0,43,9.2f);
	DipSemplice d8 = new DipSemplice(8,"Concetta","Domante",8888,0,4,9.8f);
	DipSemplice d9 = new DipSemplice(9,"Alessandro","Angelo",9999,0,8,8.5f);
	DipSemplice d10 = new DipSemplice(10,"Chiara","Rizzo",1616,0,12,6.7f);
	DipSemplice d11 = new DipSemplice(11,"Mirko","Martello",1212,0,14,7);
	DipSemplice d12 = new DipSemplice(12,"Lara","Pasotti",1313,0,11,6);
	DipSemplice d13 = new DipSemplice(13,"Rita","Ghirbelli",1414,0,19,5);
	DipSemplice d14 = new DipSemplice(14,"Jordan","Mitino",1515,0,27,8);
        DipSemplice d15 = new DipSemplice(15,"Melissa","Pacone",1010,0,33,9);

        ArrayList<DipSemplice> listaDipendentiSemplici = new ArrayList<>();
        listaDipendentiSemplici.add(d1);
        listaDipendentiSemplici.add(d2);
        listaDipendentiSemplici.add(d3);
        listaDipendentiSemplici.add(d4);
        listaDipendentiSemplici.add(d5);
        listaDipendentiSemplici.add(d6);
        listaDipendentiSemplici.add(d7);
        listaDipendentiSemplici.add(d8);
        listaDipendentiSemplici.add(d9);
        listaDipendentiSemplici.add(d10);
        listaDipendentiSemplici.add(d11);
        listaDipendentiSemplici.add(d12);
        listaDipendentiSemplici.add(d13);
        listaDipendentiSemplici.add(d14);
        listaDipendentiSemplici.add(d15);
        
        return listaDipendentiSemplici;

    }

    
    public ArrayList InitializeManager(){
        Manager m1 = new Manager(111,"Marco","Guglielmini",111,1);
        Manager m2 = new Manager(222,"Paola","Rivoldelli",222,1);
        Manager m3 = new Manager(333,"Guglielmo","Mastro",333,1);

        ArrayList<Manager> listaManager = new ArrayList<>();
        listaManager.add(m1);
        listaManager.add(m2);
        listaManager.add(m3);
        
        return listaManager;
    }
    
    public ArrayList InitializeManagerPhone(){
        ArrayList<ManagerPhone> listaManagerPhone = new ArrayList<>();
        ManagerPhone mp1 = new ManagerPhone(111,1605,1);
        ManagerPhone mp2 = new ManagerPhone(222,1605,1);  
        ManagerPhone mp3 = new ManagerPhone(333,1605,1);
        
        listaManagerPhone.add(mp1);
        listaManagerPhone.add(mp2);
        listaManagerPhone.add(mp3);
        return listaManagerPhone;
    }
    
        public ArrayList InitializeStandardPhone(){
        ArrayList<StandardPhone> listaStandardPhone = new ArrayList<>();
        StandardPhone sp1 = new StandardPhone(1,1,1605,0);
        StandardPhone sp2 = new StandardPhone(2,2,1605,0);
        StandardPhone sp3 = new StandardPhone(3,3,1605,0);
        StandardPhone sp4 = new StandardPhone(4,4,1605,0);
        StandardPhone sp5 = new StandardPhone(5,5,1605,0);
        StandardPhone sp6 = new StandardPhone(6,6,1605,0);
        StandardPhone sp7 = new StandardPhone(7,7,1605,0);
        StandardPhone sp8 = new StandardPhone(8,8,1605,0);
        StandardPhone sp9 = new StandardPhone(9,9,1605,0);
        StandardPhone sp10 = new StandardPhone(10,10,1605,0);
        StandardPhone sp11 = new StandardPhone(11,11,1605,0);
        StandardPhone sp12 = new StandardPhone(12,12,1605,0);
        StandardPhone sp13 = new StandardPhone(13,13,1605,0);
        StandardPhone sp14 = new StandardPhone(14,14,1605,0);
        StandardPhone sp15 = new StandardPhone(15,15,1605,0);
        
        listaStandardPhone.add(sp1);
        listaStandardPhone.add(sp2);
        listaStandardPhone.add(sp3);
        listaStandardPhone.add(sp4);
        listaStandardPhone.add(sp5);
        listaStandardPhone.add(sp6);
        listaStandardPhone.add(sp7);
        listaStandardPhone.add(sp8);
        listaStandardPhone.add(sp9);
        listaStandardPhone.add(sp10);
        listaStandardPhone.add(sp11);
        listaStandardPhone.add(sp12);
        listaStandardPhone.add(sp13);
        listaStandardPhone.add(sp14);
        listaStandardPhone.add(sp15);
        

        
        return listaStandardPhone;
    }

        
        public ArrayList InitializeRubriche(){
            ArrayList<Rubrica> listaRubriche = new ArrayList<>();

            Rubrica r1 = new Rubrica(1);
            Rubrica r2 = new Rubrica(2);
            Rubrica r3 = new Rubrica(3);
            Rubrica r4 = new Rubrica(4);
            Rubrica r5 = new Rubrica(5);
            Rubrica r6 = new Rubrica(6);
            Rubrica r7 = new Rubrica(7);
            Rubrica r8 = new Rubrica(8);
            Rubrica r9 = new Rubrica(9);
            Rubrica r10 = new Rubrica(10);
            Rubrica r11 = new Rubrica(11);
            Rubrica r12 = new Rubrica(12);
            Rubrica r13 = new Rubrica(13);
            Rubrica r14 = new Rubrica(144);
            Rubrica r15 = new Rubrica(15);        
                    
                            
            listaRubriche.add(r1);
            listaRubriche.add(r2);
            listaRubriche.add(r3);
            listaRubriche.add(r4);
            listaRubriche.add(r5);
            listaRubriche.add(r6);
            listaRubriche.add(r7);
            listaRubriche.add(r8);
            listaRubriche.add(r9);
            listaRubriche.add(r10);
            listaRubriche.add(r11);
            listaRubriche.add(r12);
            listaRubriche.add(r13);
            listaRubriche.add(r14);
            listaRubriche.add(r15);
            
        return listaRubriche;
        }
}
