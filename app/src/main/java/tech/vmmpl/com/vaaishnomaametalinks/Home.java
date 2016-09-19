package tech.vmmpl.com.vaaishnomaametalinks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home extends Fragment {
    private static String title;
    private static int page;
    View view;

    /** Called when the activity is first created. */

    public static Home newInstance(int i, String s) {
        Home fragmentfirst= new Home();
        Bundle args = new Bundle();
        args.putInt("1", page);
        args.putString("no.1", title);
        fragmentfirst.setArguments(args);
        return fragmentfirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.home, container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("1", 0);
        title = getArguments().getString("no.1");
    }

}
