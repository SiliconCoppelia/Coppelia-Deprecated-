package dimensions;

//import java.util.Scanner;

public class Affordance{

    private int[] index;

    private int[] affordanceFeatures;
    private Relevance relvance;
    private Valence[] valences;
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
            "you keep more than 3 pets",
            "you keep my ideal number of pets(1 or 2)"
    };

    public Affordance(int[] affordanceFeatures){
        this.affordanceFeatures=affordanceFeatures.clone();
        //this.relvance=new Relevance[](new double[]{0.8, 0.4, 0.2});
        this.valences=new Valence[3];
    }

    public Valence[] getValences(){
        return this.valences;
    }

    public String[] compare(){
        for(int i = 1; i < index.length; i++){
            switch(index[i]){
                case 1:
                    if(this.affordanceFeatures[0] < 14){
                        realFeatures[i-1]=age[0];
                        this.valences[i-1]=new Valence(0.35-0.02*Math.abs(14-affordanceFeatures[0]));
                    }else if(this.affordanceFeatures[0] < 21){
                        realFeatures[i-1]=age[1];
                        this.valences[i-1]=new Valence(0.7-0.05*Math.abs(21-affordanceFeatures[0]));
                    }else if(this.affordanceFeatures[0]<33){//21-33
                        realFeatures[i-1]=age[2];
                        this.valences[i-1]=new Valence(1-0.05*Math.abs(27-affordanceFeatures[0]));
                    }else if(this.affordanceFeatures[0]<55){
                        realFeatures[i-1]=age[3];
                        this.valences[i-1]=new Valence(0.7-0.02*Math.abs(33-affordanceFeatures[0]));
                    }else {
                        realFeatures[i-1]=age[4];
                        this.valences[i-1]=new Valence(0.26-0.005*Math.abs(55-affordanceFeatures[0]));
                    }

                    break;
                case 2:
                    if(this.affordanceFeatures[1] < 2000){
                        realFeatures[i-1]=assetStatus[0];
                        this.valences[i-1]=new Valence(0.2-0.0001*Math.abs(2000-affordanceFeatures[1]));
                    }else if(this.affordanceFeatures[1] < 5000){
                        realFeatures[i-1]=assetStatus[1];
                        this.valences[i-1]=new Valence(0.4-0.00005*Math.abs(5000-affordanceFeatures[1]));
                    }else if(this.affordanceFeatures[1]<10000){
                        realFeatures[i-1]=assetStatus[2];
                        this.valences[i-1]=new Valence(0.6-0.00004*Math.abs(10000-affordanceFeatures[1]));
                    }else if(this.affordanceFeatures[1]<50000){
                        realFeatures[i-1]=assetStatus[3];
                        this.valences[i-1]=new Valence(0.8-0.000005*Math.abs(50000-affordanceFeatures[1]));
                    }else {
                        realFeatures[i-1]=assetStatus[4];
                        this.valences[i-1]=new Valence(Math.min(1,0.8+0.000005*Math.abs(50000-affordanceFeatures[1])));
                    }

                    break;
                case 3:
                    if(this.affordanceFeatures[2]==0){
                        realFeatures[i-1]=condition[0];
                        this.valences[i-1]=new Valence(0.2);
                    }else if(this.affordanceFeatures[2]>=3) {
                        realFeatures[i-1]=condition[1];
                        this.valences[i-1]=new Valence(Math.max(0.2, 1-0.1*(this.affordanceFeatures[2]-2)));
                    }else{
                        realFeatures[i-1]=condition[2];
                        this.valences[i-1]=new Valence(1);
                    }

                    break;
                default:
                    break;
            }
        }


        return realFeatures;
    }
}

// --------------------------------------------------
