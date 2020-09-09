package by.zercomp.application.dal.parser;

import by.zercomp.application.entity.TextItem;

import java.util.regex.Matcher;

public class LinkParser {
    private LinkParser next;

    public void setNext(LinkParser nextParser) {
        if (this.next == null) {
            this.next = nextParser;
        } else {
            this.next.setNext(nextParser);
        }
    }


}
