package smartparadise.tictactoe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
    EditText et_first,et_second;
    CardView playCard;
    public static String firstName,secondName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        playCard=(CardView)findViewById(R.id.playGame);
        et_first=(EditText)findViewById(R.id.firstPlayerName);
        et_second=(EditText)findViewById(R.id.secondPlayerName);
        playCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SplashActivity.thugSound.start();
                firstName=et_first.getText().toString();
                secondName=et_second.getText().toString();
                if(firstName.equals("")||secondName.equals("")){
                    new AlertDialog.Builder(FirstActivity.this)
                            .setTitle("Message").setMessage("Fill Names first").show();
                }else{
                    startActivity(new Intent(FirstActivity.this,MainActivity.class));
                    finish();
                }


            }
        });


    }

}
