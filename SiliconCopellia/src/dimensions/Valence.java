package dimensions;

//import java.util.Scanner;

public class Valence{

    private int[] valOfFeatures = new int[3];
    private int[] affordanceFeatures;

    public Valence(int[] affordanceFeatures){
        this.affordanceFeatures=affordanceFeatures;
    }

    public int[] ValOfFeatures(){
        for(int i = 0; i < this.affordanceFeatures.length; i++){
            switch (i){
                case 0:
                    if(this.affordanceFeatures[i] < 14 || this.affordanceFeatures[i] > 55) valOfFeatures[i] = -1;
                    else if(this.affordanceFeatures[i] > 14 && this.affordanceFeatures[i] < 21) valOfFeatures[i] = 1;
                    else if(this.affordanceFeatures[i] > 21 && this.affordanceFeatures[i] < 33) valOfFeatures[i] = 2;
                    else if(this.affordanceFeatures[i] > 33 && this.affordanceFeatures[i] < 55) valOfFeatures[i] = 1;
                    break;
                case 1:
                    if(this.affordanceFeatures[i] < 2000) valOfFeatures[i] = -1;
                    else if(this.affordanceFeatures[i] < 5000) valOfFeatures[i] = -1;
                    else if(this.affordanceFeatures[i] < 10000) valOfFeatures[i] = 1;
                    else if(this.affordanceFeatures[i] < 50000) valOfFeatures[i] = 1;
                    else valOfFeatures[i] = 2;
                    break;
                case 2:
                    if(this.affordanceFeatures[i] == 1 || this.affordanceFeatures[i] == 2) valOfFeatures[i] = 2;
                    else valOfFeatures[i] = -1;
                    break;
            }
        }
        return valOfFeatures;
    }
}
