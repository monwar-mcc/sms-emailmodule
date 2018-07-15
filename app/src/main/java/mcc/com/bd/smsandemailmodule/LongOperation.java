package mcc.com.bd.smsandemailmodule;


import android.os.AsyncTask;
import android.util.Log;

public class LongOperation extends AsyncTask<Void, Void, String> {

    String url;
    public LongOperation(String url) {
        this.url=url;
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            GMailSender sender = new GMailSender("monwar.mcc@gmail.com", "password");
            sender.addAttachment(url, "File");
            sender.sendMail("This is a testing mail",
                    "This is Body of testing mail", "monwar.mcc@gmail.com",
                    "kibria.mcc@gmail.com, rezaulislam.mcc@gmail.com");

        } catch (Exception e) {
            Log.e("error", e.getMessage(), e);
            return "Email Not Sent";
        }
        return "";
    }

    @Override
    protected void onPostExecute(String result) {

        Log.e("LongOperation", result + "");
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }


}
