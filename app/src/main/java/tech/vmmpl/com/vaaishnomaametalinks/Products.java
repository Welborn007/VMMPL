package tech.vmmpl.com.vaaishnomaametalinks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tech.vmmpl.com.vaaishnomaametalinks.Aloeve.Aloeve_holder;
import tech.vmmpl.com.vaaishnomaametalinks.Grease.Grease_holder;
import tech.vmmpl.com.vaaishnomaametalinks.Ore.Iron_ore;
import tech.vmmpl.com.vaaishnomaametalinks.Phytoscience.Phytoscience_holder;
import tech.vmmpl.com.vaaishnomaametalinks.Salt.salt_holder;


public class Products extends Fragment {
    private static String title;
    private static int page;
    View view;

    TextView s1,s2,s3,s4,s5,s6;

    /** Called when the activity is first created. */

    public static Products newInstance(int i, String s) {
        Products fragmentthird = new Products();
        Bundle args = new Bundle();
        args.putInt("3", page);
        args.putString("no.3", title);
        fragmentthird.setArguments(args);
        return fragmentthird;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.fragment_products, container, false);

        s1 = (TextView) view.findViewById(R.id.i3);
        s2 = (TextView) view.findViewById(R.id.i15);
        s3 = (TextView) view.findViewById(R.id.i18);
        s4 = (TextView) view.findViewById(R.id.i6);
        s5 = (TextView) view.findViewById(R.id.i9);
        s6 = (TextView) view.findViewById(R.id.i12);

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Iron_Ore_Home.class);
                startActivity(intent);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Coal_Home.class);
                startActivity(intent);
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Salt_Home.class);
                startActivity(intent);
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Grease_Home.class);
                startActivity(intent);
            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Phytoscience_Products_home.class);
                startActivity(intent);
            }
        });

        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Alove_products_Home.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("3", 0);
        title = getArguments().getString("no.3");
    }

}
