package dimensions;

//import java.util.Scanner;

public class Affordance{


    private int[] index;
    private double[] affordanceFeatures;
    private double[] relvance;
    private String[] realFeatures;
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

        if(this.affordanceFeatures[0] < 0.14){
            this.index[0] = 0;
        }else if(this.affordanceFeatures[0] < 0.21){
            this.index[0] = 1;
        }else if(this.affordanceFeatures[0]<0.33){
            this.index[0] = 2;
        }else if(this.affordanceFeatures[0]<0.55){
            this.index[0] = 3;
        }else {
            this.index[0] = 4;
        }


        if(this.affordanceFeatures[1] < 0.2){
            this.index[1] = 0;
        }else if(this.affordanceFeatures[1] < 0.4){
            this.index[1] = 1;
        }else if(this.affordanceFeatures[1]<0.6){
            this.index[1] = 2;
        }else if(this.affordanceFeatures[1]<0.8){
            this.index[1] = 3;
        }else {
            this.index[1] = 4;
        }

        // set what value??? please update when noticing this message
        if(this.affordanceFeatures[1]<0.5){
            this.index[2]=0;
        }else{
            this.index[2]=1;
        }

        realFeatures[0]=age[this.index[0]];
        realFeatures[1]=age[this.index[1]];
        realFeatures[2]=age[this.index[2]];



    }
}
