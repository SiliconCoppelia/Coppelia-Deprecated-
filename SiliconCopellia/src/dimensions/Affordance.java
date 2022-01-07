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

    public Affordance() throws Exception {
        this.num = super.readInput();
    }


    public String compare(){
        double i= this.num/0.1;
        return this.affordance[(int)i];
    }
}
