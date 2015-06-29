package com.example.jozeffraai.mobileinfra.Activitys;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jozeffraai.mobileinfra.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
	TextView tvStudentNaam, tvSchoolID;
	EditText etStudentID;
	private static Button btnSubmit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvStudentNaam = (TextView)findViewById(R.id.tvStudentNaam);
		tvSchoolID = (TextView)findViewById(R.id.tvSchoolID);
		etStudentID = (EditText)findViewById(R.id.etStudentID);
		btnSubmit = (Button)findViewById(R.id.btnSubmit);

		btnSubmit.setOnClickListener(this);
	}

	public void execute() {
		new HttpAsyncTask().execute("http://145.109.148.44:8080/MobileInfrastructure/resources/checkin/newcheckin/2456");

	}

	public static String GET(String url) {
		InputStream inputStream = null;
		String result = "";
		try {

			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
			inputStream = httpResponse.getEntity().getContent();
			if (inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";

		} catch (Exception e) {
//            Log.d("InputStream", e.getLocalizedMessage());
		}

		return result;
	}

	private static String convertInputStreamToString(InputStream inputStream) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btnSubmit:
				execute();
				break;
		}
	}

		private class HttpAsyncTask extends AsyncTask<String, Void, String> {
			@Override
			protected String doInBackground(String... urls) {

				return GET(urls[0]);
			}

			@Override
			protected void onPostExecute(String result) {
				Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();

			}
		}
	}
