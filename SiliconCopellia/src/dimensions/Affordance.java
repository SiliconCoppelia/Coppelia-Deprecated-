package dimensions;

//import java.util.Scanner;

public class Affordance{

    private int[] index;

    private double[] affordanceFeatures;
    private double[] relvance;
    private String[] realFeatures=new String[2];
    //private String[] affordance = {};
    private String[] age=new String[]{
            "you are a child",
            "you are an adolescent",
            "young",
            "mature",
            "old"
    };

    private String[] assetStatus=new String[]{
            "poor",
            "relatively poor",
            "not wealthy but not poor as well",
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
            "you have no pets",
            "you keep pets"
    };

    public Affordance(int[] index, double[] affordanceFeatures){
        this.index=index.clone();
        this.affordanceFeatures=affordanceFeatures.clone();

    }

    public String[] compare(){


        for(int i = 1; i < index.length; i++){
            switch(index[i]){
                case 1:
                    if(this.affordanceFeatures[0] < 14){
                        realFeatures[i-1]=age[0];
                    }else if(this.affordanceFeatures[0] < 21){
                        realFeatures[i-1]=age[1];
                    }else if(this.affordanceFeatures[0]<33){
                        realFeatures[i-1]=age[2];
                    }else if(this.affordanceFeatures[0]<55){
                        realFeatures[i-1]=age[3];
                    }else {
                        realFeatures[i-1]=age[4];
                    }

                    break;
                case 2:
                    if(this.affordanceFeatures[1] < 2000){
                        realFeatures[i-1]=assetStatus[0];
                    }else if(this.affordanceFeatures[1] < 5000){

                        realFeatures[i-1]=assetStatus[1];
                    }else if(this.affordanceFeatures[1]<10000){
                        realFeatures[i-1]=assetStatus[2];
                    }else if(this.affordanceFeatures[1]<50000){
                        realFeatures[i-1]=assetStatus[3];
                    }else {
                        realFeatures[i-1]=assetStatus[4];
                    }

                    break;
                case 3:

                    if(this.affordanceFeatures[2]==0){
                        realFeatures[i-1]=condition[0];
                    }else{
                        realFeatures[i-1]=condition[1];
                    }

                    break;
            }
        }


        return realFeatures;
    }
}

// --------------------------------------------------
