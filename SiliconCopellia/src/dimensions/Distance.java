package dimensions;

//import java.util.Scanner;

public class Distance{
    private int index;
    public float num;
    private String[] affordance = {
            "I extremely have reservations about you",
            "I have much resevations about you",
            "I have reservations about you",
            "I somewhat have reservations about you",
            "I hardly have reservations about you"
    };

    public Distance(double DISTANCE){

    }



    public String compare(){
        if(this.num < 0.2 && this.num >= 0) this.index = 4;
        else if (this.num < 0.4 && this.num >= 0.2) this.index = 3;
        else if (this.num < 0.6 && this.num >= 0.4) this.index = 2;
        else if (this.num < 0.8 && this.num >= 0.6) this.index = 1;
        else  this.index = 0;

        return this.affordance[this.index];
    }
}
