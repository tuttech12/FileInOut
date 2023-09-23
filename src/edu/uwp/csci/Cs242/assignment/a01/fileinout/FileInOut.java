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
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @bugs plenty right now TODO:  remove this when done
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

    /**
     * Represents whether the input file's Scanner is open or not.
     */
    private boolean inFileIsOpen = false;

    /**
     * Represents whether the output file's PrintWriter is open or not.
     */
    private boolean outFileIsOpen = false;

    /**
     * This constructor uses the provided input and output file names to set the objects internal
     * input and outfile file names.
     * <p>
     *  The files can also be opened by passing TRUE as the pOpenFlag parameter
     * <p>
     * @param pIn - String value for the name of the input file
     * @param pOut - String value for the name of the output file
     * @param pOpenFlag - Flag that determined whether the files will be opened or not. TRUE means that the
     *                      files should be opened; FALSE otherwise.
     * @throws FileNotFoundException if the input file does not exist, input file cannot be written into, or the output
     *  file cannot be written into.
     */

    public FileInOut(String pIn, String pOut, Boolean pOpenFlag) throws FileNotFoundException {
        inFilename = pIn;
        outFilename = pOut;

        if(pOpenFlag){
            openFiles();
        }
    }

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
        return inFileIsOpen;
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
     * @throws FileNotFoundException if the input file does not exist or cannot be read
     */
    public void openInFile() throws FileNotFoundException {
        File inFile;

        if (!inFilename.isEmpty()) {
            inFile = new File(inFilename);
        } else {
            System.out.println("File is empty. Switching to default file.");
            inFile = new File(DEFAULTINFILENAME);
        }

        // Close the scanner if it's already open before assigning new object
        if (inFileIsOpen) {
            inFileScanner.close();
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
     * This method opens the outFile's PrinterWriter. The length is checked to ensure the variable has content. The
     * file is opened via the Java PrintWriter class.
     *
     *  @throws FileNotFoundException if the output file cannot be written into
     */
    public void openOutFile() throws FileNotFoundException {
        File outFile;

        if (!outFilename.isEmpty()){
            outFile = new File(outFilename);
        } else {
            System.out.println("File is empty. Switching to default file.");
            outFile = new File(DEFAULTOUTFILENAME);
        }

        // Close the PrintWriter if it's already open before assigning a new object
        if (outFileIsOpen){
            outFileWriter.close();
        }

        try {
            outFileWriter = new PrintWriter(outFile);
        } catch (FileNotFoundException e) {
            String message = "Cannot open output file! \n" + e.getMessage();
            throw new FileNotFoundException(message);
        }
        outFileIsOpen = true;
    }
    /**
     * Meta-method that opens both the input file and the output file
     */
    public void openFiles() throws FileNotFoundException {
        openInFile();
        openOutFile();
    }

    /**
     * Meta-method to close all the open files
     */
    public void closeFiles(){
        closeInFile();
        closeOutFile();
    }
    /**
     * Method to close the input file
     */
    public void closeInFile(){
        inFileScanner.close();
        inFileIsOpen = false;
    }

    /**
     * Method to close the output file
     */
    public void closeOutFile(){
        outFileWriter.close();
        outFileIsOpen = false;
    }
}
