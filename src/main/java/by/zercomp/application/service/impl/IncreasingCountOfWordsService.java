package by.zercomp.application.service.impl;

import by.zercomp.application.entity.impl.Sentence;
import by.zercomp.application.service.Service;
import by.zercomp.application.service.ServiceException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IncreasingCountOfWordsService implements Service<List<Sentence>, List<Sentence>> {


    @Override
    public List<Sentence> perform(List<Sentence> request) throws ServiceException {
        ArrayList<Sentence> sentences = new ArrayList<Sentence>(request);
        sentences.sort(Comparator.<Sentence>naturalOrder());
        return sentences;
    }
}
