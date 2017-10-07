package com.javalab;

import java.util.ArrayList;

public class LabourMethods
{
    public static void clrscr()
    {
        for(int i = 0; i<70; i++)     //works as clrscr()
            System.out.println();
    }

    public static int checkUser(String name, ArrayList<User> users)
    {
        int index = -1;

        for(User temp : users)
        {
            if(temp.name.equals(name))
                index = users.indexOf(temp);
        }

        return index;
    }
}
