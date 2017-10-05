package com.javalab.Storage;

import java.io.IOException;

public class Removable extends Storage
{
    Data d;

    @Override
    public Double getcapacity()
    {
        return this.capacity;
    }

    public Data getD()
    {
        return d;
    }

    @Override
    void capacity()
    {}

    @Override
    void persistenceSave()
    {}

    public Removable(Double capacity) throws IOException
    {
        this.capacity = capacity;
        d = new Data(capacity);
    }
}
