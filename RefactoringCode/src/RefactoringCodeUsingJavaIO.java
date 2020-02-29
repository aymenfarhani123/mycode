import java.io.*;

public class RefactoringCodeUsingJavaIO {
    private static final String PATH_NAME_IN = "text.txt";
    private static final String PATH_NAME_OUT = "textout.txt";

    public static void main(String[] args) {
        readInputFile();//Methode for reading data from file
        writeOutputFile();//Methode for writing data in a file

    }


    //read an input file
    public static BufferedInputStream readInputFile() {
        File file = new File(PATH_NAME_IN);
        FileInputStream fis = null;
        BufferedInputStream bis=null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return bis;
    }

    //write output file
    public static void writeOutputFile() {
        File fileOut = new File(PATH_NAME_OUT);
        FileOutputStream fos = null;
        BufferedOutputStream bos=null;
        BufferedInputStream bis=readInputFile();
        try {
            fos = new FileOutputStream(fileOut);
            bos = new BufferedOutputStream(fos, 1024);
            int read = 0;
            byte[] buffer = new byte[1024];
                while ((read = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, read);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
