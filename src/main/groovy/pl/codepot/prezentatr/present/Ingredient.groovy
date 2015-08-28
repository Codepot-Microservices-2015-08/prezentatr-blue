package pl.codepot.prezentatr.present

import groovy.transform.TypeChecked

@TypeChecked
class Ingredient {

    String type
    int quantity

    Ingredient(String type, int quantity) {
        this.type = type
        this.quantity = quantity
    }

}
