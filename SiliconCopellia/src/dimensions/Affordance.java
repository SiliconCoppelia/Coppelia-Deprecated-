package dimensions;

import java.util.Scanner;

public class Affordance extends Dimen{

    //private int index;
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
            "Very Intelligent"};

    public Affordance(){
        this.num = readInput();
    }

    public float readInput(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        this.num = Float.parseFloat(str);
        scan.close();
        return this.num;
    }

    public String compare(){
        double i= this.num/0.1;
        return this.affordance[(int)i];
    }
}
