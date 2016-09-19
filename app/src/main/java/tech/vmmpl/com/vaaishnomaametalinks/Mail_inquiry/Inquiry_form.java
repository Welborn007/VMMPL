package tech.vmmpl.com.vaaishnomaametalinks.Mail_inquiry;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import tech.vmmpl.com.vaaishnomaametalinks.About_Us;
import tech.vmmpl.com.vaaishnomaametalinks.Contact_Us;
import tech.vmmpl.com.vaaishnomaametalinks.Group_of_companies;
import tech.vmmpl.com.vaaishnomaametalinks.MainActivity;
import tech.vmmpl.com.vaaishnomaametalinks.Promoter;
import tech.vmmpl.com.vaaishnomaametalinks.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Inquiry_form extends Activity {

    EditText e1,e2,e3,e4,e5,e6;
    Spinner s1,s2;
    Button b1,b2;

    final String username = "vmmplappmailserver@gmail.com";
    final String password = "8xchange$";

    String company;
    String products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inquiry_form);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        View cView = getLayoutInflater().inflate(R.layout.actionbar, null);
        actionBar.setCustomView(cView);

        actionBar.setTitle(null);
        getActionBar().setDisplayShowHomeEnabled(true);

        e1 = (EditText) findViewById(R.id.Address);
        e2 = (EditText) findViewById(R.id.details);
        e3 = (EditText) findViewById(R.id.name);
        e4 = (EditText) findViewById(R.id.company_name);
        e5 = (EditText) findViewById(R.id.email);
        e6 = (EditText) findViewById(R.id.mobile);

        e1.addTextChangedListener(new EditorWatcher(e1));
        e2.addTextChangedListener(new EditorWatcher(e2));
        e3.addTextChangedListener(new EditorWatcher(e3));
        e4.addTextChangedListener(new EditorWatcher(e4));
        e5.addTextChangedListener(new EditorWatcher(e5));
        e6.addTextChangedListener(new EditorWatcher(e6));

        s1 = (Spinner) findViewById(R.id.gen);
        s2 = (Spinner) findViewById(R.id.country);

        b1 = (Button) findViewById(R.id.submit);
        b2 = (Button) findViewById(R.id.reset);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isEmptyField(e1))
                {
                    e1.setError("Enter Address");
                    return;
                }
                if (isEmptyField(e2))
                {
                    e2.setError("Enter Details");
                    return;
                }
                if (isEmptyField(e3))
                {
                    e3.setError("Enter Name");
                    return;
                }
                if (isEmptyField(e4))
                {
                    e4.setError("Enter Company Name");
                    return;
                }
                if (isEmptyField(e5))
                {
                    e5.setError("Enter Email");
                    return;
                }
                if (isEmptyField(e6))
                {
                    e6.setError("Enter Mobile no.");
                    return;
                }

                String Subject = "Inquiry received through mobile app";
                String Address = e1.getText().toString();
                String Details = e2.getText().toString().replaceAll("\\n", "<br />");
                String Name = e3.getText().toString();
                company = e4.getText().toString();
                String email = e5.getText().toString();
                String mobile = e6.getText().toString();

                try{
                    products = getIntent().getStringExtra("product");



                if (!isEmailValid(email)) return;

                String Gender = s1.getSelectedItem().toString();
                String country = s2.getSelectedItem().toString();

                String Contact_name = Gender + " " + Name;

                Calendar cal = Calendar.getInstance();

                int seconds = cal.get(Calendar.SECOND);
                int minutes = cal.get(Calendar.MINUTE);
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                final String time = hour+":"+minutes+":"+seconds;


                int day = cal.get(Calendar.DAY_OF_MONTH);
                SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
                String month_name = month_date.format(cal.getTime());
                int year = cal.get(Calendar.YEAR);
                final String date = month_name + " " + day + " " + year;

                if(products.contains("null"))
                {
                    products = "products";
                }

                String Message = "<div id=\":13r\" class=\"a3s\" style=\"overflow: hidden;\"><div dir=\"ltr\"><table style=\"border-collapse:collapse;border-spacing:0px;width:712.222px;color:rgb(51,51,51);font-family:Arial,Helvetica,sans-serif;font-size:12px\"><tbody><tr><td colspan=\"2\" style=\"padding:0px;line-height:1.7em;color:rgb(91,90,90)\"><p style=\"margin:0px;padding:0px;font-size:1.2em;font-weight:700\">"+ company + " Placed Enquiry for Purchase Of " + products + " " + "\tto&nbsp;<a href=\"\" title=\"M/s. Vaaishno Maa Metalinks Pvt Ltd.\" style=\"text-decoration:none;outline:none;color:rgb(102,102,102)\" target=\"_blank\">M/s. Vaaishno Maa Metalinks Pvt Ltd.</a></p><p style=\"margin:0px;padding:0px\"><span style=\"font-weight:700\">Date :</span>&nbsp;" + date + "</p></td></tr><tr><td colspan=\"2\" style=\"padding:0px;height:15px\"></td></tr><tr style=\"border:1px solid rgb(204,204,204);background-image:-webkit-linear-gradient(bottom,rgb(255,255,255),rgba(255,255,255,0));background-color:rgb(221,238,255)\"><td colspan=\"2\" style=\"padding:5px 5px 5px 10px;font-size:1.2em;font-weight:700;color:rgb(2,98,159)\">Sender's Contact Details</td></tr><tr><td colspan=\"2\" style=\"padding:10px 10px 0px;line-height:1.7em;color:rgb(91,90,90)\"><span style=\"font-weight:700;float:left;display:block;margin-right:10px;width:110px\">Contact person</span><span style=\"font-weight:700;margin-right:10px\">:</span>&nbsp;"+ Contact_name +"<br><span style=\"font-weight:700;float:left;display:block;margin-right:10px;width:110px\">Company Name</span><span style=\"font-weight:700;margin-right:10px\">:</span>&nbsp;" + company + "&nbsp;<br><span style=\"font-weight:700;float:left;display:block;margin-right:10px;width:110px\">Address</span><span style=\"font-weight:700;margin-right:10px\">:</span>&nbsp;" + Address + "&nbsp;<br><span style=\"font-weight:700;float:left;display:block;margin-right:10px;width:110px\">Email</span><span style=\"font-weight:700;margin-right:10px\">:</span>&nbsp;<a href=\"mailto:" + email + "\" target=\"_blank\">" + email + "</a><br><span style=\"font-weight:700;float:left;display:block;margin-right:10px;width:110px\">Mobile</span><span style=\"font-weight:700;margin-right:10px\">:</span>&nbsp;" + mobile + "<br><span style=\"font-weight:700;float:left;display:block;margin-right:10px;width:110px\">Country</span><span style=\"font-weight:700;margin-right:10px\">:</span>&nbsp;" + country + "<br></td></tr><tr><td colspan=\"2\" style=\"padding:0px;height:15px\"></td></tr><tr><td colspan=\"2\" style=\"padding:0px;height:15px\"></td></tr><tr style=\"border:1px solid rgb(204,204,204);background-image:-webkit-linear-gradient(bottom,rgb(255,255,255),rgba(255,255,255,0));background-color:rgb(221,238,255)\"><td colspan=\"2\" style=\"padding:5px 5px 5px 10px;font-size:1.2em;font-weight:700;color:rgb(2,98,159)\">Requirement Details</td></tr><tr><td colspan=\"2\" style=\"padding:10px 10px 0px;line-height:1.7em;color:rgb(91,90,90)\"><p style=\"margin:0px 0px 7px;padding:0px\">"+ Details +"</p></td></tr></tbody></table><div><div><div dir=\"ltr\"><div><span><font face=\"arial, helvetica, sans-serif\" size=\"1\" color=\"#cccccc\"><span style=\"font-weight:bold\"><u>Regd. Office</u></span><br>Plot.No :- 3D/1266, Sector-11<br>CDA, Cuttack - 753014, Odisha, India<br>E-Mail Us At :-&nbsp;<a href=\"mailto:info@vaaishnomaagroup.com\" target=\"_blank\">info@vaaishnomaagroup.com</a><br></font></span></div><div><font face=\"arial, helvetica, sans-serif\" size=\"1\" color=\"#cccccc\">web : - <a href=\"http://www.vaaishnomaagroup.com\" target=\"_blank\">www.vaaishnomaagroup.com</a></font></div></div></div></div><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                        "</div></div><div class=\"adL\">\n" +
                        "</div></div>";

                if(!country.contains("Please select country"))
                {
                    sendMail("machadowelborn@gmail.com,sanjeev@vmmpl.com,sanjeev@vaaishnomaagroup.com,info@vaaishnomaagroup.com",Subject,Message);
                }
                else
                {
                    Toast.makeText(Inquiry_form.this, "Please select your country!!!", Toast.LENGTH_SHORT).show();
                }

                }
                catch (NullPointerException npe)
                {

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                s1.setSelection(0);
                s1.setSelection(0);
            }
        });
    }

    public class EditorWatcher implements TextWatcher
    {

        public View view;

        public EditorWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            // TODO Auto-generated method stub
            switch (view.getId()) {

                case R.id.Address:
                    if (isEmptyField(e1))
                    {
                        e1.setError("Enter Address");
                        return;
                    }
                    break;

                case R.id.details:
                    if (isEmptyField(e2))
                    {
                        e2.setError("Enter Details");
                        return;
                    }
                    break;

                case R.id.name:
                    if (isEmptyField(e3))
                    {
                        e3.setError("Enter Name");
                        return;
                    }
                    break;

                case R.id.company_name:
                    if (isEmptyField(e4))
                    {
                        e4.setError("Enter Company Name");
                        return;
                    }
                    break;

                case R.id.email:
                    if (isEmptyField(e5))
                    {
                        e5.setError("Enter Email");
                        return;
                    }
                    else if (!isEmailValid(e5.getText().toString()))
                    {
                        e5.setError("Enter Proper Email-ID");
                        return;
                    }
                    break;

                case R.id.mobile:
                    if (isEmptyField(e6))
                    {
                        e6.setError("Enter Mobile no.");
                        return;
                    }
                    break;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }


    public boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;


        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;

        }
        else {

        }
        return isValid;
    }

    private boolean isEmptyField (EditText editText){
        boolean result = editText.getText().toString().length() <= 0;
        if (result)
            Toast.makeText(Inquiry_form.this, "Please Enter all details!", Toast.LENGTH_SHORT).show();
        return result;
    }


    public void sendMail(String email, String subject, String messageBody) {
        Session session = createSessionObject();

        try {
            Message message = createMessage(email, subject, messageBody, session);
            new SendMailTask().execute(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private Message createMessage(String email, String subject, String messageBody, Session session) throws MessagingException, UnsupportedEncodingException {
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("vmmplappmailserver@gmail.com", company));
        String[] recipientList = email.split(",");
        InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
        int counter = 0;
        for (String recipient : recipientList) {
            recipientAddress[counter] = new InternetAddress(recipient.trim());
            counter++;
        }
        message.setRecipients(Message.RecipientType.TO, recipientAddress);
        message.setContent(messageBody, "text/html");
        message.setSubject(subject);

        return message;
    }

    private Session createSessionObject() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        return Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private class SendMailTask extends AsyncTask<Message, Void, Void> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // custom dialog

            progressDialog = ProgressDialog.show(Inquiry_form.this, "", "Sending...");

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            try {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(),"Inquiry sent successfully",Toast.LENGTH_LONG).show();

            }catch (NullPointerException npe)
            {

            }
        }

        @Override
        protected Void doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
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

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
