import java.util.*;

public class HuffmanEncoding {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        int[] array = new int[256]; //an array to store all the frequencies

        // go through the sentence
        for (int i = 0; i < sentence.length(); i++) {
            //increment the appropriate frequencies
            array[(int) sentence.charAt(i)]++;
        }

        // make a priority queue to hold the forest of trees
        PriorityQueue <Tree> PQ = new PriorityQueue <Tree>();

        // go through frequency array
        for (int i = 0; i < array.length; i++) {
            // print out non-zero frequencies - cast to a char
            if (array[i] > 0) {

                // set variables
                char c = (char) i;
                int frequency = array[i];

                // create tree
                Tree myTree = new Tree();

                // create node for the letter
                Node myNode = new Node();
                myNode.letter = c;
                myNode.smallestLetter = c;

                // set tree attributes
                myTree.frequency = frequency;
                myTree.root =  myNode; /* this needs to be a node */;

                PQ.add(myTree);
            }
        }

        while (PQ.size() > 1) {
            // while there are two or more Trees left in the forest

            Tree combo = new Tree();
            Tree firstTree = PQ.poll();
            Tree secondTree = PQ.poll();

            Node localRoot = new Node();
            combo.root = localRoot;
            combo.frequency = firstTree.frequency + secondTree.frequency;
            localRoot.smallestLetter = firstTree.root.smallestLetter;
            localRoot.leftChild = firstTree.root;
            localRoot.rightChild = secondTree.root;

            PQ.add(combo);
        }

        Tree HuffmanTree = PQ.poll();

        // now there's only one tree left - get its codes
        for (int l=0; l<sentence.length(); l++){
            System.out.println(HuffmanTree.getCode(sentence.charAt(l)));
        }
        System.out.println();
    }
}

class Node {
    public char letter = '@'; //stores letter
    public char smallestLetter = '@';  //a nice idea is to track the smallest letter in the tree in a special variable like this

    public Node leftChild; // this node's left child
    public Node rightChild; // this node's right child
}

class Tree implements Comparable<Tree> {
    public Node root; // first node of tree
    public int frequency = 0;

    // constructor
    public Tree(){
        root = null;
    }
    public int compareTo(Tree object) {
        //compare the cumulative frequencies of the tree
        if (frequency - object.frequency > 0) {
            return 1;
        } else if (frequency - object.frequency < 0) {
            return -1;
        // return 1 or -1 depending on frequencies being bigger or smaller
        } else {
            // Sort based on letters
            char a = this.root.smallestLetter;
            char b = object.root.smallestLetter;

            if (a > b) return 1;
            else if (a < b) return -1;
            return 0;
        }
    }
    // this variable will track the path to the letter we're looking for
    String path = "error";

    // we want the code for this letter
    public String getCode(char letter) {
        // return the path that results
        return this._getCode(letter, this.root, "");
    }
    private String _getCode(char letter, Node current, String path) {
        if (current == null) return null;
        if (current.letter == letter) return path;

        String leftPath = this._getCode(letter, current.leftChild, path + "0");

        if (leftPath != null) return leftPath;

        String rightPath = this._getCode(letter, current.rightChild, path + "1");
        return rightPath;
    }
}
