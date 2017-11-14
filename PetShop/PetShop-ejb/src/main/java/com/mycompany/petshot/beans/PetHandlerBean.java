package com.mycompany.petshot.beans;

import com.mycompany.petshot.models.Pet;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(PetHandler.class)
public class PetHandlerBean implements PetHandler {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pet getPet(Integer id) {
        return entityManager.find(Pet.class, id);
    }

    @Override
    public void savePet(Pet pet) {
        System.out.println(pet.getNome());
        entityManager.persist(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        Query query = entityManager.createQuery("SELECT p FROM Pet p");
        return query.getResultList();
    }

}
