import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercise7 {
    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("java.io.dir");
        for (int i = 1; i <= 10; i++){
            Path path = Paths.get(dir, i+".txt");
            new FileWriter(path.toFile());
        }
    }
}
