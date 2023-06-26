package com.example.avidii2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.avidii2.Adapter.SubjectAdapter;
import com.example.avidii2.Model.Subject;
import com.example.avidii2.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class AskNowFragment extends Fragment {
    private GridView gridView;
    private ArrayList<Subject> subjects;
    private SubjectAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ask_now, container, false);

        gridView = rootView.findViewById(R.id.subjectGrid);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
        View bottomSheetView = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_sheet_layout, null);
        subjects = new ArrayList<>();
        subjects.add(new Subject("Physics", R.drawable.physics_icon));
        subjects.add(new Subject("Chemistry", R.drawable.chemistry_icon));
        subjects.add(new Subject("Biology", R.drawable.biology_icon));
        // ... add all your subjects here

        adapter = new SubjectAdapter(getActivity(), subjects);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener((parent, view, position, id) -> {


            TextView selectedSubjectText = bottomSheetView.findViewById(R.id.selected_subject_text);
            String selectedSubject = "You have selected " + subjects.get(position).getSubjectName();
            selectedSubjectText.setText(selectedSubject);

            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();
        });


        ImageButton closeButton = bottomSheetView.findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });


        return rootView;
    }
}
