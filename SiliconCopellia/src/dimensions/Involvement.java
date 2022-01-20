package dimensions;

import java.util.Scanner;

/**
 * @Author: Anthony, Yooki
 * @Date: 01/07/2022
 * @Description:
 */
public class Involvement extends Dimen{

    private int index;
    public float num;
    private String[] invl =new String[]{
        "I feel you as my extremely friend.",
        "I feel you as my close friend.",
        "I feel you as my friend.",
        "I somewhat feel you as my friend.",
        "I can hardly feel you as my friend."};

    public Involvement() throws Exception{
        this.num=super.readInput();
    }

    @Override
    public String compare() {
        if(this.num < 0.2) this.index = 0; 
        else if(this.num<0.4) this.index = 1;
        else if(this.num<0.6) this.index = 2;
        else if(this.num<0.8) this.index = 3;
        else this.index = 4;
        return this.invl[this.index];

    }
}
