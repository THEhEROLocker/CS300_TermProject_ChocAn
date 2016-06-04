package company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by hERO on 6/3/16.
 */
public class fileWriter {
    String filename = null;

    public fileWriter(){
        filename = null;
    }

    public fileWriter(String filename){
        this.filename = filename;
    }

    public void write_to_file(String []writeData){
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            for(int i = 0; i < writeData.length; ++i){
                writer.println(writeData[i]);
            }
            writer.close();
        }catch (UnsupportedEncodingException f){
            f.getMessage();
        }catch (FileNotFoundException f){
            f.getMessage();
        }
    }
}
