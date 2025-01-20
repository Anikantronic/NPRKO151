import java.util.Random;

public class willekeurigeSkikking {

    public static final int hoeveel = 15;

    public static void main(String[] args){

        int[] getalle = new int[hoeveel];

        System.out.println("Die getalle in die willekeurige skikking is:");

        Random willekeurig = new Random();
        int rndGetal = 0;

        for(int i=0; i<hoeveel; i++){

            rndGetal = willekeurig.nextInt(100)+1;
            getalle[i] = rndGetal;
            System.out.println(getalle[i]);

        }


    }

}