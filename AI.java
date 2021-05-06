import java.util.Arrays;
import java.util.Dictionary;
import java.util.Random;
import java.util.ArrayList;

public class AI {

    public static void main(String [] args){

        Random r= new Random();

        String[] dictionary = {"high","ignorant", "pathetic", "watery", "well-off", "gamy", "excuse", "throne", "label",
                "frequent", "effect", "answer", "night", "permissible", "meal", "kill", "old", "children", "blue-eyed",
                "uptight", "decide", "outstanding", "periodic", "womanly", "manage", "plastic", "obnoxious", "property",
                "lighten", "moan", "full", "fall", "goofy", "tip", "chief", "spare", "noxious", "spoon", "rhythm",
                "numerous", "giddy", "itchy", "touch", "houses", "volcano", "island", "drip", "ruddy", "bike",
                "redundant"};



        String target = dictionary[r.nextInt(dictionary.length)];

        String blackout="";
        for(int i=0; i<target.length(); i++){
            blackout=blackout+"_";
        }

        Brain mybrain = new Brain(Arrays.copyOf(dictionary, dictionary.length), blackout);
        int lives=8;
        int score=0;

        boolean running = true;
        long startTime = System.currentTimeMillis();
        System.out.println(target);
        while(running){

            char guess=mybrain.guessLetter();
            System.out.println(guess);

            String original =mybrain.hiddenWord; //get hiddenWord from myBrain
            char[] arrayform = original.toCharArray(); //hiddenWord to char array
            for(int i=0; i<target.length(); i++){
                if(target.charAt(i)==guess){ //If correct compared to word original
                    arrayform[i]=guess;      //replace characters arrayform
                }
            }

            String newform=""; //
            for(int i=0; i<target.length(); i++){
                newform=newform+arrayform[i];
            }

            mybrain.hiddenWord=newform;
            System.out.println(newform);
            if(newform.equals(original)){
                lives=lives-1;
            }

            if (lives==0){
                System.out.println("Lost");
                running=false;
            }
            if (mybrain.hiddenWord.equals(target)){
                System.out.println("Won");
                running=false;
                score=score+1;
            }
        }
        long endTime = System.currentTimeMillis();
        double duration = ((endTime - startTime)*0.001);

        System.out.println("Run time was "+duration);
    }


}

class Brain{
    public String[]dictionary;
    public String hiddenWord="";
    ArrayList<String> newdictionary = new ArrayList<String>();
    ArrayList<String> narrowDown = new ArrayList<String>();
    String check="aeiou";
    String alpha="abcdefghijklmnopqrstuvwxyz";
    char checker=' ';
    String guess=Character.toString(checker);

    public Brain(String[] wordlist, String target){
        dictionary = wordlist;
        hiddenWord = target;
    }

    public char guessLetter() {
      // if word is all underscores only
        if (hiddenWord.matches("^[_]*$")) {
            for (int i = 0; i < dictionary.length; i++) {
                if (dictionary[i].length() == hiddenWord.length()) {
                    newdictionary.add(dictionary[i]);
                }
            }
            checker = check.charAt(0);
            String replace = Character.toString(checker);
            check = check.replace(replace, "");
            alpha = alpha.replace(replace,"");
            return checker; // first guess
        }


        else {
          // check how many chars are filled
            int charsFilled = 0;
            int uScore = 0;
            for (int i = 0; i < hiddenWord.length(); i++) {
                if (hiddenWord.charAt(i) == '_') {
                    uScore++;

                }
                charsFilled = hiddenWord.length() - uScore;
            }


            for (int i = 0; i < newdictionary.size(); i++) {

                String hw = newdictionary.get(i);
                int count = 0;

                for (int k = 0; k < hiddenWord.length(); k++) {

                    if (hiddenWord.charAt(k) == hw.charAt(k)) {
                        count++;
                        if (count == charsFilled && !narrowDown.contains(hw)) { narrowDown.add(hw);
                        }
                    }

                }

            }
            newdictionary = narrowDown;
            narrowDown.clear();


            String d;
            char c;
            for (int al = 0; al < alpha.length(); al++) {
                    c = alpha.charAt(al);
                    d = String.valueOf(c);
                    int in = 0;
                    for (int n = 0; n < newdictionary.size(); n++)
                    {

                        if (newdictionary.get(n).contains(d)) {
                            in++;
                        }
                    }
                    if (in < 1) {
                        alpha = alpha.replace(d, "");
                    }
                }

            String concat = "";
            for (int i = 0; i < newdictionary.size(); i++) {
                concat += newdictionary.get(i);
                //Word concatenated
            }


            int countLetter = 0;
            for (int i = 0; i < alpha.length(); i++) {
                int freqLetter = 0;
                for (int j = 0; j < concat.length(); j++) {
                    if (alpha.charAt(i) == concat.charAt(i)) {
                        freqLetter++;
                    }
                }
                if (freqLetter > countLetter) {
                    countLetter = freqLetter;
                    checker = alpha.charAt(i);
                    System.out.println("this is the" + checker);
                }
            }

            alpha = alpha.replace(guess,"");


            return checker;
        }
    }
}
