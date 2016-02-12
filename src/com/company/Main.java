package com.company;
import java.io.*;

public class Main {

    // declare new array with 1 million free spaces
    private static String[] wordDatabase = new String[1000000];


    public static void main(String[] args) {
        //System.out.println("Yo Nils het werkt facking eindelijk! :D");

        BufferedReader br = null;

        try {

            String currentLine;

            // new buffered reader
            br = new BufferedReader(new FileReader(new File("wordlist.txt")));

            // put the first 10 lines of text file (wordlist.txt) in an array
            int i = 0;
            while ((currentLine = br.readLine()) != null && i < 10) {
                wordDatabase[i] = currentLine;
                //System.out.println(currentLine);
                i++;
            }

            // print the array (first 10 items)
            for(int k = 0; k < 10; k++) {
                System.out.println(wordDatabase[k]);
            }

            // compare word with array items (just 1 word to test)
            // "AAgr" is in the array so this will print correct
            int j = 0;
            while (j<10) {
                if(wordDatabase[j].equals("AAgr")) {
                    System.out.println("That word is correct!");
                    break;
                }
                j++;
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

