package dimensions;

//import java.util.Scanner;

public class Valence{

    private int index;
    private float num;
    private String[] affordance = {
            "I am certain that I can help you",
            "I have positive expectations in helping you",
            "I have negative expectations in helping you",
            "I am certain that I cannot help you"
            };

    public Valence(double[] RELEVANCE,  VALENCE){

    }
    public String compare(){
        if(this.num < 0.25) this.index = 3;
        else if (this.num < 0.5) this.index = 2;
        else if (this.num < 0.75) this.index = 1;
        else  this.index = 0;

        return this.affordance[this.index];
    }
}
