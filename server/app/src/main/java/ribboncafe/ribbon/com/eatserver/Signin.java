package ribboncafe.ribbon.com.eatserver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {


    private EditText email,password;
    Button btn_signin;
    private FirebaseAuth auth;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);



        auth = FirebaseAuth.getInstance();


        btn_signin=(Button)findViewById(R.id.btn_signin_2);
        email=(EditText)findViewById(R.id.etext_email_1);
        password=(EditText)findViewById(R.id.etext_pass_1);
        progressBar = new ProgressDialog(this);


        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String e=email.getText().toString().trim();
                String p=password.getText().toString().trim();

                if (TextUtils.isEmpty(e)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
//                if (!e.substring(e.length() - 8).equals("rbbn.com")) {
//                    Toast.makeText(getApplicationContext(), "ONLY FOR RIBBON !", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                if (TextUtils.isEmpty(p)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setMessage("Signing In Please Wait");
                progressBar.show();

                auth.signInWithEmailAndPassword(e,p).addOnCompleteListener(Signin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.dismiss();
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Signin.this,"Successfully Signed In", Toast.LENGTH_SHORT).show();
                            //Common.currentUser=e;
                            Intent change_activity=new Intent(Signin.this,Home.class);
                            Signin.this.startActivity(change_activity);
                        }
                        else
                        {
                            Toast.makeText(Signin.this,"Signin Error", Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });



    }
}
