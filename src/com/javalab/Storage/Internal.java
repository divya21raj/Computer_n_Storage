package com.javalab.Storage;

import java.io.IOException;

public class Internal extends Storage
{
    Data d;

    @Override
    void capacity()
    {
        System.out.println("The capacity of this device is " + Double.toString(this.capacity/1024) + " GB." );
    }

    @Override
    void persistenceSave()
    {
        System.out.println("This device supports persisting saving!");
    }

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
