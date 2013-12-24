package br.com.cybertronyk.minhabibliacatolicav2.factory;

import br.com.cybertronyk.minhabibliacatolicav2.MainActivity;
import br.com.cybertronyk.minhabibliacatolicav2.R;
import android.content.SharedPreferences;

import com.actionbarsherlock.app.SherlockActivity;

public class Theme extends SherlockActivity {
	MainActivity main = new MainActivity();
	int SDK_INT;

	public void settingsPreferences() {
		SharedPreferences settings = getSharedPreferences("Preferences", 0);
		main.setTheme(settings.getBoolean("PrefUsuario", true));
		main.setTextSize(settings.getInt("PrefFont", 2));
	}

	public int themeRes(Boolean x) {
		int th;
		if (x == true) {
			th = R.style.ThemeHoloWite;
		} else {
			th = R.style.ThemeHoloDark;
		}
		return th;
	}

	public int buscaSDK() {
		SDK_INT = android.os.Build.VERSION.SDK_INT;
		return SDK_INT;
	}

}
