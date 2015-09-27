package crocodile8008.dlibrary;

import android.app.Activity;
import android.support.annotation.NonNull;

/**
 * Object with activity scope
 */
public class ActivityScopedObject implements ScopedObject {

    @NonNull private final Object object;
    @NonNull private final Activity activity;

    public ActivityScopedObject(@NonNull Object object, @NonNull  Activity activity) {
        this.object = object;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Object getObject() {
        return object;
    }

    @NonNull
    @Override
    public Object getScope() {
        return activity;
    }
}
