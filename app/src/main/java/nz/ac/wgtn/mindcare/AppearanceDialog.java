package nz.ac.wgtn.mindcare;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AppearanceDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.appearance_settings)
        .setMessage(R.string.set_a_mode)
        .setPositiveButton(R.string.dark_mode, (dialog, which) -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            getActivity().finish();
            getActivity().startActivity(getActivity().getIntent());
            this.dismiss();
        }).setNegativeButton(R.string.normal_mode, (dialog, which) -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            getActivity().finish();
            getActivity().startActivity(getActivity().getIntent());
            this.dismiss();
        }).create();
        return builder.create();
    }
}
