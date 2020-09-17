package by.zercomp.application.service.impl;

import by.zercomp.application.entity.SentenceItem;
import by.zercomp.application.entity.impl.Sentence;
import by.zercomp.application.service.Service;
import by.zercomp.application.service.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountWordsInSentencesService implements Service<Integer, List<Sentence>> {

    // TODO: 17.09.20 Peredelat' naxyi
    @Override
    public Integer perform(List<Sentence> request) throws ServiceException {
        int count = 0;
        for (Sentence sentence : request) {
            Set<SentenceItem> tempSet = new HashSet<SentenceItem>(sentence.getSentence());
            if(tempSet.size() < sentence.getCountOfWords()) {
                count++;
            }
        }
        return count;
    }
}