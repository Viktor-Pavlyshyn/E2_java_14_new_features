package com.epam.javafourteen.sample;

public class Cat implements Pet {

    private final String name;
    private final String breed;
    private final String color;

    private boolean hungry;
    private boolean needsAttention;

    public Cat(String name, String breed, String color){
        super();
        this.name = name;
        this.breed = breed;
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public boolean isHungry() {
        return hungry;
    }

    @Override
    public boolean needsAttention() {
        return false;
    }

    @Override
    public void feed() {
        hungry=false;
    }

    @Override
    public void interact(InteractionType type) {
        if (type == InteractionType.PAT){
            needsAttention = false;
        }
    }

    public boolean isIgnoringYou(){
        return true;
    }

}
