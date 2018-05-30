package com.example.ronaldbenjamin.saarthironald;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignInFragment extends Fragment {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private Button  btnLogin;
  public SignInFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view= inflater.inflate(R.layout.fragment_sign_in, container, false);
      Button signin=(Button)view.findViewById(R.id.login);
      signin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              inputEmail = (EditText) getView().findViewById(R.id.emaillogin);
              inputPassword = (EditText) getView().findViewById(R.id.passwordlogin);
              String email = inputEmail.getText().toString();
              final String password = inputPassword.getText().toString();

              if (TextUtils.isEmpty(email)) {
                  Toast.makeText(getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                  return;
              }

              if (TextUtils.isEmpty(password)) {
                  Toast.makeText(getContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                  return;
              }

              //authenticate user
              auth.signInWithEmailAndPassword(email, password)
                      .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {
                              // If sign in fails, display a message to the user. If sign in succeeds
                              // the auth state listener will be notified and logic to handle the
                              // signed in user can be handled in the listener.

                              if (!task.isSuccessful()) {
                                  // there was an error
                                  Toast.makeText(getActivity(), "authentication Failed", Toast.LENGTH_LONG).show();
                              }
                              else {
                                  Toast.makeText(getActivity(), "authentication Succeeded!!", Toast.LENGTH_LONG).show();
                                  Intent intent = new Intent(getActivity(), ChatPage.class);
                                  startActivity(intent);

                              }
                          }
                      });


          }
      });
      signin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(getContext(),ChatMainPage.class));

          }
      });

      return view;
  }

}