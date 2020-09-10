package by.zercomp.application.service.parser;

import by.zercomp.application.entity.TextItem;
import by.zercomp.application.entity.impl.Punctuation;
import by.zercomp.application.entity.impl.Sentence;
import by.zercomp.application.entity.impl.Text;
import by.zercomp.application.entity.impl.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkParser {
    private LinkParser next;
    private Pattern pattern;

    public LinkParser(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public void setNext(LinkParser nextParser) {
        if (this.next == null) {
            this.next = nextParser;
        } else {
            this.next.setNext(nextParser);
        }
    }

    public TextItem parse(String text) {
        Matcher matcher = this.pattern.matcher(text);
        TextItem textItem;
        if (next != null) {
            List<String> uncompleted = new ArrayList<>();
            while (matcher.find()) {
                uncompleted.add(matcher.group());
            }
            textItem = next.next == null ? new Sentence() : new Text();
            for (String sentene : uncompleted) {
                textItem.setTextItem(next.parse(sentene));
            }
        } else {
            textItem = matcher.find() ? new Word(text) : new Punctuation(text.charAt(0));
        }
        return textItem;
    }

}
