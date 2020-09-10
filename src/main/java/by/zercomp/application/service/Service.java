package by.zercomp.application.service;

public interface Service<T> {

    T perform() throws ServiceException;

}
