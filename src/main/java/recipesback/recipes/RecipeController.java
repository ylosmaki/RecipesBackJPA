package recipesback.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= "http://localhost:3000")
public class RecipeController {
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/meals")
    public Iterable<Meal> allMeals(){
        return mealRepository.findAll();
    }

    @PostMapping("/meals")
    public void addMeal(@RequestBody Meal meal){
        mealRepository.save(meal);
    }

    @PostMapping("/ingredients/{id}")
    public void addIngredient(@RequestBody Ingredient ingredient, @PathVariable Integer id){
        Optional<Meal> meal = mealRepository.findById(id);
        ingredient.setMeal(meal.get());

        ingredientRepository.save(ingredient);
    }

    @GetMapping("/ingredients")
    public Iterable<Ingredient> allIngredients(){
        return ingredientRepository.findAll();
    }
}
