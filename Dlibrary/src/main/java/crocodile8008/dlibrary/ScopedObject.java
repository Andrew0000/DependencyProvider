package crocodile8008.dlibrary;

import android.support.annotation.NonNull;

/**
 * Object with scope
 */
public interface ScopedObject {

    @NonNull
    Object getObject();

    @NonNull
    Object getScope();

}
