import dimensions.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;

import static java.lang.Integer.parseInt;

public class Concatenate {

    private static Scanner scan = new Scanner(System.in);

    private static double ETHICS;
    private static int[] affordanceFeatures = new int[3];
    //private static double[] RELEVANCE = new double[4];      /* form: [eth, affF1, affF2, affF3] */
    //private static double[] VALENCE = new double[4];        /* form: [eth, affF1, affF2, affF3] */
    //private static double INVOLVEMENT;
    //private static double DISTANCE;
    //private static double USR_INTENTION;
    private static int num = 0;
    private static int index = 0;

    private static StringBuffer sent = new StringBuffer("You are ");

    public static void main(String[] args) throws Exception {

        // Step 1: greetings from Coppélia
        greetings();

        // Step 2: self-introduction from the agent
        usrIntro();

        // Step 3: Create all object and pass parameters for processing
        Affordance aff = new Affordance(affordanceFeatures);
        Valence val = new Valence(affordanceFeatures);

        // Step 4: Sentence formulation
        sentenceFormulation(aff, val);
        System.out.println(sent.toString());

        System.exit(0);
    }

    private static void greetings() throws Exception{
        System.out.println("Hi, I'm Coppélia.\nI want to go on a date with you.\n");

        // Currently analyze the agent by prompting self-introduction
    }

    private static void usrIntro(){

        JFrame jFrame = new JFrame(); // https://www.delftstack.com/howto/java/java-pop-up-window/
        affordanceFeatures[0] = parseInt(JOptionPane.showInputDialog(jFrame, "What is your age?"));
        affordanceFeatures[1] = parseInt(JOptionPane.showInputDialog(jFrame, "What is your monthly income?"));
        affordanceFeatures[2] = parseInt(JOptionPane.showInputDialog(jFrame, "How many pets do you have?"));
        /*
        System.out.println(getMessage);
        for(int i = 0; i < affordanceFeatures.length; i++){
            System.out.println(affordanceFeatures[i]);
        }
        */
    }

    private static void sentenceFormulation(Affordance aff, Valence val){
        countPos(val);
        if(num == 3){
            sent.append("not only ").append(aff.compare()[0]).append(" and ").append(aff.compare()[1]).append(" but also keeping ");
            if(affordanceFeatures[2] == 1) sent.append(String.valueOf(affordanceFeatures[2])).append(" pet.");
            else sent.append(String.valueOf(affordanceFeatures[2])).append(" pets.");
        }
        else if(num == 0){
            sent.append(aff.compare()[0]).append(", ").append(aff.compare()[1]);
            //System.out.print(affordanceFeatures[2]); // For debugging
            if(affordanceFeatures[2] == 0) sent.append(", and you don't keep pets.");
            else sent.append(", and you keep ").append(String.valueOf(affordanceFeatures[2])).append(" pets");
        }
        else if(num == 2){
            if(negIndex(val) == 0){
                sent.append(aff.compare()[1]).append(" and you keep ");
                if(affordanceFeatures[2] == 1) sent.append(String.valueOf(affordanceFeatures[2])).append(" pet");
                else sent.append(String.valueOf(affordanceFeatures[2])).append(" pets");
                sent.append(" but you are ").append(aff.compare()[0]);
            }
            else if(negIndex(val) == 1){
                sent.append(aff.compare()[0]).append(" and you keep ");
                if(affordanceFeatures[2] == 1) sent.append(String.valueOf(affordanceFeatures[2])).append(" pet");
                else sent.append(String.valueOf(affordanceFeatures[2])).append(" pets");
                sent.append(" but you are ").append(aff.compare()[1]);
            }
            else if(negIndex(val) == 2){
                sent.append(aff.compare()[0]).append(" and ").append(aff.compare()[1]).append(" but you ");
                if(affordanceFeatures[2] == 0) sent.append("don't keep pets");
                else sent.append("keep ").append(String.valueOf(affordanceFeatures[2])).append(" pets");
            }
        }
        else if(num == 1){
            if(posIndex(val) == 0){
                
            }
        }
    }

    private static int countPos(Valence val){
        for(int i = 0; i < val.ValOfFeatures().length; i++){
            if(val.ValOfFeatures()[i] > 0) num++;
        }
        //System.out.print(num); System.out.println("\n"); // For debugging
        return num;
    }

    private static int posIndex(Valence val){
        for(int i = 0; i < val.ValOfFeatures().length; i++){
            if(val.ValOfFeatures()[i] > 0) index = i;
        }

        return index;
    }
    private static int negIndex(Valence val){
        for(int i = 0; i < val.ValOfFeatures().length; i++){
            if(val.ValOfFeatures()[i] < 0) index = i;
        }
        //System.out.print(index); //For debugging

        return index;
    }
}
