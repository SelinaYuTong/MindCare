package nz.ac.wgtn.mindcare;

import android.app.Dialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Locale;

public class LanguageDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.appearance_settings)
                .setMessage(R.string.set_a_language)
                .setPositiveButton(R.string.english_language, (dialog, which) -> {
                    Locale locale = new Locale("en");
                    setLanguage(locale);
                    this.dismiss();
                }).setNegativeButton(R.string.french_language, (dialog, which) -> {
                    Locale locale = new Locale("fr");
                    setLanguage(locale);
                    this.dismiss();
        }).create();
        return builder.create();
    }

    public void setLanguage(Locale locale){
        Locale.setDefault(locale);
        Resources res = getContext().getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(locale);
        getContext().createConfigurationContext(config);
        res.updateConfiguration(config,res.getDisplayMetrics());
        getActivity().finish();
        getActivity().startActivity(getActivity().getIntent());
    }
}
