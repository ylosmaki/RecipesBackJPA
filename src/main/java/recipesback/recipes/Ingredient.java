package recipesback.recipes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "ingredient_id_seq")
    @SequenceGenerator(name = "ingredient_id_seq",
            sequenceName = "ingredient_id_seq",
            allocationSize = 1)
    @Column(unique = true, nullable = false, columnDefinition = "SERIAL")
    private Integer id;
    private String name;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name="meal_id", nullable= false)
    @JsonBackReference
    private Meal meal;

    public Ingredient() {
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
