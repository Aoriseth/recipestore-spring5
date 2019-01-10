package me.cockx.learn.recipestore.repositories;

import me.cockx.learn.recipestore.domain.UnitOfMeasure;
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
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;


    @Before
    public void setUp() {
    }

    @Test
    public void findByUOM(){
        Optional<UnitOfMeasure> UOM = unitOfMeasureRepository.findByUom("Teaspoon");
        UOM.ifPresent(unitOfMeasure -> assertEquals("Teaspoon", unitOfMeasure.getUom()));

    }

    @Test
    public void findByUOMCup(){
        Optional<UnitOfMeasure> UOM = unitOfMeasureRepository.findByUom("Cup");
        UOM.ifPresent(r->assertEquals("Cup",r.getUom()));
    }

}