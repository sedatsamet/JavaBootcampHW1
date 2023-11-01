import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // MARK: - Main Operation :
    //  - It gets the words from file then assign that words to Map structure.
    //  - In while loop, program requests an input from user. Then, it assigns that input to a variable.
    //  - After that, word which is wanted to translate searches in dictionary.
    //  - Finally, the result returns on console after if check.
    public static void main(String[] args) {
        System.out.println("------- Sözlük Uygulaması -------");
        Map<String, String> dictionary = readFromFile("english-turkish.txt");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("İngilizce Kelime Girin : (Uygulamadan Çıkmak İçin q'ya Basın)");
            String inputWord = scanner.nextLine().toLowerCase();
            if (inputWord.equals("q")) {
                break;
            }
            String translatedWord = dictionary.get(inputWord);
            if (translatedWord == null) {
                System.out.println("Sözcük Bulunamadı. Lütfen Yeni Bir Giriş Yapınız.");
            } else {
                System.out.println("Çeviri : " + translatedWord);
            }
        }
    }

    // MARK: - Function that is reading words from file :
    //  - It reads each row then put the split words to dictionary.
    //  - After that operations the function returns the dictionary as a Map.
    public static Map<String, String> readFromFile(String fileName) {
        Map<String, String> dictionary = new HashMap<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader((new FileReader(fileName)));
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                dictionary.put(words[0].toLowerCase(), words[1].toLowerCase());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary File Not Found.");
        } catch (IOException e) {
            System.out.println("Something went wrong while the dictionary file were reading.");
        }
        return dictionary;
    }
}