import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Item {
    private static String defaultIntPath = "sample-integers.txt";
    public static String defaultFloatPath = "sample-floats.txt";
    public static String defaultStringPath = "sample-strings.txt";
    public static void Load(String path, String resultPath1, String resultPath2, String resultPath3, boolean record) {
        if (!record) {
            if(Files.exists(Path.of(resultPath1))) {
                try {
                    Files.delete(Path.of(resultPath1));
                } catch (IOException e) {e.printStackTrace();}
            }
            if(Files.exists(Path.of(resultPath2))) {
                try {
                    Files.delete(Path.of(resultPath2));
                } catch (IOException e) {e.printStackTrace();}
            }
            if(Files.exists(Path.of(resultPath3))) {
                try {
                    Files.delete(Path.of(resultPath3));
                } catch (IOException e) {e.printStackTrace();}
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String value;
            while ((value = reader.readLine()) != null) {
                boolean resultInt = false;
                resultInt = isInteger(value);
                if (resultInt) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultPath1, true))) {
                        writer.write(value + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (isNumber(value)) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultPath2, true))) {
                        writer.write(value + "\n");
                    } catch (IOException e) {e.printStackTrace();}
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultPath3, true))) {
                        writer.write(value + "\n");
                    } catch (IOException e) {e.printStackTrace();}
                }
            }
        } catch (IOException e) {e.printStackTrace();}
    }
    public static void Load(String path, String resultPath1, String resultPath2, String resultPath3, String prefix, boolean record) {
        if (!record) {
            if(Files.exists(Path.of(getPath(resultPath1, prefix)))) {
                try {
                    Files.delete(Path.of(getPath(resultPath1, prefix)));
                } catch (IOException e) {e.printStackTrace();}
            }
            if(Files.exists(Path.of(getPath(resultPath2, prefix)))) {
                try {
                    Files.delete(Path.of(getPath(resultPath2, prefix)));
                } catch (IOException e) {e.printStackTrace();}
            }
            if(Files.exists(Path.of(getPath(resultPath3, prefix)))) {
                try {
                    Files.delete(Path.of(getPath(resultPath3, prefix)));
                } catch (IOException e) {e.printStackTrace();}
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String value;
            while ((value = reader.readLine()) != null) {
                boolean resultInt = false;
                resultInt = isInteger(value);
                if (resultInt) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(resultPath1, prefix), true))) {
                        writer.write(value);
                        writer.newLine();
                    } catch (IOException e) {e.printStackTrace();}
                } else if (isNumber(value)) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(resultPath2, prefix), true))) {
                        writer.write(value);
                        writer.newLine();
                    } catch (IOException e) {e.printStackTrace();}
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(resultPath3, prefix), true))) {
                        writer.write(value);
                        writer.newLine();
                    } catch (IOException e) {e.printStackTrace();}
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Load(String path, String prefix, boolean record) {
        if (!record) {
            if(Files.exists(Path.of((prefix +defaultIntPath)))) {
                try {
                    Files.delete(Path.of((prefix + defaultIntPath)));
                } catch (IOException e) {e.printStackTrace();}
            }
            if(Files.exists(Path.of((prefix +defaultFloatPath)))) {
                try {
                    Files.delete(Path.of((prefix +defaultFloatPath)));
                } catch (IOException e) {e.printStackTrace();}
            }
            if(Files.exists(Path.of((prefix +defaultStringPath)))) {
                try {
                    Files.delete(Path.of((prefix +defaultStringPath)));
                } catch (IOException e) {e.printStackTrace();}
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String value;
            while ((value = reader.readLine()) != null) {
                boolean resultInt = false;
                resultInt = isInteger(value);
                if (resultInt) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(prefix + defaultIntPath, true))) {
                        writer.write(value);
                        writer.newLine();
                    } catch (IOException e) {e.printStackTrace();}
                } else if (isNumber(value)) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(prefix + defaultFloatPath, true))) {
                        writer.write(value);
                        writer.newLine();
                    } catch (IOException e) {e.printStackTrace();}
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(prefix + defaultStringPath, true))) {
                        writer.write(value);
                        writer.newLine();
                    } catch (IOException e) {e.printStackTrace();}
                }
            }
        } catch (IOException e) {e.printStackTrace();}
    }
    public static void Load(String path, boolean record) {
        if (!record) {
            if(Files.exists(Path.of(defaultIntPath))) {
                try {
                    Files.delete(Path.of(defaultIntPath));
                } catch (IOException e) {e.printStackTrace();}
            }
            if(Files.exists(Path.of(defaultFloatPath))) {
                try {
                    Files.delete(Path.of(defaultFloatPath));
                } catch (IOException e) {e.printStackTrace();}
            }
            if(Files.exists(Path.of(defaultStringPath))) {
                try {
                    Files.delete(Path.of(defaultStringPath));
                } catch (IOException e) {e.printStackTrace();}
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String value;
            while ((value = reader.readLine()) != null) {
                boolean resultInt = false;
                resultInt = isInteger(value);
                if (resultInt) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(defaultIntPath, true))) {
                        writer.write(value);
                        writer.newLine();
                    } catch (IOException e) { e.printStackTrace();}
                } else if (isNumber(value)) {

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(defaultFloatPath, true))) {
                        writer.write(value);
                        writer.newLine();
                    } catch (IOException e) { }

                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(defaultStringPath, true))) {
                        writer.write(value);
                        writer.newLine();
                    } catch (IOException e) { e.printStackTrace();}
                }
            }
        } catch (IOException e) {e.printStackTrace();}
    }
    private static String getPath(String path, String prefix) {
        if (prefix.length() == 0) {
            return path;
        }
        int index = path.lastIndexOf("\\") + 1;
        String after = path.substring(0, index);
        after += prefix + path.substring(index);
        return after;
    }
    public static boolean isNumber(String str) {
        return str.matches("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");
    }
    private static boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}
