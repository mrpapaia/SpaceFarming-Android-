package com.example.spacefarming.interfaces;


public interface InterfaceDAO<T> {
    public void getById(InterfaceCallback.ApiCallback callback, String idBotijao);

    public void add(InterfaceCallback.ApiCallback callback, T obj);

    public void list(InterfaceCallback.ApiCallbackList callback);

    public void delete(InterfaceCallback.ApiCallback callback, String idBotijao);
}


