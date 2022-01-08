import dimensions.*;
import java.util.Locale;


public class Concatenate {

    public static void main(String[] args) throws Exception {
        System.out.println("Please enter all the values separated by enters: ");

        Ethics eth = new Ethics();
        Affordance aff = new Affordance();
        Relavance rel = new Relavance();
        Valence val = new Valence();
        Involvement invl = new Involvement();
        Distance dist = new Distance();
        UserIntension usr = new UserIntension();

        StringBuffer sent = new StringBuffer("I find you ");
        if((eth.num >= 0.5 && aff.num >= 0.5) || (eth.num < 0.5 && aff.num < 0.5)){
            sent = sent.append(eth.compare()).append(" and ").append(aff.compare()).append(", therefore, ");
        }
        else{
            sent = sent.append(eth.compare()).append(" but ").append(aff.compare()).append(", therefore, ");
        }

        if(invl.num >= dist.num && val.num < 0.5){
            sent.append(invl.compare()).append(" but ").append(val.compare()).append(" ").append(rel.compare()).append(". ");
        }
        else if(invl.num >= dist.num && val.num >= 0.5){
            sent.append(invl.compare()).append(" and ").append(val.compare()).append(" ").append(rel.compare()).append(". ");
        }
        else if(invl.num < dist.num && val.num >= 0.5){
            sent.append(dist.compare()).append(" but ").append(val.compare()).append(" ").append(rel.compare()).append(". ");
        }
        else if(invl.num < dist.num && val.num < 0.5){
            sent.append(dist.compare()).append(" and ").append(val.compare()).append(" ").append(rel.compare()).append(". ");
        }

        sent.append(usr.compare());
        System.out.println(sent.toString());

        TextToSpeech tts=new TextToSpeech(sent.toString());


    }
}
