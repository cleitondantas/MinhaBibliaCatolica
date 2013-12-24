package br.com.cybertronyk.minhabibliacatolicav2.factory;
import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import java.util.ArrayList;
import java.util.List;
import android.app.ActionBar;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Vars {
	public static Button  btSizeLess, btSizeMore, btnVoltarMain,btnSalvar, btDeletBanco;
	public static float screnScale;
	public static int itemPosition;
	public static int  quantVers;
	
	public static boolean actBar = false;
	public static  ActionBar ab;
	public static int verI,itemPs;
	public static String txtcap;
	public static String Copy;
	public static boolean copyVersMul = true;
	public static String[] txtNota;
	
	
	public static int pos;
	public static List<String> ListTitleMultSec  = new ArrayList<String>();
	public static String txZ,txG;
	public static List<String> li;
	public static ListView  lvNota, lvFavoritos, lvOracoes,lvTerco;
	
	public static ArrayAdapter<String> adNota, adFavoritos, adOracoes;
	public static SimpleAdapter adTerco;
	public static TextView txTitle;
	public static int itemPositionCopy;
	public static int posicao = 1;
	public static int arraySpinner[] = new int [73];
	public static String NomeBancoFavoritos ="Favoritos";
	public static String valDados;
	public static int cap[] = new int[155];

	public static String ListMinist[] = new String[4];
	public static String ListMinistSemana[] = new String[4];
	public static int textSizeResID[] = new int[5];
	public static int textSizeResLay[] = new int[5];
	public static int textSizeNota[] = new int [5];

	
	public static void arraySpinner(){
	
		arraySpinner[0] = R.array.spinner_01;
	}
	public void TextSize(){
		
		textSizeResID[0] = R.id.linesmallTx;
		textSizeResLay[0] = R.layout.linessmall;
		textSizeNota[0] = R.dimen.siteTextNota10;
		
		textSizeResID[1] = R.id.linesmallTx2;
		textSizeResLay[1] = R.layout.linesdouble;
		textSizeNota[1] = R.dimen.siteTextNota12;
		
		textSizeResID[2] = R.id.linesmallTx3;
		textSizeResLay[2] = R.layout.linestriple;
		textSizeNota[2] = R.dimen.siteTextNota13;
		
		textSizeResID[3] = R.id.linesmallTx4;
		textSizeResLay[3] = R.layout.linesquadruple;
		textSizeNota[3] = R.dimen.siteTextNota15;
		
		textSizeResID[4] = R.id.linesmallTx5;
		textSizeResLay[4] = R.layout.linesquint;
		textSizeNota[4] = R.dimen.siteTextNota20;
	}
	
	public  void CapZero() {
		MainActivity main = new MainActivity();
		main.setPosicao(1);
		for (int i = 0; i <= 153; i++) {
			cap[i] = 0;
		}
	}
	
	public int livros() {
		MainActivity main = new MainActivity();
		if (main.getLivPosicao() >= 1) {
			switch (main.getLivPosicao()) {
			case 0:
				main.setLivPosicao(1);
				quantVers = Vars.CapGen();
				break;
			case 1:
				quantVers = Vars.CapGen();
				break;
			case 2:
				quantVers = Vars.CapExo();
				break;
			case 3:
				quantVers = Vars.CapLev();
				break;
			case 4:
				quantVers = Vars.CapNum();
				break;
			case 5:
				quantVers = Vars.CapDeu();
				break;
			case 6:
				quantVers = Vars.CapJse();
				break;
			case 7:
				quantVers = Vars.CapJz();
			break;
			case 8:
				quantVers = Vars.CapRt();
			break;
			case 9:
				quantVers = Vars.Cap1Sm();
			break;
			case 10:
				quantVers = Vars.Cap2Sm();
			break;
			case 11:
				quantVers = Vars.Cap1Rs();
			break;
			case 12:
				quantVers = Vars.Cap2Rs();

			break;
			case 13:
				quantVers = Vars.Cap1Cr();

			break;
			case 14:
				quantVers = Vars.Cap2Cr();

			break;
			case 15:
				quantVers = Vars.CapEsd();

			break;
			case 16:
				quantVers = Vars.CapNe();

			break;
			case 17:
				quantVers = Vars.CapTb();

			break;
			case 18:
				quantVers = Vars.CapJt();

			break;
			case 19:
				quantVers = Vars.CapEst();

			break;
			case 20:
				quantVers = Vars.Cap1Mc();

			break;
			case 21:
				quantVers = Vars.Cap2Mc();

			break;
			case 22:
				quantVers = Vars.CapJo();

			break;
			case 23:
				quantVers = Vars.CapSl();

			break;
			case 24:
				quantVers = Vars.CapPr();

			break;
			case 25:
				quantVers = Vars.CapEcle();

			break;
			case 26:
				quantVers = Vars.CapCt();

			break;
			case 27:
				quantVers = Vars.CapSb();
			
			break;
			case 28:
				quantVers = Vars.CapEclo();

			break;
			case 29:
				quantVers = Vars.CapIs();

			break;
			case 30:
				quantVers = Vars.CapJr();

			break;
			case 31:
				quantVers = Vars.CapLm();

			break;
			case 32:
				quantVers = Vars.CapBr();

			break;
			case 33:
				quantVers = Vars.CapEz();

			break;
			case 34:
				quantVers = Vars.CapDn();

			break;
			case 35:
				quantVers = Vars.CapOs();

			break;
			case 36:
				quantVers = Vars.CapJl();

			break;
			case 37:
				quantVers = Vars.CapAm();

			break;
			case 38:
				quantVers = Vars.CapAb();

			break;
			case 39:
				quantVers = Vars.CapJn();

			break;
			
			case 40:
				quantVers = Vars.CapMq();

			break;
			case 41:
				quantVers = Vars.CapNa();

			break;
			case 42:
				quantVers = Vars.CapHab();

			break;
			case 43:
				quantVers = Vars.CapSf();

			break;
			case 44:
				quantVers = Vars.CapAg();

			break;
			case 45:
				quantVers = Vars.CapZc();

			break;
			case 46:
				quantVers = Vars.CapMl();

			break;
			case 47:
				quantVers = Vars.CapMt();

			break;
			case 48:
				quantVers = Vars.CapMc();

			break;
			case 49:
				quantVers = Vars.CapLc();

			break;
			case 50:
				quantVers = Vars.CapSJo();

			break;
			case 51:
				quantVers = Vars.CapAt();

			break;
			case 52:
				quantVers = Vars.CapRm();

			break;
			case 53:
				quantVers = Vars.Cap1Cor();

			break;
			case 54:
				quantVers = Vars.Cap2Cor();

			break;
			case 55:
				quantVers = Vars.CapGl();

			break;
			case 56:
				quantVers = Vars.CapEf();

			break;
			case 57:
				quantVers = Vars.CapFl();

			break;
			case 58:
				quantVers = Vars.CapCl();

			break;
			case 59:
				quantVers = Vars.Cap1Ts();

			break;
			case 60:
				quantVers = Vars.Cap2Ts();
			
			break;
			case 61:
				quantVers = Vars.Cap1Tm();

			break;
			case 62:
				quantVers = Vars.Cap2Tm();

			break;
			case 63:
				quantVers = Vars.CapTt();

			break;
			case 64:
				quantVers = Vars.CapFm();

			break;
			case 65:
				quantVers = Vars.CapHb();

			break;
			case 66:
				quantVers = Vars.CapTg();

			break;
			case 67:
				quantVers = Vars.Cap1Pd();

			break;
			case 68:
				quantVers = Vars.Cap2Pd();

			break;
			case 69:
				quantVers = Vars.Cap1Jo();

			break;
			case 70:
				quantVers = Vars.Cap2Jo();

			break;
			case 71:
				quantVers = Vars.Cap3Jo();

			break;
			case 72:
				quantVers = Vars.CapJd();

			break;
			case 73:
				quantVers = Vars.CapAp();
			break;
		}

		} else {
			main.setLivPosicao(1);
		}
		return quantVers;
	}

	
	public static int getQuantVers() {
		return quantVers;
	}
	public static void setQuantVers(int quantVers) {
		Vars.quantVers = quantVers;
	}
	public static int CapGen() {
		cap[1] = R.array.CapGen1;
		cap[2] = R.array.CapGen2;
		cap[3] = R.array.CapGen3;
		cap[4] = R.array.CapGen4;
		cap[5] = R.array.CapGen5;
		cap[6] = R.array.CapGen6;
		cap[7] = R.array.CapGen7;
		cap[8] = R.array.CapGen8;
		cap[9] = R.array.CapGen9;
		cap[10] = R.array.CapGen10;
		cap[11] = R.array.CapGen11;
		cap[12] = R.array.CapGen12;
		cap[13] = R.array.CapGen13;
		cap[14] = R.array.CapGen14;
		cap[15] = R.array.CapGen15;
		cap[16] = R.array.CapGen16;
		cap[17] = R.array.CapGen17;
		cap[18] = R.array.CapGen18;
		cap[19] = R.array.CapGen19;
		cap[20] = R.array.CapGen20;
		cap[21] = R.array.CapGen21;
		cap[22] = R.array.CapGen22;
		cap[23] = R.array.CapGen23;
		cap[24] = R.array.CapGen24;
		cap[25] = R.array.CapGen25;
		cap[26] = R.array.CapGen26;
		cap[27] = R.array.CapGen27;
		cap[28] = R.array.CapGen28;
		cap[29] = R.array.CapGen29;
		cap[30] = R.array.CapGen30;
		cap[31] = R.array.CapGen31;
		cap[32] = R.array.CapGen32;
		cap[33] = R.array.CapGen33;
		cap[34] = R.array.CapGen34;
		cap[35] = R.array.CapGen35;
		cap[36] = R.array.CapGen36;
		cap[37] = R.array.CapGen37;
		cap[38] = R.array.CapGen38;
		cap[39] = R.array.CapGen39;
		cap[40] = R.array.CapGen40;
		cap[41] = R.array.CapGen41;
		cap[42] = R.array.CapGen42;
		cap[43] = R.array.CapGen43;
		cap[44] = R.array.CapGen44;
		cap[45] = R.array.CapGen45;
		cap[46] = R.array.CapGen46;
		cap[47] = R.array.CapGen47;
		cap[48] = R.array.CapGen48;
		cap[49] = R.array.CapGen49;
		cap[50] = R.array.CapGen50;


		return 50;
	}

	public static int CapExo() {
		cap[1] = R.array.CapEx1;
		cap[2] = R.array.CapEx2;
		cap[3] = R.array.CapEx3;
		cap[4] = R.array.CapEx4;
		cap[5] = R.array.CapEx5;
		cap[6] = R.array.CapEx6;
		cap[7] = R.array.CapEx7;
		cap[8] = R.array.CapEx8;
		cap[9] = R.array.CapEx9;
		cap[10] = R.array.CapEx10;
		cap[11] = R.array.CapEx11;
		cap[12] = R.array.CapEx12;
		cap[13] = R.array.CapEx13;
		cap[14] = R.array.CapEx14;
		cap[15] = R.array.CapEx15;
		cap[16] = R.array.CapEx16;
		cap[17] = R.array.CapEx17;
		cap[18] = R.array.CapEx18;
		cap[19] = R.array.CapEx19;
		cap[20] = R.array.CapEx20;
		cap[21] = R.array.CapEx21;
		cap[22] = R.array.CapEx22;
		cap[23] = R.array.CapEx23;
		cap[24] = R.array.CapEx24;
		cap[25] = R.array.CapEx25;
		cap[26] = R.array.CapEx26;
		cap[27] = R.array.CapEx27;
		cap[28] = R.array.CapEx28;
		cap[29] = R.array.CapEx29;
		cap[30] = R.array.CapEx30;
		cap[31] = R.array.CapEx31;
		cap[32] = R.array.CapEx32;
		cap[33] = R.array.CapEx33;
		cap[34] = R.array.CapEx34;
		cap[35] = R.array.CapEx35;
		cap[36] = R.array.CapEx36;
		cap[37] = R.array.CapEx37;
		cap[38] = R.array.CapEx38;
		cap[39] = R.array.CapEx39;
		cap[40] = R.array.CapEx40;

		return 40;
	}

	public static int CapLev() {
		cap[1] = R.array.CapLv1;
		cap[2] = R.array.CapLv2;
		cap[3] = R.array.CapLv3;
		cap[4] = R.array.CapLv4;
		cap[5] = R.array.CapLv5;
		cap[6] = R.array.CapLv6;
		cap[7] = R.array.CapLv7;
		cap[8] = R.array.CapLv8;
		cap[9] = R.array.CapLv9;
		cap[10] = R.array.CapLv10;
		cap[11] = R.array.CapLv11;
		cap[12] = R.array.CapLv12;
		cap[13] = R.array.CapLv13;
		cap[14] = R.array.CapLv14;
		cap[15] = R.array.CapLv15;
		cap[16] = R.array.CapLv16;
		cap[17] = R.array.CapLv17;
		cap[18] = R.array.CapLv18;
		cap[19] = R.array.CapLv19;
		cap[20] = R.array.CapLv20;
		cap[21] = R.array.CapLv21;
		cap[22] = R.array.CapLv22;
		cap[23] = R.array.CapLv23;
		cap[24] = R.array.CapLv24;
		cap[25] = R.array.CapLv25;
		cap[26] = R.array.CapLv26;
		cap[27] = R.array.CapLv27;

		return 27;
	}

	public static int CapNum() {
		cap[1] = R.array.CapNm1;
		cap[2] = R.array.CapNm2;
		cap[3] = R.array.CapNm3;
		cap[4] = R.array.CapNm4;
		cap[5] = R.array.CapNm5;
		cap[6] = R.array.CapNm6;
		cap[7] = R.array.CapNm7;
		cap[8] = R.array.CapNm8;
		cap[9] = R.array.CapNm9;
		cap[10] = R.array.CapNm10;
		cap[11] = R.array.CapNm11;
		cap[12] = R.array.CapNm12;
		cap[13] = R.array.CapNm13;
		cap[14] = R.array.CapNm14;
		cap[15] = R.array.CapNm15;
		cap[16] = R.array.CapNm16;
		cap[17] = R.array.CapNm17;
		cap[18] = R.array.CapNm18;
		cap[19] = R.array.CapNm19;
		cap[20] = R.array.CapNm20;
		cap[21] = R.array.CapNm21;
		cap[22] = R.array.CapNm22;
		cap[23] = R.array.CapNm23;
		cap[24] = R.array.CapNm24;
		cap[25] = R.array.CapNm25;
		cap[26] = R.array.CapNm26;
		cap[27] = R.array.CapNm27;
		cap[28] = R.array.CapNm28;
		cap[29] = R.array.CapNm29;
		cap[30] = R.array.CapNm30;
		cap[31] = R.array.CapNm31;
		cap[32] = R.array.CapNm32;
		cap[33] = R.array.CapNm33;
		cap[34] = R.array.CapNm34;
		cap[35] = R.array.CapNm35;
		cap[36] = R.array.CapNm36;


		return 36;

	}

	public static int CapDeu() {
		cap[1] = R.array.CapDt1;
		cap[2] = R.array.CapDt2;
		cap[3] = R.array.CapDt3;
		cap[4] = R.array.CapDt4;
		cap[5] = R.array.CapDt5;
		cap[6] = R.array.CapDt6;
		cap[7] = R.array.CapDt7;
		cap[8] = R.array.CapDt8;
		cap[9] = R.array.CapDt9;
		cap[10] = R.array.CapDt10;
		cap[11] = R.array.CapDt11;
		cap[12] = R.array.CapDt12;
		cap[13] = R.array.CapDt13;
		cap[14] = R.array.CapDt14;
		cap[15] = R.array.CapDt15;
		cap[16] = R.array.CapDt16;
		cap[17] = R.array.CapDt17;
		cap[18] = R.array.CapDt18;
		cap[19] = R.array.CapDt19;
		cap[20] = R.array.CapDt20;
		cap[21] = R.array.CapDt21;
		cap[22] = R.array.CapDt22;
		cap[23] = R.array.CapDt23;
		cap[24] = R.array.CapDt24;
		cap[25] = R.array.CapDt25;
		cap[26] = R.array.CapDt26;
		cap[27] = R.array.CapDt27;
		cap[28] = R.array.CapDt28;
		cap[29] = R.array.CapDt29;
		cap[30] = R.array.CapDt30;
		cap[31] = R.array.CapDt31;
		cap[32] = R.array.CapDt32;
		cap[33] = R.array.CapDt33;
		cap[34] = R.array.CapDt34;

		
		return 34;
	}

	public static int CapJse() {
		cap[1] = R.array.CapJs1;
		cap[2] = R.array.CapJs2;
		cap[3] = R.array.CapJs3;
		cap[4] = R.array.CapJs4;
		cap[5] = R.array.CapJs5;
		cap[6] = R.array.CapJs6;
		cap[7] = R.array.CapJs7;
		cap[8] = R.array.CapJs8;
		cap[9] = R.array.CapJs9;
		cap[10] = R.array.CapJs10;
		cap[11] = R.array.CapJs11;
		cap[12] = R.array.CapJs12;
		cap[13] = R.array.CapJs13;
		cap[14] = R.array.CapJs14;
		cap[15] = R.array.CapJs15;
		cap[16] = R.array.CapJs16;
		cap[17] = R.array.CapJs17;
		cap[18] = R.array.CapJs18;
		cap[19] = R.array.CapJs19;
		cap[20] = R.array.CapJs20;
		cap[21] = R.array.CapJs21;
		cap[22] = R.array.CapJs22;
		cap[23] = R.array.CapJs23;
		cap[24] = R.array.CapJs24;

		return 24;

	}

	public static int CapJz()  {
		cap[1] = R.array.CapJz1;
		cap[2] = R.array.CapJz2;
		cap[3] = R.array.CapJz3;
		cap[4] = R.array.CapJz4;
		cap[5] = R.array.CapJz5;
		cap[6] = R.array.CapJz6;
		cap[7] = R.array.CapJz7;
		cap[8] = R.array.CapJz8;
		cap[9] = R.array.CapJz9;
		cap[10] = R.array.CapJz10;
		cap[11] = R.array.CapJz11;
		cap[12] = R.array.CapJz12;
		cap[13] = R.array.CapJz13;
		cap[14] = R.array.CapJz14;
		cap[15] = R.array.CapJz15;
		cap[16] = R.array.CapJz16;
		cap[17] = R.array.CapJz17;
		cap[18] = R.array.CapJz18;
		cap[19] = R.array.CapJz19;
		cap[20] = R.array.CapJz20;
		cap[21] = R.array.CapJz21;
		
		return 21;
	}
	public static int CapRt(){
		cap[1] = R.array.CapRt1;
		cap[2] = R.array.CapRt2;
		cap[3] = R.array.CapRt3;
		cap[4] = R.array.CapRt4;

		return  4;
		
	}
	public static int Cap1Sm(){
		cap[1] = R.array.Cap1Sm1;
		cap[2] = R.array.Cap1Sm2;
		cap[3] = R.array.Cap1Sm3;
		cap[4] = R.array.Cap1Sm4;
		cap[5] = R.array.Cap1Sm5;
		cap[6] = R.array.Cap1Sm6;
		cap[7] = R.array.Cap1Sm7;
		cap[8] = R.array.Cap1Sm8;
		cap[9] = R.array.Cap1Sm9;
		cap[10] = R.array.Cap1Sm10;
		cap[11] = R.array.Cap1Sm11;
		cap[12] = R.array.Cap1Sm12;
		cap[13] = R.array.Cap1Sm13;
		cap[14] = R.array.Cap1Sm14;
		cap[15] = R.array.Cap1Sm15;
		cap[16] = R.array.Cap1Sm16;
		cap[17] = R.array.Cap1Sm17;
		cap[18] = R.array.Cap1Sm18;
		cap[19] = R.array.Cap1Sm19;
		cap[20] = R.array.Cap1Sm20;
		cap[21] = R.array.Cap1Sm21;
		cap[22] = R.array.Cap1Sm22;
		cap[23] = R.array.Cap1Sm23;
		cap[24] = R.array.Cap1Sm24;
		cap[25] = R.array.Cap1Sm25;
		cap[26] = R.array.Cap1Sm26;
		cap[27] = R.array.Cap1Sm27;
		cap[28] = R.array.Cap1Sm28;
		cap[29] = R.array.Cap1Sm29;
		cap[30] = R.array.Cap1Sm30;
		cap[31] = R.array.Cap1Sm31;
		
		return 31;
	}
	public static int Cap2Sm(){
		cap[1] = R.array.Cap2Sm1;
		cap[2] = R.array.Cap2Sm2;
		cap[3] = R.array.Cap2Sm3;
		cap[4] = R.array.Cap2Sm4;
		cap[5] = R.array.Cap2Sm5;
		cap[6] = R.array.Cap2Sm6;
		cap[7] = R.array.Cap2Sm7;
		cap[8] = R.array.Cap2Sm8;
		cap[9] = R.array.Cap2Sm9;
		cap[10] = R.array.Cap2Sm10;
		cap[11] = R.array.Cap2Sm11;
		cap[12] = R.array.Cap2Sm12;
		cap[13] = R.array.Cap2Sm13;
		cap[14] = R.array.Cap2Sm14;
		cap[15] = R.array.Cap2Sm15;
		cap[16] = R.array.Cap2Sm16;
		cap[17] = R.array.Cap2Sm17;
		cap[18] = R.array.Cap2Sm18;
		cap[19] = R.array.Cap2Sm19;
		cap[20] = R.array.Cap2Sm20;
		cap[21] = R.array.Cap2Sm21;
		cap[22] = R.array.Cap2Sm22;
		cap[23] = R.array.Cap2Sm23;
		cap[24] = R.array.Cap2Sm24;
		return 24;
	}

	public static int Cap1Rs(){
		cap[1] = R.array.Cap1Rs1;
		cap[2] = R.array.Cap1Rs2;
		cap[3] = R.array.Cap1Rs3;
		cap[4] = R.array.Cap1Rs4;
		cap[5] = R.array.Cap1Rs5;
		cap[6] = R.array.Cap1Rs6;
		cap[7] = R.array.Cap1Rs7;
		cap[8] = R.array.Cap1Rs8;
		cap[9] = R.array.Cap1Rs9;
		cap[10] = R.array.Cap1Rs10;
		cap[11] = R.array.Cap1Rs11;
		cap[12] = R.array.Cap1Rs12;
		cap[13] = R.array.Cap1Rs13;
		cap[14] = R.array.Cap1Rs14;
		cap[15] = R.array.Cap1Rs15;
		cap[16] = R.array.Cap1Rs16;
		cap[17] = R.array.Cap1Rs17;
		cap[18] = R.array.Cap1Rs18;
		cap[19] = R.array.Cap1Rs19;
		cap[20] = R.array.Cap1Rs20;
		cap[21] = R.array.Cap1Rs21;
		cap[22] = R.array.Cap1Rs22;
		
			return 22;
	}
	public static int Cap2Rs(){
		
		cap[1] = R.array.Cap2Rs1;
		cap[2] = R.array.Cap2Rs2;
		cap[3] = R.array.Cap2Rs3;
		cap[4] = R.array.Cap2Rs4;
		cap[5] = R.array.Cap2Rs5;
		cap[6] = R.array.Cap2Rs6;
		cap[7] = R.array.Cap2Rs7;
		cap[8] = R.array.Cap2Rs8;
		cap[9] = R.array.Cap2Rs9;
		cap[10] = R.array.Cap2Rs10;
		cap[11] = R.array.Cap2Rs11;
		cap[12] = R.array.Cap2Rs12;
		cap[13] = R.array.Cap2Rs13;
		cap[14] = R.array.Cap2Rs14;
		cap[15] = R.array.Cap2Rs15;
		cap[16] = R.array.Cap2Rs16;
		cap[17] = R.array.Cap2Rs17;
		cap[18] = R.array.Cap2Rs18;
		cap[19] = R.array.Cap2Rs19;
		cap[20] = R.array.Cap2Rs20;
		cap[21] = R.array.Cap2Rs21;
		cap[22] = R.array.Cap2Rs22;
		cap[23] = R.array.Cap2Rs23;
		cap[24] = R.array.Cap2Rs24;
		cap[25] = R.array.Cap2Rs25;

		
		return 25;
	}
	public static int Cap1Cr(){
				cap[1] = R.array.Cap1Cr1;
				cap[2] = R.array.Cap1Cr2;
				cap[3] = R.array.Cap1Cr3;
				cap[4] = R.array.Cap1Cr4;
				cap[5] = R.array.Cap1Cr5;
				cap[6] = R.array.Cap1Cr6;
				cap[7] = R.array.Cap1Cr7;
				cap[8] = R.array.Cap1Cr8;
				cap[9] = R.array.Cap1Cr9;
				cap[10] = R.array.Cap1Cr10;
				cap[11] = R.array.Cap1Cr11;
				cap[12] = R.array.Cap1Cr12;
				cap[13] = R.array.Cap1Cr13;
				cap[14] = R.array.Cap1Cr14;
				cap[15] = R.array.Cap1Cr15;
				cap[16] = R.array.Cap1Cr16;
				cap[17] = R.array.Cap1Cr17;
				cap[18] = R.array.Cap1Cr18;
				cap[19] = R.array.Cap1Cr19;
				cap[20] = R.array.Cap1Cr20;
				cap[21] = R.array.Cap1Cr21;
				cap[22] = R.array.Cap1Cr22;
				cap[23] = R.array.Cap1Cr23;
				cap[24] = R.array.Cap1Cr24;
				cap[25] = R.array.Cap1Cr25;
				cap[26] = R.array.Cap1Cr26;
				cap[27] = R.array.Cap1Cr27;
				cap[28] = R.array.Cap1Cr28;
				cap[29] = R.array.Cap1Cr29;
		
		return 29;
	}
	public static int Cap2Cr(){
		cap[1] = R.array.Cap2Cr1;
		cap[2] = R.array.Cap2Cr2;
		cap[3] = R.array.Cap2Cr3;
		cap[4] = R.array.Cap2Cr4;
		cap[5] = R.array.Cap2Cr5;
		cap[6] = R.array.Cap2Cr6;
		cap[7] = R.array.Cap2Cr7;
		cap[8] = R.array.Cap2Cr8;
		cap[9] = R.array.Cap2Cr9;
		cap[10] = R.array.Cap2Cr10;
		cap[11] = R.array.Cap2Cr11;
		cap[12] = R.array.Cap2Cr12;
		cap[13] = R.array.Cap2Cr13;
		cap[14] = R.array.Cap2Cr14;
		cap[15] = R.array.Cap2Cr15;
		cap[16] = R.array.Cap2Cr16;
		cap[17] = R.array.Cap2Cr17;
		cap[18] = R.array.Cap2Cr18;
		cap[19] = R.array.Cap2Cr19;
		cap[20] = R.array.Cap2Cr20;
		cap[21] = R.array.Cap2Cr21;
		cap[22] = R.array.Cap2Cr22;
		cap[23] = R.array.Cap2Cr23;
		cap[24] = R.array.Cap2Cr24;
		cap[25] = R.array.Cap2Cr25;
		cap[26] = R.array.Cap2Cr26;
		cap[27] = R.array.Cap2Cr27;
		cap[28] = R.array.Cap2Cr28;
		cap[29] = R.array.Cap2Cr29;
		cap[30] = R.array.Cap2Cr30;
		cap[31] = R.array.Cap2Cr31;
		cap[32] = R.array.Cap2Cr32;
		cap[33] = R.array.Cap2Cr33;
		cap[34] = R.array.Cap2Cr34;
		cap[35] = R.array.Cap2Cr35;
		cap[36] = R.array.Cap2Cr36;

		
		return 36;
	}
	public static int CapEsd(){
		cap[1] = R.array.CapEsd1;
		cap[2] = R.array.CapEsd2;
		cap[3] = R.array.CapEsd3;
		cap[4] = R.array.CapEsd4;
		cap[5] = R.array.CapEsd5;
		cap[6] = R.array.CapEsd6;
		cap[7] = R.array.CapEsd7;
		cap[8] = R.array.CapEsd8;
		cap[9] = R.array.CapEsd9;
		cap[10] = R.array.CapEsd10;

		return 10;
	}
	public static int CapNe(){
		cap[1] = R.array.CapNe1;
		cap[2] = R.array.CapNe2;
		cap[3] = R.array.CapNe3;
		cap[4] = R.array.CapNe4;
		cap[5] = R.array.CapNe5;
		cap[6] = R.array.CapNe6;
		cap[7] = R.array.CapNe7;
		cap[8] = R.array.CapNe8;
		cap[9] = R.array.CapNe9;
		cap[10] = R.array.CapNe10;
		cap[11] = R.array.CapNe11;
		cap[12] = R.array.CapNe12;
		cap[13] = R.array.CapNe13;

		
		return 13;
	}
	public static int CapTb(){
		cap[1] = R.array.CapTb1;
		cap[2] = R.array.CapTb2;
		cap[3] = R.array.CapTb3;
		cap[4] = R.array.CapTb4;
		cap[5] = R.array.CapTb5;
		cap[6] = R.array.CapTb6;
		cap[7] = R.array.CapTb7;
		cap[8] = R.array.CapTb8;
		cap[9] = R.array.CapTb9;
		cap[10] = R.array.CapTb10;
		cap[11] = R.array.CapTb11;
		cap[12] = R.array.CapTb12;
		cap[13] = R.array.CapTb13;
		cap[14] = R.array.CapTb14;
		
		return 14;
	}
	public static int CapJt(){
		cap[1] = R.array.CapJt1;
		cap[2] = R.array.CapJt2;
		cap[3] = R.array.CapJt3;
		cap[4] = R.array.CapJt4;
		cap[5] = R.array.CapJt5;
		cap[6] = R.array.CapJt6;
		cap[7] = R.array.CapJt7;
		cap[8] = R.array.CapJt8;
		cap[9] = R.array.CapJt9;
		cap[10] = R.array.CapJt10;
		cap[11] = R.array.CapJt11;
		cap[12] = R.array.CapJt12;
		cap[13] = R.array.CapJt13;
		cap[14] = R.array.CapJt14;
		cap[15] = R.array.CapJt15;
		cap[16] = R.array.CapJt16;

		return 26;
	}
	public static int CapEst(){
		cap[1] = R.array.CapEst1;
		cap[2] = R.array.CapEst2;
		cap[3] = R.array.CapEst3;
		cap[4] = R.array.CapEst4;
		cap[5] = R.array.CapEst5;
		cap[6] = R.array.CapEst6;
		cap[7] = R.array.CapEst7;
		cap[8] = R.array.CapEst8;
		cap[9] = R.array.CapEst9;
		cap[10] = R.array.CapEst10;
		cap[11] = R.array.CapEst11;
		cap[12] = R.array.CapEst12;
		cap[13] = R.array.CapEst13;
		cap[14] = R.array.CapEst14;
		cap[15] = R.array.CapEst15;
		cap[16] = R.array.CapEst16;
		
		return 16;
	}
	public static int Cap1Mc(){
		
		cap[1] = R.array.Cap1Mc1;
		cap[2] = R.array.Cap1Mc2;
		cap[3] = R.array.Cap1Mc3;
		cap[4] = R.array.Cap1Mc4;
		cap[5] = R.array.Cap1Mc5;
		cap[6] = R.array.Cap1Mc6;
		cap[7] = R.array.Cap1Mc7;
		cap[8] = R.array.Cap1Mc8;
		cap[9] = R.array.Cap1Mc9;
		cap[10] = R.array.Cap1Mc10;
		cap[11] = R.array.Cap1Mc11;
		cap[12] = R.array.Cap1Mc12;
		cap[13] = R.array.Cap1Mc13;
		cap[14] = R.array.Cap1Mc14;
		cap[15] = R.array.Cap1Mc15;
		cap[16] = R.array.Cap1Mc16;

		
		return 16;
	}
	public static int Cap2Mc(){
		cap[1] = R.array.Cap2Mc1;
		cap[2] = R.array.Cap2Mc2;
		cap[3] = R.array.Cap2Mc3;
		cap[4] = R.array.Cap2Mc4;
		cap[5] = R.array.Cap2Mc5;
		cap[6] = R.array.Cap2Mc6;
		cap[7] = R.array.Cap2Mc7;
		cap[8] = R.array.Cap2Mc8;
		cap[9] = R.array.Cap2Mc9;
		cap[10] = R.array.Cap2Mc10;
		cap[11] = R.array.Cap2Mc11;
		cap[12] = R.array.Cap2Mc12;
		cap[13] = R.array.Cap2Mc13;
		cap[14] = R.array.Cap2Mc14;
		cap[15] = R.array.Cap2Mc15;

		return 15;
	}
	public static int CapJo(){
		cap[1] = R.array.CapJo1;
		cap[2] = R.array.CapJo2;
		cap[3] = R.array.CapJo3;
		cap[4] = R.array.CapJo4;
		cap[5] = R.array.CapJo5;
		cap[6] = R.array.CapJo6;
		cap[7] = R.array.CapJo7;
		cap[8] = R.array.CapJo8;
		cap[9] = R.array.CapJo9;
		cap[10] = R.array.CapJo10;
		cap[11] = R.array.CapJo11;
		cap[12] = R.array.CapJo12;
		cap[13] = R.array.CapJo13;
		cap[14] = R.array.CapJo14;
		cap[15] = R.array.CapJo15;
		cap[16] = R.array.CapJo16;
		cap[17] = R.array.CapJo17;
		cap[18] = R.array.CapJo18;
		cap[19] = R.array.CapJo19;
		cap[20] = R.array.CapJo20;
		cap[21] = R.array.CapJo21;
		cap[22] = R.array.CapJo22;
		cap[23] = R.array.CapJo23;
		cap[24] = R.array.CapJo24;
		cap[25] = R.array.CapJo25;
		cap[26] = R.array.CapJo26;
		cap[27] = R.array.CapJo27;
		cap[28] = R.array.CapJo28;
		cap[29] = R.array.CapJo29;
		cap[30] = R.array.CapJo30;
		cap[31] = R.array.CapJo31;
		cap[32] = R.array.CapJo32;
		cap[33] = R.array.CapJo33;
		cap[34] = R.array.CapJo34;
		cap[35] = R.array.CapJo35;
		cap[36] = R.array.CapJo36;
		cap[37] = R.array.CapJo37;
		cap[38] = R.array.CapJo38;
		cap[39] = R.array.CapJo39;
		cap[40] = R.array.CapJo40;
		cap[41] = R.array.CapJo41;
		cap[42] = R.array.CapJo42;

		return 42;
	}
	public static int CapSl(){
		cap[1] = R.array.CapSl1;
		cap[2] = R.array.CapSl2;
		cap[3] = R.array.CapSl3;
		cap[4] = R.array.CapSl4;
		cap[5] = R.array.CapSl5;
		cap[6] = R.array.CapSl6;
		cap[7] = R.array.CapSl7;
		cap[8] = R.array.CapSl8;
		cap[9] = R.array.CapSl9;
		cap[10] = R.array.CapSl10;
		cap[11] = R.array.CapSl11;
		cap[12] = R.array.CapSl12;
		cap[13] = R.array.CapSl13;
		cap[14] = R.array.CapSl14;
		cap[15] = R.array.CapSl15;
		cap[16] = R.array.CapSl16;
		cap[17] = R.array.CapSl17;
		cap[18] = R.array.CapSl18;
		cap[19] = R.array.CapSl19;
		cap[20] = R.array.CapSl20;
		cap[21] = R.array.CapSl21;
		cap[22] = R.array.CapSl22;
		cap[23] = R.array.CapSl23;
		cap[24] = R.array.CapSl24;
		cap[25] = R.array.CapSl25;
		cap[26] = R.array.CapSl26;
		cap[27] = R.array.CapSl27;
		cap[28] = R.array.CapSl28;
		cap[29] = R.array.CapSl29;
		cap[30] = R.array.CapSl30;
		cap[31] = R.array.CapSl31;
		cap[32] = R.array.CapSl32;
		cap[33] = R.array.CapSl33;
		cap[34] = R.array.CapSl34;
		cap[35] = R.array.CapSl35;
		cap[36] = R.array.CapSl36;
		cap[37] = R.array.CapSl37;
		cap[38] = R.array.CapSl38;
		cap[39] = R.array.CapSl39;
		cap[40] = R.array.CapSl40;
		cap[41] = R.array.CapSl41;
		cap[42] = R.array.CapSl42;
		cap[43] = R.array.CapSl43;
		cap[44] = R.array.CapSl44;
		cap[45] = R.array.CapSl45;
		cap[46] = R.array.CapSl46;
		cap[47] = R.array.CapSl47;
		cap[48] = R.array.CapSl48;
		cap[49] = R.array.CapSl49;
		cap[50] = R.array.CapSl50;
		cap[51] = R.array.CapSl51;
		cap[52] = R.array.CapSl52;
		cap[53] = R.array.CapSl53;
		cap[54] = R.array.CapSl54;
		cap[55] = R.array.CapSl55;
		cap[56] = R.array.CapSl56;
		cap[57] = R.array.CapSl57;
		cap[58] = R.array.CapSl58;
		cap[59] = R.array.CapSl59;
		cap[60] = R.array.CapSl60;
		cap[61] = R.array.CapSl61;
		cap[62] = R.array.CapSl62;
		cap[63] = R.array.CapSl63;
		cap[64] = R.array.CapSl64;
		cap[65] = R.array.CapSl65;
		cap[66] = R.array.CapSl66;
		cap[67] = R.array.CapSl67;
		cap[68] = R.array.CapSl68;
		cap[69] = R.array.CapSl69;
		cap[70] = R.array.CapSl70;
		cap[71] = R.array.CapSl71;
		cap[72] = R.array.CapSl72;
		cap[73] = R.array.CapSl73;
		cap[74] = R.array.CapSl74;
		cap[75] = R.array.CapSl75;
		cap[76] = R.array.CapSl76;
		cap[77] = R.array.CapSl77;
		cap[78] = R.array.CapSl78;
		cap[79] = R.array.CapSl79;
		cap[80] = R.array.CapSl80;
		cap[81] = R.array.CapSl81;
		cap[82] = R.array.CapSl82;
		cap[83] = R.array.CapSl83;
		cap[84] = R.array.CapSl84;
		cap[85] = R.array.CapSl85;
		cap[86] = R.array.CapSl86;
		cap[87] = R.array.CapSl87;
		cap[88] = R.array.CapSl88;
		cap[89] = R.array.CapSl89;
		cap[90] = R.array.CapSl90;
		cap[91] = R.array.CapSl91;
		cap[92] = R.array.CapSl92;
		cap[93] = R.array.CapSl93;
		cap[94] = R.array.CapSl94;
		cap[95] = R.array.CapSl95;
		cap[96] = R.array.CapSl96;
		cap[97] = R.array.CapSl97;
		cap[98] = R.array.CapSl98;
		cap[99] = R.array.CapSl99;
		cap[100] = R.array.CapSl100;
		cap[101] = R.array.CapSl101;
		cap[102] = R.array.CapSl102;
		cap[103] = R.array.CapSl103;
		cap[104] = R.array.CapSl104;
		cap[105] = R.array.CapSl105;
		cap[106] = R.array.CapSl106;
		cap[107] = R.array.CapSl107;
		cap[108] = R.array.CapSl108;
		cap[109] = R.array.CapSl109;
		cap[110] = R.array.CapSl110;
		cap[111] = R.array.CapSl111;
		cap[112] = R.array.CapSl112;
		cap[113] = R.array.CapSl113;
		cap[114] = R.array.CapSl114;
		cap[115] = R.array.CapSl115;
		cap[116] = R.array.CapSl116;
		cap[117] = R.array.CapSl117;
		cap[118] = R.array.CapSl118;
		cap[119] = R.array.CapSl119;
		cap[120] = R.array.CapSl120;
		cap[121] = R.array.CapSl121;
		cap[122] = R.array.CapSl122;
		cap[123] = R.array.CapSl123;
		cap[124] = R.array.CapSl124;
		cap[125] = R.array.CapSl125;
		cap[126] = R.array.CapSl126;
		cap[127] = R.array.CapSl127;
		cap[128] = R.array.CapSl128;
		cap[129] = R.array.CapSl129;
		cap[130] = R.array.CapSl130;
		cap[131] = R.array.CapSl131;
		cap[132] = R.array.CapSl132;
		cap[133] = R.array.CapSl133;
		cap[134] = R.array.CapSl134;
		cap[135] = R.array.CapSl135;
		cap[136] = R.array.CapSl136;
		cap[137] = R.array.CapSl137;
		cap[138] = R.array.CapSl138;
		cap[139] = R.array.CapSl139;
		cap[140] = R.array.CapSl140;
		cap[141] = R.array.CapSl141;
		cap[142] = R.array.CapSl142;
		cap[143] = R.array.CapSl143;
		cap[144] = R.array.CapSl144;
		cap[145] = R.array.CapSl145;
		cap[146] = R.array.CapSl146;
		cap[147] = R.array.CapSl147;
		cap[148] = R.array.CapSl148;
		cap[149] = R.array.CapSl149;
		cap[150] = R.array.CapSl150;


		return 150;
	}
	public static int CapPr(){
		cap[1] = R.array.CapPr1;
		cap[2] = R.array.CapPr2;
		cap[3] = R.array.CapPr3;
		cap[4] = R.array.CapPr4;
		cap[5] = R.array.CapPr5;
		cap[6] = R.array.CapPr6;
		cap[7] = R.array.CapPr7;
		cap[8] = R.array.CapPr8;
		cap[9] = R.array.CapPr9;
		cap[10] = R.array.CapPr10;
		cap[11] = R.array.CapPr11;
		cap[12] = R.array.CapPr12;
		cap[13] = R.array.CapPr13;
		cap[14] = R.array.CapPr14;
		cap[15] = R.array.CapPr15;
		cap[16] = R.array.CapPr16;
		cap[17] = R.array.CapPr17;
		cap[18] = R.array.CapPr18;
		cap[19] = R.array.CapPr19;
		cap[20] = R.array.CapPr20;
		cap[21] = R.array.CapPr21;
		cap[22] = R.array.CapPr22;
		cap[23] = R.array.CapPr23;
		cap[24] = R.array.CapPr24;
		cap[25] = R.array.CapPr25;
		cap[26] = R.array.CapPr26;
		cap[27] = R.array.CapPr27;
		cap[28] = R.array.CapPr28;
		cap[29] = R.array.CapPr29;
		cap[30] = R.array.CapPr30;
		cap[31] = R.array.CapPr31;

		return 31;
	}
	public static int CapEcle(){
		cap[1] = R.array.CapEcle1;
		cap[2] = R.array.CapEcle2;
		cap[3] = R.array.CapEcle3;
		cap[4] = R.array.CapEcle4;
		cap[5] = R.array.CapEcle5;
		cap[6] = R.array.CapEcle6;
		cap[7] = R.array.CapEcle7;
		cap[8] = R.array.CapEcle8;
		cap[9] = R.array.CapEcle9;
		cap[10] = R.array.CapEcle10;
		cap[11] = R.array.CapEcle11;
		cap[12] = R.array.CapEcle12;

		
		return 12;
	}
	public static int CapCt(){
		cap[1] = R.array.CapCt1;
		cap[2] = R.array.CapCt2;
		cap[3] = R.array.CapCt3;
		cap[4] = R.array.CapCt4;
		cap[5] = R.array.CapCt5;
		cap[6] = R.array.CapCt6;
		cap[7] = R.array.CapCt7;
		cap[8] = R.array.CapCt8;

		
		return 8;
	}
	
	public static int CapSb(){
		cap[1] = R.array.CapSb1;
		cap[2] = R.array.CapSb2;
		cap[3] = R.array.CapSb3;
		cap[4] = R.array.CapSb4;
		cap[5] = R.array.CapSb5;
		cap[6] = R.array.CapSb6;
		cap[7] = R.array.CapSb7;
		cap[8] = R.array.CapSb8;
		cap[9] = R.array.CapSb9;
		cap[10] = R.array.CapSb10;
		cap[11] = R.array.CapSb11;
		cap[12] = R.array.CapSb12;
		cap[13] = R.array.CapSb13;
		cap[14] = R.array.CapSb14;
		cap[15] = R.array.CapSb15;
		cap[16] = R.array.CapSb16;
		cap[17] = R.array.CapSb17;
		cap[18] = R.array.CapSb18;
		cap[19] = R.array.CapSb19;
		return 19;
	}
	public static int CapEclo(){
		cap[1] = R.array.CapEclo1;
		cap[2] = R.array.CapEclo2;
		cap[3] = R.array.CapEclo3;
		cap[4] = R.array.CapEclo4;
		cap[5] = R.array.CapEclo5;
		cap[6] = R.array.CapEclo6;
		cap[7] = R.array.CapEclo7;
		cap[8] = R.array.CapEclo8;
		cap[9] = R.array.CapEclo9;
		cap[10] = R.array.CapEclo10;
		cap[11] = R.array.CapEclo11;
		cap[12] = R.array.CapEclo12;
		cap[13] = R.array.CapEclo13;
		cap[14] = R.array.CapEclo14;
		cap[15] = R.array.CapEclo15;
		cap[16] = R.array.CapEclo16;
		cap[17] = R.array.CapEclo17;
		cap[18] = R.array.CapEclo18;
		cap[19] = R.array.CapEclo19;
		cap[20] = R.array.CapEclo20;
		cap[21] = R.array.CapEclo21;
		cap[22] = R.array.CapEclo22;
		cap[23] = R.array.CapEclo23;
		cap[24] = R.array.CapEclo24;
		cap[25] = R.array.CapEclo25;
		cap[26] = R.array.CapEclo26;
		cap[27] = R.array.CapEclo27;
		cap[28] = R.array.CapEclo28;
		cap[29] = R.array.CapEclo29;
		cap[30] = R.array.CapEclo30;
		cap[31] = R.array.CapEclo31;
		cap[32] = R.array.CapEclo32;
		cap[33] = R.array.CapEclo33;
		cap[34] = R.array.CapEclo34;
		cap[35] = R.array.CapEclo35;
		cap[36] = R.array.CapEclo36;
		cap[37] = R.array.CapEclo37;
		cap[38] = R.array.CapEclo38;
		cap[39] = R.array.CapEclo39;
		cap[40] = R.array.CapEclo40;
		cap[41] = R.array.CapEclo41;
		cap[42] = R.array.CapEclo42;
		cap[43] = R.array.CapEclo43;
		cap[44] = R.array.CapEclo44;
		cap[45] = R.array.CapEclo45;
		cap[46] = R.array.CapEclo46;
		cap[47] = R.array.CapEclo47;
		cap[48] = R.array.CapEclo48;
		cap[49] = R.array.CapEclo49;
		cap[50] = R.array.CapEclo50;
		cap[51] = R.array.CapEclo51;

		return 51;
	}
	public static int CapIs(){
		cap[1] = R.array.CapIs1;
		cap[2] = R.array.CapIs2;
		cap[3] = R.array.CapIs3;
		cap[4] = R.array.CapIs4;
		cap[5] = R.array.CapIs5;
		cap[6] = R.array.CapIs6;
		cap[7] = R.array.CapIs7;
		cap[8] = R.array.CapIs8;
		cap[9] = R.array.CapIs9;
		cap[10] = R.array.CapIs10;
		cap[11] = R.array.CapIs11;
		cap[12] = R.array.CapIs12;
		cap[13] = R.array.CapIs13;
		cap[14] = R.array.CapIs14;
		cap[15] = R.array.CapIs15;
		cap[16] = R.array.CapIs16;
		cap[17] = R.array.CapIs17;
		cap[18] = R.array.CapIs18;
		cap[19] = R.array.CapIs19;
		cap[20] = R.array.CapIs20;
		cap[21] = R.array.CapIs21;
		cap[22] = R.array.CapIs22;
		cap[23] = R.array.CapIs23;
		cap[24] = R.array.CapIs24;
		cap[25] = R.array.CapIs25;
		cap[26] = R.array.CapIs26;
		cap[27] = R.array.CapIs27;
		cap[28] = R.array.CapIs28;
		cap[29] = R.array.CapIs29;
		cap[30] = R.array.CapIs30;
		cap[31] = R.array.CapIs31;
		cap[32] = R.array.CapIs32;
		cap[33] = R.array.CapIs33;
		cap[34] = R.array.CapIs34;
		cap[35] = R.array.CapIs35;
		cap[36] = R.array.CapIs36;
		cap[37] = R.array.CapIs37;
		cap[38] = R.array.CapIs38;
		cap[39] = R.array.CapIs39;
		cap[40] = R.array.CapIs40;
		cap[41] = R.array.CapIs41;
		cap[42] = R.array.CapIs42;
		cap[43] = R.array.CapIs43;
		cap[44] = R.array.CapIs44;
		cap[45] = R.array.CapIs45;
		cap[46] = R.array.CapIs46;
		cap[47] = R.array.CapIs47;
		cap[48] = R.array.CapIs48;
		cap[49] = R.array.CapIs49;
		cap[50] = R.array.CapIs50;
		cap[51] = R.array.CapIs51;
		cap[52] = R.array.CapIs52;
		cap[53] = R.array.CapIs53;
		cap[54] = R.array.CapIs54;
		cap[55] = R.array.CapIs55;
		cap[56] = R.array.CapIs56;
		cap[57] = R.array.CapIs57;
		cap[58] = R.array.CapIs58;
		cap[59] = R.array.CapIs59;
		cap[60] = R.array.CapIs60;
		cap[61] = R.array.CapIs61;
		cap[62] = R.array.CapIs62;
		cap[63] = R.array.CapIs63;
		cap[64] = R.array.CapIs64;
		cap[65] = R.array.CapIs65;
		cap[66] = R.array.CapIs66;

		
		return 66;
	}
	public static int CapJr(){
		cap[1] = R.array.CapJr1;
		cap[2] = R.array.CapJr2;
		cap[3] = R.array.CapJr3;
		cap[4] = R.array.CapJr4;
		cap[5] = R.array.CapJr5;
		cap[6] = R.array.CapJr6;
		cap[7] = R.array.CapJr7;
		cap[8] = R.array.CapJr8;
		cap[9] = R.array.CapJr9;
		cap[10] = R.array.CapJr10;
		cap[11] = R.array.CapJr11;
		cap[12] = R.array.CapJr12;
		cap[13] = R.array.CapJr13;
		cap[14] = R.array.CapJr14;
		cap[15] = R.array.CapJr15;
		cap[16] = R.array.CapJr16;
		cap[17] = R.array.CapJr17;
		cap[18] = R.array.CapJr18;
		cap[19] = R.array.CapJr19;
		cap[20] = R.array.CapJr20;
		cap[21] = R.array.CapJr21;
		cap[22] = R.array.CapJr22;
		cap[23] = R.array.CapJr23;
		cap[24] = R.array.CapJr24;
		cap[25] = R.array.CapJr25;
		cap[26] = R.array.CapJr26;
		cap[27] = R.array.CapJr27;
		cap[28] = R.array.CapJr28;
		cap[29] = R.array.CapJr29;
		cap[30] = R.array.CapJr30;
		cap[31] = R.array.CapJr31;
		cap[32] = R.array.CapJr32;
		cap[33] = R.array.CapJr33;
		cap[34] = R.array.CapJr34;
		cap[35] = R.array.CapJr35;
		cap[36] = R.array.CapJr36;
		cap[37] = R.array.CapJr37;
		cap[38] = R.array.CapJr38;
		cap[39] = R.array.CapJr39;
		cap[40] = R.array.CapJr40;
		cap[41] = R.array.CapJr41;
		cap[42] = R.array.CapJr42;
		cap[43] = R.array.CapJr43;
		cap[44] = R.array.CapJr44;
		cap[45] = R.array.CapJr45;
		cap[46] = R.array.CapJr46;
		cap[47] = R.array.CapJr47;
		cap[48] = R.array.CapJr48;
		cap[49] = R.array.CapJr49;
		cap[50] = R.array.CapJr50;
		cap[51] = R.array.CapJr51;
		cap[52] = R.array.CapJr52;

		return 52;
	}
	public static int CapLm(){
		cap[1] = R.array.CapJr1;
		cap[2] = R.array.CapJr2;
		cap[3] = R.array.CapJr3;
		cap[4] = R.array.CapJr4;
		cap[5] = R.array.CapJr5;

		return 5;
	}
	public static int CapBr(){
		cap[1] = R.array.CapBr1;
		cap[2] = R.array.CapBr2;
		cap[3] = R.array.CapBr3;
		cap[4] = R.array.CapBr4;
		cap[5] = R.array.CapBr5;
		cap[6] = R.array.CapBr6;

		return 6;
	}
	public static int CapEz(){
		cap[1] = R.array.CapEz1;
		cap[2] = R.array.CapEz2;
		cap[3] = R.array.CapEz3;
		cap[4] = R.array.CapEz4;
		cap[5] = R.array.CapEz5;
		cap[6] = R.array.CapEz6;
		cap[7] = R.array.CapEz7;
		cap[8] = R.array.CapEz8;
		cap[9] = R.array.CapEz9;
		cap[10] = R.array.CapEz10;
		cap[11] = R.array.CapEz11;
		cap[12] = R.array.CapEz12;
		cap[13] = R.array.CapEz13;
		cap[14] = R.array.CapEz14;
		cap[15] = R.array.CapEz15;
		cap[16] = R.array.CapEz16;
		cap[17] = R.array.CapEz17;
		cap[18] = R.array.CapEz18;
		cap[19] = R.array.CapEz19;
		cap[20] = R.array.CapEz20;
		cap[21] = R.array.CapEz21;
		cap[22] = R.array.CapEz22;
		cap[23] = R.array.CapEz23;
		cap[24] = R.array.CapEz24;
		cap[25] = R.array.CapEz25;
		cap[26] = R.array.CapEz26;
		cap[27] = R.array.CapEz27;
		cap[28] = R.array.CapEz28;
		cap[29] = R.array.CapEz29;
		cap[30] = R.array.CapEz30;
		cap[31] = R.array.CapEz31;
		cap[32] = R.array.CapEz32;
		cap[33] = R.array.CapEz33;
		cap[34] = R.array.CapEz34;
		cap[35] = R.array.CapEz35;
		cap[36] = R.array.CapEz36;
		cap[37] = R.array.CapEz37;
		cap[38] = R.array.CapEz38;
		cap[39] = R.array.CapEz39;
		cap[40] = R.array.CapEz40;
		cap[41] = R.array.CapEz41;
		cap[42] = R.array.CapEz42;
		cap[43] = R.array.CapEz43;
		cap[44] = R.array.CapEz44;
		cap[45] = R.array.CapEz45;
		cap[46] = R.array.CapEz46;
		cap[47] = R.array.CapEz47;
		cap[48] = R.array.CapEz48;


		return 48;
	}
	public static int CapDn(){
		cap[1] = R.array.CapDn1;
		cap[2] = R.array.CapDn2;
		cap[3] = R.array.CapDn3;
		cap[4] = R.array.CapDn4;
		cap[5] = R.array.CapDn5;
		cap[6] = R.array.CapDn6;
		cap[7] = R.array.CapDn7;
		cap[8] = R.array.CapDn8;
		cap[9] = R.array.CapDn9;
		cap[10] = R.array.CapDn10;
		cap[11] = R.array.CapDn11;
		cap[12] = R.array.CapDn12;
		cap[13] = R.array.CapDn13;
		cap[14] = R.array.CapDn14;

		return 14;
	}
	public static int CapOs(){
		cap[1] = R.array.CapOs1;
		cap[2] = R.array.CapOs2;
		cap[3] = R.array.CapOs3;
		cap[4] = R.array.CapOs4;
		cap[5] = R.array.CapOs5;
		cap[6] = R.array.CapOs6;
		cap[7] = R.array.CapOs7;
		cap[8] = R.array.CapOs8;
		cap[9] = R.array.CapOs9;
		cap[10] = R.array.CapOs10;
		cap[11] = R.array.CapOs11;
		cap[12] = R.array.CapOs12;
		cap[13] = R.array.CapOs13;
		cap[14] = R.array.CapOs14;

		return 14;
	}
	public static int CapJl(){
		
		cap[1] = R.array.CapJl1;
		cap[2] = R.array.CapJl2;
		cap[3] = R.array.CapJl3;
		cap[4] = R.array.CapJl4;

		
		return 4;
	}
	public static int CapAm(){
		cap[1] = R.array.CapAm1;
		cap[2] = R.array.CapAm2;
		cap[3] = R.array.CapAm3;
		cap[4] = R.array.CapAm4;
		cap[5] = R.array.CapAm5;
		cap[6] = R.array.CapAm6;
		cap[7] = R.array.CapAm7;
		cap[8] = R.array.CapAm8;
		cap[9] = R.array.CapAm9;

		return 9;
	}
	public static int CapAb(){
		cap[1] = R.array.CapAb1;

		return 1;
	}
	public static int CapJn(){
		cap[1] = R.array.CapJn1;
		cap[2] = R.array.CapJn2;
		cap[3] = R.array.CapJn3;
		cap[4] = R.array.CapJn4;

		
		return 4;
	}
	public static int CapMq(){
		cap[1] = R.array.CapMq1;
		cap[2] = R.array.CapMq2;
		cap[3] = R.array.CapMq3;
		cap[4] = R.array.CapMq4;
		cap[5] = R.array.CapMq5;
		cap[6] = R.array.CapMq6;
		cap[7] = R.array.CapMq7;

		return 7;
	}
	public static int CapNa(){
		cap[1] = R.array.CapNa1;
		cap[2] = R.array.CapNa2;
		cap[3] = R.array.CapNa3;

		return 3;
	}
	public static int CapHab(){
		cap[1] = R.array.CapHab1;
		cap[2] = R.array.CapHab2;
		cap[3] = R.array.CapHab3;

		return 3;
	}
	
	public static int CapSf(){
		cap[1] = R.array.CapSf1;
		cap[2] = R.array.CapSf2;
		cap[3] = R.array.CapSf3;

		return 3;
	}
	public static int CapAg(){
		cap[1] = R.array.CapAg1;
		cap[2] = R.array.CapAg2;

		return 2;
	}
	public static int CapZc(){
		cap[1] = R.array.CapZc1;
		cap[2] = R.array.CapZc2;
		cap[3] = R.array.CapZc3;
		cap[4] = R.array.CapZc4;
		cap[5] = R.array.CapZc5;
		cap[6] = R.array.CapZc6;
		cap[7] = R.array.CapZc7;
		cap[8] = R.array.CapZc8;
		cap[9] = R.array.CapZc9;
		cap[10] = R.array.CapZc10;
		cap[11] = R.array.CapZc11;
		cap[12] = R.array.CapZc12;
		cap[13] = R.array.CapZc13;
		cap[14] = R.array.CapZc14;

		return 14;
	}
	public static int CapMl(){
		cap[1] = R.array.CapMl1;
		cap[2] = R.array.CapMl2;
		cap[3] = R.array.CapMl3;

		return 3;
	}
	public static int CapMt(){
		cap[1] = R.array.CapMt1;
		cap[2] = R.array.CapMt2;
		cap[3] = R.array.CapMt3;
		cap[4] = R.array.CapMt4;
		cap[5] = R.array.CapMt5;
		cap[6] = R.array.CapMt6;
		cap[7] = R.array.CapMt7;
		cap[8] = R.array.CapMt8;
		cap[9] = R.array.CapMt9;
		cap[10] = R.array.CapMt10;
		cap[11] = R.array.CapMt11;
		cap[12] = R.array.CapMt12;
		cap[13] = R.array.CapMt13;
		cap[14] = R.array.CapMt14;
		cap[15] = R.array.CapMt15;
		cap[16] = R.array.CapMt16;
		cap[17] = R.array.CapMt17;
		cap[18] = R.array.CapMt18;
		cap[19] = R.array.CapMt19;
		cap[20] = R.array.CapMt20;
		cap[21] = R.array.CapMt21;
		cap[22] = R.array.CapMt22;
		cap[23] = R.array.CapMt23;
		cap[24] = R.array.CapMt24;
		cap[25] = R.array.CapMt25;
		cap[26] = R.array.CapMt26;
		cap[27] = R.array.CapMt27;
		cap[28] = R.array.CapMt28;
		return 28;
	}
	public static int CapMc(){
		
		cap[1] = R.array.CapMc1;
		cap[2] = R.array.CapMc2;
		cap[3] = R.array.CapMc3;
		cap[4] = R.array.CapMc4;
		cap[5] = R.array.CapMc5;
		cap[6] = R.array.CapMc6;
		cap[7] = R.array.CapMc7;
		cap[8] = R.array.CapMc8;
		cap[9] = R.array.CapMc9;
		cap[10] = R.array.CapMc10;
		cap[11] = R.array.CapMc11;
		cap[12] = R.array.CapMc12;
		cap[13] = R.array.CapMc13;
		cap[14] = R.array.CapMc14;
		cap[15] = R.array.CapMc15;
		cap[16] = R.array.CapMc16;
return 16;
	}
	public static int CapLc(){
		cap[1] = R.array.CapLc1;
		cap[2] = R.array.CapLc2;
		cap[3] = R.array.CapLc3;
		cap[4] = R.array.CapLc4;
		cap[5] = R.array.CapLc5;
		cap[6] = R.array.CapLc6;
		cap[7] = R.array.CapLc7;
		cap[8] = R.array.CapLc8;
		cap[9] = R.array.CapLc9;
		cap[10] = R.array.CapLc10;
		cap[11] = R.array.CapLc11;
		cap[12] = R.array.CapLc12;
		cap[13] = R.array.CapLc13;
		cap[14] = R.array.CapLc14;
		cap[15] = R.array.CapLc15;
		cap[16] = R.array.CapLc16;
		cap[17] = R.array.CapLc17;
		cap[18] = R.array.CapLc18;
		cap[19] = R.array.CapLc19;
		cap[20] = R.array.CapLc20;
		cap[21] = R.array.CapLc21;
		cap[22] = R.array.CapLc22;
		cap[23] = R.array.CapLc23;
		cap[24] = R.array.CapLc24;
		return 24;
	}
	public static int CapSJo(){
		cap[1] = R.array.CapSJo1;
		cap[2] = R.array.CapSJo2;
		cap[3] = R.array.CapSJo3;
		cap[4] = R.array.CapSJo4;
		cap[5] = R.array.CapSJo5;
		cap[6] = R.array.CapSJo6;
		cap[7] = R.array.CapSJo7;
		cap[8] = R.array.CapSJo8;
		cap[9] = R.array.CapSJo9;
		cap[10] = R.array.CapSJo10;
		cap[11] = R.array.CapSJo11;
		cap[12] = R.array.CapSJo12;
		cap[13] = R.array.CapSJo13;
		cap[14] = R.array.CapSJo14;
		cap[15] = R.array.CapSJo15;
		cap[16] = R.array.CapSJo16;
		cap[17] = R.array.CapSJo17;
		cap[18] = R.array.CapSJo18;
		cap[19] = R.array.CapSJo19;
		cap[20] = R.array.CapSJo20;
		cap[21] = R.array.CapSJo21;


		return 21;
	}
	public static int CapAt(){
		cap[1] = R.array.CapAt1;
		cap[2] = R.array.CapAt2;
		cap[3] = R.array.CapAt3;
		cap[4] = R.array.CapAt4;
		cap[5] = R.array.CapAt5;
		cap[6] = R.array.CapAt6;
		cap[7] = R.array.CapAt7;
		cap[8] = R.array.CapAt8;
		cap[9] = R.array.CapAt9;
		cap[10] = R.array.CapAt10;
		cap[11] = R.array.CapAt11;
		cap[12] = R.array.CapAt12;
		cap[13] = R.array.CapAt13;
		cap[14] = R.array.CapAt14;
		cap[15] = R.array.CapAt15;
		cap[16] = R.array.CapAt16;
		cap[17] = R.array.CapAt17;
		cap[18] = R.array.CapAt18;
		cap[19] = R.array.CapAt19;
		cap[20] = R.array.CapAt20;
		cap[21] = R.array.CapAt21;
		cap[22] = R.array.CapAt22;
		cap[23] = R.array.CapAt23;
		cap[24] = R.array.CapAt24;
		cap[25] = R.array.CapAt25;
		cap[26] = R.array.CapAt26;
		cap[27] = R.array.CapAt27;
		cap[28] = R.array.CapAt28;

		return 28;
	}
	public static int CapRm(){
		cap[1] = R.array.CapRm1;
		cap[2] = R.array.CapRm2;
		cap[3] = R.array.CapRm3;
		cap[4] = R.array.CapRm4;
		cap[5] = R.array.CapRm5;
		cap[6] = R.array.CapRm6;
		cap[7] = R.array.CapRm7;
		cap[8] = R.array.CapRm8;
		cap[9] = R.array.CapRm9;
		cap[10] = R.array.CapRm10;
		cap[11] = R.array.CapRm11;
		cap[12] = R.array.CapRm12;
		cap[13] = R.array.CapRm13;
		cap[14] = R.array.CapRm14;
		cap[15] = R.array.CapRm15;
		cap[16] = R.array.CapRm16;

		
		return 16;
	}
	public static int Cap1Cor(){
		cap[1] = R.array.Cap1Cor1;
		cap[2] = R.array.Cap1Cor2;
		cap[3] = R.array.Cap1Cor3;
		cap[4] = R.array.Cap1Cor4;
		cap[5] = R.array.Cap1Cor5;
		cap[6] = R.array.Cap1Cor6;
		cap[7] = R.array.Cap1Cor7;
		cap[8] = R.array.Cap1Cor8;
		cap[9] = R.array.Cap1Cor9;
		cap[10] = R.array.Cap1Cor10;
		cap[11] = R.array.Cap1Cor11;
		cap[12] = R.array.Cap1Cor12;
		cap[13] = R.array.Cap1Cor13;
		cap[14] = R.array.Cap1Cor14;
		cap[15] = R.array.Cap1Cor15;
		cap[16] = R.array.Cap1Cor16;

		return 16;
	}
	public static int Cap2Cor(){
		cap[1] = R.array.Cap2Cor1;
		cap[2] = R.array.Cap2Cor2;
		cap[3] = R.array.Cap2Cor3;
		cap[4] = R.array.Cap2Cor4;
		cap[5] = R.array.Cap2Cor5;
		cap[6] = R.array.Cap2Cor6;
		cap[7] = R.array.Cap2Cor7;
		cap[8] = R.array.Cap2Cor8;
		cap[9] = R.array.Cap2Cor9;
		cap[10] = R.array.Cap2Cor10;
		cap[11] = R.array.Cap2Cor11;
		cap[12] = R.array.Cap2Cor12;
		cap[13] = R.array.Cap2Cor13;

		return 13;
	}
	public static int CapGl(){
		cap[1] = R.array.CapGl1;
		cap[2] = R.array.CapGl2;
		cap[3] = R.array.CapGl3;
		cap[4] = R.array.CapGl4;
		cap[5] = R.array.CapGl5;
		cap[6] = R.array.CapGl6;

		
		return 6;
	}
	public static int CapEf(){
		cap[1] = R.array.CapEf1;
		cap[2] = R.array.CapEf2;
		cap[3] = R.array.CapEf3;
		cap[4] = R.array.CapEf4;
		cap[5] = R.array.CapEf5;
		cap[6] = R.array.CapEf6;

		return 6;
	}
	public static int CapFl(){
		cap[1] = R.array.CapFl1;
		cap[2] = R.array.CapFl2;
		cap[3] = R.array.CapFl3;
		cap[4] = R.array.CapFl4;

		
		return 4;
	}
	public static int CapCl(){
		cap[1] = R.array.CapCl1;
		cap[2] = R.array.CapCl2;
		cap[3] = R.array.CapCl3;
		cap[4] = R.array.CapCl4;

		return 4;
	}
	public static int Cap1Ts(){
		cap[1] = R.array.Cap1Ts1;
		cap[2] = R.array.Cap1Ts2;
		cap[3] = R.array.Cap1Ts3;
		cap[4] = R.array.Cap1Ts4;
		cap[5] = R.array.Cap1Ts5;

		return 5;
	}
	public static int Cap2Ts(){
		cap[1] = R.array.Cap2Ts1;
		cap[2] = R.array.Cap2Ts2;
		cap[3] = R.array.Cap2Ts3;

		return 3;
	}
	public static int Cap1Tm(){
		cap[1] = R.array.Cap1Tm1;
		cap[2] = R.array.Cap1Tm2;
		cap[3] = R.array.Cap1Tm3;
		cap[4] = R.array.Cap1Tm4;
		cap[5] = R.array.Cap1Tm5;
		cap[6] = R.array.Cap1Tm6;

		return 6;
	}
	public static int Cap2Tm(){
		cap[1] = R.array.Cap2Tm1;
		cap[2] = R.array.Cap2Tm2;
		cap[3] = R.array.Cap2Tm3;
		cap[4] = R.array.Cap2Tm4;

		return 4;
	}
	public static int CapTt(){
		cap[1] = R.array.CapTt1;
		cap[2] = R.array.CapTt2;
		cap[3] = R.array.CapTt3;

		return 3;
	}
	public static int CapFm(){
		
		cap[1] = R.array.CapFm1;
		return 1;
	}
	public static int CapHb(){
		cap[1] = R.array.CapHb1;
		cap[2] = R.array.CapHb2;
		cap[3] = R.array.CapHb3;
		cap[4] = R.array.CapHb4;
		cap[5] = R.array.CapHb5;
		cap[6] = R.array.CapHb6;
		cap[7] = R.array.CapHb7;
		cap[8] = R.array.CapHb8;
		cap[9] = R.array.CapHb9;
		cap[10] = R.array.CapHb10;
		cap[11] = R.array.CapHb11;
		cap[12] = R.array.CapHb12;
		cap[13] = R.array.CapHb13;

		return 13;
	}
	public static int CapTg(){
		cap[1] = R.array.CapTg1;
		cap[2] = R.array.CapTg2;
		cap[3] = R.array.CapTg3;
		cap[4] = R.array.CapTg4;
		cap[5] = R.array.CapTg5;

		return 5;
	}
	public static int Cap1Pd(){
		cap[1] = R.array.Cap1Pd1;
		cap[2] = R.array.Cap1Pd2;
		cap[3] = R.array.Cap1Pd3;
		cap[4] = R.array.Cap1Pd4;
		cap[5] = R.array.Cap1Pd5;

		return 5;
	}
	public static int Cap2Pd(){
		cap[1] = R.array.Cap2Pd1;
		cap[2] = R.array.Cap2Pd2;
		cap[3] = R.array.Cap2Pd3;

		return 3;
	}
	public static int Cap1Jo(){
		cap[1] = R.array.Cap1Jo1;
		cap[2] = R.array.Cap1Jo2;
		cap[3] = R.array.Cap1Jo3;
		cap[4] = R.array.Cap1Jo4;
		cap[5] = R.array.Cap1Jo5;

		return 5;
	}
	public static int Cap2Jo(){
		cap[1] = R.array.Cap2Jo1;

		return 1;
	}
	public static int Cap3Jo(){
		cap[1] = R.array.Cap3Jo1;
		return 1;
	}
	public static int CapJd(){
	
		cap[1] = R.array.CapJd1;
		return 1;
	}
	
	public static int CapAp(){
		cap[1] = R.array.CapAp1;
		cap[2] = R.array.CapAp2;
		cap[3] = R.array.CapAp3;
		cap[4] = R.array.CapAp4;
		cap[5] = R.array.CapAp5;
		cap[6] = R.array.CapAp6;
		cap[7] = R.array.CapAp7;
		cap[8] = R.array.CapAp8;
		cap[9] = R.array.CapAp9;
		cap[10] = R.array.CapAp10;
		cap[11] = R.array.CapAp11;
		cap[12] = R.array.CapAp12;
		cap[13] = R.array.CapAp13;
		cap[14] = R.array.CapAp14;
		cap[15] = R.array.CapAp15;
		cap[16] = R.array.CapAp16;
		cap[17] = R.array.CapAp17;
		cap[18] = R.array.CapAp18;
		cap[19] = R.array.CapAp19;
		cap[20] = R.array.CapAp20;
		cap[21] = R.array.CapAp21;
		cap[22] = R.array.CapAp22;

		return 22;
	}
	
	
}




