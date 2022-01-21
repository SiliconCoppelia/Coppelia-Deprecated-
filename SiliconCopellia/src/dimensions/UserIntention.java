package dimensions;

//import java.util.Scanner;

public class UserIntention{

    private int index;
    private double num;
    private double valenceNum;

    private final String[] useIntentionPositive = {"I will invite you to go on a date with me.",
            "I want to invite you on a date.",
            "I will actively arrange a date with you.",
            "I desperately want to date you."};
    private final String[] useIntentionNegative = {"Maybe we could do something else together.",
            "I have reservations about dating you.",
            "I somewhat refuse to date you.",
            "I'll have to refuse you directly in arranging a date with you."};

    public UserIntention(double num, double valenceNum){
        this.num = num;
        this.valenceNum = valenceNum;
        //System.out.println(str.append("The input number is: ").append(super.readInput()));    //For Debugging
    }


    public String compare(){
        double i = 0.25;
        while(i < this.num){
            i = i + 0.25;
        }
        if(i <= 0.25) this.index = 0;
        else if(i <= 0.5) this.index = 1;
        else if(i <= 0.75) this.index = 2;
        else if(i <= 1) this.index = 3;

        if(this.valenceNum > 0){
            return this.useIntentionPositive[this.index];
        }
        else{
            return this.useIntentionNegative[this.index];
        }
    }
}
