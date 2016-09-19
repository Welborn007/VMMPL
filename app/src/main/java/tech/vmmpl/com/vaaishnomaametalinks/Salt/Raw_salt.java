package tech.vmmpl.com.vaaishnomaametalinks.Salt;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tech.vmmpl.com.vaaishnomaametalinks.Mail_inquiry.Inquiry_form;
import tech.vmmpl.com.vaaishnomaametalinks.R;

public class Raw_salt extends Fragment {

    private static String title;
    private static int page;
    View view;

    /** Called when the activity is first created. */

    public static Raw_salt newInstance(int i, String s) {
        Raw_salt fragmentfourth= new Raw_salt();
        Bundle args = new Bundle();
        args.putInt("4", page);
        args.putString("no.4", title);
        fragmentfourth.setArguments(args);
        return fragmentfourth;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.fragment_raw_salt, container, false);
        Button a1 = (Button) view.findViewById(R.id.inquiry);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Inquiry_form.class);
                intent.putExtra("product","Raw Salt");
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("4", 0);
        title = getArguments().getString("no.4");
    }

}
