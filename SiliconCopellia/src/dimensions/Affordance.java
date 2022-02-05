package dimensions;

//import java.util.Scanner;

public class Affordance{

    private int[] affordanceFeatures;
    private String[] features = new String[2];
    private String[] age = new String[]{
            "you are a child",
            "you are an adolescent",
            "young",
            "mature",
            "old"
    };
    private String[] monthlyIncome = new String[]{
            "poor",
            "relatively poor",
            "well-off",
            "relatively wealthy",
            "wealthy"
    };

    public Affordance(int[] affordanceFeatures){
        this.affordanceFeatures=affordanceFeatures;
    }

    public String[] compare(){
        for(int i = 0; i < this.affordanceFeatures.length - 1; i++){
            switch (i){
                case 0:
                    if(this.affordanceFeatures[i] < 14) features[i] = age [0];
                    else if(this.affordanceFeatures[i] < 21) features[i] = age [1];
                    else if(this.affordanceFeatures[i] < 33) features[i] = age [2];
                    else if(this.affordanceFeatures[i] < 55) features[i] = age [3];
                    else features[i] = age [4];
                    break;
                case 1:
                    if(this.affordanceFeatures[i] < 2000) features[i] = monthlyIncome [0];
                    else if(this.affordanceFeatures[i] < 5000) features[i] = monthlyIncome [1];
                    else if(this.affordanceFeatures[i] < 10000) features[i] = monthlyIncome [2];
                    else if(this.affordanceFeatures[i] < 50000) features[i] = monthlyIncome [3];
                    else features[i] = monthlyIncome [4];
                    break;
            }
        }
        return features;
    }
}

// --------------------------------------------------
