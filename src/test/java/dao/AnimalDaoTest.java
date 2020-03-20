package dao;

import dao.models.Animal;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalDaoTest {

    static Animal dummyAnimal;

    @BeforeClass
    public static void initializeVariables(){
        dummyAnimal = new Animal("Doge", 2, true);
    }


    @Test
    public void save_differentObjects_getDifferentId(){
        Animal khaleesi = new Animal("Khaleesi", 1, true);
        int savedDummyId = AnimalDao.save(dummyAnimal);
        int savedId = AnimalDao.save(khaleesi);
        Assert.assertNotEquals(savedDummyId, savedId);

    }
    @Test
    public void get(){
        int savedId = AnimalDao.save(dummyAnimal);
        System.out.println(savedId);
        Animal selectedAnimal = AnimalDao.getById(savedId);
        Assert.assertEquals(dummyAnimal.getName(), selectedAnimal.getName());
    }
    @Test
    public void update(){
        dummyAnimal.setId(10);
        AnimalDao.update(dummyAnimal);
        int expectedId = dummyAnimal.getId();
        dummyAnimal.setName("Doggo");
        int actualId = AnimalDao.update(dummyAnimal);
        Assert.assertEquals(expectedId, actualId);
    }

}