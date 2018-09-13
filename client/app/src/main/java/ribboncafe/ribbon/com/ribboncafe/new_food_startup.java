package ribboncafe.ribbon.com.ribboncafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class new_food_startup extends AppCompatActivity {

    private Button signin;
    private Button signup;
    private TextView txt;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_food_startup);

        auth=FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(new_food_startup.this, nav_drawer.class));
            finish();
        }


        signin=(Button)findViewById(R.id.btn_signin_1);
        signup=(Button)findViewById(R.id.btn_signup_1);
        txt=(TextView)findViewById(R.id.txt_about);

//        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/NABILA.TTF");
//        txt.setTypeface(face);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent change_activity=new Intent(new_food_startup.this,new_sign_in.class);
                new_food_startup.this.startActivity(change_activity);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent change_activity=new Intent(new_food_startup.this,new_sign_up.class);
                new_food_startup.this.startActivity(change_activity);

            }
        });
    }
}
