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


public class Aloe_Vera_Body_Wash extends Fragment {

    Button a1;

    private static String title;
    private static int page;
    View view;

    /** Called when the activity is first created. */

    public static Aloe_Vera_Body_Wash newInstance(int i, String s) {
        Aloe_Vera_Body_Wash fragmentsecond= new Aloe_Vera_Body_Wash();
        Bundle args = new Bundle();
        args.putInt("2", page);
        args.putString("no.2", title);
        fragmentsecond.setArguments(args);
        return fragmentsecond;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.fragment_aloe__vera__body__wash, container, false);
        a1 = (Button) view.findViewById(R.id.inquiry);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Inquiry_form.class);
                intent.putExtra("product","Aloe Vera Body Wash");
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("2", 0);
        title = getArguments().getString("no.2");
    }


}
