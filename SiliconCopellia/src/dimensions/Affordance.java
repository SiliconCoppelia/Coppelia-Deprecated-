package dimensions;

import java.util.Scanner;

public class Affordance extends Dimen{

    //private int index;
    public float num;
    private String[] affordance = {
            "very stupid",
            "stupid",
            "a little stupid",
            "kind of dumb",
            "not so smart",
            "smart",
            "intelligent",
            "kind of intelligent",
            "pretty intelligent",
            "very intelligent"};

    public Affordance() throws Exception {
        this.num = super.readInput();
    }


    public String compare(){
        double i= this.num/0.1;
        return this.affordance[(int)i];
    }
}
