package com.odhp;

import com.odhp.factory.NotificationExecutorFactory;
import com.odhp.strategy.FacebookStrategy;
import com.odhp.strategy.GooglePlusStrategy;
import com.odhp.strategy.SocialMediaContext;
import com.odhp.strategy.TwitterStrategy;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SocialMediaContext smContext = new SocialMediaContext();

        smContext.setSocialMediaStrategy(new FacebookStrategy());
        smContext.connect("Otha");

        System.out.println("===========================");

        smContext.setSocialMediaStrategy(new GooglePlusStrategy());
        smContext.connect("Otha");

        System.out.println("===========================");

        smContext.setSocialMediaStrategy(new TwitterStrategy());
        smContext.connect("Otha");

        System.out.println("===========================");

        NotificationExecutorFactory.getNotificationExecutor("sms").executeNotification();
        NotificationExecutorFactory.getNotificationExecutor("email").executeNotification();
    }
}
