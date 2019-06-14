import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.out;

public class Exercise10 {
    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dest = args[1];
        out.println("Copy from: " + src + " to: " + dest);
        Path destinationDirectory = Paths.get(dest);
        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(src));
        for (Path toCopy : stream) {
            Path toCreate = destinationDirectory.resolve(toCopy.getFileName());
            out.println("Create: " + toCreate + "...");
            if (Files.isDirectory(toCopy)) {
                Files.createDirectory(toCreate);
            } else if (Files.isRegularFile(toCopy)) {
                Files.createFile(toCreate);
            } else {
                System.err.println("Cannot process " + toCopy);
            }
        }
        stream.close();
        out.close();
    }
}
