package methode;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {      
        System.out.println("Er is een 4-cijferige code gegenereerd.\n"
                + "Je hebt 10 gokken om de code te raden.\n"
                + "De keuze zijn de cijfers 0 t/m 5");
        System.out.println("---------------------------------------\n");
        int[] random=nummerGenerator();
        int maxGokken=10;
        int correctPlek=0;
        int correctCijfer=0;
        while(maxGokken>0 && correctPlek!=4){
            int[] gok=krijgGok();
            correctPlek=0;
            correctCijfer=0;
            for(int i=0;i<gok.length;i++){
                if(gok[i]==random[i]){
                    correctPlek++;
                }
                else if(gok[i]==random[0] || gok[i]==random[1] || gok[i]==random[2] || gok[i]==random[3]){
                    correctCijfer++;
                }
            }
            if(correctPlek==4){
                System.out.print("Goedzo dit is de juiste code! De code was inderdaad: ");
                for(int i=0;i<gok.length;i++){
                    System.out.print(gok[i]);
                }
            }
            else{
                maxGokken--;
                if(maxGokken>1){
                    System.out.println("Je hebt "+correctPlek+" cijfers op de correcte plaats,"+
                    " en "+correctCijfer+" correcte cijfgers maar op de verkeerde plaats. \n"+maxGokken+" pogingen over.");
                }
                else if(maxGokken==1){
                    System.out.println("Je hebt "+correctPlek+" correcte cijfers op de correcte plaats,"+
                    " en "+correctCijfer+" correcte cijfers op de verkeerde plaats. \nLaatste poging!. Succes");
                }
                else{
                    System.out.println("Helaas is het niet gelukt binnen 10 pogingen");
                    System.out.print("De goede code was: ");
                    for(int i=0;i<random.length;i++){
                        System.out.print(random[i]);
                }
            }
        }
    }   
}

public static int[] krijgGok(){
    Scanner codeInput = new Scanner(System.in);
    System.out.println("Wat is de code? ");
    String input = codeInput.nextLine();
        if(input.length()!=4 || input.replaceAll("\\D","").length()!=4){
            System.out.println("Dit is niet correct, alleen nummers 0-5 kunnen ingevoerd worden");
            return krijgGok();
    }
    int[] gok = new int[4];
    for (int i = 0; i < 4; i++) {
        gok[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
    }
    return gok;
}

public static int[] nummerGenerator() {
    Random rand = new Random();
    int[] randArray = {6,6,6,6};

    for(int i=0;i<randArray.length;i++){
        int code = rand.nextInt(5);
        while(code == randArray[0] || 
        		  code == randArray[1] || 
        		  code == randArray[2] || 
        		  code == randArray[3])	{
              code=rand.nextInt(5);
        }
        randArray[i]=code;      
    }
    return randArray;
}
}
