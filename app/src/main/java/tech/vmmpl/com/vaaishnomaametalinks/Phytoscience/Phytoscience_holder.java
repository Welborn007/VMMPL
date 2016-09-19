package tech.vmmpl.com.vaaishnomaametalinks.Phytoscience;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import tech.vmmpl.com.vaaishnomaametalinks.About_Us;
import tech.vmmpl.com.vaaishnomaametalinks.Contact_Us;
import tech.vmmpl.com.vaaishnomaametalinks.Group_of_companies;
import tech.vmmpl.com.vaaishnomaametalinks.MainActivity;
import tech.vmmpl.com.vaaishnomaametalinks.Promoter;
import tech.vmmpl.com.vaaishnomaametalinks.R;
import tech.vmmpl.com.vaaishnomaametalinks.Salt.Salt_Sliding_tabs;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Phytoscience_holder extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phytoscience_holder);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        View cView = getLayoutInflater().inflate(R.layout.actionbar, null);
        actionBar.setCustomView(cView);

        actionBar.setTitle(null);
        getActionBar().setDisplayShowHomeEnabled(true);

        // calling home screen main fragment which holds 3 different fragments
        if (savedInstanceState == null)
        {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Phytoscience_Sliding_tabs fragment = new Phytoscience_Sliding_tabs();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action buttons
        switch (item.getItemId()) {

            case R.id.aboutus:
                Intent intent9 = new Intent(this,About_Us.class);
                intent9.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent9);
                return true;

            case R.id.promoter:
                Intent intent5 = new Intent(this,Promoter.class);
                intent5.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent5);
                return true;

            case  R.id.contact:
                Intent intent6 = new Intent(this,Contact_Us.class);
                intent6.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent6);
                return true;

            case R.id.goc:
                Intent intent7 = new Intent(this,Group_of_companies.class);
                intent7.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent7);
                return true;

            case R.id.action_home:
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                return true;

            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
