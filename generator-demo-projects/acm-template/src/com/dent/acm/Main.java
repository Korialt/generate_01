import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// pending for copy function
public class Main {
    public static int depth = 0;
    public static void main(String[] args) throws IOException {
        String arg = "D:\\PDF书籍";
        String path = arg;
        String output = arg + "_Scan_" + ".txt";
        File file = new File(output);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        scan(path, writer);
        writer.close();

    }
    static void show(char from, char to) {
        System.out.printf("Moving From " + from + " to " + to + '\n');
    }

    public static int hanoi(char A, char B, char C, int n) {
        if (n == 1) {
            show(A, C);
            return 1;
        }
        int a = hanoi(A, C, B, n - 1);
        show(A, C);
        a += hanoi(B, A, C, n - 1);
        return a + 1;
    }

    public static void scan(String path, BufferedWriter writer) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("No such a file!");
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    ++ depth;
                    for (int i = 0; i < depth - 1; ++ i){
                        System.out.print("\t");
                        writer.write("\t");

                    }
                    System.out.println(f.getName() + ":");
                    writer.write(f.getName() + ":" + "\n");
                    scan(f.getPath(), writer);
                    depth--;
                } else {
                    for (int i = 0; i < depth; ++ i){
                        System.out.print("\t");
                        writer.write("\t");
                    }
                    System.out.println(f.getName() + " " + f.length() + " Byte(s) " + f.lastModified());
                    writer.write(f.getName() + "\n");
                    /*
                    if (f.getName().toLowerCase().contains("rust")) {
                        for (int i = 0; i < depth; ++ i){
                            System.out.print("\t");
                            writer.write("\t");
                        }
                        System.out.println(f.getName() + " " + f.length() + " Byte(s) " + f.lastModified());
                        writer.write(f.getName() + "\n");
                    * */
                }

            }
        }
    }
}
}

