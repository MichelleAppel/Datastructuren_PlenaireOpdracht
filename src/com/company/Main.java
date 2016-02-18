package com.company;
import java.io.*;

public class Main {

    // declare new array with 638285 free spaces (lines amount of wordlist.txt)
    private static final String DIR_NAME = "src/samples";

    private static String[] wordDatabase = new String[638285];
    private static String[] wordDatabase2 = new String[100000000];
    private static String[] wordDatabase3 = new String[5000];

    private static int totalCorrectWords = 0;
    private static int totalCorrectWords2 = 0;
    private static int totalCorrectWords3 = 0;

    public static void main(String[] args) {

        // fill in all array indices with words from the file
        createWordDatabase1();
        spellcheck1();

        createWordDatabase2();
        spellcheck2();

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
        long start = System.nanoTime();
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

        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 1 " + runTime + " nanosecs to create the worddatabase. (" + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );

    }


    public static void createWordDatabase2() {
        long start = System.nanoTime();
        // buffered reader om wordlist op te slaan in een hash table (wordDatabase)

        BufferedReader br21 = null;

        try {

            String currentLine21;

            // new buffered reader
            br21 = new BufferedReader(new FileReader(new File("wordlist.txt")));

            // put the lines of text file (wordlist.txt) in an hashmap
            int key = 0;
            char charAt;
            int firstPrime = 7;
            int secondPrime = 11;
            while ((currentLine21 = br21.readLine()) != null) {
                for(int i = 0; i < currentLine21.length(); i++) {
                    charAt = currentLine21.charAt(i);
                    key += Character.getNumericValue(charAt);
                }
                // multiply key by word length times firstPrime
                int wordLength = currentLine21.length();
                key *= wordLength*firstPrime;

                // add numeric value of first char times word length times secondPrime
                char firstLetter = currentLine21.charAt(0);
                key += Character.getNumericValue(firstLetter)*wordLength*secondPrime;

                boolean wordIsPlaced = false;
                while(!wordIsPlaced) {
                    if(wordDatabase2[key] == null) {
                        wordDatabase2[key] = currentLine21;
                        wordIsPlaced = true;
                    } else {
                        key += firstLetter;
                    }
                }
                key = 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br21 != null) br21.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 3 " + runTime + " nanosecs to create the worddatabase. (" + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );

    }

    public static void spellcheck2() {
        // for multiple files
        //File[] files = new File(DIR_NAME).listFiles();
        //for(File file_name: files) {

        // measure start time
        long start = System.nanoTime();

        // buffered reader voor de sample list
        BufferedReader br22 = null;
        try {
            String currentLine22;
            // new buffered reader (new File())
            br22 = new BufferedReader(new FileReader("sample__in]Ot6R79.txt"));

            boolean wordFound2;
            int wordsInFile = 0;
            int i = 0;
            int key = 0;
            int firstPrime = 7;
            int secondPrime = 11;
            while ((currentLine22 = br22.readLine()) != null) {
                wordFound2 = false;

                char charAt;

                for (int l = 0; l < currentLine22.length(); l++) {
                        charAt = currentLine22.charAt(l);
                        key += Character.getNumericValue(charAt);
                    }

                // multiply key by word length times firstPrime
                int wordLength = currentLine22.length();
                key *= wordLength*firstPrime;

                // add numeric value of first char times word length times secondPrime
                char firstLetter = currentLine22.charAt(0);
                key += Character.getNumericValue(firstLetter)*wordLength*secondPrime;

                //System.out.println(currentLine33);
                //System.out.println(wordDatabase3[key]);

                int currentKey = key;
                while(!wordFound2 && key < currentKey+1000000) {
                    if(wordDatabase2[key] == null) {
                        break;
                    }
                    if(wordDatabase2[key].equals(currentLine22)) {
                        totalCorrectWords2 += 1;
                        wordFound2 = true;
                    } else {
                        key += firstLetter;
                    }
                }

                key = 0;
                i++;
                wordsInFile = i;
            }
            System.out.println("From " + wordsInFile + " words in the sample file, " +
                    totalCorrectWords2 + " words were spelled correctly.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br22 != null) br22.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // measure stop time and substract start time to get execution time
        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 2 " + runTime + " nanosecs. (" + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)"  );
    }


















    // Michelle doe je jouw stukje in een nieuwe functie hieronder??



    public static void createWordDatabase3() {
        // buffered reader om wordlist op te slaan in een array (wordDatabase3)
        long start = System.nanoTime();
        BufferedReader br3 = null;

        try {
            String currentLine3;
            int key;

            // new buffered reader
            br3 = new BufferedReader(new FileReader(new File("wordlist.txt")));

            // put the lines of text file (wordlist.txt) in an array at the index given by the key of the word
            // which is the numeric value of the characters summed up
            while ((currentLine3 = br3.readLine()) != null) {
            key = keyGen(currentLine3);
                if (wordDatabase3[key] != null) {
                    wordDatabase3[key] += currentLine3 + "/";
                } else {
                    wordDatabase3[key] = "/" + currentLine3 + "/";
                }
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
        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 3 " + runTime + " nanosecs to create the worddatabase. (" + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );

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
            int key;
            while ((currentLine33 = br33.readLine()) != null) {

                key = keyGen(currentLine33);

                if (wordDatabase3[key] != null) {
                    if (wordDatabase3[key].contains("/" + currentLine33 + "/")){
                        totalCorrectWords3 += 1;
                    }

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




    public static int keyGen(String word) {
        int key = 0;
        for(int i = 0; i < word.length(); i++) {
            key += Character.getNumericValue(word.charAt(i));
        }
        return key;
    }


}

