import java.util.Scanner;

public class StudenteStelsel {

    public static Scanner invoer = new Scanner(System.in); //Scanner

    public static void main(String[] args) {

        //Skikkings word geskep vir al die data velde, sonder enige data spasie wat gegee word.
        int[] stuNommer = {};
        String[] stuNaam = {};
        String[] stuStudieveld = {};
        double[] stuPersentasie = {};

        boolean eindig = false; //Om te toets of gebruiker die program wil be-eindig.
        int keuse = 0; //veranderlikke om gebruiker se kieslys keuse te ontvang
        int aantalStudente = 0; //Gaan gebruik word om te weet hoeveel studente se data die gebruiker wil inlees.

        //Welkom die gebruiker na die program en stel voor dat data eerste ingelees word
        System.out.println("Welkom by die Studentebestuurstelsel");
        System.out.println("Dit word aanbeveel om te begin deurom die Studente data in te lees.");

        while(!eindig){ //Spdat gebruiker vele keure deur die program kan hardloop

            try { //Om enige gebruikers invoer foute te vang

                vertoonKeuses(); //Metode om keuses te vertoon opgeroep
                keuse = invoer.nextInt(); //Onvang keuse vanaf gebruiker
                invoer.nextLine();

                switch(keuse){ //Die verskillende opsies in die kieslys word nou opgeroep soos ontvang vanaf die gebruiker

                    case 1: //Lees die studente data in

                        try { // Om gebruikers se invoer foute vir die verskeie velde wat ingelees gaan word te vang

                            System.out.print("Hoeveel Studente se data gaan ingelees word: ");
                            aantalStudente = invoer.nextInt();
                            invoer.nextLine();

                            //Al die skikkings word nou geskep met die groote wat ontvang is vanaf die gebruiker vir die aantal studente
                            stuNommer = nuweStuNommer(aantalStudente, stuNommer);
                            stuNaam = nuweStuNaamOfVeld(aantalStudente, stuNaam);
                            stuStudieveld = nuweStuNaamOfVeld(aantalStudente, stuStudieveld);
                            stuPersentasie = nuweStuPersentasie(aantalStudente, stuPersentasie);

                            //Die studente se data word nou ingelees
                            for(int i=0; i<aantalStudente; i++){

                                System.out.print("Studentenommer: ");
                                String studenteNommer = invoer.nextLine(); //Ontvang studente nommer as 'n string om die nodige toetse te kan doen

                                System.out.print("Student naam: ");
                                stuNaam[i] = invoer.nextLine();

                                System.out.print("Student Studieveld: ");
                                stuStudieveld[i] = invoer.nextLine();

                                System.out.print("Student persentasie: ");
                                stuPersentasie[i] = invoer.nextDouble();
                                invoer.nextLine();
                                
                                int[] toetsStuNr = new int[studenteNommer.length()]; //Skep 'n array met die gegewe studente nommers as skikking waardes

                                for(int j=0; j<studenteNommer.length(); j++){

                                    toetsStuNr[j] = Integer.parseInt(studenteNommer.substring(j,j+1)); //Stoor nou die string karakters as integers
                                }

                                if(geldigeStudentenommer(toetsStuNr)){ //Toets of die studente nommer geldig is

                                    stuNommer[i] = Integer.parseInt(studenteNommer);
                                    System.out.println("Geldige Studente nommer is gegee, dankie.");
                                } else {
                                    System.out.println("Die studente nommer was nie geldig nie.");
                                    System.out.println("Begin u poging van voor af.");
                                    break;
                                }

                            }

                            
                        } catch (Exception e) {//Fout boodskap
                            System.out.println("Voer asseblief geldige waardes in vir die verskeie velde, dankie.");
                        }

                        break;

                    case 2: //Vertoon studente data

                        System.out.println("");
                        System.out.println("Hierop volg die Studentedata: (Studienommer,Naam,Studieveld,Persentasie)");
                        vertoonStudenteData(stuNommer, stuNaam, stuStudieveld, stuPersentasie); //Roep metode wat die data vertoon
                        break;

                    case 3: //Sorteer en vertoon volgens die persentasie

                        //Roep die metode wat die data sorteer volgens die studente se persentasies
                        sorteerStudentePersentasie(stuNommer, stuNaam, stuStudieveld, stuPersentasie);
                        break;

                    case 4: //Bereken die gemiddelde persentasie

                        //Die graad se gemiddeld word nou bereken
                        System.out.println("");
                        System.out.println("Die gemiddelde persentasie van alle studente is: "+berekenGemiddeldePersentasie(stuPersentasie));
                        break;

                    case 5: //Eindig die program

                        System.out.println("");
                        System.out.println("Dankie dat u die program gebruik het.");
                        System.out.println("Totsiens.");
                        eindig = true;
                        break;

                    default: //As heelgetalle wat nie een van die keuses was ingevoer word
                        System.out.println("Voer asseblief 'n geldige getal in vir u keuse.");
                        break;
                

                }


                
            } catch (Exception e) { //Fout boodskap
                System.out.println("Voer asseblief 'n toepaslike keuse in, dankie.");
            }
            
        }

    }

