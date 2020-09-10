package by.zercomp.application.service;

public class RegexConst {
    public static final String PROPERTY_KEY_SOURCE_TEXT_FILE_PATH = "textSourcePath";
    public static final String SENTENCE = "[A-Z][^\\.\\!\\?]+[\\.\\!\\?]";
    public static final String WORD_OR_PUNCT = "([\\w-]+|[^\\w\\s])";
    public static final String WORD = "(\\w+)-?(\\w+)?";

    private RegexConst() {
    }
}
