package com.javalab.Storage;

import java.io.IOException;

public class Removable extends Storage
{
    Data d;

    public Data getD()
    {
        return d;
    }

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

    public Removable(Double capacity) throws IOException
    {
        this.capacity = capacity;
        d = new Data(capacity);
    }
}
