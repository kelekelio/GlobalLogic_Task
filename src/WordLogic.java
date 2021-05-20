import java.util.*;

public class WordLogic {

    public static Word returnWord (String word) {
        int count = 0;
        List<Character> resultChars = new ArrayList<>(); // list of chars after removing 0 values

        String lookUpString = LookUpString.LOOK_UP_STRING; //lookup string, ex "LOGIC"
        char[] lookupArray = lookUpString.toLowerCase().toCharArray(); // converting lookup string to chars {l, o, g, i, c}

        LinkedHashMap<Character, Integer> lookupChars = new LinkedHashMap<>(); //map to store the freq of each lookup char, l => 0++, o => 0++...

        for(char c : lookupArray) {
            //for each char in lookup string, put each char into lookupChars
            lookupChars.put(c, 0);
        }



        //convert the word to char array
        char[] wordToChar = word.toLowerCase().toCharArray();


        for(char c : wordToChar) {
            //if the character of the word is one of the lookup chars, increase count by 1
            if (lookupChars.containsKey(c)) {
                lookupChars.put(c, lookupChars.get(c) + 1);
            }
        }




        for (Map.Entry<Character, Integer> entry : lookupChars.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            //System.out.println("key = " + key);
            //System.out.println("value = " + value);

            //move all chars that have more than 0 values to the new map resultChars and increase the total count by the number of appearances
            if (value > 0) {
                resultChars.add(key);
                count = count + value;
            }


        }

        /**
         * @param String word
         * @param String letters
         * @param Integer length
         * @param Integer count
         */
        return new Word(word, resultChars.toString(), word.length(), count);
    }


    public static void checkString (String s) {
        Extra.saveToFile("Provided string is: " + s);
        String[] words = s.split(" ");

        int strintSize = 0;
        int totalChars = 0;

        List<Word> listOfWordsObjs = new ArrayList<>();


        for(String word : words) {
            if (word.length() > 0) {
                listOfWordsObjs.add(WordLogic.returnWord(word));
            }
        }

        for (int i = 0; i < listOfWordsObjs.size(); i++) {
            strintSize = strintSize + listOfWordsObjs.get(i).getLength();
            totalChars = totalChars + listOfWordsObjs.get(i).getCount();
        }




        listOfWordsObjs.sort(Comparator.comparing(Word::getCount));
        //System.out.println("size = " + listOfWordsObjs.size());
        for (int i = 0; i < listOfWordsObjs.size(); i++) {

            String output = "{" +
                    listOfWordsObjs.get(i).getLetters() + ", " +
                    listOfWordsObjs.get(i).getLength() + "} = " +
                    Extra.roundFreq(listOfWordsObjs.get(i).getCount(), totalChars) + " (" +
                    listOfWordsObjs.get(i).getCount() + "/" + totalChars + ")";

            Extra.saveToFile(output);


        }


        String output = "TOTAL Frequency: " + Extra.roundFreq(totalChars, strintSize) + " (" + totalChars  + "/" + strintSize + ")";
        Extra.saveToFile(output);

    }



}
