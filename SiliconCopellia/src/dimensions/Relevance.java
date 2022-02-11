package dimensions;

//import java.util.Scanner;
//

public class Relevance {

    private int index;
    private float num;
    private String level;
    //private String[] rel=new String[]{"cheat on exams","cooking for home"};
    private double relevance;

    public Relevance(double RELEVANCE){
        this.relevance=RELEVANCE;
    }


    public String getLevel(){
        if(relevance<=0.25){
            level="very unimportant";
        }else if(relevance<=0.5){
            level="somewhat unimportant";
        }else if(relevance<=0.75){
            level="somewhat important";
        }else{
            level="very important";
        }


        return level;
    }
    /*public int[] top2_index(){
        int[] temp=new int[]{0, 2, 3};
        int minIndex=1;
        double minNum=relevance[1];
        for(int i=2; i<4; i++){
            if(relevance[i]<minNum){
                minNum=relevance[i];
                minIndex=i;
            }
        }
        switch(minIndex){
            case 1:
                temp=new int[]{0, 2, 3};
                break;
            case 2:
                temp=new int[]{0, 1, 3};
                break;
            case 3:
                temp=new int[]{0, 1, 2};
                break;
            default:
                break;
        }
        return temp;
    }*/


}