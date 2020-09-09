package by.zercomp.application.controller;

import by.zercomp.application.dal.DaoException;
import by.zercomp.application.dal.InformationDAO;
import by.zercomp.application.dal.impl.InformationDAOImpl;

import java.util.List;

public class MainController {

    public static void main(String[] args) throws DaoException {
        InformationDAO dao = InformationDAOImpl.getInstance();
        List<String> strings = dao.findAll();
        for (String item : strings) {
            System.out.println(item);
            System.out.println();
        }
    }

}
