package tech.vmmpl.com.vaaishnomaametalinks.Ore;

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


public class Sponge_Iron extends Fragment {
    private static String title;
    private static int page;
    View view;

    /** Called when the activity is first created. */

    public static Sponge_Iron newInstance(int i, String s) {
        Sponge_Iron fragmentfifth = new Sponge_Iron();
        Bundle args = new Bundle();
        args.putInt("5", page);
        args.putString("no.5", title);
        fragmentfifth.setArguments(args);
        return fragmentfifth;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.fragment_sponge__iron, container, false);
        Button a1 = (Button) view.findViewById(R.id.inquiry);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Inquiry_form.class);
                intent.putExtra("product","Sponge Iron Ore");
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("5", 0);
        title = getArguments().getString("no.5");
    }

}
