package com.tts.coffeeproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// makes this a DB object as well as a class
@Entity
public class Coffee {
    // Sets the ID as primary key
    @Id
    // Allows the underlying database to set the value for the field
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String product;
    public String author;
    public String coffeeReview;

    public Coffee() {
        // empty contructor needed
    }

    public Coffee(String product, String author, String coffeeReview) {
        this.product = product;
        this.author = author;
        this.coffeeReview = coffeeReview;
    }

    public String getproduct() {
        return product;
    }

    public void setproduct(String product) {
        this.product = product;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getcoffeeReview() {
        return coffeeReview;
    }

    public void setcoffeeReview(String coffeeReview) {
        this.coffeeReview = coffeeReview;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Coffee [id=" + id + ",author=" + author + ", coffeeReview=" + coffeeReview + ",  product=" + product
                + "]";
    }

}
