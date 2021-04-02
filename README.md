# Design Patterns and Principles in Java

## Principles

*Identify the aspects of your
application that vary and separate
them from what stays the same.*

#### another way of thinking about things:

*take the parts
that vary and encapsulate them, so that later you can
alter or extend the parts that vary without affecting
those that don’t.*

This forms the basis of almost every design pattern.

*Program to an interface not to an implementation*

*Favor composition over inheritance*

## Behavioral

Definition: These are design patterns that identify common communication patterns among objects. 
By doing so, these patterns increase flexibility in carrying out communication.

### Strategy
This is when class behavior or algorithm can be changed at run time by encapsulating it inside of a it's own class.

Consider this example. You have a Duck superclass and a bunch of ducks that inherit from it. They inherit it's behavior/methods, like quack which is great. THey have to implemement the quack method in each sub class. But now we want to be able to give every duck that can fly a fly method. Well we add the fly method to the duck superclass and implement it everywhere else. The problem is that what if we had a rubber duck sub class? Well that subclass shouldn't be able to fly? So how do we deal with that?

If I want to be able to give some but not all subclasses some behavior we could use the strategy pattern.

Lets take another example. Say we have a social media application and we want it to connect to a friend on all social media platforms. I would have to implement some connectTo behavior for each social media platform that they are on. This is a perfect time to use the strategy pattern.

Let's start by creating a context


Next we will create a context
```java
package com.odhp.strategy;

public class SocialMediaContext {
    ISocialMediaStrategy smStrategy;

    public void setSocialMediaStrategy(ISocialMediaStrategy smStrategy) {
        this.smStrategy = smStrategy;
    }

    public void connect(String name){
        smStrategy.connectTo(name);
    }
}
```

Notice how we are saving an instance of some class that implements `ISocialMediaStrategy`, and I have a method called `connect(String name)` that runs some method called `connectTo(name)`. We can use this context to store whatever specific social media strategy class the implements ISocialMediaStrategy in here and call it's own version of the `connectTo` method.

Lets create that interface now.

```java
package com.odhp.strategy;

public interface ISocialMediaStrategy {
    public void connectTo(String friendName);
}

```

Now if we need our application to create a Facebook connection we can create a class that would do that.

```java
package com.odhp.strategy;

public class FacebookStrategy implements ISocialMediaStrategy{
    @Override
    public void connectTo(String friendName) {
        System.out.println("Connecting with " + friendName + " through Facebook");
    }
}
```

Now if we wanted to do that for Google Plus it would look like this.

```java
package com.odhp.strategy;

public class GooglePlusStrategy implements ISocialMediaStrategy{
    @Override
    public void connectTo(String friendName) {
        System.out.println("Connecting with " + friendName + " through Google Plus");
    }
}
```

Notice how they are both implementing their own versions of the connectTo method.

Finally this is how we might use these different strategies. Let's take a look at the Main class.

```java
public class Main {

    public static void main(String[] args) {
	// write your code here
        SocialMediaContext smContext = new SocialMediaContext();
        // Facebook strategy
        smContext.setSocialMediaStrategy(new FacebookStrategy());
        smContext.connect("Otha");

        System.out.println("===========================");

        smContext.setSocialMediaStrategy(new GooglePlusStrategy());
        smContext.connect("Otha");

        System.out.println("===========================");

        smContext.setSocialMediaStrategy(new TwitterStrategy());
        smContext.connect("Otha");

        System.out.println("===========================");
    }
}
```