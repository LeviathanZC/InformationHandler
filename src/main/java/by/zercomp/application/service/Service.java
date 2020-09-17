package by.zercomp.application.service;

public interface Service<T, V> {

    T perform(V request) throws ServiceException;

}
