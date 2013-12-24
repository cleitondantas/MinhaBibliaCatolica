package br.com.cybertronyk.minhabibliacatolicav2.factory;

import java.util.Arrays;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.Context;
import android.widget.Toast;

public class Actions extends SherlockActivity{
	
	public void toastNote(String txt) {
		Context context = getApplicationContext();
		CharSequence text = txt;
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	public String reConcatena(String txtTitleConcatena){  
		String[] test = txtTitleConcatena.split(",");  
		int[] saida = new int[test.length];    
		for (int i = 0; i < test.length; i++) {   
			saida[i] = Integer.parseInt(test[i]);
			}                
		Arrays.sort(saida);  
		int a = 0;  
		int t = 0; 
		int z = 0; 
		String stringFinal = "";   
		stringFinal = "";//+=""+saida[0];
		boolean control = true; 
		boolean control2 = false;
		for (int i = 0; i < saida.length; i++) {   
			if (i == 0) { 
				t = saida[i]; // atual    
				stringFinal += t + ",";   
				control = false;        
				} else {      
					control = true; 
					a = saida[i - 1]; // anterior   
					t = saida[i]; // atual  
					if (i <= saida.length - 2) { 
						z = saida[i + 1]; // posterior
						}           
					}     
			if (a + 1 == t && t + 1 == z) {   
				// Passa por aqui quando é para pular o valor   
				} else if (a + 1 == t && t + 1 != z) {                  
					t = saida[i]; // atual   
					control2 = true;     
					} else {         
						if (control) {   
							stringFinal += t + ",";   
							}        
						}     
			if(control2){    
				if(t != 1){    
					stringFinal += "-"+t+",";     
					}           
				control2 = false;  
				}      
			}   
		stringFinal = stringFinal.replace(",-", "-");  
		return stringFinal;    
		}	

}
