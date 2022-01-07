package dimensions;

import java.util.Scanner;

/**
 * @Author: Anthony
 * @Date: 01/07/2022
 * @Description:
 */
public class Ethics extends Dimen {

    private int index;
    public float num;
    private String[] ethics = {
            "very bad",
            "bad",
            "little bad",
            "little good",
            "good",
            "very good"
    };


    public Ethics() throws Exception{
        readInput();
    }

    public void readInput() throws Exception{
        System.out.println("Please enter the Ethics value: ");
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
            throw new IllegalArgumentException("The problem occurs in Ethics");
        }

    }

    @Override
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
