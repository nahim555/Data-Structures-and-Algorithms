import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AutoCompletion extends DictionaryFinder{

    private static ArrayList<String> dicitionaryWords;

    public AutoCompletion(){
        super();
        dicitionaryWords = new ArrayList <>();

    };

    public static ArrayList<String> readWordsFromCSV(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter(" |,");
        ArrayList <String> words = new ArrayList <>();
        String str;
        while (sc.hasNext()) {
            str = sc.next();
            str = str.trim();
            str = str.toLowerCase();
            words.add(str);
            //Collections.sort(words);
        }
        return words;

    }

    public static ArrayList <String> formDictionary(String file) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> dicitionaryWords = new ArrayList <>();

        String aFile = file;
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
            //System.out.println(word); //Collections.frequency(dicitionaryWords, word));
            Collections.sort(dicitionaryWords);
        }

        for(String value :readWordsFromCSV(aFile) ){
            sb.append(value);
        }
        String s = sb.toString();


        //System.out.print(readWordsFromCSV(aFile).toString().replaceAll("(^\\[|\\]$)", ""));
        return dicitionaryWords;
    }

    public static void formTrie() throws FileNotFoundException {

        DictionaryFinder d = new DictionaryFinder();
        String file = "src/lotrQueries.csv";
        String q2 = "src/lotrQueries.csv";
        String gollum = "src/gollum.csv";
        formDictionary(file);
        formDictionary(q2);


        formDictionary(gollum);

        Trie t = new Trie();
        TrieNode node = new TrieNode();

        int i = 0;
        for (i = 0; i < dicitionaryWords.size(); i++) {
            t.add(dicitionaryWords.get(i));
        }

        //input words into a list
        ArrayList<String> prefix = readWordsFromCSV(file);

        //load prefix
        for(String wordPrefix : prefix){
            t.getSubTrie(wordPrefix);
        }














    }



}



