package by.zercomp.application.service.impl;

import by.zercomp.application.dal.DaoException;
import by.zercomp.application.dal.InformationDAO;
import by.zercomp.application.dal.impl.InformationDAOImpl;
import by.zercomp.application.entity.impl.Text;
import by.zercomp.application.service.ServiceException;
import by.zercomp.application.service.parser.LinkParser;
import by.zercomp.application.service.RegexConst;
import by.zercomp.application.service.Service;

import java.util.List;

public class FindService implements Service<Text> {


    @Override
    public Text perform() throws ServiceException {
        InformationDAO dao = InformationDAOImpl.getInstance();
        List<String> allStrings;
        try {
            allStrings = dao.findAll();
            LinkParser parser = new LinkParser(RegexConst.SENTENCE);
            parser.setNext(new LinkParser(RegexConst.WORD_OR_PUNCT));
            parser.setNext(new LinkParser(RegexConst.WORD));
            return (Text) parser.parse(allStrings.toString());
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }
}
