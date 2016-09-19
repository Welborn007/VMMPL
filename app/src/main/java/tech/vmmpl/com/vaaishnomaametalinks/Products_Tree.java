package tech.vmmpl.com.vaaishnomaametalinks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tech.vmmpl.com.vaaishnomaametalinks.Aloeve.Aloeve_holder;
import tech.vmmpl.com.vaaishnomaametalinks.Grease.Grease_holder;
import tech.vmmpl.com.vaaishnomaametalinks.Ore.Iron_ore;
import tech.vmmpl.com.vaaishnomaametalinks.Phytoscience.Phytoscience_holder;
import tech.vmmpl.com.vaaishnomaametalinks.Salt.salt_holder;

public class Products_Tree extends Fragment {
    private static String title;
    private static int page;
    View view;

    TextView s1,s2,s3,s4,s5;

    /** Called when the activity is first created. */

    public static Products_Tree newInstance(int i, String s) {
        Products_Tree fragmentSecond= new Products_Tree();
        Bundle args = new Bundle();
        args.putInt("2", page);
        args.putString("no.2", title);
        fragmentSecond.setArguments(args);
        return fragmentSecond;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.fragment_products_tree, container, false);

        s1 = (TextView) view.findViewById(R.id.a1);
        s2 = (TextView) view.findViewById(R.id.a2);
        s3 = (TextView) view.findViewById(R.id.a3);
        s4 = (TextView) view.findViewById(R.id.a4);
        s5 = (TextView) view.findViewById(R.id.a5);

        SpannableString content = new SpannableString(s1.getText());
        content.setSpan(new UnderlineSpan(), 0, s1.getText().length(), 0);
        s1.setText(content, TextView.BufferType.SPANNABLE);

        SpannableString content1 = new SpannableString(s2.getText());
        content1.setSpan(new UnderlineSpan(), 0, s2.getText().length(), 0);
        s2.setText(content1, TextView.BufferType.SPANNABLE);

        SpannableString content2 = new SpannableString(s3.getText());
        content2.setSpan(new UnderlineSpan(), 0, s3.getText().length(), 0);
        s3.setText(content2, TextView.BufferType.SPANNABLE);

        SpannableString content3 = new SpannableString(s4.getText());
        content3.setSpan(new UnderlineSpan(), 0, s4.getText().length(), 0);
        s4.setText(content3, TextView.BufferType.SPANNABLE);

        SpannableString content4 = new SpannableString(s5.getText());
        content4.setSpan(new UnderlineSpan(), 0, s5.getText().length(), 0);
        s5.setText(content4, TextView.BufferType.SPANNABLE);

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Iron_ore.class);
                startActivity(intent);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), salt_holder.class);
                startActivity(intent);
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Grease_holder.class);
                startActivity(intent);
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Phytoscience_holder.class);
                startActivity(intent);
            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Aloeve_holder.class);
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
