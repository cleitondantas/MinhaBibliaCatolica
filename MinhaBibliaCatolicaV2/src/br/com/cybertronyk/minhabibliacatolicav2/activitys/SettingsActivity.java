package br.com.cybertronyk.minhabibliacatolicav2.activitys;
import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import br.com.cybertronyk.minhabibliacatolicav2.dao.ConnectDAO;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Theme;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Vars;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class SettingsActivity extends SherlockActivity  {
	MainActivity main = new MainActivity();
	ConnectDAO connectDAO = new ConnectDAO();
	private PopupWindow mpopup;
	SQLiteDatabase BancoDados;
	boolean rbButton;
	private Button btDeletBanco;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(main.getSDK_INT() <= 10){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		super.setTheme(new Theme().themeRes(main.isTheme()));

		setContentView(R.layout.activity_settings);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		final RadioButton rbClaro = (RadioButton)findViewById(R.id.radioButtonClaro);
		final RadioButton rbEscuro = (RadioButton)findViewById(R.id.radioButtonEscuro);
		final Button BtAbout = (Button)findViewById(R.id.btAbout);
		final SeekBar SBSizeFont = (SeekBar)findViewById(R.id.seekBar);
		final LinearLayout linearRadioButton = (LinearLayout)findViewById(R.id.linearRadioButton);
		final Button btDeletBanco = (Button) findViewById(R.id.deletBanco);
		
		if(main.getSDK_INT() <= 10){
		linearRadioButton.removeAllViews();
		}
		SBSizeFont.setMax(4);
		SBSizeFont.setProgress(main.getTextSize());
		
		SBSizeFont.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

				main.setTextSize(progress);
				salvarPref();
			}
		});
		
		if(main.isTheme() == true){
			rbClaro.setChecked(true);
			rbEscuro.setChecked(false);
		}else{
			rbClaro.setChecked(false);
			rbEscuro.setChecked(true);
		}
			
		
		rbClaro.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked == true){
					main.setTheme(true);
				salvarPref();
				}
			}
		});
		rbEscuro.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked == true){
					main.setTheme(false);
					salvarPref();
				}
				
			}
		});

		btDeletBanco.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mensagemExiber("Deseja apagar tudo?","Todas as anotoções e favoritos serão \n   apagados permanentimente ! ");
			}
		});
		
		BtAbout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				View popUpView = getLayoutInflater().inflate(R.layout.popupabout, null); // inflating popup 
				mpopup = new PopupWindow(popUpView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
                mpopup.setAnimationStyle(android.R.style.Animation_Dialog);   
                mpopup.showAtLocation(popUpView, Gravity.CENTER, 0, 0);    // Displaying popup
                
                final  Button btnOk = (Button) popUpView.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new OnClickListener(){                    
                    @Override
                    public void onClick(View v) 
                    {
                        mpopup.dismiss();  //dismissing the popup
                    }
                });
                
			}
		});
		
	}
	
	@Override
    public void onBackPressed() {
		Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
		startActivity(intent);
    super.onBackPressed();
}
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		
			case android.R.id.home:
			Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
			startActivity(intent);
			break;

		}
		return super.onOptionsItemSelected(item);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_settings, menu);
		return true;
	}
	
	public void toastNote(String txt) {
		Context context = getApplicationContext();
		CharSequence text = txt;
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	public void mensagemExiber(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(SettingsActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNegativeButton("Não",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
				
					}
				});
		mensagem.setPositiveButton("Sim",new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						connectDAO.deletaTabela();
					}
				});
		mensagem.setIcon(R.drawable.ic_launcher);
		mensagem.show();
	}

    //Restaura as preferencias gravadas

public void salvarPref(){
       SharedPreferences settings = getSharedPreferences("Preferences", 0);
       SharedPreferences.Editor editor = settings.edit();
       editor.putBoolean("PrefUsuario", main.isTheme());
       editor.putInt("PrefFont", main.getTextSize());
       editor.commit();
	}

}
