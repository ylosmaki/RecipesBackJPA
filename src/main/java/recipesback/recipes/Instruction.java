package recipesback.recipes;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Instruction {
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "instruction_id_seq")
    @SequenceGenerator(name = "instruction_id_seq",
            sequenceName = "instruction_id_seq",
            allocationSize = 1)
    @Column(unique = true, nullable = false, columnDefinition = "SERIAL")
    private Integer id;
    private String name;
    private String link;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "meal_id",referencedColumnName = "id")
    private Meal meal;

    public Instruction() {
    }

    public Integer getId() {
        return id;
    }

    public Meal getMeal() {
        return meal;
    }



    public void setMeal(Meal meal) {
        this.meal = meal;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
