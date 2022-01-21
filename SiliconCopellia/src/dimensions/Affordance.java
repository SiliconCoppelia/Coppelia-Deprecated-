package dimensions;

//import java.util.Scanner;

public class Affordance{

    private int[] index=new int[2];
    private double[] affordanceFeatures;
    private double[] relvance;
    private String[] realFeatures=new String[2];
    //private String[] affordance = {};
    private String[] age=new String[]{
            "child",
            "adolescent",
            "young",
            "mature",
            "old"
    };

    private String[] assetStatus=new String[]{
            "poor",
            "relatively poor",
            "average",
            "relatively wealthy",
            "wealthy"
    };

    /* it may conflict with aesthetic (TBD)
    private String[] attractiveness=new String[]{
            "ugly",
            "unsightly",
            "average",
            "attractive",
            "beautiful"
    };*/

    private String[] condition=new String[]{
            "have not pet",
            "keep pets"
    };

    public Affordance(double[] relvance, double[] affordanceFeatures){
        this.relvance=relvance.clone();
        this.affordanceFeatures=affordanceFeatures.clone();

    }

    public String[] compare(){


        for(int i = 1; i < index.length; i++){
            switch(index[i]){
                case 1:
                    if(this.affordanceFeatures[0] < 14){
                        this.index[i-1] = 0;
                    }else if(this.affordanceFeatures[0] < 21){
                        this.index[i-1] = 1;
                    }else if(this.affordanceFeatures[0]<33){
                        this.index[i-1] = 2;
                    }else if(this.affordanceFeatures[0]<55){
                        this.index[i-1] = 3;
                    }else {
                        this.index[i-1] = 4;
                    }
                    break;
                case 2:
                    if(this.affordanceFeatures[1] < 2000){
                        this.index[i-1] = 0;
                    }else if(this.affordanceFeatures[1] < 5000){
                        this.index[i-1] = 1;
                    }else if(this.affordanceFeatures[1]<10000){
                        this.index[i-1] = 2;
                    }else if(this.affordanceFeatures[1]<50000){
                        this.index[i-1] = 3;
                    }else {
                        this.index[i-1] = 4;
                    }
                    break;
                case 3:
                    // set what value??? please update when noticing this message
                    if(this.affordanceFeatures[1]==0){
                        this.index[i-1]=0;
                    }else{
                        this.index[i-1]=1;
                    }
                    break;
            }
        }

        realFeatures[0]=age[this.index[0]];
        realFeatures[1]=assetStatus[this.index[1]];

        return realFeatures;
    }
}

// --------------------------------------------------







