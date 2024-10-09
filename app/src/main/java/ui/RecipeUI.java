package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        searchRecipe();
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            } finally {

            }

        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {

        RecipeFileHandler recipi = new RecipeFileHandler();
        ArrayList<String> recipies = recipi.readRecipes();
        if (!(recipies.isEmpty())) {
            try {
                for (int i = 0; i < recipies.size(); i++) {
                    String re = recipies.get(i);
                    String[] strs = re.split(",");

                    if (strs.length > 1) { // 分割チェック
                        String name = strs[0].trim();
                        // Arrays.copyOfRange 指定した箇所 配列の1番目の要素から最後の要素
                        String join = String.join(",", Arrays.copyOfRange(strs, 1, strs.length));
                        System.out.println("---------------");
                        System.out.println("Recipi Name: " + name);
                        System.out.println("Main Ingre: " + join);
                        System.out.println("");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No recipes available.");
        }
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter recipe name: ");
        String addName = br.readLine();

        System.out.println("Enter main ingredients (comma separated): ");
        String addIngred = br.readLine();

        RecipeFileHandler r = new RecipeFileHandler();
        r.addRecipe(addName, addIngred);
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

        String fileName = "app/src/main/resources/recipes.txt";

        // RecipeUI ui = new RecipeUI();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String serch = br.readLine();
        String addName = br.readLine();
        String addIngred = br.readLine();

        try (BufferedReader br2 = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                // 行内に検索単語が含まれているかチェック
                if (line.contains(addName) || line.contains(addIngred)) {
                    String so = line;
                    System.out.println(so);
                }
            }
            

        } catch (IOException e) {
            System.out.println("No recipes found matching the criteria. ");
        }

    }

}
/*
 * 検索クエリはnameとingredientのキーをサポートし、&で複数の条件を組み合わせることができる。
 * 
 * 例: name=Soup&ingredient=Tomatoは、名前に"Soup"を含み、材料に"Tomato"を含むレシピを検索する。
 * 一致するレシピがある場合は、そのレシピの名前と主な材料を表示する。
 * 
 * 一致するレシピがない場合は、No recipes found matching the criteria.と出力する。
 * 
 * 表示形式は以下の出力例を再現すること
 */
