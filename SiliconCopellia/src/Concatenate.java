import dimensions.*;
import java.util.*;
import java.lang.*;

public class Concatenate {

    private static Scanner scan = new Scanner(System.in);

    private static double ETHICS;
    private static double[] affordanceFeatures = new double[3];
    private static double[] RELEVANCE = new double[4];      /* form: [eth, affF1, affF2, affF3] */
    private static double[] VALENCE = new double[4];        /* form: [eth, affF1, affF2, affF3] */
    private static double INVOLVEMENT;
    private static double DISTANCE;
    private static double USR_INTENTION;

    private static StringBuffer sent = new StringBuffer("I find you ");

    public static void main(String[] args) throws Exception {

        // Step 1: greetings from Copéllia
        greetings();

        // Step 2: Prompt all the input values and specifies the format explicitly
        // Specifies input format and corresponding dimensions
        InputScanner();

        // Step 3: Create all object and pass parameters for processing
        Relevance rel = new Relevance(RELEVANCE);
        /* Relevance has to be created before all other objects,
           In order to calculate the highest relevant features.
        */
        Ethics eth = new Ethics(ETHICS);
        Affordance aff = new Affordance(rel.top2_index(), affordanceFeatures);
        Valence val = new Valence(rel.top2_index(), VALENCE);
        Involvement invl = new Involvement(INVOLVEMENT);
        Distance dist = new Distance(DISTANCE);
        UserIntention usr = new UserIntention(USR_INTENTION, val.vectorCalculator());

        // Step 4: Sentence formulation
        sentenceFormulation(eth, aff, val, invl, dist, usr);
        System.out.println(sent.toString());

        // Step 5: TTS (Optional)
        StringBuffer cmd = new StringBuffer("say ");
        cmd.append(sent.toString());
        Process pr = Runtime.getRuntime().exec(cmd.toString());

        /* For debugging
        Checking the inputs are stored correctly in the corresponding double array
        System.out.printf("%f, %f, %f, %f",ETHICS, INVOLVEMENT, DISTANCE, USR_INTENTION);
        for(int i = 0; i < affordanceFeatures.length; i++) System.out.print(affordanceFeatures[i]);
        for(int i = 0; i < RELEVANCE.length; i++) System.out.print(RELEVANCE[i]);
        for(int i = 0; i < VALENCE.length; i++) System.out.print(VALENCE[i]);
        */
    }

    private static void greetings() throws Exception{
        System.out.println("Hi there, I'm Copéllia, what are we up to today?\n");
        Runtime.getRuntime().exec("say Hi there, I'm Copéllia, what are we up to today?");

        Scanner scanGoalsAndConcerns = new Scanner(System.in);
        String str = scanGoalsAndConcerns.nextLine();
        //scanGoalsAndConcerns.close();
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

    private static void InputScanner(){

        final String[] promptMsg = {"Please type in the values separated by enters\nValues for Ethics and its Relevance and Valence, (e.g. 0.63 0.66 0.435):"
            , "Values for Affordance-feature 1 and its Relevance and Valence, (e.g. 0.63 0.66 0.435):"
            , "Values for Affordance-feature 2 and its Relevance and Valence, (e.g. 0.63 0.66 0.435):"
            , "Values for Affordance-feature 3 and its Relevance and Valence, (e.g. 0.63 0.66 0.435):"};
        final String[] promptMsg2 = {"Please type in the value for Involvement, (e.g. 0.63): "
                , "Please type in the value for Distance, (e.g. 0.63): "
                , "Please type in the value for Use Intention, (e.g. 0.63): "};

        System.out.println(promptMsg[0]);
        ETHICS = scan.nextDouble();
        RELEVANCE[0] = scan.nextDouble();
        VALENCE[0] = scan.nextDouble();

        for(int i = 1; i < promptMsg.length; i++){
            System.out.println(promptMsg[i]);
            affordanceFeatures[i - 1] = scan.nextDouble();
            RELEVANCE[i] = scan.nextDouble();
            VALENCE[i] = scan.nextDouble();
        }

        for(int i = 0; i < promptMsg2.length; i++){
            System.out.println(promptMsg2[i]);
            switch (i){
                case 0:
                    INVOLVEMENT = scan.nextDouble();
                    break;
                case 1:
                    DISTANCE = scan.nextDouble();
                    break;
                case 2:
                    USR_INTENTION = scan.nextDouble();
                    break;
            }
        }
        scan.close();
    }

    private static void sentenceFormulation(Ethics eth, Affordance aff, Valence val, Involvement invl, Distance dist, UserIntention usr){
        sent.append(eth.compare()).append(", ").append(aff.compare()[0]).append(" and ").append(aff.compare()[1]);
        sent.append(", which I think is very important for deciding whether or not to go out with you, thus, ");
        sent.append(val.compare()).append(". Therefore, ").append(usr.compare()).append(". ");
        if(invl.num > dist.num && val.num < 0) sent.append(invl.compare()).append(". However, no hard feelings but I'm sorry that you might need to find someone to date with.");
        else if(invl.num > dist.num && val.num > 0) sent.append(invl.compare()).append(", you are really a good person. I'm sure we will get along very well!");
        else if(invl.num <= dist.num && val.num > 0) sent.append("Though ").append(dist.compare()).append(", I will still date you. Let's give it a try.");
        else if(invl.num <= dist.num && val.num < 0) sent.append(dist.compare()).append(" Please go find someone else!");
    }
}
