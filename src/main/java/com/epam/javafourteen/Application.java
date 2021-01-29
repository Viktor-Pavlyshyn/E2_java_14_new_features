package com.epam.javafourteen;

import com.epam.javafourteen.sample.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Pet> pets = getPetList();

        /** Java 14 (instanceof patterns) */
        showInstanceOf(pets);

        /** Java 14 (switch expressions) */
        System.out.println( showSwitch(InteractionType.PAT));

        /** Java 14 (Records) */
        Menu menu = new Menu("Apple", new BigDecimal(3.45));
        System.out.println(menu.name());
        System.out.println(menu.getFormattedItem());

        /** Java 14 (text blocks) */
        System.out.println(getText());

        /** Java 14 (NollPointerException) */
        BigDecimal decimal = getNullObject();
        decimal.setScale(2, RoundingMode.CEILING);

    }

    public static List<Pet> getPetList(){
        List<Pet> pets = new ArrayList();
        pets.add(new Dog("Oreo", "Mixed", "black/white"));
        pets.add(new Dog("Ruger", "Mixed", "grey/black"));
        pets.add(new Dog("Max", "Labrador Retriever", "black"));
        pets.add(new Dog("Mocha", "Labrador Retiever", "chocolate"));
        pets.add(new Dog("Pokey", "Beagle", "brown/white/black"));
        pets.add(new Cat("Frosty", "Mixed", "white"));
        pets.add(new Cat("Warlock", "Mixed", "black"));
        return pets;
    }

    /** Before Java 14 (instanceof patterns) */
//    public static void showInstanceOf(List<Pet> pets){
//        pets.forEach(pet->{
//            String message = pet.getName() + " ";
//            if (pet instanceof Dog){
//                Dog dog = (Dog)pet;
//                message = message + (dog.isFollowingYou()?"is":"isn't") + " following you.";
//            }else if (pet instanceof Cat){
//                Cat cat = (Cat)pet;
//                message = message + (cat.isIgnoringYou()?"is":"isn't") + " ignoring you.";
//            }
//            System.out.println(message);
//        });
//    }

    /** After Java 14 (instanceof patterns)*/
    public static void showInstanceOf(List<Pet> pets){
        pets.forEach(pet->{
            String message = pet.getName() + " ";
            if (pet instanceof Dog dog){
                message = message + (dog.isFollowingYou()?"is":"isn't") + " following you.";
            }else if (pet instanceof Cat cat){
                message = message + (cat.isIgnoringYou()?"is":"isn't") + " ignoring you.";
            }
            System.out.println(message);
        });
    }

    /** Before Java 14 (switch expressions) */
//    public static void showSwitch(InteractionType type){
//        switch(type){
//            case PAT:
//                System.out.println("You should pat your dog when he needs attention");
//                break;
//            case TALK_TO:
//                System.out.println("You should talk to your bird whe he needs attention");
//                break;
//            case WATCH:
//                System.out.println("You can only watch your fish, they don't need attention");
//        }
//    }
    /** After Java 14 (switch expressions) */
    public static String showSwitch(InteractionType type){
        return switch(type){
            case PAT -> "You should pat your dog when he needs attention";
            case TALK_TO -> "You should talk to your bird whe he needs attention";
            case WATCH -> "You can only watch your fish, they don't need attention";
            default -> "default";
        };
    }

    /** Before Java 14 (text blocks) */
//    public static String getText() {
//        return  "<html>\n" +
//                "    <body>\n" +
//                "        <p>Hello, JavaRush Student</p>\n" +
//                "    </body>\n" +
//                "</html>\n";
//    }
    /** After Java 14 (text blocks) */
        public static String getText() {
        return  """
              <html>
                  <body>
                      <p>Hello, JavaRush Student</p>
                  </body>
              </html>
              """;
    }

    /** After Java 14 (NollPointerException)
     * Add to Edit Configuration -> VM options: "-XX:+ShowCodeDetailsInExceptionMessages".
     * You will receive more detailed information about the exception.
     */
    public static BigDecimal getNullObject(){
        return null;
    }
}