package crocodile8008.dependencyprovider;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import crocodile8008.dependencyprovider.data.BookProvider;
import crocodile8008.dependencyprovider.helpers.Lo;
import crocodile8008.dependencyprovider.utils.SomeWorkerWithActivityContext;
import crocodile8008.dlibrary.SingletonContainer;

/**
 * Created by Andrey Riik in 2015
 */
public class MainActivity extends FragmentActivity {

    // test 10Mb data for fast activity-leaks detection
    private final byte[] testPayload = new byte[10000000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBookProvider();
        setupWorkerWithActivityContext();

        Lo.i(getClass().getSimpleName() + " onCreate end BookProvider: "
                + SingletonContainer.get(BookProvider.class));
        Lo.i(getClass().getSimpleName() + " onCreate end SomeWorker: "
                + SingletonContainer.get(SomeWorkerWithActivityContext.class));
    }

    private void setupBookProvider() {
        if (!SingletonContainer.contains(BookProvider.class)) {
            SingletonContainer.put(new BookProvider());
        }
    }

    private void setupWorkerWithActivityContext() {
        SingletonContainer.putForActivity(new SomeWorkerWithActivityContext(this), this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SingletonContainer.handleActivityDestroy(this);
    }
}
