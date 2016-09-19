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


public class Aloeve_Winter_Moisturizing_Gel extends Fragment {

    private static String title;
    private static int page;
    View view;

    /** Called when the activity is first created. */

    public static Aloeve_Winter_Moisturizing_Gel newInstance(int i, String s) {
        Aloeve_Winter_Moisturizing_Gel fragmenteight = new Aloeve_Winter_Moisturizing_Gel();
        Bundle args = new Bundle();
        args.putInt("8", page);
        args.putString("no.8", title);
        fragmenteight.setArguments(args);
        return fragmenteight;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.fragment_aloeve__winter__moisturizing__gel, container, false);
        Button a1 = (Button) view.findViewById(R.id.inquiry);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Inquiry_form.class);
                intent.putExtra("product","Aloeve Winter Moisturizing Gel");
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("8", 0);
        title = getArguments().getString("no.8");
    }


}
