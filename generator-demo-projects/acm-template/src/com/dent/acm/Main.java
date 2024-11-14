import java.io.File;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int depth = 0;

    public static void main(String[] args) {
        //"C:/Users/Dent/dentcode/"
        File file = new File("./D.txt");
        if (!file.exists()) {
            System.out.println("File not found");

        }
        //String path = "D:/";
        String path = System.getProperty("user.dir");
        scan(path);

        /*
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ans;
        ans = hanoi('A', 'B', 'C', n);
        System.out.println(ans);*/
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

    public static void scan(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    ++ depth;
                    for (int i = 0; i < depth - 1; ++ i){
                        System.out.print("\t");
                    }
                    System.out.println(f.getName() + ":");
                    scan(f.getPath());
                    depth--;
                } else {
                    for (int i = 0; i < depth; ++ i){
                        System.out.print("\t");
                    }
                    System.out.println(f.getName());
                }
            }
        }
    }
}

