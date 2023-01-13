import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    private static int newWidth = 600;

    public static void main(String[] args) throws Exception {
        String srcFolder = "ImageResizer/pictures";
        String dstFolder = "ImageResizer/dst";
        long start = System.currentTimeMillis();

        try {
            File srcDir = new File(srcFolder);

            File[] files = srcDir.listFiles();

            int quarter = files.length / 4;
            int middle = files.length / 2;

            File[] files1 = new File[quarter];
            System.arraycopy(files, 0, files1, 0, quarter);
            ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
            resizer1.start();

            File[] files2 = new File[quarter];
            System.arraycopy(files, quarter, files2, 0, quarter);
            ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
            resizer2.start();

            File[] files3 = new File[quarter];
            System.arraycopy(files, middle, files3, 0, quarter);
            ImageResizer resizer3 = new ImageResizer(files3, newWidth, dstFolder, start);
            resizer3.start();

            File[] files4 = new File[quarter];
            System.arraycopy(files, middle, files4, 0, quarter);
            ImageResizer resizer4 = new ImageResizer(files4, newWidth, dstFolder, start);
            resizer4.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
