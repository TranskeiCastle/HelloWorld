package rename;

import java.io.File;

import org.junit.Test;

public class Rename {
    @Test
    public void myTest() {
        // 这里写上发替换的文件夹路径,注意使用双斜杠
        File folder = new File("c://pictures");
        String[] files = folder.list();
        File f = null;
        String filename_original = "";
        String filename_latter = "";
        int count = 0;
        for (String file : files) {
            // 一定要写成File(folder,file) ，不能是File(file)而且要全路径
            f = new File(folder, file);
            filename_original = f.getName();
            filename_latter = "新_" + f.getName();
            System.out.print("原来的文件名：" + filename_original + "\t");
            f.renameTo(new File(
                    folder.getAbsolutePath() + "//" + filename_original.replace(filename_original, filename_latter)));
            System.out.println("修改后的文件名：" + filename_latter);
            count++;
        }
        System.out.println("修改文件数：" + count);
    }

}