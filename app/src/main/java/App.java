import data.RecipeFileHandler;
import ui.RecipeUI;

public class App {
    public static void main(String[] args) {
        RecipeUI ui = new RecipeUI();
        ui.displayMenu();
        RecipeFileHandler r = new RecipeFileHandler();
        r.readRecipes();
        
    }
}
