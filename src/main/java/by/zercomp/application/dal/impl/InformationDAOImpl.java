package by.zercomp.application.dal.impl;

import by.zercomp.application.dal.DaoException;
import by.zercomp.application.dal.InformationDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InformationDAOImpl implements InformationDAO {

    private static volatile InformationDAO INSTANCE;

    private InformationDAOImpl() {
    }

    public static InformationDAO getInstance() {
        if (INSTANCE == null) {
            synchronized (InformationDAOImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new InformationDAOImpl();
                    ;
                }
            }
        }
        return INSTANCE;
    }

    private ResourceBundle bundle;
    private String property = "input";
    private String filePath = "file.path";
    private String path;

    {
        bundle = ResourceBundle.getBundle(property);
        path = bundle.getString(filePath);
    }

    @Override
    public List<String> findAll() throws DaoException {
        List<String> strings = new ArrayList<>();
        File file = new File(this.path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("can't read file : " + e);
        } catch (IOException e) {
            throw new DaoException("error while reading file : " + e);
        }
        return strings;
    }
}
