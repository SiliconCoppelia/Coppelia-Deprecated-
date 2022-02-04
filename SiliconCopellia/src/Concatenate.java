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

    private static StringBuffer sent = new StringBuffer("I find you ");

    public static void main(String[] args) throws Exception {

        // Step 1: greetings from Coppélia
        greetings();

        // Step 2: self-introduction from the agent
        usrIntro();

        // Step 3: Create all object and pass parameters for processing
        Relevance rel = new Relevance(RELEVANCE);
        /* Relevance has to be created before all other objects,
           In order to calculate the highest relevant features.
        */
        Ethics eth = new Ethics(ETHICS);
        Affordance aff = new Affordance(rel.top2_index(), affordanceFeatures);
        Valence val = new Valence(rel.top2_index(), RELEVANCE, VALENCE);
        Involvement invl = new Involvement(INVOLVEMENT);
        Distance dist = new Distance(DISTANCE);
        UserIntention usr = new UserIntention(USR_INTENTION, val.num);

        // Step 4: Sentence formulation
        sentenceFormulation(eth, aff, val, invl, dist, usr);
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

    private static void sentenceFormulation(Ethics eth, Affordance aff, Valence val, Involvement invl, Distance dist, UserIntention usr){
        sent.append("You are ").append(aff.compare());
    }
}
