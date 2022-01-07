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
    private String[] rel=new String[]{
            "cheat on exams",
            "cooking for home"
    };

    public Relavance() throws Exception{
        readInput();
    }
    @Override
    public String compare(){
        if(this.num < 0.5){
            this.index = 1;
        } else {
            this.index=0;
        }

        return rel[this.index];

    }

    @Override
    public void readInput() throws Exception{
        System.out.println("Please enter the Relavance value: ");
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
            throw new IllegalArgumentException("The problem occurs in Relavance");
        }
    }
}
