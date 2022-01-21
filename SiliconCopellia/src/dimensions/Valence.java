package dimensions;

//import java.util.Scanner;

public class Valence{

    private int index;
    private double num;
    private int[] rel_index;
    private double[] valence;
    private String[] affordance = {
            "I am certain that I can help you",
            "I have positive expectations in helping you",
            "I have negative expectations in helping you",
            "I am certain that I cannot help you"
            };

    public Valence(int[] index,  double[] VALENCE){
        this.rel_index=index;
        this.valence=VALENCE;
        this.num=(this.rel_index[0]*this.valence[0]+
                 this.rel_index[1]*this.valence[1]+
                 this.rel_index[2]*this.valence[2]+
                 this.rel_index[3]*this.valence[3])/4;
    }

    public double getValence(){
        return this.num;
    }

    public String compare(){
        if(this.num < -0.5) this.index = 3;
        else if (this.num < 0) this.index = 2;
        else if (this.num < 0.5) this.index = 1;
        else  this.index = 0;

        return this.affordance[this.index];
    }
}
