package dimensions;

//import java.util.Scanner;

/**
 * @Author: Anthony
 * @Date: 01/07/2022
 * @Description:
 */
public class Ethics{

    private int index;
    private double num;
    private String[] ethics = {"very bad","bad","little bad","little good","good","very good"};

    public Ethics(double ETHICS){
        num=ETHICS;
    }


    public String compare() {
        if(this.num < 0.1){
            this.index = 0;
        }
        else if(this.num < 0.3){
            this.index = 1;
        }else if(this.num<0.5){
            this.index = 2;
        }else if(this.num<0.7){
            this.index = 3;
        }else if(this.num<0.9){
            this.index = 4;
        }else{
            this.index = 5;
        }
        return ethics[this.index];
    }


}
