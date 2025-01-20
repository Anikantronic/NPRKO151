import java.util.Scanner;

public class Verslag {

    public static Scanner invoer = new Scanner(System.in);
    public static final double honderd = 100;
    public static void main(String[] args){

        System.out.println("Welkom by die gevaarlikheids vlak program.");

        int keuse = 0;
        double hoeveelSperdatums = 10;
        double gemisteSperdatums = 10;
        double verskonings = 10;
        String pasNaam = "";
        double gevaarlikheidsvlak = 0;
        String jaNee = "";

        System.out.println("Kies na wat u will doen:");
        System.out.println("1 - Pasiënt se naam invoer");
        System.out.println("2 - Verander gewigte van die faktore");
        System.out.println("3 - Voer in die valk-waardes");
        System.out.println("4 - Vertoon die pasiënt se verslag");
        System.out.println("5 - Stop die program");
        System.out.print("U keuse: ");
        keuse = invoer.nextInt();
        invoer.nextLine();

        if(keuse == 5){
            System.out.print("Is u seker u wil die program stop?(Ja/Nee)");
            jaNee = invoer.nextLine().toLowerCase();
            if(jaNee.equals("ja") == true){
    
                keuse = 99;
            } 
        }

        while(keuse != 99){
            
            switch (keuse) {
                case 1:
                    //Verkry die pasient se naam
                    pasNaam = kryNaam();
                    
                    break;
            
                case 2:
                    //Verkry die gewigte van die faktore
                    System.out.print("Wat is die gewig van die vlak van die hoeveelheid sperdatums: ");
                    hoeveelSperdatums = gewigFaktore("hoeveelheid");
                    System.out.print("Wat is die gewig van die vlak van gemiste sperdatums: ");
                    gemisteSperdatums = gewigFaktore("gewig");
                    System.out.print("Wat is die gewig van die vlak van verskoonings: ");
                    verskonings = gewigFaktore(3);

                    break;

                case 3:
                    //Kry vlak-waarde vir elke faktor
                    System.out.print("Wat is die vlak van die hoeveelheid sperdatums wat gemis is(0-100): ");
                    double hoeveelSperdatumsVlak = invoer.nextDouble();
                    invoer.nextLine();
                    System.out.print("Wat is die vlak van gemiste sperdatums(0-100): ");
                    double gemisteSperdatumsVlak = invoer.nextDouble();
                    invoer.nextLine();
                    System.out.print("Wat is die vlak van verskonings(0-100): ");
                    double verskoningsVlak = invoer.nextDouble();
                    invoer.nextLine();

                    //Bereken die gevaarlikheidsvlak
                    gevaarlikheidsvlak = berekenGevaarlikheidsvlak(hoeveelSperdatums, gemisteSperdatums, verskonings, hoeveelSperdatumsVlak, gemisteSperdatumsVlak, verskoningsVlak);
                    break;
                
                case 4:
                    //Vertoon verslag
                    System.out.println("Hierso is die verslag: ");
                    System.out.println("Die pasiëntnaam: "+pasNaam);
                    System.out.println("Die gevaarlikheidsvlak is: "+gevaarlikheidsvlak);
                    
                    if(gevaarlikheidsvlak >= 0 && gevaarlikheidsvlak < 50){
                        System.out.println("Die pasiënt kan wag tot môre");
                    }
                    else if(gevaarlikheidsvlak >= 50 && gevaarlikheidsvlak < 75){
                        System.out.println("Die pasiënt moet 'n dagboek van sperdatums hou");
                    }
                    else if(gevaarlikheidsvlak >= 75 && gevaarlikheidsvlak <= 100){
                        System.out.println("Die pasiënt moet 'n twee-dae waarskuwing implementeer");
                    }

                    break;

                default:
                    System.out.println("Kies 'n toepaslikke getal vir u keuse asb.");
                    break;
            }
            System.out.println("Kies na wat u will doen:");
            System.out.println("1 - Pasiënt se naam invoer");
            System.out.println("2 - Verander gewigte van die faktore");
            System.out.println("3 - Voer in die valk-waardes");
            System.out.println("4 - Vertoon die pasiënt se verslag");                
            System.out.println("5 - Stop die program");
            System.out.print("U keuse: ");
            keuse = invoer.nextInt();
            invoer.nextLine();

            //Toets weer of die gebruiker die program wil stop, om enige ongelukke te verkom
            if(keuse == 5){
                System.out.print("Is u seker u wil die program stop?(Ja/Nee)");
                jaNee = invoer.nextLine().toLowerCase();
                if(jaNee.equals("ja") == true){
        
                    keuse = 99;
                } 
            }

        }

        invoer.close();

    }

    public static String kryNaam(){

        System.out.print("Voer asb die pasiënt se naam in: ");
        String naam = invoer.nextLine();
        return naam;
    }

    public static double gewigFaktore(String keuse){

        double gewig = invoer.nextDouble();
        invoer.nextLine();

        return gewig;
    }

    //My oorlaaide metode
    public static double gewigFaktore(int keuse){

        double gewig = invoer.nextDouble();
        invoer.nextLine();

        return gewig;
    }

    public static double berekenGevaarlikheidsvlak(double gewigHS, double gewigGS, double gewigV, double vlakHS, double vlakGS, double vlakV){

        //HS - Hoeveel Sperdatums, GS - Gemiste Sperdatums, V - Verskonings
        double totaalGewig = gewigHS+gewigGS+gewigV;
        double totaalVlak = ((vlakHS/honderd)*gewigHS + (vlakGS/honderd)*gewigGS + (vlakV/honderd)*gewigV)/totaalGewig * 100;

        return totaalVlak;
    }

}
