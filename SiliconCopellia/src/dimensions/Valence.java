package dimensions;

//import java.util.Scanner;

public class Valence{
    private float ethics;
    private int[] valOfFeatures = new int[4]; // result
    private String[] Level=new String[4];
    private int[] affordanceFeatures; // used in constructor

    public Valence(float ethics, int[] affordanceFeatures){
        this.ethics=ethics;
        this.affordanceFeatures=affordanceFeatures;
    }

    public int[] ValOfFeatures(){ // convert three affordance features to Level represented by integer
        if(ethics<=0.4){
            valOfFeatures[0]=-1;
        }else if(ethics<=0.6){
            valOfFeatures[0]=1;
        }else{
            valOfFeatures[0]=2;
        }

        for(int i = 1; i <= this.affordanceFeatures.length; i++){
            switch (i){
                case 1:
                    if(this.affordanceFeatures[i] < 14 || this.affordanceFeatures[i] > 55) valOfFeatures[i] = -1;
                    else if(this.affordanceFeatures[i] > 14 && this.affordanceFeatures[i] < 21) valOfFeatures[i] = 1;
                    else if(this.affordanceFeatures[i] > 21 && this.affordanceFeatures[i] < 33) valOfFeatures[i] = 2;
                    else if(this.affordanceFeatures[i] > 33 && this.affordanceFeatures[i] < 55) valOfFeatures[i] = 1;
                    break;
                case 2:
                    if(this.affordanceFeatures[i] < 2000) valOfFeatures[i] = -2;
                    else if(this.affordanceFeatures[i] < 5000) valOfFeatures[i] = -1;
                    else if(this.affordanceFeatures[i] < 10000) valOfFeatures[i] = 1;
                    else if(this.affordanceFeatures[i] < 50000) valOfFeatures[i] = 1;
                    else valOfFeatures[i] = 2;
                    break;
                case 3:
                    if(this.affordanceFeatures[i] == 1 || this.affordanceFeatures[i] == 2) valOfFeatures[i] = 2;
                    else valOfFeatures[i] = -1;
                    break;
            }
        }

        return valOfFeatures;
    }

    public String[] getLevel(){

        for(int i=0; i<valOfFeatures.length; i++){
            if(this.affordanceFeatures[i]==-2){
                Level[i]="much worried";
            }else if(this.affordanceFeatures[i]==-1){
                Level[i]="some worried";
            }else if(this.affordanceFeatures[i]==1){
                Level[i]="some hope";
            }else{
                Level[i]="much hope";
            }
        }
        return Level;
    }


}
