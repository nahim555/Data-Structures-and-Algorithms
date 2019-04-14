import java.io.*;
import java.nio.BufferUnderflowException;
import java.util.*;

public class DictionaryFinder {

        private List<String> Dictionary;

        public DictionaryFinder(ArrayList<String> dictionary){
            this.Dictionary = dictionary;

        }

    public DictionaryFinder() {

    }

    /**
         * Reads all the words in a comma separated text document into an Array
         * @param
         */
        public static ArrayList<String> readWordsFromCSV(String file) throws FileNotFoundException {
            Scanner sc=new Scanner(new File(file));
            sc.useDelimiter(" |,");
            ArrayList<String> words=new ArrayList<>();
            String str;
            while(sc.hasNext()){
                str=sc.next();
                str=str.trim();
                str=str.toLowerCase();
                words.add(str);
                //Collections.sort(words);
            }
            return words;
        }
        public static void saveCollectionToFile(Collection<?> c,String file) throws IOException {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(Object w: c){
                printWriter.println(w.toString());
            }
            printWriter.close();
        }

        public static ArrayList <String> formDictionary() throws FileNotFoundException {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> dicitionaryWords = new ArrayList <>();

            String aFile = "src/testDocument.txt";

            //add strings to arraylist
            for (String line : readWordsFromCSV(aFile) ){
                dicitionaryWords.add(line);
            }

            Set<String> wCount = new HashSet<>(dicitionaryWords);
            List SortList = new ArrayList(wCount);
            Collections.sort(SortList);
           // int count = 0;
            for (Object word : SortList){
               // Integer count = wCount.get(word);
               // wCount.put(word, (count==null) ? 1 : count + 1);
                System.out.println(word + ", " + Collections.frequency(dicitionaryWords, word));
                System.out.println(word); //Collections.frequency(dicitionaryWords, word));
                Collections.sort(dicitionaryWords);
            }

            for(String value :readWordsFromCSV(aFile) ){
                sb.append(value);
            }
            String file = sb.toString();

            //System.out.print(readWordsFromCSV(aFile).toString().replaceAll("(^\\[|\\]$)", ""));
            return dicitionaryWords;
        }
        public void saveToFile() throws IOException {
            ArrayList<String> Dictionary = new ArrayList <>();
            String fileName = "dictionary.txt";
            DictionaryFinder df=new DictionaryFinder(Dictionary);

            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            df.formDictionary();
            writer.println(formDictionary());
            writer.close();

        }

    /**
     * function to count frequencies using hashmap
     * @throws FileNotFoundException
     */
        public void countFrequencies() throws FileNotFoundException {

            StringBuilder sb = new StringBuilder();
            ArrayList<String> dicitionaryWords = new ArrayList <>();

            String aFile = "src/testDocument.txt";
            for (String line : readWordsFromCSV(aFile) ){
                dicitionaryWords.add(line);
            }

            Set<String> wCount = new HashSet<>(dicitionaryWords);
            List SortList = new ArrayList(wCount);
            Collections.sort(SortList);

            //print frequencies of words in dictionary
            for (Object word : SortList){
                System.out.println(Collections.frequency(dicitionaryWords, word));

            }

        }

    /**
     * testing dictionary
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

            ArrayList<String> Dictionary = new ArrayList <>();
            String aFile = null;
            DictionaryFinder df=new DictionaryFinder(Dictionary);
            ArrayList<String> in=readWordsFromCSV("src/testDictionary.txt");
            //DO STUFF TO df HERE in countFrequencies

            df.formDictionary();
            df.saveToFile();

            ArrayList<String> list = new ArrayList <>();

           // list = df.formDictionary();

           // Trie n = new Trie(Dictionary);
           // TrieNode node = new TrieNode();
          //  node.add("c");

        //    n.outputBreadthFirsdtSearch();

            String keys[] = {"cheese", "forty", "nine", "a", "bat"};

            String[] output = {"not in trie", "is in trie"};
            char c = 'a';
            TrieNode root = new TrieNode();
            Trie a = new Trie();

            //adding dictionary to arraylist and converting it to string
         //  String[] s = df.formDictionary().toArray(new String[0]);

           /// for (int i = 0; i<s.length; i++){
           //     System.out.println(s[i]);
           // }


            //add strings to trie
            for (int i = 0; i < keys.length; i++) {
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

           //adding nodes to the trie
            a.root = new TrieNode("HELLO");
            a.root.left = new TrieNode("s");
            a.root.left.left = new TrieNode("t");
            a.root.right = new TrieNode("c");
            a.root.right.left = new TrieNode("a");
            a.root.right.left.left = new TrieNode("t");

            System.out.println("order ");;
            a.outputBreadthFirstSearch();
            System.out.println(" ");


            if(a.contain("forty") == true){
                System.out.println("forty--- " + output[1]);
            }
            else
                System.out.println("forty --- " + output[0]);

            if(a.contain("cheese") == true) {
                System.out.println("cheese --- " + output[1]);
            }
            else System.out.println("these --- " + output[0]);


        }


    }
