package by.zercomp.application.entity.impl;

import by.zercomp.application.entity.SentenceItem;
import by.zercomp.application.entity.TextItem;

public class Punctuation implements SentenceItem {
    private Character character;

    public Punctuation(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Punctuation that = (Punctuation) o;

        return getCharacter() != null ? getCharacter().equals(that.getCharacter()) : that.getCharacter() == null;
    }

    @Override
    public int hashCode() {
        return getCharacter() != null ? getCharacter().hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(character);
        builder.append(" ");
        return builder.toString();
    }

    @Override
    public void setTextItem(TextItem textItem) {
        character = textItem.toString().charAt(0);
    }
}