    public static void vertoonKeuses(){ //Metode om die gebruiker keuses te vertoon

        System.out.println("");
        System.out.println("1 - Lees die Studente data in");
        System.out.println("2 - Vertoon die Studente data");
        System.out.println("3 - Sorteer die Studente data volgens persentasie");
        System.out.println("4 - Bereken die gemiddelde persentasie");
        System.out.println("5 - Eindig die program");

    }

    public static int[] nuweStuNommer(int aantalStudente, int[] stuNommer){

        //Die skikking vir studente nommers word nou geskep met die gegewe aantal studente
        int[] nuweStuNommer = new int[aantalStudente];

        return nuweStuNommer;        
    }

    public static String[] nuweStuNaamOfVeld(int aantalStudente, String[] stuNaamOfVeld){

        //Die skikking vir studente Name of studievelde word nou geskep met die gegewe aantal studente
        String[] nuweStuNaamOfVeld = new String[aantalStudente];

        return nuweStuNaamOfVeld;
    }

    public static double[] nuweStuPersentasie(int aantalStudente, double[] stuPersentasie){

        //Die skikking vir studente persentasies word nou geskep met die gegewe aantal studente
        double[] nuweStuPersentasie = new double[aantalStudente];

        return nuweStuPersentasie;        
    }


    public static boolean geldigeStudentenommer(int[] nommer){

        //Metode om die studente nommer te toets of dit geldig is of nie
        boolean geldig = false;

        if(nommer.length != 8){//Toets die lengte van die nommer

            System.out.println("Studente nommers is net 8 letters lank.");
            geldig = false;
        } else {

            int gewig = 8;
            double somVan = 0;
            for(int i=0; i<nommer.length; i++){//Som die getalle op

                somVan += nommer[i]*gewig;
                gewig--;
            }

            if(somVan%11 == 0){//Toets die modulus vir geldigheid

                geldig = true;
            }

        }

        return geldig;
    }

    public static void vertoonStudenteData(int[] stuNommer, String[] stuNaam, String[] stuStudieveld, double[] stuPersentasie){

        //Metode om die studente se data te vertoon dmv 'n for lus
        for(int i=0; i<stuNommer.length; i++){

            System.out.println(stuNommer[i]+" - "+stuNaam[i]+", "+stuStudieveld[i]+" ("+stuPersentasie[i]+"%)");

        }
    }

    public static void sorteerStudentePersentasie(int[] stuNommer, String[] stuNaam, String[] stuStudieveld, double[] stuPersentasie){

        //Die studente persentasies word nou getoets om dit te rangskik in stygende volgorde
        for(int i=0; i<stuNommer.length -1; i++){ //BubbelSort

            for(int j=0; j<stuNommer.length -1; j++){

                if(stuPersentasie[j]>stuPersentasie[j+1]){

                    //Al die skikkings word hierso gerankskik sodat die parallele skikkings, parallel bly
                    int tempNommer = stuNommer[j];
                    stuNommer[j] = stuNommer[j+1];
                    stuNommer[j+1] = tempNommer;

                    String tempNaam = stuNaam[j];
                    stuNaam[j] = stuNaam[j+1];
                    stuNaam[j+1] = tempNaam;

                    String tempStudieveld = stuStudieveld[j];
                    stuStudieveld[j] = stuStudieveld[j+1];
                    stuStudieveld[j+1] = tempStudieveld;

                    double tempPersentasie = stuPersentasie[j];
                    stuPersentasie[j] = stuPersentasie[j+1];
                    stuPersentasie[j+1] = tempPersentasie;

                }

            }

        }
        System.out.println("");
        System.out.println("Hierop volg die gesorteerde Studentedata, volgens persentasie: (Stygende volgorde)");
        //Die vertoon metode word nou weer opgeroep om die gesorteerde data te vertoon
        vertoonStudenteData(stuNommer, stuNaam, stuStudieveld, stuPersentasie);
    }

    public static double berekenGemiddeldePersentasie(double[] stuPersentasie){

        //Die metode om die graad gemiddeld van al die studente te bereken
        int aantalStudente = stuPersentasie.length;
        double totaleStudenteGemiddelde = 0; //Om die studente se persentasies te som
        double gemiddeldePersentasie = 0; //Veranderlikke wat die gemiddelde persentasie van al die studente gaan behou

        for(int i=0; i<aantalStudente; i++){//For lus om al die skikking se persentasies te som

            totaleStudenteGemiddelde += stuPersentasie[i];
        }
        //Die gemiddeld word nou bereken
        gemiddeldePersentasie = totaleStudenteGemiddelde/aantalStudente;

        return gemiddeldePersentasie;
    }
    
}
