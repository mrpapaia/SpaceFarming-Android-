package com.example.spacefarming.frag;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.spacefarming.MainActivity;
import com.example.spacefarming.R;
import com.example.spacefarming.Tela2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends Fragment {

    private static String TAG = "access";
    private Button btLogin;
    private CardView cadastrar;
    private TextInputLayout tiEmail;
    private TextInputLayout tiSenha;
    private FirebaseAuth mAuth;

    public Login() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        btLogin = v.findViewById(R.id.btLogin);
        cadastrar = v.findViewById(R.id.cadastrar);
        tiEmail = v.findViewById(R.id.tiEmail);
        tiSenha = v.findViewById(R.id.tiSenha);

        btLogin.setOnClickListener(onClickLogin());
        cadastrar.setOnClickListener(onClickCadastro());
        return v;
    }


    protected View.OnClickListener onClickLogin() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                mAuth.signInWithEmailAndPassword(tiEmail.getEditText().getText().toString(),
                        tiSenha.getEditText().getText().toString())
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "signInWithEmail:success");

                                    Intent it = new Intent(getContext(), MainActivity.class);
                                    startActivity(it);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(getContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        };
    }

    protected View.OnClickListener onClickCadastro() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(), Tela2.class);
                it.putExtra("frag",3);
                startActivity(it);
            }
        };
    }
}