package LMS.util;

import LMS.entities.Delivery;
import LMS.provided.Matcher;

public class OnRouteMatcher implements Matcher<Delivery> {



    @Override
    public boolean matches(Delivery delivery) {
        return delivery.isCollected() && !delivery.isDelivered();
    }
}
