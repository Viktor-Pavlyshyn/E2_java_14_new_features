package com.epam.javafourteen.sample;

public interface Pet {
    String getName();
    String getColor();
    String getBreed();
    boolean isHungry();
    boolean needsAttention();
    void feed();
    void interact(InteractionType type);
}
