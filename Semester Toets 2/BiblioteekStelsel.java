import java.util.Scanner;

public class BiblioteekStelsel {
    
    public static final int GETALBOEKE = 5; //Die hoeveelheid boeke beskikbaar
    public static final int VERGELYK = 0; //Word gebruik in sorteerBoekeVolgensTitel() metode

    //Die parallelle reekse wat die boeke se inligting bevat
    public static String[] boekName = {"Mere Christianiy","Lord of the rings","To Kill a Mockingbird","The Great Gatsby","Lord of the flies"};
    public static String[] boekSkrywers = {"C.S Lewis","J.R.R. Tolkien","Harper Lee","F. Scott Fitzgerald","William Golding"};
    public static int[] boekJare = {1952,1968,1960,1925,1954}; 

    //Scanner klas word geskep
    public static Scanner invoer = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("Welkom by Akademia se Biblioteekstelsel");

        boolean exit = false; //Om te toets of gebruiker die program wil verlaat
        char keuse = 0; //Die keuse van die gebruiker
        String boekTitel = ""; //Gebruik wanneer gebruiker na titel soek

        while(!exit){ //Sodat die program aanhou hardloop totdat gebruiker wil uittree

            vertoonBoekInfo(GETALBOEKE);

            System.out.println("");
            System.out.print("Voer jou keuse in: ");
            keuse = invoer.nextLine().charAt(0);
            
            switch (keuse) { //Om die gebruiker se keuse te hanteer
                case 'a': //Soek na 'n boek'
                    
                    System.out.print("Voer asseblief die titel van die boek in wat jy wil soek, of 'exit' vir vorige lys : ");
                    boekTitel = invoer.nextLine();

                    soekBoek(boekTitel);

                    break;
            
                case 'b': //Sorteer beskikbare boeke volgens titel

                    sorteerBoekeVolgensTitle();
                    break;

                case 'c': //Verlaat die program

                    System.out.println("Dankie dat jy Akademia se Biblioteekstelsel gebruik het. Totsiens!");
                    exit = true;
                    break;

                default: //Vra die gebruiker om 'n geldige keuse in te voer
                    System.out.println("Voer asb 'n geldige keuse in.");
                    break;
            }

        }
        


    }

    public static void vertoonBoekInfo(int index){

        //Die index wat onvang word is onnodig so word dus nie gebruik nie
        System.out.println("Beskikbare boeke:");
        for(int i=0; i<GETALBOEKE; i++){

            System.out.println((i+1)+" \""+boekName[i]+"\" by "+boekSkrywers[i]+" ("+boekJare[i]+")");

        }
        System.out.println("");
        System.out.println("Kies 'n opsie:");
        System.out.println("a. Soek na 'n boek");
        System.out.println("b. Sorteer beskikbare boeke volgens titel");
        System.out.println("c. Verlaat die program");

    }

    public static boolean soekBoek(String title){

        boolean gevind = false; //Om te toets of boek gevind is of nie
        int indexGevind = 0;

        if(title.equalsIgnoreCase("exit")){ //Hierso is een van die IgnoreCase() gebruike
            gevind = false; //Toets of gebruiker nie meer 'n boek wil soek nie
        }else{
            for(int i=0; i<GETALBOEKE; i++){

                //Soek vir die boek
                if(title.equalsIgnoreCase(boekName[i])){
                    indexGevind = i;
                    gevind = true;
                }
            }
            if(gevind){

                System.out.println("Boek gevind!");
                System.out.println("Title: "+boekName[indexGevind]);
                System.out.println("Skrywer: "+boekSkrywers[indexGevind]);
                System.out.println("Publikasiejaar: "+boekJare[indexGevind]);

            }else System.out.println("Die boek is nie te vinde nie, jammer daaroor.");
        }

        return gevind; //Dit gee terug 'n boolean waarde maar word nie gebruik nie want dit is nie nodig nie(net vir punte volgens die merkblad)
    }

    public static void sorteerBoekeVolgensTitle(){

        //Tydelike veranderlikkes vir elkeen van die skikkings
        String tempNaam = "";
        String tempSkrywer = "";
        int tempJaar = 0;

        //Bubbelsorteer-algoritme
        for(int i=0; i<GETALBOEKE -1; i++){

            for(int j=0; j<GETALBOEKE -i -1; j++){

                if(boekName[i].compareToIgnoreCase(boekName[j]) < 0){

                    tempNaam = boekName[j];
                    boekName[j] = boekName[j+1];
                    boekName[j+1] = tempNaam;

                    tempJaar = boekJare[j];
                    boekJare[j] = boekJare[j+1];
                    boekJare[j+1] = tempJaar;

                    tempSkrywer = boekSkrywers[j];
                    boekSkrywers[j] = boekSkrywers[j+1];
                    boekSkrywers[j+1] = tempSkrywer;

                }

            }

        }

        //Om die boeke alphabeties te vertoon soos die voorbeeld uitvoer wat gegee is(Na die voorige bubbelsorteering)
        System.out.println("Boeke volgens titel gesorteer:");
        for(int i=0; i<GETALBOEKE; i++){

            System.out.println("Title: "+boekName[i]);
            System.out.println("Skrywer: "+boekSkrywers[i]);
            System.out.println("Publikasiejaar: "+boekJare[i]);
            System.out.println("");

        }

    }

}
