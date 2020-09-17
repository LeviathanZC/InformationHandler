package by.zercomp.application.service.impl;

import by.zercomp.application.controller.command.Request;
import by.zercomp.application.entity.SentenceItem;
import by.zercomp.application.entity.impl.Sentence;
import by.zercomp.application.entity.impl.Text;
import by.zercomp.application.entity.impl.Word;
import by.zercomp.application.service.Service;
import by.zercomp.application.service.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeleteWordsSpecifiedLengthStartedWithConsonantService implements Service<Text, Request> {

    @Override
    public Text perform(Request request) throws ServiceException {
        Text newText = new Text();
        List<Sentence> sentences = request.getData().getSentences();
        int length = (Integer) request.getParam();
        for (int i = 0; i < sentences.size(); i++) {
            newText.setTextItem(deleteSpecifiedLengthWord(sentences.get(i), length));
        }
        return newText;
    }

    private Sentence deleteSpecifiedLengthWord(Sentence given, int specifiedLength) {
        List<SentenceItem> words = given.getSentence();
        //System.out.println("given : " + given);
        for (int i = 0; i < words.size(); i++) {
            SentenceItem item = words.get(i);
            if (item instanceof Word) {
                //System.out.print("item [" + item + "] is a WORD!");
                if (((Word) item).getContent().length() == specifiedLength) {
                    //System.out.println(" and suited to requirements");
                    if (isStartedWithConsonant((Word) item)) {
                        //System.out.println(item);
                        words.remove(item);
                        //System.out.println("\tRemoved!\n");
                    }
                }
                //System.out.println();
            }
        }
        Sentence newSentence = new Sentence();
        //System.out.println("\n\n Create newSentence");
        for (SentenceItem item : words) {
            //System.out.println("added item : " + item);
            newSentence.setTextItem(item);
            //System.out.println(item);
        }
        return newSentence;
    }

    private boolean isStartedWithConsonant(Word word) {
        boolean flag = true;
        char firstChar = word.getContent().charAt(0);
        switch (firstChar) {
            case 'a':
            case 'o':
            case 'e':
            case 'u':
            case 'A':
            case 'O':
            case 'E':
            case 'U':
            case 'I':
            case 'i':
            case 'Y':
            case 'y': {
                flag = false;
            }
        }
        return flag;
    }

}
