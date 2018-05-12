package com.tang.springmvc.recipe.Model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob // be able to store large object
    private String recipeNote;

    public Notes() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof Notes;
    }

}
