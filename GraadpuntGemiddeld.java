import java.util.Scanner;

public class GraadpuntGemiddeld {

    public static Scanner invoer = new Scanner(System.in); //Scanner

    enum Grade {

        A(4.0),B(3.0),C(2.0),D(1.0),F(0.0); //My enumerasies

        private final double punt; //Die waarde variable vir elke enumerasie

        Grade(double punt){ //Gee elke enumerasie die waarde variable

            this.punt = punt;
        }

        private double kryPunt(){ //Sodat ek die punt waarde vir elke enumerasie kan gebruik in die berekening

            return punt;
        }

    }
    public static void main(String[] args){

        double gradeTotaal = 0, gradeGemiddeld = 0, aantalStudente = 0; //Die drie veranderlikes wat ek gaan gebruik
        //gradeTotaal-die som van al die studnete se grade, gradeGemiddeld-dit wat ek wil bereken, aantalStudente- Totale aantal Studente

        System.out.println("Voer die aantal Studente wat elke graad ontvang het in:");

        try { //Om seker te maak dat die invoer net getalle is, en nie letters nie

            for(Grade gemiddeld : Grade.values()){ //Lus om deur al die enumerasies te gaan

                System.out.print("Aantal studente wat 'n "+gemiddeld.name()+"("+gemiddeld.kryPunt()+") gekry het: ");
                int hoeveelheid = invoer.nextInt(); //Ontvang die hoeveelheid studente vir elke graadpunt
                invoer.nextLine();
    
                aantalStudente += hoeveelheid; //Som al die studente
                gradeTotaal += hoeveelheid*gemiddeld.kryPunt(); //Som van (Graadpunt x aantal Studente)
    
            }
    
            gradeGemiddeld = gradeTotaal/ aantalStudente; //Wat ek wil bereken, soos gegee
    
            System.out.println("Die Graad Punt Gemiddeld(GPA) is: "+gradeGemiddeld); //Uitvoer
    
            
        } catch (Exception e) { //Boodskap om die gebruiker te laat weet van sy fout.
            
            System.out.println("Voer asb net getalle in, nie letters nie.");
        }
        
    }

}