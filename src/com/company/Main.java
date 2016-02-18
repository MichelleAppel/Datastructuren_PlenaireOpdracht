package com.company;
import java.io.*;

public class Main {

    // declare new array with 638285 free spaces (lines amount of wordlist.txt)
    private static String[] wordDatabase = new String[638285];
    private static final String DIR_NAME = "src/samples";

    private static String[] wordDatabase3 = new String[10000];
    
    private static int totalCorrectWords = 0;
    private static int totalCorrectWords3 = 0;

    public static void main(String[] args) {

        // fill in all array indices with words from the file
        createWordDatabase1();
        spellcheck1();

        createWordDatabase3();
        spellcheck3();
    }

    public static void spellcheck1() {
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
        System.out.println("It took method 1 "  + runTime + " nanosecs. (" + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)");
    }



    public static void createWordDatabase1() {
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



    public static void createWordDatabase3() {
        // buffered reader om wordlist op te slaan in een hash table (wordDatabase)

        BufferedReader br3 = null;

        try {

            String currentLine3;

            // new buffered reader
            br3 = new BufferedReader(new FileReader(new File("wordlist.txt")));

            // put the lines of text file (wordlist.txt) in an array
            int key = 0;
            while ((currentLine3 = br3.readLine()) != null) {
                for(int i = 0; i < currentLine3.length(); i++) {
                    key += Character.getNumericValue(currentLine3.charAt(i));
                }
                if (wordDatabase3[key] == null) {
                    wordDatabase3[key] = "/" + currentLine3 + "/";
                } else {
                    wordDatabase3[key] += currentLine3 + "/";
                }
                key = 0;
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br3 != null) br3.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


    public static void spellcheck3() {
        // for multiple files
        //File[] files = new File(DIR_NAME).listFiles();
        //for(File file_name: files) {

        // measure start time
        long start = System.nanoTime();

        // buffered reader voor de sample list
        BufferedReader br33 = null;
        try {
            String currentLine33;
            // new buffered reader (new File())
            br33 = new BufferedReader(new FileReader("sample__in]Ot6R79.txt"));


            int wordsInFile = 0;
            int key = 0;
            while ((currentLine33 = br33.readLine()) != null) {

                for (int l = 0; l < currentLine33.length(); l++) {
                    key += Character.getNumericValue(currentLine33.charAt(l));
                }

                if (wordDatabase3[key] != null) {
                    if (wordDatabase3[key].contains("/" + currentLine33 + "/")){
                        totalCorrectWords3 += 1;
                    }
                    key = 0;
                    wordsInFile++;
                }
            }
            System.out.println("From " + wordsInFile + " words in the sample file, " +
                    totalCorrectWords3 + " words were spelled correctly.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br33 != null) br33.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // measure stop time and substract start time to get execution time
        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 3 " + runTime + " nanosecs. (" + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );
    }


















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

