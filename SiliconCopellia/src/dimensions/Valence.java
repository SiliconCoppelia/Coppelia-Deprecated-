package dimensions;

import java.util.Scanner;

public class Valence extends Dimen{

    private int index;
    public float num;
    private String[] affordance = {
            "I am certain that I can help you",
            "I have positive expectations in helping you",
            "I have negative expectations in helping you",
            "I am certain that I cannot help you"
    };

    public Valence() throws Exception{
         readInput();
    }

    public void readInput() throws Exception {
        System.out.println("Please enter the Valence value: ");
        try{
            Scanner scanner=new Scanner(System.in);
            this.num=scanner.nextFloat();
            scanner.close();
            /*
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        float num=Float.parseFloat(str);
        scanner.close();*/
        }catch (Exception e){
            throw new IllegalArgumentException("The problem occurs in Valence");
        }
    }

    public String compare(){
        if(this.num < 0.25 && this.num >= 0) this.index = 0;
        else if (this.num < 0.5 && this.num >= 0.25) this.index = 1;
        else if (this.num < 0.75 && this.num >= 0.5) this.index = 2;
        else  this.index = 3;

        return this.affordance[this.index];
    }
}
