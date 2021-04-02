package com.odhp.factory;

public class NotificationExecutorFactory {
    public static INotificationExecutor getNotificationExecutor(String executorType){
        if (executorType.equalsIgnoreCase("email")) {
            return new EmailNotificationExecutor();
        }
        if (executorType.equalsIgnoreCase("sms")){
            return new SMSNotificationExecutor();
        }
        return null;
    }
}
