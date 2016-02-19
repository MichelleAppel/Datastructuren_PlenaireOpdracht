package com.company;
import java.io.*;

public class Main {


    private static final String DIR_NAME = "src/samples";

    // declare new array with 638285 free spaces (lines amount of wordlist.txt)

    private static String[] wordDatabase = new String[638285];
    private static String[] wordDatabase2 = new String[1000000];

    private static final int ARRAY_SIZE = 500;
    private static String[] wordDatabase3 = new String[ARRAY_SIZE];

    private static int[][][] wordDatabase4 = new int[15000][100][2];

    private static int totalCorrectWords = 0;
    private static int totalCorrectWords2 = 0;
    private static int totalCorrectWords3 = 0;
    private static int totalCorrectWords4 = 0;


    public static void main(String[] args) {
        //createWordDatabase1();
        //spellcheck1();

        //createWordDatabase2();
        //spellcheck2();

        //createWordDatabase3();
        //spellcheck3();

        createWordDatabase4();
        //spellcheck4();
    }

    public static void createWordDatabase1() {
        long start = System.nanoTime();
        // buffered reader om wordlist op te slaan in een array (wordDatabase)
        BufferedReader br11 = null;

        try {
            String currentLine;

            // new buffered reader
            br11 = new BufferedReader(new FileReader(new File("wordlist.txt")));

            // put all the lines (words) of wordlist.txt in the array
            int i = 0;
            while ((currentLine = br11.readLine()) != null) {
                wordDatabase[i] = currentLine;
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br11 != null) br11.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 1 " + runTime + " nanosecs to create the worddatabase. ("
                + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );

    }

    public static void spellcheck1() {
        // for multiple files
        //File[] files = new File(DIR_NAME).listFiles();
        //for(File file_name: files) {

        // measure start time
        long start = System.nanoTime();

        // buffered reader voor de sample list
        BufferedReader br12 = null;
        try {
            String currentLine2;
            // new buffered reader (new File())
            br12 = new BufferedReader(new FileReader("sample__in]Ot6R79.txt"));

            boolean wordFound;
            int wordsInFile = 0;
            int i = 0;
            while ((currentLine2 = br12.readLine()) != null) {
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
                if (br12 != null) br12.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // measure stop time and substract start time to get execution time
        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 1 "  + runTime + " nanosecs. (" + runTime / 1000000000 + "."
                + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)");
    }

    public static void createWordDatabase2() {
        long start = System.nanoTime();
        // buffered reader om wordlist op te slaan in een hash table (wordDatabase)

        BufferedReader br21 = null;

        try {
            String currentLine21;

            // new buffered reader
            br21 = new BufferedReader(new FileReader(new File("wordlist.txt")));

            // put the lines of text file (wordlist.txt) in a hashmap
            int key;
            while ((currentLine21 = br21.readLine()) != null) {
                key = specialKeyGen(currentLine21);
                boolean wordIsPlaced = false;
                while(!wordIsPlaced) {
                    if(key < 1000000) {
                        if (wordDatabase2[key] == null) {
                            wordDatabase2[key] = currentLine21;
                            wordIsPlaced = true;
                        } else {
                            key += 1;
                        }
                    } else {
                        key -= 999999;
                    }
                }
                //key = 0;
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
        System.out.println("It took method 2 " + runTime + " nanosecs to create the worddatabase. ("
                + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );

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
            int key;
            while ((currentLine22 = br22.readLine()) != null) {
                key = specialKeyGen(currentLine22);
                wordFound2 = false;

                int currentKey = key;
                while(!wordFound2 && key < currentKey+1000000) {
                    if(key < 1000000) {
                        if (wordDatabase2[key] == null) {
                            break;
                        }
                        if (wordDatabase2[key].equals(currentLine22)) {
                            totalCorrectWords2 += 1;
                            wordFound2 = true;
                        } else {
                            key += 1;
                        }
                    } else {
                        key -= 999999;
                    }
                }
                //key = 0;

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

    public static void createWordDatabase3() {
        // buffered reader om wordlist op te slaan in een array (wordDatabase3)
        long start = System.nanoTime();
        BufferedReader br31 = null;

        try {
            String currentLine31;
            int key;

            // new buffered reader
            br31 = new BufferedReader(new FileReader(new File("wordlist.txt")));

            // put the lines of text file (wordlist.txt) in an array at the index given by the key of the word
            // which is the numeric value of the characters summed up
            while ((currentLine31 = br31.readLine()) != null) {
            key = keyGen(currentLine31);
                if (wordDatabase3[key] != null) {
                    wordDatabase3[key] += currentLine31 + "/";
                } else {
                    wordDatabase3[key] = "/" + currentLine31 + "/";
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br31 != null) br31.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 3 " + runTime + " nanosecs to create the worddatabase. ("
                + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );

    }


    public static void spellcheck3() {
        // for multiple files
        //File[] files = new File(DIR_NAME).listFiles();
        //for(File file_name: files) {

        // measure start time
        long start = System.nanoTime();

        // buffered reader voor de sample list
        BufferedReader br32 = null;
        try {
            String currentLine33;
            // new buffered reader (new File())
            br32 = new BufferedReader(new FileReader("sample__in]Ot6R79.txt"));


            int wordsInFile = 0;
            int key;
            while ((currentLine33 = br32.readLine()) != null) {

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
                if (br32 != null) br32.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // measure stop time and substract start time to get execution time
        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 3 " + runTime + " nanosecs. (" + runTime / 1000000000 + "." +
                ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );
    }

    public static int keyGen(String word) {
        int key = 0;
        for(int i = 0; i < word.length(); i++) {
            key += Character.getNumericValue(word.charAt(i));
        }
        while(key >= ARRAY_SIZE) {
            key -= ARRAY_SIZE;
        }
        return key;
    }

    public static int specialKeyGen(String word) {
        int key = 0;
        char charAt;
        for(int i = 0; i < word.length(); i++) {
            charAt = word.charAt(i);
            key += Character.getNumericValue(charAt)*2;
            key += Character.getNumericValue(charAt)*i;
        }
        // multiply key by word length times firstPrime
        int wordLength = word.length();
        key *= 7*wordLength*wordLength;

        // add numeric value of first char times word length times secondPrime
        char firstLetter = word.charAt(0);
        key += Character.getNumericValue(firstLetter)*wordLength
                *11*13;
        key += firstLetter+3;
        return key;
    }


    public static void createWordDatabase4() {
        // buffered reader om wordlist op te slaan in een array (wordDatabase3)
        long start = System.nanoTime();
        BufferedReader br4 = null;

        try {
            String currentLine4;

            // new buffered reader
            br4 = new BufferedReader(new FileReader(new File("wordlist.txt")));

            while ((currentLine4 = br4.readLine()) != null) {
                int char_at;
                int char_at1;
                for(int i = 0; i < currentLine4.length(); i++){
                    char_at = Character.getNumericValue(currentLine4.charAt(i)) - 64;

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br4 != null) br4.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 4 " + runTime + " nanosecs to create the worddatabase. ("
                + runTime / 1000000000 + "." + ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );

        // insert code here
    }

    public static void spellcheck4() {
        long start = System.nanoTime();

        // buffered reader voor de sample list
        BufferedReader br42 = null;
        try {
            String currentLine42;
            // new buffered reader (new File())
            br42 = new BufferedReader(new FileReader("sample__in]Ot6R79.txt"));


            int wordsInFile = 0;
            int char_at;
            int char_at1;
            while ((currentLine42 = br42.readLine()) != null) {

                // fillin

                }

            System.out.println("From " + wordsInFile + " words in the sample file, " +
                    totalCorrectWords4 + " words were spelled correctly.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br42 != null) br42.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // measure stop time and substract start time to get execution time
        long stop = System.nanoTime();
        long runTime = stop - start;
        System.out.println("It took method 3 " + runTime + " nanosecs. (" + runTime / 1000000000 + "." +
                ((runTime / 10000000)-(runTime / 1000000000)*100) +  " seconds)" );
    }






}

// end of file