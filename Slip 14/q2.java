import java.util.Scanner;
import java.io.File;
import java.io.FilenameFilter;

public class q2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Directory Path : ");
        String path = sc.nextLine();

        System.out.println("Enter File Extension (Without dot) : ");
        final String f = sc.nextLine();  // ✅ Declared final to use inside inner class

        File d = new File(path);

        File[] files = d.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("." + f);
            }
        });

        if (files == null || files.length == 0) {
            System.out.println("No Files Found with given extension");
        } else {
            System.out.println("Files with ." + f + " extension:");
            for (File f1 : files) {
                System.out.println(f1.getName());
            }
        }
    }
}
