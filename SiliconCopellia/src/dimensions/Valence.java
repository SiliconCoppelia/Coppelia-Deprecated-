package dimensions;

//import java.util.Scanner;

public class Valence<String> {

    private int index;
    private double num;
    private int[] rel_index;
    private double[] val;
    private double[] rel;
    private String[] valence = {
            "I am certain that I can help you",
            "I have positive expectations in helping you",
            "I have negative expectations in helping you",
            "I am certain that I cannot help you"
            };

    public Valence(int[] index,  double[] Relevance, double[] VALENCE){
        this.rel_index=index;
        this.val=VALENCE;
        this.rel=Relevance;
        this.num=(this.rel[this.rel_index[0]]*this.val[0]+
                 this.rel[this.rel_index[1]]*this.val[1]+
                 this.rel[this.rel_index[2]]*this.val[2])/3;
    }

    public double getValence(){
        return this.num;
    }

    public String compare(){
        if(this.num < -0.5) this.index = 3;
        else if (this.num < 0) this.index = 2;
        else if (this.num < 0.5) this.index = 1;
        else  this.index = 0;

        return this.valence[this.index];
    }
}
