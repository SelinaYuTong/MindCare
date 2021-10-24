package nz.ac.wgtn.mindcare;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialogFragment;

public class FutureworksDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.future_works_settings)
                .setMessage(R.string.future_works_message)
                .setPositiveButton(R.string.close, (dialog, which) -> {
                    this.dismiss();
                });
        return builder.create();
    }
}
