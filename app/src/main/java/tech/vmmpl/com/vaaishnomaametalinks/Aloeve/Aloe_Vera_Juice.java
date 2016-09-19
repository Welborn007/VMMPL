package tech.vmmpl.com.vaaishnomaametalinks.Aloeve;

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


public class Aloe_Vera_Juice extends Fragment {
    private static String title;
    private static int page;
    View view;
    Button a1;

    /** Called when the activity is first created. */

    public static Aloe_Vera_Juice newInstance(int i, String s) {
        Aloe_Vera_Juice fragmentfirst= new Aloe_Vera_Juice();
        Bundle args = new Bundle();
        args.putInt("1", page);
        args.putString("no.1", title);
        fragmentfirst.setArguments(args);
        return fragmentfirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.fragment_aloe__vera__juice, container, false);
        a1 = (Button) view.findViewById(R.id.inquiry);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Inquiry_form.class);
                intent.putExtra("product","Aloeve Aloe Vera Juice");
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("1", 0);
        title = getArguments().getString("no.1");
    }


}
