package com.tang.springmvc.recipe.Repos;

import com.tang.springmvc.recipe.Model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureReposTest {

    @Autowired
    UnitOfMeasureRepos unitOfMeasureRepos;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() throws Exception {
        Optional<UnitOfMeasure> unitOptional = unitOfMeasureRepos.findByDescription("Teaspoon");

        assertEquals("Teaspoon", unitOptional.get().getDescription());
    }
}