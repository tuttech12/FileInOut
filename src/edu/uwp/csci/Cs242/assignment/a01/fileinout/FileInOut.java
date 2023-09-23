package edu.uwp.csci.Cs242.assignment.a01.fileinout;

// TODO: Double-check exception handling

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * FileInOut holds and keeps track of a Scanner for an input file and a
 * PrintWriter for an output file, which is used to for reading input and
 * writing output for the class.
 * <p>
 *  When a file is opened, a new Object of the type associated with the file
 *  (Scanner for input, PrintWriter for output) is instantiated and assigned to
 *  its relative property of this.
 *
 * @author Tyler Uttech
 * edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * edu.uwp.cs.242.section 001
 * edu.uwp.cs.242.assignment 1
 * bugs plenty right now
 *
 */
public class FileInOut {

    /**
     * default filename for the input file
     */
    private final String DEFAULTINFILENAME = "default_in.txt";

    /**
     * default filename for the output file
     */
    private final String DEFAULTOUTFILENAME = "default_out.txt";

    /**
     * variable that holds the current name of the input file
     */
    private String inFilename;

    /**
     * variable that holds the current name of the output file
     */
    private String outFilename;

    /**
     * The Scanner to read the input file.
     */
    private Scanner inFileScanner;

    /**
     * The PrintWriter to write for the output file.
     */
    private PrintWriter outFileWriter;

    // TODO: write a meaningful constructor.
    //public FileInOut()

    // region Getters and Setters
    /**
     * Returns the current filename of the input file.
     *
     * @return inFilename of the current input file.
     */
    private String getInFilename () {
        return inFilename;
    }

    /**
     * Sets the input file's filename to the given String.
     *
     * @param inFilename String to set the input file's filename to.
     */
    private void setInFilename(String inFilename){
        this.inFilename = inFilename;
    }

    /**
     * Returns the current filename of the output file.
     *
     * @return outFilename of the current output file.
     */
    private String getOutFilename () {
        return outFilename;
    }

    /**
     * Sets the output file's filename to the given String.
     *
     * @param outFilename String to set the output file's filename to.
     */
    private void setOutFilename(String outFilename){
        this.outFilename = outFilename;
    }

    /**
     * Returns true if the input file's Scanner is open, false otherwise.
     *
     * @return True if the input file's Scanner is open, false otherwise.
     */
    public boolean inFileIsOpen(){
        return inFileOpen;
    }
    /**
     * Returns true if the input file's PrintWriter is open, false otherwise.
     *
     * @return true if the input file's PrintWriter is open, false otherwise.
     */
    public boolean outFileIsOpen (){
        return outFileIsOpen;
    }
    /**
     * Opens the input file for input using a Scanner
     * <p>
     *  This method opens the file whose name is specified in the class level variable inFilename. The length
     *  is checked to ensure the variable has content. The file is opened via the Java Scanner class.
     *
     */
    public void openInFile() throws FileNotFoundException {
        File inFile;

        if(!inFilename.isEmpty()){
            inFile = new File(inFilename);
        } else {
            inFile = new File(DEFAULTINFILENAME);
        }


        try {
            inFileScanner = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            String message = "Cannot open input file! \n" + e.getMessage();
            throw new FileNotFoundException(message);
        }
        inFileIsOpen = true;
    }
    /**
     * Open outfile's PrintWriter openOutFile()
     */
    public void openOutFile(){
        File outFile;

        if (!outFilename.isEmpty()){
            outFile = new File(outFilename);
        } else {
            outFile = new File(DEFAULTINFILENAME);
        }
    }
    /**
     * openFiles()
     */
}
