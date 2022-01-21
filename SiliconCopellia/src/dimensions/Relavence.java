package dimensions;

//import java.util.Scanner;

public class Relevance {

    private int index;
    private float num;
    //private String[] rel=new String[]{"cheat on exams","cooking for home"};
    private double[] relevance;

    public Relevance(double[] RELEVANCE){
        this.relevance=RELEVANCE;
    }

    public int[] index(){
        int[] temp=new int[]{0, 2, 3};
        int minIndex=0;
        double minNum=relevance[0];
        for(int i=1; i<3; i++){
            if(relevance[i]<minNum){
                minNum=relevance[i];
                minIndex=i;
            }
        }
        switch(minIndex){
            case 0:
                temp=new int[]{0, 2, 3};
                break;
            case 1:
                temp=new int[]{0, 1, 3};
                break;
            case 2:
                temp=new int[]{0, 1, 2};
                break;
            default:
                break;
        }
        return temp;
    }


}