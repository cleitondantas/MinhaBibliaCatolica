package br.com.cybertronyk.minhabibliacatolicav2.activitys;
import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import br.com.cybertronyk.minhabibliacatolicav2.dao.ConnectDAO;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Actions;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Theme;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Vars;

import java.util.ArrayList;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Favoritos extends SherlockActivity {
	SQLiteDatabase BancoDados = null;
	Cursor cursor;
	private String valDados;
	private String favId;
	private int favLivroint;
	private int favCapint;
	private int index;
	private int xpiner;
	Actions actions = new Actions();
	public static ListView lvFavoritos;
	public static ArrayAdapter<String> adFavoritos;
	MainActivity main = new MainActivity();
	ConnectDAO connectDAO = new ConnectDAO(); 

	ArrayList<String> FavTxlivro = new ArrayList<String>();
	ArrayList<Integer> FavLivro = new ArrayList<Integer>();
	ArrayList<Integer> FavCap = new ArrayList<Integer>();
	ArrayList<String> FavVer = new ArrayList<String>();
	ArrayList<String> FavId = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//-- Busca o Tema e o Aplica
		if(main.getSDK_INT() <= 10){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		super.setTheme(new Theme().themeRes(main.isTheme()));
		setContentView(R.layout.activity_favoritos);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		valDados =  connectDAO.buscaRegDadosFavoritos();
		
		if(valDados != null){
			start();
			ClickOpenFav();
			LongClickOpenFav();
			valDados = null;
		}else{
			actions.toastNote("Não exitem favoritos a exibir");
			Intent intent = new Intent(Favoritos.this, MainActivity.class);
			startActivity(intent);
		}

	}

	public void LongClickOpenFav(){
		lvFavoritos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
				main.setPosicao(pos);
				favId = FavId.get(pos).toString();
				String titulo = "";
				String texto = "Você deseja apagar este favorito?";
				mensagemExiber(titulo, texto);

				return false;
			}
		
		});
	}
	
	public void mensagemExiber(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(Favoritos.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		
		mensagem.setPositiveButton("Sim",new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				connectDAO.deleteLineFavoritos(favId);
				Intent intent = new Intent(Favoritos.this, Favoritos.class);
				startActivity(intent);
			}
		});
		mensagem.setNegativeButton("Não",new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});


		mensagem.setIcon(R.drawable.ic_launcher);
		mensagem.show();
	}



	public void start() {
		int i = cursor.getCount();
		do {
			i--;
			cursor.moveToPosition(i);
			FavTxlivro.add(cursor.getString(cursor.getColumnIndex("txlivro")));
			FavLivro.add(cursor.getInt(cursor.getColumnIndex("livro")));
			FavCap.add(cursor.getInt(cursor.getColumnIndex("cap")));
			FavVer.add(cursor.getString(cursor.getColumnIndex("ver")));
			FavId.add(cursor.getString(cursor.getColumnIndex("id")));

		} while (i != 0);
		
		adFavoritos = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,FavTxlivro);
		lvFavoritos = (ListView) findViewById(R.id.listFavoritos);
		lvFavoritos.setAdapter(Vars.adFavoritos);

	}
	public void ClickOpenFav(){
		Vars.lvFavoritos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
				favLivroint = FavLivro.get(pos).intValue();
				favCapint = FavCap.get(pos).intValue();
				actions.toastNote("Pagina "+FavTxlivro.get(pos).toString());

//				Vars.favCap = 5;
				
				OpenHomeMainActivity();	
			}
		});
	}	
	
	public void OpenHomeMainActivity(){
		index = 1;
		xpiner = 0;
		Intent intent = new Intent(Favoritos.this, MainActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_favoritos, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		
		case android.R.id.home:
			Intent intent = new Intent(Favoritos.this, MainActivity.class);
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
