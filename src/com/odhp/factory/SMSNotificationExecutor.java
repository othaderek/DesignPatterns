package com.odhp.factory;

public class SMSNotificationExecutor implements INotificationExecutor{
    @Override
    public void executeNotification() {
        System.out.println("SMS Notification sent!");
    }
}
