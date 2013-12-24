package br.com.cybertronyk.minhabibliacatolicav2.dao;

import br.com.cybertronyk.minhabibliacatolicav2.factory.Actions;
import com.actionbarsherlock.app.SherlockActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//Classe para incerir as conecxoes com o bamco de dados
public class ConnectDAO extends SherlockActivity{
	public static String NomeBancoFavoritos ="Favoritos";
	SQLiteDatabase BancoDados;
	private String nomeBanco = "Bloco";
	private String valDados;
	private int numeroRegistros = 0;
	Cursor cursor;
	Actions actions = new Actions();
	
	
	public void criaBanco(){
		try {
			BancoDados = openOrCreateDatabase(nomeBanco,MODE_WORLD_READABLE, null);
			String SQL = "CREATE TABLE IF NOT EXISTS tabBloco (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, ver TEXT, nota TEXT)";
			BancoDados.execSQL(SQL);
			String SQL2 = "CREATE TABLE IF NOT EXISTS tabFavoritos (id INTEGER PRIMARY KEY AUTOINCREMENT, livro INTEGER, cap INTERGER, ver INTEGER, txlivro TEXT)";
			BancoDados.execSQL(SQL2);

		}catch (Exception erro) {
			actions.toastNote("Erro no banco de dados \n" + erro);
		}
	}
	
	public void OpenBanco(){ // Abri o Banco
		try {
			BancoDados = openOrCreateDatabase(nomeBanco,MODE_WORLD_READABLE, null);
		} catch (Exception erro) {
			actions.toastNote("Erro ao Abrir Banco"+ erro);

		}
	}
	
	public void salveFavoritos(int livro,int cap,int ver,String txLivro){
		try {
			BancoDados = openOrCreateDatabase(nomeBanco,MODE_WORLD_READABLE, null);
			String SQL = "INSERT INTO tabFavoritos VALUES (null,'"+livro+"','"+cap+" ','"+ver+"','"+txLivro+"')";
			BancoDados.execSQL(SQL);
			actions.toastNote("Nota Salva em Favoritos"+"\n"+txLivro );
		} catch (Exception erro) {
			actions.toastNote("Erro ao incerir Favoritos \n " + erro);
		}
	}
	
	public void deletaTabela(){
		try {
			valDados= null;
			BancoDados = openOrCreateDatabase(nomeBanco,MODE_WORLD_READABLE, null);
			String SQL = "DROP TABLE tabBloco";
			String SQL2 = "DROP TABLE tabFavoritos";
			BancoDados.execSQL(SQL);
			BancoDados.execSQL(SQL2);
			BancoDados.close();
			
			actions.toastNote("Todas as notas e Favoritos excluidos !");
		} catch (Exception erro) {
			actions.toastNote("Erro ao Excluir!"+erro);
		}
	}
	
	public void deleteLineBlocoNota(String blocoNotasId){
		try {
			BancoDados = openOrCreateDatabase(nomeBanco,MODE_WORLD_READABLE, null);
			String SQL = "DELETE FROM tabBloco WHERE id ='"+blocoNotasId+"'";
			BancoDados.execSQL(SQL);
			actions.toastNote("Nota Excluida!");
		} catch (Exception erro) {
			actions.toastNote("Erro ao Excluir nota!" + erro);
		}	
	}
	
	public String buscaRegDadosFavoritos(){ // realiza a consulta dos dados 
		OpenBanco();
		
		try {
			cursor = BancoDados.query("tabFavoritos",new String[]{"id","livro","cap","ver","txlivro"},null,null,null,null,null);
			numeroRegistros  = cursor.getCount();
			
			if(numeroRegistros != 0){
				cursor.moveToFirst();
				valDados = cursor.getString(cursor.getColumnIndex("txlivro"));
			}
			return valDados;
		} catch (Exception erro) {

			actions.toastNote("Erro ao Buscar Registros"+ erro);
			return null;
		}
	}


	public String buscaRegDados(){ // realiza a consulta dos dados 
		OpenBanco();
		try {
			cursor = BancoDados.query("tabBloco",new String[]{"id","titulo","ver","nota"},null,null,null,null,null);
			if(cursor.getCount() != 0){
				cursor.moveToFirst();
				valDados = cursor.getString(cursor.getColumnIndex("titulo"));
			}
			return valDados;
		} catch (Exception erro) {

			actions.toastNote("Erro ao Buscar Registros"+ erro);
			return null;
		}
		

	}

	
	public void deleteLineFavoritos(String favId){
		try {
			BancoDados = openOrCreateDatabase(nomeBanco,MODE_WORLD_READABLE, null);
			String SQL = "DELETE FROM tabFavoritos WHERE id ='"+favId+"'";
			BancoDados.execSQL(SQL);
			actions.toastNote("Favorito Excluido!");
		} catch (Exception erro) {
			actions.toastNote("Erro ao Excluir nota!" + erro);
		}
	}
	public void gravaBanco(String titulo, String ver, String nota) {
		try {
			BancoDados = openOrCreateDatabase(nomeBanco,MODE_WORLD_READABLE, null);
			String SQL = "INSERT INTO tabBloco VALUES (null,'"+titulo+"','"+ver+" ','"+nota+"')";
			BancoDados.execSQL(SQL);
			actions.toastNote("Nota incerida !");

		} catch (Exception erro) {
			actions.toastNote("Nota não incerida !"+erro);
		} 
	}
	public void alteraBanco(String id, String titulo, String ver, String nota) {
		try {
			BancoDados = openOrCreateDatabase(nomeBanco,MODE_WORLD_READABLE, null);
			String SQL = "update tabBloco set nota = '"+nota+"' where id = '"+id+"'";
			BancoDados.execSQL(SQL);
			actions.toastNote("Nota Atualizada !");

		} catch (Exception erro) {
			actions.toastNote("Nota não incerida !"+erro);
		} 
	}
	


	public boolean buscaDados(){
		try {
			cursor = BancoDados.query("tabBloco",new String[]{"titulo","ver","nota"},null,null,null,null,null);
			int numeroRegistros  = cursor.getCount();
			if(numeroRegistros != 0){
				cursor.moveToFirst();
				return true;
			}else{
				return false;
			}
		} catch (Exception erro) {
			actions.toastNote("não foi possivel Buscar dados"+ erro);
			return false;
		}
		
	}
	
	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	
}
