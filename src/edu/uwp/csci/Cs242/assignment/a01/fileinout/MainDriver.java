package edu.uwp.csci.Cs242.assignment.a01.fileinout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A program to encrypt a selected file
 *
 * @author Tyler Uttech
 * @edu.uwp.edu.cs.242.course CS242 - Computer Science II
 * @bugs none since they're is no program at the moment // TODO:  remove this when done
 */
public class MainDriver {
    public static void main (String [] args) throws FileNotFoundException {

        // select file for reading input
        final String fileName = "testFiles/FavoriteQuote.txt";
        // select file for writing output to
        final String copyFileName = "testFiles/FavoriteQuote-copy.txt";

        //create FileInOut constructor with input and output file above
        FileInOut fio = new FileInOut(fileName, copyFileName, true);

        fio.openInFile();
        fio.openOutFile();

        Scanner read = new Scanner(new FileReader(fileName));
        try {
            String line;
            while ((line = read.nextLine()) != null){
                System.out.println(line);
                if (!read.hasNextLine()){
                    System.out.println("\n End of file.");
                    break;
                }
            }
        }
            finally
         {
            read.close();
        }
        }



    }

