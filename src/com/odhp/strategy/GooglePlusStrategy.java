package com.odhp.strategy;

public class GooglePlusStrategy implements ISocialMediaStrategy{
    @Override
    public void connectTo(String friendName) {
        System.out.println("Connecting with " + friendName + " through Google Plus");
    }
}
