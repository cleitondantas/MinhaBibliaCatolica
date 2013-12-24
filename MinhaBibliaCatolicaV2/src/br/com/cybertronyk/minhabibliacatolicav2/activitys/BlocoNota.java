package br.com.cybertronyk.minhabibliacatolicav2.activitys;
import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import br.com.cybertronyk.minhabibliacatolicav2.dao.ConnectDAO;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Theme;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Vars;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.SubMenu;
import com.actionbarsherlock.view.MenuItem;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BlocoNota extends SherlockActivity {
	MainActivity main = new MainActivity();
	SQLiteDatabase BancoDados = null;
	Cursor cursor;
	ConnectDAO connectDAO = new ConnectDAO();
	private String blocoNotasTexto;
	private String blocoNotasTitulo;
	private String blocoNotasNota;
	private String blocoNotasId;
	private TextView tvBlocoTitulo,tvBlocoTexto;
	private EditText tvBlocoNota;
	private String shareComp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//-- Busca o Tema e o Aplica
		if(main.getSDK_INT() <= 10){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		super.setTheme(new Theme().themeRes(main.isTheme()));
		
		setContentView(R.layout.activity_bloco);
		
		tvBlocoTexto = (TextView) findViewById(R.id.tvVersConNota);
		tvBlocoTitulo = (TextView) findViewById(R.id.tvTitleCapVer);
		tvBlocoNota = (EditText) findViewById(R.id.ETNota);
		
		
		tvBlocoTexto.setText(blocoNotasTexto);
		tvBlocoTitulo.setText(blocoNotasTitulo);
		tvBlocoNota.setText(blocoNotasNota);
		
		tvBlocoTexto.setTextSize(getResources().getDimension(Vars.textSizeNota[main.getTextSize()]));
		tvBlocoNota.setTextSize(getResources().getDimension(Vars.textSizeNota[main.getTextSize()]));
		
		if(main.isFocusable() == true){
		tvBlocoNota.setFocusable(true);
		}else{
			tvBlocoNota.setFocusable(false);
		}
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}

	public void mostrarDados(){
		toastNote(cursor.getString(cursor.getColumnIndex("nota")));
		
	}
	public void mostrarReg(){
		try {
			connectDAO.buscaDados();
			cursor.moveToNext();
			mostrarDados();
			
		} catch (Exception erro) {
		toastNote("Não foi possivel mostrar Geristro  / "+erro);
		}
	}
	
	
	//----------------------------------------- Fim Dados
	public void MensagemErro(String titulo, String msgAlerta) {
		AlertDialog.Builder Mensagem = new AlertDialog.Builder(BlocoNota.this);
		Mensagem.setTitle(titulo);
		Mensagem.setMessage(msgAlerta);
		Mensagem.setNeutralButton("OK", null);
	}


	// --------------------------------Menus E Botoes ActionBar
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getSupportMenuInflater().inflate(R.menu.activity_bloco, menu);
		
		SubMenu submenu = menu.addSubMenu(0,0,2,"Navigation Menu");
		
		MenuItem subMenuItem = (MenuItem) submenu.getItem();
		
		subMenuItem.setIcon(android.R.drawable.ic_menu_more);
		subMenuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		submenu.add(0,2,2,"Editar").setIcon(android.R.drawable.ic_menu_edit);
		submenu.add(0,3,3,"Compartilhar").setIcon(android.R.drawable.ic_menu_share);
		
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		
		case android.R.id.home:
			
			Intent intent = new Intent(BlocoNota.this, MainActivity.class);
			startActivity(intent);
			break;
		
		case R.id.menu_save:

			if(main.isFocusable() == true){
				if(main.isSalvaOrUpdate() == true){
					
				String nota = tvBlocoNota.getText().toString();
				connectDAO.gravaBanco(blocoNotasTitulo, blocoNotasTexto, nota);
				main.setSalvaOrUpdate(false);
				}else{
				String nota = tvBlocoNota.getText().toString();	
				connectDAO.alteraBanco(blocoNotasId, blocoNotasTitulo, blocoNotasTexto, nota);
				}
			}else{
				toastNote(" Não foi possivel salvar \n No modo de Visualização ");
			}

			break;
		case 2:
			main.setFocusable(true);
			
			intent = new Intent(BlocoNota.this, BlocoNota.class);
			startActivity(intent);
			
			break;
		case 3:
			String nota = tvBlocoNota.getText().toString();
			shareComp = " ' "+blocoNotasTexto+" ' "+blocoNotasTitulo+" \n \n Nota:\n"+nota;
			shareIt();

			break;
		}

		return super.onOptionsItemSelected(item);
		
		
	}

	public void toastNote(String txt) {
		Context context = getApplicationContext();
		CharSequence text = txt;
		int duration = Toast.LENGTH_LONG;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	private void shareIt() {
		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,shareComp);
		startActivity(Intent.createChooser(sharingIntent, "Compartilhar via"));

	}
	@Override
    public void onBackPressed() {
		Intent intent = new Intent(BlocoNota.this, Anotacoes.class);
		startActivity(intent);
    super.onBackPressed();
}
}
