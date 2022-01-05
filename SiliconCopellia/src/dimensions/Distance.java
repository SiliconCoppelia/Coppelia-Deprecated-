package dimensions;

import java.util.Scanner;

public class Distance {
    private int index;
    public float num;
    private String[] affordance = {
            "You are weird.",
            "You make me feel uneasy and nervous",
            "Sometimes you give me feelings of discomfort.",
            "I don't really like you.",
            "You are not my friend"
    };

    public Distance(){
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
        if(this.num < 0.2 && this.num >= 0) this.index = 0;
        else if (this.num < 0.4 && this.num >= 0.2) this.index = 1;
        else if (this.num < 0.6 && this.num >= 0.4) this.index = 2;
        else if (this.num < 0.8 && this.num >= 0.6) this.index = 3;
        else  this.index = 4;

        return this.affordance[this.index];
    }
}
