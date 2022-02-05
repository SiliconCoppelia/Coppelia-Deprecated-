package dimensions;

//import java.util.Scanner;

public class Valence{

    private int index;
    public double num;
    private int[] rel_index;
    private double val;
    private double[] rel;
    private String[] valence = {
            "I am certain that I can fulfill your goal",
            "I have positive expectations in fulfilling your goal",
            "I have negative expectations in fulfilling your goal",
            "I am certain that I cannot help you with your goal"
            };

    /*
    public Valence(int[] index,  double[] Relevance, double[] VALENCE){
        this.rel_index=index;
        this.val=VALENCE;
        this.rel=Relevance;
        this.num=(this.rel[this.rel_index[0]]*this.val[0]+
                 this.rel[this.rel_index[1]]*this.val[1]+
                 this.rel[this.rel_index[2]]*this.val[2])/3;
    }*/
    public Valence(double VALENCE){
        this.val=VALENCE;
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
