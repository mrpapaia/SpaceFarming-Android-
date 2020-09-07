package com.example.spacefarming.frag;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.spacefarming.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class CadastroUsuario extends Fragment {
    private static String TAG = "access";
    private TextInputLayout tiEmail;
    private TextInputLayout tiSenha;
    private Button btCadastro;
    private FirebaseAuth mAuth;

    public CadastroUsuario() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cadastro_usuario, container, false);
        btCadastro = v.findViewById(R.id.btCadastrar);
        tiEmail = v.findViewById(R.id.tiEmail);
        tiSenha = v.findViewById(R.id.tiSenha);
        btCadastro.setOnClickListener(onClickCreateUser());
        return v;
    }

    protected View.OnClickListener onClickCreateUser() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(tiEmail.getEditText().getText().toString(),
                        tiSenha.getEditText().getText().toString())
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "createUserWithEmail:success");
                                    Toast.makeText(getContext(), "Usuario foi cadastrado com sucesso!!",
                                            Toast.LENGTH_LONG).show();
                                    mAuth.signOut();
                                    getActivity().finish();
                                } else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getContext(), "Falha ao tentar cadastrar usuario!!",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });


            }
        };
    }
}