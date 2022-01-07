package dimensions;

import java.util.Scanner;

/**
 * @Author: Anthony
 * @Date: 01/07/2022
 * @Description:
 */
public class Relavance extends Dimen {

    private int index;
    public float num;
    private String[] rel=new String[]{"cheat on exams","cooking for home"};

    public Relavance(){
        this.num=readInput();
    }
    @Override
    public String compare() {
        if(this.num < 0.5){
            this.index = 1;
        } else {
            this.index=0;
        }

        return rel[this.index];

    }

    @Override
    public float readInput() {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        float num=Float.parseFloat(str);
        scanner.close();
        return num;
    }
}
