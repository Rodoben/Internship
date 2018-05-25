package com.example.ronaldbenjamin.saarthironald;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class OptionFragment extends Fragment {
  public OptionFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_option, container, false);

    Button login = (Button) view.findViewById(R.id.button);
    Button Signup = (Button) view.findViewById(R.id.button10);

    Signup.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
            SignUpFragment selectFragment = new SignUpFragment();
            FragmentManager manager = getFragmentManager();
            manager
                .beginTransaction()
                .replace(R.id.MainFrame, selectFragment, selectFragment.getTag())
                .commit();
          }
        });

    login.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
            SignInFragment selectFragment = new SignInFragment();

            FragmentManager manager = getFragmentManager();

            manager
                .beginTransaction()
                .replace(R.id.MainFrame, selectFragment, selectFragment.getTag())
                .commit();
          }
        });

    return view;
  }
    }
