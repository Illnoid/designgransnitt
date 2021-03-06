package recipesearch;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.lab2.Recipe;

import java.io.IOException;

public class RecipeListItem extends AnchorPane {
    private RecipeSearchController parentController;
    private Recipe recipe;

    @FXML private ImageView recipeImage;
    @FXML private Label recipeName;
    @FXML private ImageView recipeCuisineImage;
    @FXML private ImageView recipeMainIngredientImage;
    @FXML private ImageView recipeDifficultyImage;
    @FXML private Label recipeDescription;

    public RecipeListItem(Recipe recipe, RecipeSearchController recipeSearchController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recipe_listitem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.recipe = recipe;
        this.parentController = recipeSearchController;

        recipeImage.setImage(recipe.getFXImage());
        recipeName.setText(recipe.getName());
        recipeCuisineImage.setImage(parentController.getCuisineImage(recipe.getCuisine()));
        recipeMainIngredientImage.setImage(parentController.getMainIngredientImage(recipe.getMainIngredient()));
        recipeDifficultyImage.setImage(parentController.getDifficultyImage(recipe.getDifficulty()));
        recipeDescription.setText(recipe.getDescription());
    }

    @FXML
    protected void onClick(Event event) {
        parentController.openRecipeView(recipe);
    }

}
