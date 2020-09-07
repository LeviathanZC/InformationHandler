package by.zercomp.application.entity.impl;

import by.zercomp.application.entity.TextItem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Text implements TextItem {
    private List<Sentence> sentences = new LinkedList<>();

    public List<Sentence> getSentences() {
        return Collections.unmodifiableList(sentences);
    }

    @Override
    public void setTextItem(TextItem textItem) {
        sentences.add((Sentence) textItem);
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

        return sentences.equals(sentence.getSentence());
    }

    @Override
    public int hashCode() {
        return sentences.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Sentence item : sentences) {
            builder.append(item.toString());
        }
        return builder.toString();
    }
}
