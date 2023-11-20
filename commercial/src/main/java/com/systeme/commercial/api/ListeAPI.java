package com.systeme.commercial.api;

public class ListeAPI extends APIResponse {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

     public ListeAPI(String string, Object object) {
        super(string, object);
    }
}
