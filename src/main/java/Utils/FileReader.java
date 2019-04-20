package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileReader {
    private String inputPath;

    public FileReader(final String inputPath) {
        this.inputPath = inputPath;
    }

    public List<String> readFile() {
        return Optional.ofNullable(initialiseBufferedReader())
                .map(this::readFile)
                .orElse(null);
    }

    private BufferedReader initialiseBufferedReader() {
        try {
            return new BufferedReader(new java.io.FileReader(inputPath));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private List<String> readFile(final BufferedReader br) {
        final List<String> lines = readLines(br);
        closeReader(br);
        return lines;
    }

    private void closeReader(final BufferedReader br) {
        try {
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> readLines(final BufferedReader br) {
        final List<String> fileLines = new ArrayList<>();
        Optional<String> line = readLine(br);
        while (line.isPresent()) {
            fileLines.add(line.get());
            line = readLine(br);
        }
        return fileLines;
    }

    private Optional<String> readLine(final BufferedReader br) {
        try {
            return Optional.ofNullable(br.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
