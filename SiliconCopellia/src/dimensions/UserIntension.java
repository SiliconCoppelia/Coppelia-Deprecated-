package dimensions;

import java.util.Scanner;

public class UserIntension extends Dimen{

    private int index;
    public float num;
    private String[] userIntension = {
            "Let’s do this together!",
            "Go find someone else"
    };

    public UserIntension() throws Exception{
        readInput();
        //System.out.println(str.append("The input number is: ").append(super.readInput()));    //For Debugging
    }
    @Override
    public void readInput() throws Exception{
        System.out.println("Please enter the UserIntension value: ");
        try{
            Scanner scanner=new Scanner(System.in);
            this.num=scanner.nextFloat();
            scanner.close();
            /*
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        float num=Float.parseFloat(str);
        scanner.close();*/
        }catch (Exception e){
            throw new IllegalArgumentException("The problem occurs in UserIntension");
        }
    }

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
