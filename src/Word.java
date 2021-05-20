public class Word implements Comparable<Word>{

    private String word;
    private String letters;
    private Integer length;
    private Integer count;

    public Word(String word, String letters, Integer length, Integer count) {
        this.word = word;
        this.letters = letters;
        this.length = length;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int compareTo(Word w) {
        if (getCount() == null || w.getCount() == null) {
            return 0;
        }
        return getCount().compareTo(w.getCount());
    }
}
