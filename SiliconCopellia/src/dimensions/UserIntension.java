package dimensions;

import java.util.Scanner;

public class UserIntension extends Dimen{

    private int index;
    public float num;
    private String[] userIntension = {"Let’s do this together!", "Go find someone else"};

    public UserIntension(){
        this.num = readInput();
        //System.out.println(str.append("The input number is: ").append(super.readInput()));    //For Debugging
    }
    @Override
    public float readInput(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        this.num = Float.parseFloat(str);
        scan.close();
        return this.num;
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
