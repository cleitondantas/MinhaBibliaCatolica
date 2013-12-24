package br.com.cybertronyk.minhabibliacatolicav2.activitys;
import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Theme;


import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import android.os.Bundle;
import android.view.Window;
import android.content.Intent;



public class HelpActivity extends SherlockActivity {
	MainActivity main = new MainActivity();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(main.getSDK_INT() <= 10){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		super.setTheme(new Theme().themeRes(main.isTheme()));

		setContentView(R.layout.activity_help);
		
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getSupportMenuInflater().inflate(R.menu.activity_help, menu);
	
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		
		case android.R.id.home:
			Intent intent = new Intent(HelpActivity.this, MainActivity.class);
			startActivity(intent);
			break;

		}
		return super.onOptionsItemSelected(item);
	}
	@Override
    public void onBackPressed() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
    super.onBackPressed();
}
}
