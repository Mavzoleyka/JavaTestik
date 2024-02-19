import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistic {
    private int _count;
    private List<String> strings = new ArrayList<>();
    private List<Float> floats = new ArrayList<>();
    private float min = 0;
    private float max = 0;
    private float avg = 0;
    private float sum = 0;
    public void shortStat(String path1, String path2) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(path1))) {
            int count = 0;
            String line;
            while ((line = reader1.readLine()) != null) {
                count++;
            }
            _count += count;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader2 = new BufferedReader(new FileReader(path2))) {
            int count = 0;
            String line;
            while ((line = reader2.readLine()) != null) {
                count++;
            }
            _count += count;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void shortStatShow() {
        System.out.println("Количество строк в указанных файлах: " + _count);
    }
    public void fullStat(String path1, String path2) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(path1))) {
            String line;
            while ((line = reader1.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader2 = new BufferedReader(new FileReader(path2))) {
            String line;
            while ((line = reader2.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = 0;
        for (String s : strings) {
            try {
                float newValue = Float.parseFloat(s);
                sum += newValue;
                floats.add(newValue);
                count++;
            } catch (NumberFormatException e) {
                String val = s.replace(".", ",");
                try {
                    float newValue = Float.parseFloat(val);
                    sum += newValue;
                    floats.add(newValue);
                    count++;
                } catch (NumberFormatException ex) {
                    // Ignore non-parsable values
                }
            }
        }
        avg = sum / count;
        min = Collections.min(floats);
        max = Collections.max(floats);
    }
    public void showFullStat() {
        System.out.println("Сумма чисел: " + sum);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + avg);
    }
}
