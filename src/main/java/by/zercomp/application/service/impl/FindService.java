package by.zercomp.application.service.impl;

import by.zercomp.application.dal.DaoException;
import by.zercomp.application.dal.InformationDAO;
import by.zercomp.application.dal.impl.InformationDAOImpl;
import by.zercomp.application.entity.impl.Text;
import by.zercomp.application.service.ServiceException;
import by.zercomp.application.service.parser.LinkParser;
import by.zercomp.application.service.RegexConst;
import by.zercomp.application.service.Service;

public class FindService implements Service<Text, Boolean> {


    @Override
    public Text perform(Boolean stub) throws ServiceException {
        InformationDAO dao = InformationDAOImpl.getInstance();
        String allText;
        try {
            allText = dao.findAll();
            LinkParser parser = new LinkParser(RegexConst.SENTENCE);
            parser.setNext(new LinkParser(RegexConst.WORD_OR_PUNCT));
            parser.setNext(new LinkParser(RegexConst.WORD));
            return (Text) parser.parse(allText);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }
}
