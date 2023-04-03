package com.example.e_commerce.model;

import java.util.HashSet;
import java.util.Set;

public class Order {

    public static Set<Integer> items_id = new HashSet<>();  //Set отличается от List тем, что каждый курс можно будет добавить только 1 раз, т.е. этот список хранится только 1 повторяющееся значение

}
