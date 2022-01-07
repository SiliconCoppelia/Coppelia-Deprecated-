package dimensions;

import java.util.Scanner;

public class UserIntension extends Dimen{

    private int index;
    public float num;
    private String[] userIntension = {"Let’s do this together!", "Go find someone else"};

    public UserIntension() throws Exception{
        this.num = super.readInput();
        //System.out.println(str.append("The input number is: ").append(super.readInput()));    //For Debugging
    }

    
    @Override
    public String compare(){
        if(this.num < 0.5){
            this.index = 1;
        }
        else if(this.num >= 0.5){
            this.index = 0;
        }
        return this.userIntension[this.index];
    }
}
