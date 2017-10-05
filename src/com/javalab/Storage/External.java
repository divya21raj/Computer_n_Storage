package com.javalab.Storage;

import java.io.IOException;

public class External extends Storage
{
    Data d;

    public Data getD()
    {
        return d;
    }

    @Override
    void capacity()
    {

    }

    @Override
    void persistenceSave()
    {

    }

    public External(Double capacity) throws IOException
    {
        this.capacity = capacity;
        d = new Data(capacity);
    }
}
