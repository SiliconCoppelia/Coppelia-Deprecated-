package dimensions;


import java.util.Scanner;

public abstract class Dimen {
    private float num;
    public abstract String compare();

    public float readInput(){
        Scanner scan = new Scanner(System.in);
        this.num = scan.nextFloat();
        return this.num;
    }
}
