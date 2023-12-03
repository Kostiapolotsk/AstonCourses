package school.lesson6;

import java.io.*;
import java.util.*;

public class AppData {

    private String[] header;
    private int[][] data;

    public AppData() {
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void save(String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            // Записываем заголовок
            for (int i = 0; i < header.length; i++) {
                writer.print(header[i]);
                if (i < header.length - 1) {
                    writer.print(";");
                }
            }
            writer.println();

            // Записываем данные
            for (int[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    writer.print(row[i]);
                    if (i < row.length - 1) {
                        writer.print(";");
                    }
                }
                writer.println();
            }
        }
    }

    public void load(String filePath) throws IOException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Читаем заголовок
            if (scanner.hasNextLine()) {
                header = scanner.nextLine().split(";");
            }

            List<int[]> dataList = new ArrayList<>();
            // Читаем данные
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";");
                int[] dataRow = new int[line.length];
                for (int i = 0; i < line.length; i++) {
                    dataRow[i] = Integer.parseInt(line[i]);
                }
                dataList.add(dataRow);
            }
            data = dataList.toArray(new int[dataList.size()][]);
        }
    }
}

