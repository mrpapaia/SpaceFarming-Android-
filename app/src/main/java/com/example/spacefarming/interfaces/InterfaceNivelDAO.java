package com.example.spacefarming.interfaces;

import android.widget.EditText;

import java.util.List;

import com.example.spacefarming.entidades.Botijao;

public interface InterfaceNivelDAO<T> {
    public void getById(InterfaceCallback.ApiCallbackList callback, String idBotijao);

    public void add(InterfaceCallback.ApiCallback callback, T obj);

    public void list(InterfaceCallback.ApiCallbackList callback);

    public void delete(InterfaceCallback.ApiCallback callback, String id);
}
