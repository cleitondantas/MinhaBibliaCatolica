package br.com.cybertronyk.minhabibliacatolicav2.activitys;

import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Theme;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Vars;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
public class TextoDasOracoes extends SherlockActivity {
	MainActivity  main = new MainActivity();
	Oracoes oracoes = new Oracoes();
	private TextView tvTextoDasOracoes;
	private String txTextoDasOracoes;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(main.getSDK_INT() <= 10){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		super.setTheme(new Theme().themeRes(main.isTheme()));
		
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		setContentView(R.layout.activity_texto_das_oracoes);
		tvTextoDasOracoes = (TextView) findViewById(R.id.tvTextoDasOracoes);
		
		tvTextoDasOracoes.setText(txTextoDasOracoes);
		tvTextoDasOracoes.setTextSize(getResources().getDimension(Vars.textSizeNota[main.getTextSize()]));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, Oracoes.class);
			startActivity(intent);
			break;
		
			}
		return false;
	
	}
	@Override
    public void onBackPressed() {
		Intent intent = new Intent(this, Oracoes.class);
		startActivity(intent);
    super.onBackPressed();
	}

	public String getTxTextoDasOracoes() {
		return txTextoDasOracoes;
	}

	public void setTxTextoDasOracoes(String txTextoDasOracoes) {
		this.txTextoDasOracoes = txTextoDasOracoes;
	}
	
}
