package company;

import java.io.*;

/**
 * Created by hERO on 05/11/15.
 * Usage:
 *
 *      fileReader myReader = new fileReader(<path to file>);
 *      String[] fileData = null;
 *
 *      try{
 *          fileData = myReader.ReadFileData(); // returns all the lines in the file as an array of strings. This needs 
 *                                              // to be parsed further in the funciton that is calling it and break down 
 *                                              // every line into pieces and change the data type for each piece to macth 
 *                                              // what the constructor of that class requires
 *      }
 *      catch(IOException badShitHappened){
 *          System.out.println(badShitHappened.getMessage());
 *          System.out.println("File IO just shit itself");
 *      }
 */
public class fileReader {
    private String filePath = null;

    public fileReader(String inputFilePath){
        filePath = inputFilePath;
    }

    public String[] ReadFileData() throws IOException{

        FileReader fr = new FileReader(filePath);
        BufferedReader textReader = new BufferedReader(fr);
        int numberOfLines = countLines();
        String [] fileData = new String[numberOfLines];

        for(int i = 0; i < numberOfLines; ++i){
            fileData[i] = textReader.readLine();
        }
        textReader.close();

        return fileData;
    }

    private int countLines() throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filePath));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;

            while ((readChars = is.read(c)) != -1) { //stops reading when there are no more bytes to read in the stream
                empty = false;
                for (int i = 0; i < readChars; ++i) { // finding the number of newlines in the bytes read from inside the loop
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }

            return (count == 0 && !empty) ? 1 : count;

        }
        finally {
            is.close();
        }
    }

}
