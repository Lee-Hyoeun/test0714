package com.angie.test0714;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class fbActivity extends AppCompatActivity {



    public static final String AUTHOR_KEY = "author";
    public static final String QUOTE_KEY = "quote";
    public static final String TAG = "InspiringQuite";

    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("sampleData/inspiration");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
    }


    public void saveQuote(View view) {
        EditText quoteView = (EditText) findViewById(R.id.editTextQuote);
        EditText authorView = (EditText) findViewById(R.id.editTextAuthor);
        String quoteText = quoteView.getText().toString();
        String authorText = authorView.getText().toString();

        if(quoteText.isEmpty() || authorText.isEmpty()) {return;}
        Map<String, Object> dataTosave = new HashMap<String, Object>();
        dataTosave.put(QUOTE_KEY, quoteText);
        dataTosave.put(AUTHOR_KEY, authorText);
        Log.e(TAG, " ㅡㅡ 뭐가문제냐");
        mDocRef.set(dataTosave).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.e(TAG, "Document has been saved!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "Document was not saved!", e);
            }
        });
    }
}


