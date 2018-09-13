package ribboncafe.ribbon.com.ribboncafe;

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

public class MainActivity extends AppCompatActivity {


    private Button btn_reg;
    private Button btn_signin;
    private EditText email;
    private EditText password;
    private FirebaseAuth auth;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, nav_drawer.class));
            finish();
        }


        btn_reg=(Button)findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change_activity=new Intent(MainActivity.this,reg_activity.class);
                MainActivity.this.startActivity(change_activity);
            }
        });

        btn_signin=(Button)findViewById(R.id.btn_signin);
        email=(EditText)findViewById(R.id.etext_sigin_email);
        password=(EditText)findViewById(R.id.etext_signin_password);
        progressBar = new ProgressDialog(this);


        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=email.getText().toString().trim();
                String p=password.getText().toString().trim();

                if (TextUtils.isEmpty(e)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(p)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setMessage("Signing In Please Wait");
                progressBar.show();

                auth.signInWithEmailAndPassword(e,p).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.dismiss();
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,"Successfully Signed In", Toast.LENGTH_LONG).show();
                            Intent change_activity=new Intent(MainActivity.this,nav_drawer.class);
                            MainActivity.this.startActivity(change_activity);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Signin Error", Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });





    }
}
