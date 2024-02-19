import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Statistic statistic = new Statistic();
        String path = "C:\\Users\\User\\Java_resourses\\in1.txt";
        String path2 = "C:\\Users\\User\\Java_resourses\\in2.txt";

        System.out.println("Добро пожаловать! Введите '-o' для ввода пути файлов или введите любые знаки");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        System.out.println("Введите '-a', что задать режим добавления в существующие файлы или введите любое значение");
        boolean record = false;
        String choiceRecord = scanner.nextLine();
        if (choiceRecord.equals("-a")) {
            record = true;
        }
        switch (choice) {
            case "-o":
                System.out.println("Введите путь, куда нужно сохранить результаты типа Integer");
                String pathResult1 = scanner.nextLine();
                System.out.println("Введите путь, куда нужно сохранить результаты типа Float");
                String pathResult2 = scanner.nextLine();
                System.out.println("Введите путь, куда нужно сохранить результаты типа String");
                String pathResult3 = scanner.nextLine();
                System.out.println("Нужен префикс?'-p'");
                String prefixChoice = scanner.nextLine();
                if (prefixChoice.equals("-p")) {
                    System.out.println("Введите префикс");
                    String prefix = scanner.nextLine();
                    Item.Load(path, pathResult1, pathResult2, pathResult3, prefix, record);
                    record = true;
                    Item.Load(path2, pathResult1, pathResult2, pathResult3, prefix, record);
                } else {
                    Item.Load(path, pathResult1, pathResult2, pathResult3, record);
                    record = true;
                    Item.Load(path2, pathResult1, pathResult2, pathResult3, record);
                }
                System.out.println("Вывести статистику?\r\n -s : короткая, -f : полная\r\n или введите любые знаки");
                String choice2 = scanner.nextLine();
                if (choice2.equals("-s")) {
                    statistic.shortStat(path, path2);
                    statistic.shortStatShow();
                } else if (choice2.equals("-f")) {
                    statistic.fullStat(path, path2);
                    statistic.showFullStat();
                }
                break;
            default:
                System.out.println("Добавить префикс к имени?(Команда '-p')");
                String result = scanner.nextLine();
                if (result.equals("-p")) {
                    System.out.println("Введите префикс");
                    String prefix = scanner.nextLine();
                    Item.Load(path, prefix, record);
                    record = true;
                    Item.Load(path2, prefix, record);
                    System.out.println("Вывести статистику?\r\n -s : короткая, -f : полная\r\n или введите любые знаки");
                    String choice3 = scanner.nextLine();
                    if (choice3.equals("-s")) {
                        statistic.shortStat(path, path2);
                        statistic.shortStatShow();
                    } else if (choice3.equals("-f")) {
                        statistic.fullStat(path, path2);
                        statistic.showFullStat();
                    }
                } else {
                    Item.Load(path, record);
                    record = true;
                    Item.Load(path2, record);
                    System.out.println("Вывести статистику?\r\n -s : короткая, -f : полная\r\n или введите любые знаки");
                    String choice4 = scanner.nextLine();
                    if (choice4.equals("-s")) {
                        statistic.shortStat(path, path2);
                        statistic.shortStatShow();
                    } else if (choice4.equals("-f")) {
                        statistic.fullStat(path, path2);
                        statistic.showFullStat();
                    }
                }
                break;
        }
    }
}