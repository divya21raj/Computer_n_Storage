package com.javalab.Storage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Data
{
    ArrayList<String> files;
    ArrayList<Double> size; //size of each file in files

    static ArrayList<String> allFiles;
    static ArrayList<Double> allFileSize;

    Data() throws IOException
    {
        if(allFiles.isEmpty() == true)
            allFilesInit();

        fillData(files);

    }

    private void fillData(ArrayList<String> files) throws IOException
    {
        Random random = new Random();

        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int i=0; i<allFiles.size(); i++)
            numList.add(i);

        Collections.shuffle(numList);


        for(int i =0; i< random.nextInt(allFiles.size()); i++)
        {
            files.add(allFiles.get(numList.get(i)));
            size.add(allFileSize.get(numList.get(i)));
        }

    }

    private void allFilesInit() throws IOException
    {
        String fileSource = "files/fileNames.txt";
        String sizeSource = "files/fileSizes.txt";
        FileReader fileReader1 = new FileReader(fileSource);
        FileReader fileReader2 = new FileReader(sizeSource);

        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

        while(true)
        {
            String fileLine = bufferedReader1.readLine();
            String sizeLine = bufferedReader2.readLine();

            if(fileLine == null)
                break;

            else
            {
                allFiles.add(fileLine);
                allFileSize.add(Double.parseDouble(sizeLine));
            }
        }

        bufferedReader1.close();
        bufferedReader2.close();
        fileReader1.close();
        fileReader2.close();
    }
}
