
import java.util.Queue;

public class TrieNode{
    boolean wordComplete;
    private static final int ALPHABET = 26;
    public char c;
    TrieNode[] offspring;
    TrieNode left;
    TrieNode right;
    String data;

    /**
     * creates a new TrieNode offspring of size ALPHABET
     */
    public TrieNode() {
        this.offspring = new TrieNode[ALPHABET];
        this.wordComplete = false;

    }

    /**
     * assign fields in constructor and positions of the characters in node
     * @param d
     */
    public TrieNode(String d) {
        offspring = new TrieNode[ALPHABET];
        this.data = d;
        this.left = null;
        this.right = null;
    }

    /**
     * return character
     * @return
     */
    public char getChar() {
        return c;
    }

    /**
     * get offspring by scanning node and return character on match
     * @param x
     * @return
     */
    public TrieNode getOffspring(char x) {
        TrieNode a = new TrieNode();
        for (TrieNode d : offspring) {
            if (a.getChar() == x) {
                return a;
            }
        }

        return null;
    }

   // static TrieNode root = new TrieNode();

    /**
     * add string to node
     * @param key
     */
    public void add(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode node = new TrieNode();
        char fChar = key.charAt(0);
//        TrieNode offspring = getOffspring(fChar);

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (node.offspring[index] == null) {
            node.offspring[index] = new TrieNode();

            node = node.offspring[index];

        }
            else
                node.wordComplete = true;

        }


    }

    /**
     * find is node contains string
     * @param key
     * @return
     */
    public boolean contain(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode node = new TrieNode();

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (node.offspring[index] == null)
                return false;

            node = node.offspring[index];


        }
        return (node != null && node.wordComplete);
    }

    /*
       /**
        * set character
        * @param c
        * @param node
        */
 /* public void setChild(char x, TrieNode node){
        char c;
        node = new TrieNode();
        c = x;
        node.add(c);

    }

    */

    /*8
    add node delete
     */
    public void add(TrieNode s) {

        Trie t = new Trie();
        t.root = s;

    }
}
