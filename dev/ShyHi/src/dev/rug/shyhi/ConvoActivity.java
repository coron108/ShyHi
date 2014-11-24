package dev.rug.shyhi;

import java.net.URL;
import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class ConvoActivity extends ActionBarActivity {

    public static final String PREFS_NAME = "userInfoPrefs";
    public String restUrl = "http://104.236.22.60:5984/shyhi/_design/conversation/_view/get_convo?key=";
	RestUtils restUtil = new RestUtils();
	SharedPreferences userInfo = null;
	private Convo convo;
	private String userID = "";
	private ArrayList<Message> messages;
	private convoAdapter adapter;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_convo);
		userInfo = getSharedPreferences("dev.rug.shyhi",MODE_PRIVATE);
		//get convo id, which will be passed as an intent extra
		Intent intent = getIntent();
	    userID = intent.getStringExtra("idExtra");	
	}

	@Override
	protected void onResume(){
		super.onResume();	
		convo = restUtil.getConvoById(userID);
		// pass context and data to the custom adapter
		messages = convo.getMessages();
	    adapter = new convoAdapter(this, messages);
		ListView lv = (ListView)findViewById(R.id.msgsLv);	
	    //setListAdapter
	    lv.setAdapter(adapter);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.convo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
