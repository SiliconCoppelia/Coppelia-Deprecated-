import dimensions.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;

import static java.lang.Integer.parseInt;

public class Concatenate {

    private static Scanner scan = new Scanner(System.in);

    private static double ETHICS;
    private static int[] affordanceFeatures = new int[3];
    private static double[] RELEVANCE = new double[4];      /* form: [eth, affF1, affF2, affF3] */
    private static double[] VALENCE = new double[4];        /* form: [eth, affF1, affF2, affF3] */
    private static double INVOLVEMENT;
    private static double DISTANCE;
    private static double USR_INTENTION;

    private static StringBuffer sent = new StringBuffer("You are ");

    public static void main(String[] args) throws Exception {

        // Step 1: greetings from Coppélia
        greetings();

        // Step 2: self-introduction from the agent
        usrIntro();

        // Step 3: Create all object and pass parameters for processing
        Affordance aff = new Affordance(affordanceFeatures);
        Relevance rel = new Relevance(affordanceFeatures);

        // Step 4: Sentence formulation
        sentenceFormulation(aff, rel);
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

    private static void sentenceFormulation(Affordance aff, Relevance rel){
        if(countPos(rel) == 3){
            sent.append("not only ").append(aff.compare()[0]).append(" and ").append(aff.compare()[1]).append(" but also you have ");
            if(affordanceFeatures[2] == 1) sent.append(String.valueOf(affordanceFeatures[2])).append(" pet");
            else sent.append(String.valueOf(affordanceFeatures[2])).append(" pets");
        }
        else if(countPos(rel) == 0){}
        else if(countPos(rel) == 2){}
        else if(countPos(rel) == 1){}
    }

    private static int countPos(Relevance rel){
        int num = 0;
        for(int i = 0; i < rel.RelOfFeatures().length; i++){
            if(rel.RelOfFeatures()[i] > 0) num++;
        }
        //System.out.print(num); // For debugging
        return num;
    }
}
