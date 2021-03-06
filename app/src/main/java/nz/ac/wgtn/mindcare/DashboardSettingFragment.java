package nz.ac.wgtn.mindcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardSettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardSettingFragment extends Fragment {

    private ImageView ivAppearance;
    private ImageView ivLanguage;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardSettingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardSettingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardSettingFragment newInstance(String param1, String param2) {
        DashboardSettingFragment fragment = new DashboardSettingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard_setting, container, false);
        ivAppearance = view.findViewById(R.id.appearanceImageView);
        ivAppearance.setOnClickListener(v -> {
            openAppearanceDialog();
        });
        ivLanguage = view.findViewById(R.id.languageImageView);
        ivLanguage.setOnClickListener(v -> {
            openLanguageDialog();
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void openAppearanceDialog() {
        AppearanceDialog appearanceDialog = new AppearanceDialog();
        appearanceDialog.show(getChildFragmentManager(), "Appearance Dialog");
    }

    private void openLanguageDialog() {
        LanguageDialog languageDialog = new LanguageDialog();
        languageDialog.show(getChildFragmentManager(), "Language Dialog");
    }
}