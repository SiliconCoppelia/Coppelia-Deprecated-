package dimensions;

import java.util.Scanner;

public class Affordance extends Dimen{

    private int index;
    public float num;
    private String[] affordance = {
            "Very Stupid",
            "Stupid",
            "A little Stupid",
            "Kind of dumb",
            "Not so Smart",
            "Smart",
            "Intelligent",
            "Kind of Intelligent",
            "Pretty intelligent",
            "Very Intelligent"
    };

    public Affordance() throws Exception{
        readInput();
    }

    public void readInput() throws Exception{
        System.out.println("Please enter the Affordance value: ");
        try{
            Scanner scanner = new Scanner(System.in);

            this.num = scanner.nextFloat();
            scanner.close();
            /*
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        float num=Float.parseFloat(str);
        scanner.close();*/
        }catch (Exception e){
            throw new IllegalArgumentException("The problem occurs in Affordance");
        }


    }

    public String compare(){
        if(this.num < 0.1 && this.num >= 0) this.index = 0;
        else if (this.num < 0.2 ) this.index = 1;
        else if (this.num < 0.3 ) this.index = 2;
        else if (this.num < 0.4 ) this.index = 3;
        else if (this.num < 0.5 ) this.index = 4;
        else if (this.num < 0.6 ) this.index = 5;
        else if (this.num < 0.7 ) this.index = 6;
        else if (this.num < 0.8 ) this.index = 7;
        else if (this.num < 0.9 ) this.index = 8;
        else  this.index = 9;

        return this.affordance[this.index];
    }
}
