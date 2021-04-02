package com.odhp.factory;

public class EmailNotificationExecutor implements INotificationExecutor{
    @Override
    public void executeNotification() {
        System.out.println("Email notification sent!");
    }
}
