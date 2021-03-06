package com.angie.test0714;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRevoke, btnLogout, btnStore, btnFb;
    private FirebaseAuth mAuth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("LoginActivity","onCreate 호출됨");

        btnStore = (Button)findViewById(R.id.btn_store);
        btnLogout = (Button)findViewById(R.id.btn_logout);
        btnRevoke = (Button)findViewById(R.id.btn_revoke);
        btnFb = (Button)findViewById(R.id.btn_fb);

        mAuth = FirebaseAuth.getInstance();

        btnStore.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
        btnRevoke.setOnClickListener(this);
        btnFb.setOnClickListener(this);
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    private void revokeAccess() {
        mAuth.getCurrentUser().delete();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_store:
                Intent intent = new Intent(this, NavidrawAcivity.class);
                startActivity(intent);
                break;
            case R.id.btn_logout:
                signOut();
                finishAffinity();
                break;
            case R.id.btn_revoke:
                revokeAccess();
                finishAffinity();
                break;

            case R.id.btn_fb:
                Intent intent2 = new Intent(this, fbActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
