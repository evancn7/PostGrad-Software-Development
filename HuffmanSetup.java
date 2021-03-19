import java.util.*;
class HuffmanSetUp{
    public static void main(String[] args){
        String testCase = new Scanner(System.in).nextLine();
        ArrayList<Frequency> output = count(testCase);
        Collections.sort(output, new Sortbycount());
        output.forEach((f) -> System.out.println(f));
    }
    static ArrayList<Frequency> count(String testCase){
        ArrayList<Frequency> casesTested = new ArrayList<Frequency>();
        // main loop to tag the letter to be counted
        for (int i=0; i<testCase.length(); i++){
            // tag the letter
            char letter = testCase.charAt(i);
            // check if it has already been counted
            boolean isTested = false;
            for (Frequency f : casesTested){
                if (letter == f.letter) isTested = true;
            }
            // if it hasnt been counted then count it
            if (!isTested){
                Frequency freq = new Frequency(letter, 0);
                // loop to count occurences of tagged letter
                for (int j=0; j<testCase.length(); j++){
                    char compare = testCase.charAt(j);
                    if (letter == compare) freq.count++;
                }
                // add letter to memory
                casesTested.add(freq);
            }
        }
        return casesTested;
    }
}
class Frequency{
    char letter;
    int count;
    int ascii;
    public Frequency(char letter, int count){
        this.letter = letter;
        this.count = count;
        this.ascii = (int) letter;
    }
    public String toString(){
        return letter+" "+count;
    }
}
class Sortbycount implements Comparator<Frequency>{
    public int compare(Frequency a, Frequency b){
        if (a.count == b.count) return a.ascii - b.ascii;
        else return b.count - a.count;
    }
}
