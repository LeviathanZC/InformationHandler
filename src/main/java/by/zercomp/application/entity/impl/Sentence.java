package by.zercomp.application.entity.impl;

import by.zercomp.application.entity.SentenceItem;
import by.zercomp.application.entity.TextItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sentence implements TextItem, Comparable<Sentence> {
    private List<SentenceItem> sentence = new ArrayList<>();

    @Override
    public void setTextItem(TextItem textItem) {
        sentence.add((SentenceItem) textItem);
    }

    public List<SentenceItem> getSentence() {
        return sentence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Sentence sentence = (Sentence) o;

        return this.sentence.equals(sentence.getSentence());
    }

    @Override
    public int hashCode() {
        return this.sentence.hashCode();
    }

    @Override
    public String toString() {
        // TODO: 7.09.20  
        StringBuilder builder = new StringBuilder();
        for (SentenceItem item : sentence) {
            builder.append(item);
        }
        return builder.toString();
    }

    public int getCountOfWords() {
        int count = 0;
        for (SentenceItem word : sentence) {
            if (word instanceof Word) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int compareTo(Sentence o) {
        return this.getCountOfWords() - o.getCountOfWords();
    }
}
