package by.zercomp.application.controller;

import by.zercomp.application.controller.command.Request;
import by.zercomp.application.dal.DaoException;
import by.zercomp.application.entity.SentenceItem;
import by.zercomp.application.entity.impl.Sentence;
import by.zercomp.application.entity.impl.Text;
import by.zercomp.application.service.ServiceException;
import by.zercomp.application.service.impl.DeleteWordsSpecifiedLengthStartedWithConsonantService;
import by.zercomp.application.service.impl.FindService;

import java.util.List;

public class MainController {

    public static void main(String[] args) throws DaoException, ServiceException {
        FindService reader = new FindService();
        Text text = reader.perform(true);
        DeleteWordsSpecifiedLengthStartedWithConsonantService counter = new DeleteWordsSpecifiedLengthStartedWithConsonantService();
        Request request = new Request(text, 3);
        Text newText = counter.perform(request);
        List<Sentence> sentences = newText.getSentences();
        for (Sentence item : sentences) {
            System.out.println(item);
        }
    }

}
