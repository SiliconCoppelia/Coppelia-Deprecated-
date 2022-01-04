package dimensions;

import java.util.Scanner;

public abstract class Dimen {
    public int num;
    public void readInput(String[] args){
        Scanner scan = new Scanner(System.in);
        this.num = scan.nextInt();
        scan.close();
    }

    public abstract String compare();
}
