import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Trie {

    public static TrieNode root;
    public char c;
    TrieNode left;
    TrieNode right;
    String data;


    /**
     * create empty trie node
     */
    public Trie() {

        root = new TrieNode();

    }

    /**
     * get node from the trie
     * @param key
     * @return
     */
    public TrieNode getNode(String key) {
        TrieNode Node = root;
        for (int i = 0; i < key.length(); i++) {
            TrieNode offspring = Node.offspring[key.charAt(i) - 'a'];
            if (offspring == null) {
                return null;
            }
            Node = offspring;
        }
        return Node;
    }

    public boolean contains(String key) {
        TrieNode Node = getNode(key);
        return Node != null && Node.wordComplete;
    }


    public boolean contain(String keys) {

        int level;
        int length = keys.length();
        int index;
        TrieNode node = root;

        for (level = 0; level < length; level++) {
            index = keys.charAt(level) - 'a';

            if (node.offspring[index] == null)
                return false;

            node = node.offspring[index];
        }

        return (node != null && node.wordComplete);
    }


    /**
     * add string to the trie at next node
      * @param key
     */
    public void add(String key) {
        int level;
        int length = key.length();
        int pos;
        TrieNode node = root;
        char fChar = key.charAt(0);

        for (level = 0; level < length; level++) {
            pos = key.charAt(level) - 'a';
            if (node.offspring[pos] == null) {
                node.offspring[pos] = new TrieNode();

                node = node.offspring[pos];

            } else
                node.wordComplete = true;

        }


    }

    /**
     * return String containing words in traversal breadth order using queue
     * @return
     */

    String outputBreadthFirstSearch(){
        TrieNode node;

        Queue<TrieNode> q = new LinkedList <TrieNode>();
        q.add(root);

        String bfs = "";
        if(root == null)
            System.out.println("Empty");
        q.clear();
        q.add(root);
        while(!q.isEmpty()){

            node = q.remove();
            System.out.print(node.data + " ");
            bfs+= node.data + " ";
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
        return  bfs;

    }

    String outputDepthFirstSearch(){

        //creates an node of root
        TrieNode node = root;
        TrieNode temp = new TrieNode();

        //return empty
        if(root == null){
            System.out.print("empty");
        }

        //empty stack
        Stack<TrieNode> s = new Stack <TrieNode>();
        String dfs = "";
        s.push(root);
        while(s.isEmpty() == false){
            temp = s.peek();
            TrieNode c = s.pop();

            if(c.right != null){
                s.add(c.right);
            }
            if (c.left!=null){
                s.add(c.left);
            }
            System.out.print(" " + c.data);
            dfs+= node.data + " ";

        }
        return dfs;
    }


    //get prefix of word
    public Trie getSubTrie(String prefix){
        Trie t = new Trie();
        TrieNode temp = root;

        //searches if prefix exists in the trie
        for(int i = 0; i<prefix.length(); i++){
            TrieNode word = temp.getOffspring(prefix.charAt(i));
            if(word == null){
                System.out.println("empty");
            }
            temp = word;
            t.root = temp;

        }

        return t;

    }

    //scan through node and add to list then print
    public List getAllWords(){
        TrieNode node = root;
        List<TrieNode> list = new ArrayList <>();
        for(TrieNode s : list){
            s = node;
            list.add(s);
            System.out.print(list + ", ");
        }

        return list;

    }


    /**Section 3 - Word Auto Completion
     * testing the trie
     * @throws FileNotFoundException
     */
    public static void main() throws IOException {
        ArrayList<String> Dictionary = new ArrayList <>();
        String aFile = null;
        DictionaryFinder df=new DictionaryFinder(Dictionary);
        ArrayList<String> in= DictionaryFinder.readWordsFromCSV("src/testDictionary.txt");
        //DO STUFF TO df HERE in countFrequencies

        df.formDictionary();
        df.saveToFile();


        String keys[] = {"arsernal", "forty", "nine"};

        String[] output = {"not in trie", "is in trie"};

        TrieNode root = new TrieNode();
        Trie a = new Trie();

        //adding dictionary to arraylist and converting it to string
         String[] s = df.formDictionary().toArray(new String[0]);

        /// for (int i = 0; i<s.length; i++){
        //     System.out.println(s[i]);
        // }

        //add keys to the trie
        int i = 0;
        for (i = 0; i < keys.length; i++) {
            a.add(keys[i]);
        }

           /* Trie t = new Trie();
            t.root = new TrieNode("ARSENAL");
            t.root.add(new TrieNode("FORTY"));
            t.root.offspring[0].add(new TrieNode("I"));
            t.root.offspring[1].add(new TrieNode("Bet"));
            t.root.offspring[2].offspring[1].add(new TrieNode("Examples"));

            System.out.println(t);
            */

           //test the trie
        a.root = new TrieNode("HELLO");
        a.root.left = new TrieNode("s");
        a.root.left.left = new TrieNode("t");
        a.root.right = new TrieNode("c");
        a.root.right.left = new TrieNode("a");
        a.root.right.left.left = new TrieNode("t");

        //output BreadthFirstSearch
        System.out.println("order ");;
        a.outputBreadthFirstSearch();
        System.out.println(" ");

        if(a.contain("arsenal") == true){
            System.out.println("arsenal " + output[1]);
        }
        else
            System.out.println("arsenal " + output[0]);
        if(a.contain("forty") == true) {
            System.out.println("forty " + output[1]);
        }
        else System.out.println("forty" + output[0]);

    }


}

