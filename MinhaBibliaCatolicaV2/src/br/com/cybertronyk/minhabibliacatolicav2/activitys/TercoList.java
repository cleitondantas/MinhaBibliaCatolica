package br.com.cybertronyk.minhabibliacatolicav2.activitys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Theme;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Vars;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;


public class TercoList extends SherlockActivity {
	MainActivity main = new MainActivity();
	TextoDasOracoes textoDasOracoesClasse = new TextoDasOracoes();
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
		setContentView(R.layout.activity_terco_list);

		 
		 List<Map<String, String>> l = getExampleList();
	        String[] from = { "ExampleId", "ExampleName" };
	        int[] to = { android.R.id.text1, android.R.id.text2 };
		Vars.adTerco = new SimpleAdapter(this,l,android.R.layout.simple_list_item_2,from,to);
		Vars.lvTerco = (ListView) findViewById(R.id.listTerco);
		Vars.lvTerco.setAdapter(Vars.adTerco);
		
		Vars.lvTerco.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
			
				switch (pos) {
				case 0:
					textoDasOracoesClasse.setTxTextoDasOracoes(getString(R.string.misterioGozosos));
					startIntent();
					break;
				case 1:
					textoDasOracoesClasse.setTxTextoDasOracoes(getString(R.string.misterioDolorosos));
					startIntent();
					break;
				case 2:
					textoDasOracoesClasse.setTxTextoDasOracoes(getString(R.string.misterioGloriosos));
					startIntent();
					break;	
				case 3:
					textoDasOracoesClasse.setTxTextoDasOracoes(getString(R.string.misterioLuminosos));
					startIntent();
					break;	
				}
				
			}
		});

	}

	private List<Map<String, String>> getExampleList() {
		listMinisterios();
        List<Map<String, String>> l = new ArrayList<Map<String, String>>();
        
        for (int i = 0; i < 4; i++) {
            Map<String, String> m = new HashMap<String, String>();
            m.put("ExampleId", Vars.ListMinist[i]);
            m.put("ExampleName",Vars.ListMinistSemana[i]);
            l.add(m);
		}
        return l;
	}

	public void startIntent(){
		Intent intent = new Intent(TercoList.this, TextoDasOracoes.class);
		startActivity(intent);
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
	private void listMinisterios(){
	      Vars.ListMinist = getResources().getStringArray(R.array.listTerco);
	      Vars.ListMinistSemana = getResources().getStringArray(R.array.listTercoSemana);
	}
}
