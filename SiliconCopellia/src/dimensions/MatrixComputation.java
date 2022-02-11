package dimensions;
import java.util.Scanner;

public class MatrixComputation {
    private int m,n;
    private double[][] arr;

    public MatrixComputation(int m,int n, double[][]a){ //m row; n column
        this.m=m;
        this.n=n;
        this.arr=a;
    }

    public double[][] getArr() {
        return arr;
    }

    public int getRow() {
        return this.m;
    }

    public int getColumn() {
        return this.n;
    }

/*
    public void display()
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("-----"+arr.length+"*"+arr[0].length);
    }
*/



    public static double[][] multiple(MatrixComputation a,MatrixComputation b){
        if(a.getColumn()!=b.getRow())
            System.out.print("Error! "+ a.getColumn() + " is not equal to " + b.getRow());

        double[][] end=new double[a.getRow()][b.getColumn()];

        int num;

        //int count=0;
        for(int c=0; c<b.getColumn(); c++){
            for(int i=0; i<a.getRow(); i++){
                num=0;
                for(int j=0; j<b.getRow(); j++) {
                    num+=a.getArr()[i][j]*b.getArr()[j][c];
                    //System.out.println("-----"+"["+i+","+j+"] "+c+"/// "+num);
                }
                end[i][c]=num;
            }
            //System.out.println("--跳出循环后的i,j---"+"["+i+","+j+"]"+c+"### ");
        }
        return end;
    }
}
