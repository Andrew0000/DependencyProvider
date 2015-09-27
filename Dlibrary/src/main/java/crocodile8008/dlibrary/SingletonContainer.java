package crocodile8008.dlibrary;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import crocodile8008.dlibrary.helpers.Lo;

/**
 * Holder for classes instances
 */
public class SingletonContainer {

    private static final HashMap<Class, Object> instances = new HashMap<>();

    /**
     * Store instance of object
     */
    @Nullable
    public static synchronized Object put(Object object) {
        return instances.put(object.getClass(), object);
    }

    /**
     * Store instance of object with activity scope
     * <br>
     * Note! You must call handleActivityDestroy() method for unbind this object
     */
    @Nullable
    public static synchronized Object putForActivity(Object object, @NonNull Activity activity) {
        return instances.put(object.getClass(), new ActivityScopedObject(object, activity));
    }

    /**
     *
     * @return true if object with given class already stored
     */
    public static synchronized boolean contains(Class clazz) {
        return instances.get(clazz) != null;
    }

    /**
     * Get instance of object or null if object is not stored
     */
    @Nullable
    public static synchronized <T> T get(Class<T> clazz) {
        Object object = instances.get(clazz);
        if (object != null) {
            if (object instanceof ActivityScopedObject) {
                ActivityScopedObject activityScopedObject = (ActivityScopedObject) object;
                return clazz.cast(activityScopedObject.getObject());
            }
            return clazz.cast(object);
        }
        return null;
    }

    /**
     * Unregister objects with given activity scope
     */
    public static synchronized void handleActivityDestroy(@NonNull Activity activity) {
        Collection values = instances.values();
        List<Object> listToRemove = new ArrayList<>();
        for (Object object : values) {
            if (object != null && object instanceof ActivityScopedObject) {
                ActivityScopedObject activityScopedObject = (ActivityScopedObject) object;
                if (activityScopedObject.getScope().equals(activity)) {
                    listToRemove.add(activityScopedObject.getObject());
                }
            }
        }

        Lo.v("SingletonsContainer handleActivityDestroy find " + listToRemove.size() + " obj. to remove");
        for (Object object : listToRemove) {
            instances.remove(object.getClass());
            Lo.v("SingletonsContainer handleActivityDestroy remove: " + object);
        }
    }

}
