import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Exercise8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new FileReader("doublons.txt")));
        PrintStream output = new PrintStream(("sansDoublons.txt"));
        Set<String> uniqueLines = new HashSet<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!uniqueLines.contains(line)) {
                System.out.println(line);
            }
            uniqueLines.add(line);
        }
        bufferedReader.close();
        output.close();
    }
}
