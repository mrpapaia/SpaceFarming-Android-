package com.example.spacefarming.interfaces;

import java.util.List;

public interface InterfaceCallback {
    interface ApiCallbackList{
        void onCallback(List<Object> list);
    }

    interface ApiCallback{
            void onCallback(Object obj);

    }
}
