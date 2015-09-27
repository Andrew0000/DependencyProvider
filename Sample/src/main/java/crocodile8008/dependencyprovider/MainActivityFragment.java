package crocodile8008.dependencyprovider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import crocodile8008.dependencyprovider.helpers.Lo;
import crocodile8008.dependencyprovider.utils.SomeWorkerWithActivityContext;
import crocodile8008.dlibrary.SingletonContainer;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @Bind(R.id.textView1) TextView textView1;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ButterKnife.bind(this, getView());

        SomeWorkerWithActivityContext worker = SingletonContainer.get(SomeWorkerWithActivityContext.class);
        Lo.i(getClass().getSimpleName() + " onActivityCreated worker: " + worker);
        if (worker != null) {
            textView1.setText(worker.getBooksString());
        }
    }
}
