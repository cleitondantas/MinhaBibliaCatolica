package br.com.cybertronyk.minhabibliacatolicav2.activitys;

import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Theme;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Vars;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.actionbarsherlock.view.MenuItem;

public class Oracoes extends SherlockActivity {
	private String[] listas;
	TextoDasOracoes textoDasOracoesClasse = new TextoDasOracoes(); 
	MainActivity main = new MainActivity();
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
		
		setContentView(R.layout.activity_oracoes);
		
		listas = getResources().getStringArray(R.array.listOracoes);
		Vars.adOracoes = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, listas);// Vars.li
		Vars.lvOracoes = (ListView) findViewById(R.id.listOracoes);
		Vars.lvOracoes.setAdapter(Vars.adOracoes);
		
		Vars.lvOracoes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
			
				switch (pos) {
				case 0:
					textoDasOracoesClasse.setTxTextoDasOracoes(getString(R.string.paiNosso));
					startIntent();
					break;
				case 1:
					textoDasOracoesClasse.setTxTextoDasOracoes(getString(R.string.aveMaria));
					startIntent();
					break;
				case 2:
					tercoIntent();
					break;	
				case 3:
					textoDasOracoesClasse.setTxTextoDasOracoes(getString(R.string.coroinha));
					startIntent();
					break;	
				}
				
			}
		});
	}
	
	public void startIntent(){
		Intent intent = new Intent(Oracoes.this, TextoDasOracoes.class);
		startActivity(intent);
	}
	public void tercoIntent(){
		Intent intent = new Intent(Oracoes.this, TercoList.class);
		startActivity(intent);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(Oracoes.this, MainActivity.class);
			startActivity(intent);
			break;
		
			}
		return false;
	
	}
	@Override
    public void onBackPressed() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
    super.onBackPressed();
}

	
	
	
}
