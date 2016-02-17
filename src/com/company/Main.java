package com.company;
import java.io.*;

public class Main {

    // declare new array with 638285 free spaces (lines amount of wordlist.txt)
    private static String[] wordDatabase = new String[638285];
    private static final String DIR_NAME = "src/samples";

    private static int totalCorrectWords = 0;

    public static void main(String[] args) {

        // fill in all array indices with words from the file
        createWordDatabase();

        // for multiple files
        //File[] files = new File(DIR_NAME).listFiles();
        //for(File file_name: files) {

        // measure start time
        long start = System.nanoTime();

        // buffered reader voor de sample list
        BufferedReader br2 = null;
        try {
            String currentLine2;
            // new buffered reader (new File())
            br2 = new BufferedReader(new FileReader("sample__in]Ot6R79.txt"));

            boolean wordFound;
            int wordsInFile = 0;
            int i = 0;
            while ((currentLine2 = br2.readLine()) != null) {
                int j = 0;
                wordFound = false;
                while (j < wordDatabase.length && !wordFound) {
                    if (currentLine2.equals(wordDatabase[j])) {
                        totalCorrectWords += 1;
                        wordFound = true;
                    }
                    j++;
                }
                i++;
                wordsInFile = i;
            }
            System.out.println("From " + wordsInFile + " words in the sample file, " +
                    totalCorrectWords + " words were spelled correctly.");

        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                    if (br2 != null) br2.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }

            // measure stop time and substract start time to get execution time
            long stop = System.nanoTime();
            long runTime = stop - start;
            System.out.println(runTime);
    }

    public static void createWordDatabase() {
        // buffered reader om wordlist op te slaan in een array (wordDatabase)
        BufferedReader br = null;

        try {
            String currentLine;

            // new buffered reader
            br = new BufferedReader(new FileReader(new File("wordlist.txt")));

            // put all the lines (words) of wordlist.txt in the array
            int i = 0;
            while ((currentLine = br.readLine()) != null) {
                wordDatabase[i] = currentLine;
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }









    // Michelle doe je jouw stukje in een nieuwe functie hieronder??

























}


// end of file

    /*

    COMMENTS

    public static void main(String args[])throws IOException{

        File file = new File("hello1.txt");

        // creates the file
         file.createNewFile();
        // creates a FileWriter Object
         FileWriter writer = new FileWriter(file);
        // Writes the content to the file
         writer.write("This\n is\n an\n example\n");
         writer.flush();
         writer.close();

        //Creates a FileReader Object
        FileReader fr = new FileReader(file);
        char [] a = new char[50];
        fr.read(a); // reads the content to the array
        for(char c : a)
            System.out.print(c); //prints the characters one by one
        fr.close();


    }
    */
    // een test

