package by.zercomp.application.entity.impl;

import by.zercomp.application.entity.SentenceItem;
import by.zercomp.application.entity.TextItem;

public class Word implements SentenceItem {
    private String content;

    public Word(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setTextItem(TextItem textItem) {
        content = textItem.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Word word = (Word) o;

        return getContent() != null ? getContent().equals(word.getContent()) : word.getContent() == null;
    }

    @Override
    public int hashCode() {
        return getContent() != null ? getContent().hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.content);
        builder.append(" ");
        return builder.toString();
    }
}
