package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br>
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        String fileName = "app/src/main/resources/recipes.txt";
        ArrayList<String> array = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {

                array.add(line);
                line.split(",");
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        for (String str : array) {
            System.out.println(str);
        }
        return array;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName  レシピ名
     * @param ingredients 材料名
     */
    //
    public void addRecipe(String recipeName, String ingredients) throws IOException {
        String fileName = "app/src/main/resources/recipes.txt";

        String writeee = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writeee = (recipeName) + "," + (ingredients) + "\r\n";
            System.out.println();
            writer.write(writeee);
            System.out.println("Recipe added successfully.");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
