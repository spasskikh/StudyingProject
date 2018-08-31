package collections.map.hashmap;

public class WordWrapper implements Comparable<WordWrapper> {

    private final String word;
    private final Integer count;

    public WordWrapper(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public int compareTo(WordWrapper thatWord) {
        if (count < thatWord.getCount()) {
            return -1;
        } else if (count > thatWord.getCount()) {
            return 1;
        } else {
            return word.compareTo(thatWord.getWord());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        else {
            WordWrapper word = (WordWrapper) o;
            if (!this.word.equals(word.getWord())) {
                return false;
            } else return this.count.equals(word.getCount());
        }
    }

    @Override
    public String toString() {
        return word + " -> " + count;
    }
}
