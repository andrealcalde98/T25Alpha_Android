package com.example.t25alpha.Semanas;

import com.example.t25alpha.R;

import java.util.ArrayList;
import java.util.List;

public class Semanas {
    String name;
    int photoId;

    Semanas(String name, int photoId) {
        this.name = name;
        this.photoId = photoId;
    }

    private List<Semanas> persons;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Semanas("Semana 1", R.drawable.ic_hombrepesas));
        persons.add(new Semanas("Semana 2", R.drawable.ic_hombrepesas));
        persons.add(new Semanas("Semana 3", R.drawable.ic_hombrepesas));
        persons.add(new Semanas("Semana 4", R.drawable.ic_hombrepesas));
        persons.add(new Semanas("Semana 5", R.drawable.ic_hombrepesas));
        persons.add(new Semanas("Semana 6", R.drawable.ic_hombrepesas));
        persons.add(new Semanas("Semana 7", R.drawable.ic_hombrepesas));

    }
}
