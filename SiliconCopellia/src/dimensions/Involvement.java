package dimensions;

import java.util.Scanner;

/**
 * @Author: Anthony
 * @Date: 01/07/2022
 * @Description:
 */
public class Involvement extends Dimen{

    private int index;
    public float num;
    private String[] invl =new String[]{"I like you so much", "You are fun to be with","I feel close to you","I want to be friends with you"};

    public Involvement(){
        this.num=readInput();
    }


    @Override
    public float readInput() {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        float num=Float.parseFloat(str);
        scanner.close();
        return num;
    }
    @Override
    public String compare() {
        if(this.num < 0.25){
            this.index = 3;
        } else if(this.num<0.5){
            this.index = 2;
        }else if(this.num<0.75){
            this.index = 1;
        }else{
            this.index = 0;
        }
        return this.invl[this.index];

    }
}
