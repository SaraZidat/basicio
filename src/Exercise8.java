import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Exercise8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new FileReader("doublons.txt")));
        Set<String> uniqueLines = new HashSet<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!uniqueLines.contains(line)) {
                System.out.println(line);
            }
            uniqueLines.add(line);
        }
        bufferedReader.close();
    }
}
