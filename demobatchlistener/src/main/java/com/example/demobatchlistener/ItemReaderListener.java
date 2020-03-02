package com.example.demobatchlistener;

import org.springframework.batch.core.ItemReadListener;

public class ItemReaderListener implements ItemReadListener<User> {
    @Override
    public void beforeRead() {
        System.out.println("Before reading an item");
    }

    @Override
    public void afterRead(User user) {
        System.out.println("After reading an item: "+ user.toString());
    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("Error occurred while reading an item!");
    }
}
