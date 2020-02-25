package recipesback.recipes;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Meal  {
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "meal_id_seq")
    @SequenceGenerator(name = "meal_id_seq",
            sequenceName = "meal_id_seq",
            allocationSize = 1)
    private Integer id;
    private String name;
    private Integer portions;
    private Integer cookingtime;
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "meal")
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>(0);
    @OneToOne(mappedBy = "meal")
    private Instruction instruction;

    public Meal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPortions() {
        return portions;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    public Integer getCookingtime() {
        return cookingtime;
    }

    public void setCookingtime(Integer cookingtime) {
        this.cookingtime = cookingtime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
