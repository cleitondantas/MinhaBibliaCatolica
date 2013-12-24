package br.com.cybertronyk.minhabibliacatolicav2.activitys;
import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import br.com.cybertronyk.minhabibliacatolicav2.R.drawable;
import br.com.cybertronyk.minhabibliacatolicav2.R.id;
import br.com.cybertronyk.minhabibliacatolicav2.R.layout;
import br.com.cybertronyk.minhabibliacatolicav2.R.menu;
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
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Anotacoes extends SherlockActivity {
	SQLiteDatabase BancoDados = null;
	MainActivity main = new MainActivity();
	ConnectDAO connectDAO = new ConnectDAO();
	Actions actions = new Actions(); 
	Cursor cursor = null;
	private String valDados;
	private boolean focusable = false;
	ArrayList<String> ListTitulo = new ArrayList<String>();
	ArrayList<String> ListTexto = new ArrayList<String>();
	ArrayList<String> ListNota = new ArrayList<String>();
	ArrayList<String> ListId = new ArrayList<String>();
	private int posicao;
	private String blocoNotasTitulo;
	private String blocoNotasTexto ;
	private String blocoNotasNota ;
	private String blocoNotasId ;
	private int numeroRegistros;
	private int pos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(main.getSDK_INT() <= 10){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		super.setTheme(new Theme().themeRes(main.isTheme()));
		
		setContentView(R.layout.activity_anotacoes);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		valDados = connectDAO.buscaRegDados();
		if (valDados != null) {
			start();
			ClickOpen();
			LongClickOpen();
			valDados = null;
			focusable = false; // Irá impedir que vá para o BlocoNota.java em modo de edição
		}else{
			Intent intent = new Intent(Anotacoes.this, MainActivity.class);
			startActivity(intent);

			actions.toastNote("Não exitem notas a Exibir");
		}
	}
//---------------------------------------Banco de Dados---------------
	public void ClickOpen(){
		Vars.lvNota.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
				posicao = Integer.valueOf(pos);
				MostraNota();
			}
		});
	}	
	public void LongClickOpen(){
		Vars.lvNota.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
				posicao = pos;
				blocoNotasId = ListId.get(pos).toString();
				mensagemExiber("", "Você deseja apagar esta nota?");	
				return false;
			}
		});
	}


	public void mensagemExiber(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(Anotacoes.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setPositiveButton("Sim",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				connectDAO.deleteLineBlocoNota(blocoNotasId);
				Intent intent = new Intent(Anotacoes.this, Anotacoes.class);
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
	
//	---------------------------------- FIm Banco
	
//-----------------------------ListView-

		
		public void start() {
			int i = cursor.getCount();
			cursor.moveToLast();
			do {
			i--;
			cursor.moveToPosition(i);
			ListTitulo.add(cursor.getString(cursor.getColumnIndex("titulo")));
			ListTexto.add(cursor.getString(cursor.getColumnIndex("ver")));
			ListNota.add(cursor.getString(cursor.getColumnIndex("nota")));
			ListId.add(cursor.getString(cursor.getColumnIndex("id")));
			
			
			} while (i != 0);
			
			Vars.adNota = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,ListTitulo);// Vars.li
			Vars.lvNota = (ListView) findViewById(R.id.listNota);
			Vars.lvNota.setAdapter(Vars.adNota);

		}

// ------------------ Fim Listview
		public void MostraNota(){
			int i = main.getPosicao();
			  //ListTitulo.get(i).toString();
			blocoNotasNota = "";
	
			blocoNotasTitulo = ListTitulo.get(i).toString();
			blocoNotasTexto =  ListTexto.get(i).toString();
			blocoNotasNota = ListNota.get(i).toString();
			blocoNotasId = ListId.get(i).toString();

			main.setSalvaOrUpdate(false);
			Intent intent = new Intent(Anotacoes.this, BlocoNota.class);
			startActivity(intent);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_anotacoes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(Anotacoes.this, MainActivity.class);
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
