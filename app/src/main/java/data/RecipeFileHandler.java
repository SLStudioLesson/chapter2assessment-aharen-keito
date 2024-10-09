package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        String fileName = "recipes.txt";
        ArrayList<String> array = new ArrayList<>();
        array.add("Tomato Soup,Tomatoes, Onion, Garlic, Vegetable Stock");
        array.add("Chicken Curry,Chicken, Curry Powder, Onion, Garlic, Ginger");
        array.add("Beef Stew,Beef, Potatoes, Carrots, Onion, Beef Stock");
        array.add("Vegetable Stir Fry,Broccoli, Carrot, Bell Peppers, Soy Sauce");
        array.add("Spaghetti Bolognese,Ground Beef, Tomato Sauce, Onion, Garlic, Spaghetti");
        array.add("Caesar Salad,Romaine Lettuce, Croutons, Parmesan Cheese, Caesar Dressing");
        array.add("Grilled Salmon,Salmon, Lemon, Garlic, Olive Oil");
        array.add("Pancakes,Flour, Milk, Egg, Butter, Maple Syrup");
        array.add("Chocolate Cake,Flour, Cocoa Powder, Baking Powder, Eggs, Sugar");
        array.add("Lasagna,Ground Beef, Lasagna Noodles, Ricotta Cheese, Tomato Sauce");
        array.add("Tacos,Ground Beef, Taco Shells, Lettuce, Tomato, Cheese");
        array.add("French Toast,Bread, Egg, Milk, Cinnamon, Sugar");
        array.add("Mushroom Risotto,Arborio Rice, Mushrooms, Onion, Chicken Stock, Parmesan Cheese");
        array.add("he Lorraine,Eggs, Cream, Bacon, Cheese, Pie Crust");
        array.add("touille,Eggplant, Zucchini, Bell Pepper, Tomato, Onion");
        array.add("ken Alfredo,Chicken, Fettuccine, Cream, Parmesan Cheese, Garlic");
        array.add("Ribs,Pork Ribs, BBQ Sauce, Garlic, Brown Sugar");
        array.add("table Soup,Carrots, Potatoes, Celery, Tomato, Vegetable Stock");
        array.add("roni and Cheese,Macaroni, Cheddar Cheese, Milk, Butter, Flour");
        array.add("na Bread,Bananas, Flour, Sugar, Baking Soda, Eggs");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                line.split(",");
                array.add(line);
                // System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        for(String str : array){
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
    public void addRecipe(String recipeName, String ingredients) {
        // try {

        // } catch (IOException e) {

        // }
    }
}
