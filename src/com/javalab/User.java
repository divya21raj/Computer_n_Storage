package com.javalab;

import com.javalab.Computer.*;
import com.javalab.Storage.External;
import com.javalab.Storage.Removable;

import java.io.IOException;

public class User
{
    String name;

    Computer laptop, desktop, mobile, tablet;

    Removable usb;
    External hdd;

    User() throws IOException
    {
        laptop = null;
        mobile = null;
        desktop = null;
        tablet = null;


        usb = new Removable((double) (8*1023));
        hdd = new External((double) (999*1023));
    }
}
