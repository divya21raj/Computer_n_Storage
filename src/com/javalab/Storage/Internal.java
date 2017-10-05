package com.javalab.Storage;

import java.io.IOException;

public class Internal extends Storage
{
    Data d;

    @Override
    void capacity()
    {}

    @Override
    void persistenceSave()
    {}

    public Internal(Double capacity) throws IOException
    {
        this.capacity = capacity;
        d = new Data(capacity);
    }

    public Data getD()
    {
        return d;
    }
}
