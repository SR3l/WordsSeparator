import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSeparator {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the file name or type QUIT to exit:\n");
        String fileName = scan.nextLine();
        if(fileName.equalsIgnoreCase("quit")) {
            return;
            }

        File file = new File(fileName);
        while(!file.exists()) {
            System.out.printf("File '%s' is not found.%n", fileName);
            System.out.println("Please re-enter the file name or type QUIT to exit:");
            fileName = scan.nextLine();
            file = new File(fileName);
            if(fileName.equalsIgnoreCase("quit")) {
                return;
                }
            }
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String formattedSentence = formatSentence(line);
                System.out.println(formattedSentence);
            }
            scan.close();
    }

    public static String formatSentence(String sentence) {
        StringBuilder res = new StringBuilder();
        boolean startOfWord = true;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (Character.isUpperCase(ch) && !startOfWord) {
                res.append(" ");
                res.append(Character.toLowerCase(ch));
            } else {
                res.append(startOfWord ? ch : Character.toLowerCase(ch));
            }


            if(ch == '.' || ch == '!' || ch == '?') {
                if (i + 1 < sentence.length() && sentence.charAt(i + 1) != ' ') {
                    res.append(" ");
                }
                startOfWord = true;
            } else {
                startOfWord = false;
            }
        }
        return res.toString();
    }
}
