package br.com.cybertronyk.minhabibliacatolicav2;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import br.com.cybertronyk.minhabibliacatolicav2.activitys.Anotacoes;
import br.com.cybertronyk.minhabibliacatolicav2.activitys.BlocoNota;
import br.com.cybertronyk.minhabibliacatolicav2.activitys.Favoritos;
import br.com.cybertronyk.minhabibliacatolicav2.activitys.HelpActivity;
import br.com.cybertronyk.minhabibliacatolicav2.activitys.Oracoes;
import br.com.cybertronyk.minhabibliacatolicav2.activitys.SettingsActivity;
import br.com.cybertronyk.minhabibliacatolicav2.dao.ConnectDAO;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Actions;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Theme;
import br.com.cybertronyk.minhabibliacatolicav2.factory.Vars;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

public class MainActivity extends SherlockActivity {
	
	//Comentarios
	private MenuItem mSpinnerItem = null;
	private OnNavigationListener mOnNavigationListener;
	private TextView etTitleCopy;
	private Button btCapVoltar, btCapAvancar;
	private ListView lv;
	private LinearLayout linearlayout;
	private String shareComp;
	private String titleLivro;
	private String copy;
	private String textoCap;
	
	private String blocoNotasTexto,blocoNotasTitulo,blocoNotasNota;
	private String txtversConcatena,txtTitleConcatena;
	private String[] itensTitle;
	public static String[] listas;
	private  ArrayAdapter<String> ad;
	private int SDK_INT;
	private int textSize;
	private int livPosicao = 1;
	private int index = 0;
	private int xpiner;
	private int favCap;
	private int posVerciculo;
	private int quantVers;
	private int posicao = 1;
	private int copyNumMult = -1;
	private int favLivro; // indice do livro favorito
	private boolean orientationLand;
	private boolean orientTrueFalse = false;
	private boolean salvaOrUpdate = false;
	private boolean theme = true;
	private boolean focusable = false;
	ConnectDAO connectDAO = new ConnectDAO();
	Vars varsClasse = new Vars();
	Actions actions = new Actions();
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sharedPreferences();
		SDK_INT = new Theme().buscaSDK();
		if(SDK_INT <= 10){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		super.setTheme(new Theme().themeRes(theme));
		setContentView(R.layout.main);
		//connectDAO.criaBanco(); // Cria O banco de dados caso não tenha
		varsClasse.TextSize(); // Seta o tamanho da fonte	
		quantVers =  varsClasse.livros(); // Seta os Livros
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		
		start();
		btCapAvancar = (Button) findViewById(R.id.btCapAvancar);
		btCapVoltar = (Button) findViewById(R.id.btCapVoltar);
		etTitleCopy = (TextView) findViewById(R.id.etTitleCopy);
		linearlayout = (LinearLayout) findViewById(R.id.linear);
		
		
		itensTitle = getResources().getStringArray(R.array.spinner_Liv);
		SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,R.array.spinner_Liv,R.layout.sherlock_spinner_dropdown_item);
		mOnNavigationListener = new OnNavigationListener() {
			@Override
			public boolean onNavigationItemSelected(int itemPosition,long itemId) {
				
				if(index == 1){
					livPosicao =favLivro;
				}else{
					livPosicao = itemPosition + 1;	
				}
				favLivro =	livPosicao;
				quantVers =	varsClasse.livros();
				setupSpinner(mSpinnerItem);
				start();
				
				return true;
			}
		};
		getSupportActionBar().setListNavigationCallbacks(mSpinnerAdapter, mOnNavigationListener );


		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
				final String txtvers = lv.getAdapter().getItem(pos).toString();
				final String txtcap = lv.getAdapter().getItem(0).toString();
				textoCap = txtcap;
				if(copyNumMult== pos){
					if(txtversConcatena == null){
						txtversConcatena =  txtvers;
					}else{
						txtversConcatena =  txtversConcatena +" \n"+ txtvers;
					}
					
					if(txtTitleConcatena == null){
						txtTitleConcatena =  Integer.toString(pos);
					}else{
						txtTitleConcatena = txtTitleConcatena +","+  Integer.toString(pos);					
					}
					
					titleLivro = itensTitle[livPosicao - 1];
					copy = "("+ titleLivro + " " + txtcap + " Ver " + txtTitleConcatena + ")";
					actions.toastNote(copy);
					if(orientationLand == true){
						etTitleCopy.setText(copy);
					}
					copyNumMult= 0;// Zera novamente
					} else {
						copyNumMult= pos;
					}
					if (copyNumMult== -1) {
						copyNumMult= pos;
					}
				}
			});
		
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
				posVerciculo = pos;
				titleLivro = itensTitle[livPosicao - 1];

				final String txtvers = lv.getAdapter().getItem(pos).toString();
				final String txtcap = lv.getAdapter().getItem(0).toString();
				
				blocoNotasTexto = txtvers;
				blocoNotasNota = "";
				
				mensagemExiber("Versículo " + pos, txtvers + " ("+ titleLivro + " " + txtcap + " Ver " + pos + ")");
				blocoNotasTitulo = "("+ titleLivro + " " + txtcap + " Ver " + pos + ")";
				shareComp = (txtvers + " (" + titleLivro + " "+ txtcap + " Ver " + pos + ")");
				
				return false;
			}

		});
		
		orientacao();
		orientTrueFalse = true;
	}
	
	public void multSelecVers(){
		blocoNotasTexto = txtversConcatena;

		blocoNotasTitulo = "("+ titleLivro + " " + textoCap + " Ver " +   actions.reConcatena(txtTitleConcatena) + ")";
		copMultVers(titleLivro, txtversConcatena);
	}

	public void start() {
		getSupportActionBar().setSelectedNavigationItem(livPosicao -1);
		listas = getResources().getStringArray(Vars.cap[posicao]);
		ad = new ArrayAdapter<String>(this,Vars.textSizeResLay[textSize],Vars.textSizeResID[textSize], listas);// Vars.li
		lv = (ListView) findViewById(R.id.list);
		lv.setAdapter(ad);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuinflater = getSupportMenuInflater();
		menuinflater.inflate(R.menu.main, menu);
		
		mSpinnerItem = menu.findItem(R.id.menu_spinner);
		setupSpinner(mSpinnerItem);
		
		SubMenu submenu = menu.addSubMenu("Navigation Menu");

		MenuItem subMenuItem = submenu.getItem();
		subMenuItem.setIcon(android.R.drawable.ic_menu_more);
		subMenuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		submenu.add(0,1,1,"Anotações").setIcon(android.R.drawable.ic_menu_edit);
		submenu.add(0,2,2,"Favoritos").setIcon(android.R.drawable.btn_star);
		submenu.add(0,3,3,"Orações").setIcon(R.drawable.maosoracao2);
		submenu.add(0,4,4,"MultSeleção").setIcon(android.R.drawable.ic_menu_sort_by_size);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.AAless:
			if (textSize == 0) {
			} else {
				textSize--;
				start();
			}
			break;
		case R.id.AAMore:
			if (textSize == 4) {
			} else {
				textSize++;
				start();
			}
			break;

		case R.id.config:
				chamaConfig();
			break;
		case R.id.help:
				chamaHelp();
			break;
		case R.id.exit:
				finish();
			break;
		case 1:
			chamaTelaAnotacoes();
			break;
		case 2:
			chamafavoritos();
			break;
		case 3:
			oracoes();
		break;		
		case 4:
			if (txtversConcatena == null) {
				actions.toastNote("Não Existe verciculos selecionados \n Click duas vezes no verciculo para selecionalo");
			} else {
				multSelecVers();
			}
			break;
		}
	
		return super.onOptionsItemSelected(item);
	}
		public void mensagemExiber(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("Salvar \n Favoritos",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ConnectDAO connectDAO = new ConnectDAO();
				connectDAO.salveFavoritos(livPosicao, posicao, posVerciculo, blocoNotasTitulo);

			}
		});
		mensagem.setNegativeButton("Compartilhar",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						shareIt();
					}
				});
		mensagem.setPositiveButton("Comentar",new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						ChamaTelaBLoco();
					}
				});

		mensagem.setIcon(R.drawable.ic_launcher);
		mensagem.show();
	}
		public void copMultVers(String titulo, String texto) {
			AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
			mensagem.setTitle(titulo);
			mensagem.setMessage(texto);
			mensagem.setNegativeButton("Compartilhar",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							shareComp = (txtversConcatena + " "+ blocoNotasTitulo );
							shareIt();

						}
					});
			mensagem.setNeutralButton("Cancelar",new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					CancMultVers("Aviso", "Deseja apagar todos os verciculos que já foram selecionados ?");
				}
			});
			mensagem.setPositiveButton("Comentar",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							ChamaTelaBLoco();
						}
					});

			mensagem.setIcon(R.drawable.ic_launcher);
			mensagem.show();
		}
		public void CancMultVers(String titulo, String texto) {AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
			mensagem.setTitle(titulo);
			mensagem.setMessage(texto);
			mensagem.setNegativeButton("Não",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					});
			mensagem.setPositiveButton("sim",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							zeraVarsMultSec();
						}
					});
			mensagem.setIcon(R.drawable.ic_launcher);
			mensagem.show();
		}
		
	public void msgAbout(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("Ok",null);

		mensagem.setIcon(R.drawable.ic_launcher);
		mensagem.show();
	}

	private void shareIt() {
		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,shareComp);
		startActivity(Intent.createChooser(sharingIntent, "Compartilhar via"));

	}
	
	private void setupSpinner(MenuItem item) {
		
		item.setVisible(getSupportActionBar().getNavigationMode() == ActionBar.NAVIGATION_MODE_LIST);
		selecionaLivro();
		View view = item.getActionView();
		
		final Spinner spinner = (Spinner) view;
		
		if (livPosicao == 1) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,R.array.spinner_01,R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 2) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,R.array.spinner_02,R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 3) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,R.array.spinner_03,R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 4) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,R.array.spinner_04,R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 5) {spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_05,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 6) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_06,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 7) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_07,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 8) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_08,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 9) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_09,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 10) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_10,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 11) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_11,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 12) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_12,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 13) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_13,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 14) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_14,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 15) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_15,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 16) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_16,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 17) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_17,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 18) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_18,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 19) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_19,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 20) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_20,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 21) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_21,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 22) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_22,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 23) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_23,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 24) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_24,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 25) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_25,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 26) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_26,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 27) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_27,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 28) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_28,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 29) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_29,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 30) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_30,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 31) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_31,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 32) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_32,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 33) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_33,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 34) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_34,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 35) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_35,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 36) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_36,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 37) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_37,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 38) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_38,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 39) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_39,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 40) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_40,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 41) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_41,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 42) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_42,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 43) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_43,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 44) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_44,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 45) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_45,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 46) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_46,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 47) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_47,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 48) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_48,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 49) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_49,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 50) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_50,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 51) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_51,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 52) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_52,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 53) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_53,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 54) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_54,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 55) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_55,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 57) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_57,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 58) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_58,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 59) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_59,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 60) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_60,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 61) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_61,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 62) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_62,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 63) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_63,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 64) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_64,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 65) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_65,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 66) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_66,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 67) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_67,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 68) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_68,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 69) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_69,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 70) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_70,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 71) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_71,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 72) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_72,
					R.layout.sherlock_spinner_dropdown_item));
		}
		if (livPosicao == 73) {
			spinner.setAdapter(ArrayAdapter.createFromResource(this,
					R.array.spinner_73,
					R.layout.sherlock_spinner_dropdown_item));
		}
		
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int itemPosition, long id) {
				
				if (SDK_INT >= 16) {
					if (index == 1) {
						xpiner++;
						if (xpiner == 2) {
							posicao = favCap;
							spinner.setSelection(posicao - 1);
							index = 0;
						}

					} else {
						posicao = itemPosition + 1;
					}
				}
				if (SDK_INT <= 15) {

					if (index == 1) {
							posicao = favCap;
							spinner.setSelection(posicao - 1);
							index = 0;
					} else {
						posicao = itemPosition + 1;
					}
					index = 0;
					posicao = itemPosition + 1;
				}
				favCap = posicao;
				start();
			}
		
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
			
		btCapVoltar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				indexFalse();
				spinner.setSelection(posicao - 2);

			}
		});
		btCapAvancar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				indexFalse();
				if (posicao == quantVers) {
					posicao = quantVers;
				} else {

					spinner.setSelection(posicao++);
				}

			}
		});
	}
	private void selecionaLivro(){
		
	}
	public void ChamaTelaBLoco(){
		salvaOrUpdate = true;
		focusable = true;
		Intent intent = new Intent(MainActivity.this, BlocoNota.class);
		startActivity(intent);
		}
	public void chamaTelaAnotacoes(){
		Intent intent = new Intent(MainActivity.this, Anotacoes.class);
		startActivity(intent);
	}
	public void chamafavoritos(){
		Intent intent = new Intent(MainActivity.this, Favoritos.class);
		startActivity(intent);
	}
	public void oracoes(){
		Intent intent = new Intent(MainActivity.this, Oracoes.class);
		startActivity(intent);
	}
	public void chamaConfig(){
		Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
		startActivity(intent);

	}
	public void chamaHelp(){

		Intent intent = new Intent(MainActivity.this, HelpActivity.class);
		startActivity(intent);
	}
	



	public void indexFalse(){
		if(index == 1){
			index = 0;
		}
		
	}


	@Override
	public void onPause(){
		super.onPause();
	}
	@Override
	public void onDestroy(){
		super.onDestroy();
	}
	public void zeraVarsMultSec(){
		shareComp = null;
		txtversConcatena = null;
		txtTitleConcatena = null; 
		titleLivro = null;
		copy = null;
		copyNumMult= -1;
		if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
			etTitleCopy.setText("(Nenhum verciculo selecionado)");
		}
	}
	
	public void orientacao(){
		switch (this.getResources().getConfiguration().orientation) {
		case Configuration.ORIENTATION_LANDSCAPE:

	    	orientationLand = true;
	    	if(copy != null){
	    		etTitleCopy.setText(copy);
	    	}else{
	    		etTitleCopy.setText("(Nenhum verciculo selecionado)");
	    	}
			orient();
			break;

		case Configuration.ORIENTATION_PORTRAIT :
			orientationLand = false;
			orient();
			break;
		}
	}
	
	public void orient(){
		if(orientTrueFalse == true){
			index = 1;
			xpiner =0;
			posicao = favCap;
			livPosicao = favLivro;
			start();
		}
	}
	
	@Override
    public void onBackPressed() {
    exitOrMenu(" Gostaria de sair do App?");
	}
	public void exitOrMenu(String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
		mensagem.setMessage(texto);
		mensagem.setNegativeButton("Não",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});

		mensagem.setPositiveButton("sim",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				});

		mensagem.setIcon(R.drawable.ic_launcher);
		mensagem.show();
	}
	public void sharedPreferences(){
		SharedPreferences settings = getSharedPreferences("Preferences", 0);
		theme =  settings.getBoolean("PrefUsuario",true);
		textSize = settings.getInt("PrefFont", 2);
	}
	

	
	
	
	//----------Getters And Setters--------------------------------------------

	public int getSDK_INT() {
		return SDK_INT;
	}

	public void setSDK_INT(int sDK_INT) {
		SDK_INT = sDK_INT;
	}

	public boolean isTheme() {
		return theme;
	}

	public void setTheme(boolean theme) {
		this.theme = theme;
	}

	public int getTextSize() {
		return textSize;
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}
	public boolean isSalvaOrUpdate() {
		return salvaOrUpdate;
	}
	public void setSalvaOrUpdate(boolean salvaOrUpdate) {
		this.salvaOrUpdate = salvaOrUpdate;
	}
	public boolean isFocusable() {
		return focusable;
	}
	public void setFocusable(boolean focusable) {
		this.focusable = focusable;
	}
	public int getLivPosicao() {
		return livPosicao;
	}
	public void setLivPosicao(int livPosicao) {
		this.livPosicao = livPosicao;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	
	
}
