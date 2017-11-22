
package com.mycompany.petshot.beans;

import com.mycompany.petshot.models.Pet;
import java.util.List;

public interface PetHandler {
    public Pet getPet(Integer id);
    public List<Pet> getAllPets();
    public void savePet(Pet pet);
}
