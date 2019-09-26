import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    private Data data = new Data();

    public FileManager(String path) {
        readFile(path);
    }


    private void readFile(String path) {
        try (FileReader read = new FileReader(path)) {
            Scanner scan = new Scanner(read);
            StringBuilder text = new StringBuilder();
            while (scan.hasNextLine()) {
                text.append(scan.nextLine());
            }
            Gson gson = new Gson();
            data = gson.fromJson(text.toString(), Data.class);
        } catch (Exception a) {
            System.out.println("Файл пуст. Проверьте содержимое.");
        }
    }


    public void save(String path) {
        try (FileWriter writer = new FileWriter(path)) {
            Gson gson = new Gson();
            String text = gson.toJson(data);
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Ошибка записи.");
        }
    }

    public Data getData() {
        return data;
    }
}
