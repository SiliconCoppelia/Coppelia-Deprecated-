import dimensions.*;
import java.util.Scanner;
import java.lang.*;

public class Concatenate {

    private static StringBuffer inputBuffer = new StringBuffer();
    Scanner scan = new Scanner(System.in);
    String strInput = scan.nextLine();

    private static double ETHICS;
    private static double[] affordanceFeatures;
    private static double[] RELEVANCE;      /* form: [eth, affF1, affF2, affF3] */
    private static double[] VALENCE;        /* form: [eth, affF1, affF2, affF3] */
    private static double INVOLVEMENT;
    private static double DISTANCE;
    private static double USR_INTENTION;

    private static StringBuffer sent = new StringBuffer("I find you ");

    public static void main(String[] args) throws Exception {

        // Step 1: greetings from Copéllia
        greetings();

        // Step 2: Prompt all the input values and specifies the format explicitly
        // Specifies input format and corresponding
        System.out.println("Please type in the values separated by spaces:\nValues for Ethics and its Relevance and Valence, (e.g. 0.63 0.66 0.435): ");
        System.out.println("Values for Affordance-feature 1 and its Relevance and Valence, (e.g. 0.63 0.66 0.435): ");
        System.out.println("Values for Affordance-feature 2 and its Relevance and Valence, (e.g. 0.63 0.66 0.435): ");
        System.out.println("Values for Affordance-feature 3 and its Relevance and Valence, (e.g. 0.63 0.66 0.435): ");

        System.out.println("Please type in the value for Involvement, (e.g. 0.63): ");
        System.out.println("Please type in the value for Distance, (e.g. 0.63): ");
        System.out.println("Please type in the value for Use Intention, (e.g. 0.63): ");


        Ethics eth = new Ethics(ETHICS);
        Affordance aff = new Affordance(RELEVANCE, affordanceFeatures);
        //Relevance rel = new Relevance();
        Valence val = new Valence(RELEVANCE, VALENCE);
        Involvement invl = new Involvement(INVOLVEMENT);
        Distance dist = new Distance(DISTANCE);
        UserIntention usr = new UserIntention(USR_INTENTION, Valence.vectorCalculator());

        System.out.println(sent.toString());

        //StringBuffer cmd = new StringBuffer("say ");
        //cmd.append(sent.toString());
        //Process pr = Runtime.getRuntime().exec(cmd.toString());

    }

    private static void greetings() throws Exception{
        System.out.println("Hi there, I'm Copéllia, what are we up to today?\n");
        Runtime.getRuntime().exec("say Hi there, I'm Copéllia, what are we up to today?");

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        scan.close();
        if(str.toLowerCase().contains("date")){
            Runtime.getRuntime().exec("say Let me think...");
            System.out.println("Let me think...\n");
        }
        else{
            System.out.println("I'm sorry. " +
                    "I don't yet have the ability to understand such a difficult command\n");
            Runtime.getRuntime().exec("say I'm sorry. " +
                    "I don't yet have the ability to understand such a difficult command");
            System.exit(0);
        }
    }
}
