import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UploadPhotoFromUrl implements Runnable{

    private String inDirectory;
    private String photoName;
    private String remotePhotoPath;


    public UploadPhotoFromUrl(String remotePhotoPath,String inDirectory, String photoName) {
        this.remotePhotoPath = remotePhotoPath;
        this.inDirectory = inDirectory;
        this.photoName = photoName;
    }
    public static void main(String ...args) throws IOException {
       
        String input=args[0];
        File inputSource=new File(input);
        FileReader fr=new FileReader(inputSource);
        BufferedReader br=new BufferedReader(fr);
        String linkPhoto;
        while((linkPhoto=br.readLine())!=null){
            int lastImmatChar=linkPhoto.indexOf("_");
            int beginIndex = linkPhoto.indexOf("https");
            int endIndex = linkPhoto.lastIndexOf("	");
            int lastIndexOfPhotoName = linkPhoto.replace("	", "").indexOf("https");
            String remotePhotoPath = linkPhoto.substring(beginIndex, endIndex);
            String photoName = linkPhoto.substring(0, lastIndexOfPhotoName);
            String inDirectory = "C:/Users/ITPEAC/Desktop/import";
            new Thread(new UploadPhotoFromUrl(remotePhotoPath, inDirectory, photoName)).start();
        }
    }
    @Override
    public void run() {
        System.out.println("Lancement du Thread downloadPhoto pour la photo: "+ photoName);
        BufferedOutputStream bos=null;
        FileOutputStream fos=null;
        try{
            URL url=new URL(remotePhotoPath);
            HttpURLConnection http=(HttpURLConnection) url.openConnection();
            BufferedInputStream bis=new BufferedInputStream(http.getInputStream());
            fos=new FileOutputStream(inDirectory+"/"+photoName);
            bos=new BufferedOutputStream(fos, 1024);
            byte[] buffer=new byte[1024];
            int read=0;
            while ((read= bis.read(buffer))!= -1){
                bos.write(buffer,0,read);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la recuperation du fichier "+ inDirectory + "/"+ photoName);
        }
        finally{
            try {
                if(bos != null) {
                    bos.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Erreur lors de la fermeture du fichier "+ inDirectory + "/" + photoName);
            }
        }
    }
}
