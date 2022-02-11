import dimensions.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Concatenate {

    private static Scanner scan = new Scanner(System.in);

    private static float ETHICS;
    private static int[] affordanceFeatures = new int[3];
    //private static double[] RELEVANCE = new double[4];      /* form: [eth, affF1, affF2, affF3] */
    //private static double[] VALENCE = new double[4];        /* form: [eth, affF1, affF2, affF3] */
    //private static double INVOLVEMENT;
    //private static double DISTANCE;
    //private static double USR_INTENTION;
    private static int num = 0;
    private static int index = 0;
    private static String[] valence = {"Your age", "Your income status", "The number of pets you have"};

    private static StringBuffer sent1 = new StringBuffer("You are ");   // Ethics and Affordances
    private static StringBuffer sent2 = new StringBuffer("");           // Relevance: What is important and what is not
    private static StringBuffer sent3 = new StringBuffer("\n");         // Valence: hope/fear a pos/neg outcome

    public static void main(String[] args) throws Exception {

        // Step 1: greetings from Coppélia
        greetings();

        // Step 2: self-introduction from the agent
        usrIntro();

        // Step 3: Create all object and pass parameters for processing
        Random rd = new Random(); ETHICS = rd.nextFloat(); // Random Ethics
        Ethics eth = new Ethics(ETHICS);
        Affordance aff = new Affordance(affordanceFeatures);
        Valence val = new Valence(affordanceFeatures);
        // feature-1: ethics   feature-2: age  feature-3: income  feature-4: pet
        // For Users: All relevance can be changed here
        Relevance[] rel = {new Relevance(0.657), new Relevance(0.9), new Relevance(0.312), new Relevance(0.76)};

        // Step 4: sentence formulation
        System.out.println(eth.compare());
        sentenceFormulation(aff, val);
        System.out.println(sent1.toString());

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
            sent1.append("not only ").append(aff.compare()[0]).append(" and ").append(aff.compare()[1]).append(" but also keeping ");
            if(affordanceFeatures[2] == 1) sent1.append(String.valueOf(affordanceFeatures[2])).append(" pet.");
            else sent1.append(String.valueOf(affordanceFeatures[2])).append(" pets.");

            // sent3
            sent3.append("Not only ");
        }
        else if(num == 0){
            sent1.append(aff.compare()[0]).append(", ").append(aff.compare()[1]);
            //System.out.print(affordanceFeatures[2]); // For debugging
            if(affordanceFeatures[2] == 0) sent1.append(", and you don't keep pets.");
            else sent1.append(", and you keep ").append(String.valueOf(affordanceFeatures[2])).append(" pets");
        }
        else if(num == 2){
            if(negIndex(val) == 0){
                sent1.append(aff.compare()[1]).append(" and you keep ");
                if(affordanceFeatures[2] == 1) sent1.append(String.valueOf(affordanceFeatures[2])).append(" pet");
                else sent1.append(String.valueOf(affordanceFeatures[2])).append(" pets");
                sent1.append(" but you are ").append(aff.compare()[0]);
            }
            else if(negIndex(val) == 1){
                sent1.append(aff.compare()[0]).append(" and you keep ");
                if(affordanceFeatures[2] == 1) sent1.append(String.valueOf(affordanceFeatures[2])).append(" pet");
                else sent1.append(String.valueOf(affordanceFeatures[2])).append(" pets");
                sent1.append(" but you are ").append(aff.compare()[1]);
            }
            else if(negIndex(val) == 2){
                sent1.append(aff.compare()[0]).append(" and ").append(aff.compare()[1]).append(" but you ");
                if(affordanceFeatures[2] == 0) sent1.append("don't keep pets");
                else sent1.append("keep ").append(String.valueOf(affordanceFeatures[2])).append(" pets");
            }
        }
        else if(num == 1){
            if(posIndex(val) == 0){
                sent1.append(aff.compare()[0]).append(" yet you are ").append(aff.compare()[1]).append(" and you ");
                if(affordanceFeatures[2] == 0) sent1.append("don't keep pets");
                else sent1.append("have ").append(String.valueOf(affordanceFeatures[2])).append(" pets");
            }
            else if(posIndex(val) == 1){
                sent1.append(aff.compare()[1]).append(" yet you are ").append(aff.compare()[0]).append(" and you ");
                if(affordanceFeatures[2] == 0) sent1.append("don't keep pets");
                else sent1.append("have ").append(String.valueOf(affordanceFeatures[2])).append(" pets");
            }
            else if(posIndex(val) == 2){
                sent1.append(aff.compare()[0]).append(" and ").append(aff.compare()[1]).append(" but you keep ");
                if(affordanceFeatures[2] == 1) sent1.append(String.valueOf(affordanceFeatures[2])).append(" pet");
                else sent1.append(String.valueOf(affordanceFeatures[2])).append(" pets");
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
