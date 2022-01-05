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
            "Very Intelligent",
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
        if(this.num < 0.1 && this.num >= 0) this.index = 0;
        else if (this.num < 0.2 && this.num >= 0.1) this.index = 1;
        else if (this.num < 0.3 && this.num >= 0.2) this.index = 2;
        else if (this.num < 0.4 && this.num >= 0.3) this.index = 3;
        else if (this.num < 0.5 && this.num >= 0.4) this.index = 4;
        else if (this.num < 0.6 && this.num >= 0.5) this.index = 5;
        else if (this.num < 0.7 && this.num >= 0.6) this.index = 6;
        else if (this.num < 0.8 && this.num >= 0.7) this.index = 7;
        else if (this.num < 0.9 && this.num >= 0.8) this.index = 8;
        else  this.index = 9;

        return this.affordance[this.index];
    }
}
