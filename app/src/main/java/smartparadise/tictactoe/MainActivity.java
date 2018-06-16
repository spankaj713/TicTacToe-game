package smartparadise.tictactoe;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView playerText,result;
    int player=1;
    int buttonPressed,i;
    String mark="",playerName=FirstActivity.firstName;
    CardView quit,playAgain;
    View dialogView;


    AlertDialog.Builder alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogView= LayoutInflater.from(this).inflate(R.layout.dialog_layout,null);
        initViews();
        playerText.setText(playerName+" take your turn!!");
        initListeners();

    }
    public void play(){

        mark=(player==1)?"X":"O";
        if(buttonPressed==1){
            b1.setText(mark);
        }
        else if(buttonPressed==2){
            b2.setText(mark);
        }

        else if(buttonPressed==3){
            b3.setText(mark);
        }

        else if(buttonPressed==4){
            b4.setText(mark);
        }

        else if(buttonPressed==5){
            b5.setText(mark);
        }

        else if(buttonPressed==6){
            b6.setText(mark);
        }

        else if(buttonPressed==7){
            b7.setText(mark);
        }

        else if(buttonPressed==8){
            b8.setText(mark);
        }

        else if(buttonPressed==9){
            b9.setText(mark);
        }
        i=checkBoard();
        if(i==1){
            SplashActivity.mediaPlayer.start();
            setAlertDialog(playerName+" won!!");
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);

            return;
        }
        if(i==0){
            SplashActivity.mediaPlayer.start();
            setAlertDialog("Game Draw");
            return;
        }
        player++;
        player=(player%2!=0)?1:2;
        if(player==1){
            playerName=FirstActivity.firstName;
        }else{
            playerName=FirstActivity.secondName;
        }
        playerText.setText(playerName+" take your turn!!");

    }
    public void setAlertDialog(String message){
        alertDialog=new AlertDialog.Builder(this)
                .setView(dialogView);
        result.setText(message);
        alertDialog.show();
        alertDialog.setCancelable(false);
    }

    public int checkBoard(){
        if(b1.getText().toString().equals(b2.getText().toString())&&b2.getText().toString().equals(b3.getText().toString())){

            if(b1.getText().toString().equals("")&&b2.getText().toString().equals("")&&b3.getText().toString().equals("")){
                return 4;

            }
            return 1;
        }

        else if(b7.getText().toString().equals(b8.getText().toString())&&b8.getText().toString().equals(b9.getText().toString())){
            if(b7.getText().toString().equals("")&&b8.getText().toString().equals("")&&b9.getText().toString().equals("")){

                return 4;

            }
            Log.e("Status:","method called");
            return 1;
        }
        else if(b1.getText().toString().equals(b5.getText().toString())&&b5.getText().toString().equals(b9.getText().toString())){
            if(b1.getText().toString().equals("")&&b5.getText().toString().equals("")&&b9.getText().toString().equals("")){
                return 4;

            }
            return 1;
        }
        else if(b1.getText().toString().equals(b4.getText().toString())&&b4.getText().toString().equals(b7.getText().toString())){
            if(b1.getText().toString().equals("")&&b4.getText().toString().equals("")&&b7.getText().toString().equals("")){
                return 4;

            }
            return 1;
        }

        else if(b3.getText().toString().equals(b6.getText().toString())&&b6.getText().toString().equals(b9.getText().toString())){
            if(b3.getText().toString().equals("")&&b6.getText().toString().equals("")&&b9.getText().toString().equals("")){
                return 4;

            }
            return 1;
        }
        else if(b3.getText().toString().equals(b5.getText().toString())&&b5.getText().toString().equals(b7.getText().toString())){
            if(b3.getText().toString().equals("")&&b5.getText().toString().equals("")&&b7.getText().toString().equals("")){
                return 4;

            }
            return 1;
        }
        else if(!b1.getText().toString().equals("")&&!b2.getText().toString().equals("")&&!b3.getText().toString().equals("")&&
                !b4.getText().toString().equals("")&&!b5.getText().toString().equals("")&&!b6.getText().toString().equals("")&&
                !b7.getText().toString().equals("")&&!b8.getText().toString().equals("")&&!b9.getText().toString().equals("")){
            return 0;
        }
        else if(b2.getText().toString().equals(b5.getText().toString())&&b5.getText().toString().equals(b8.getText().toString())){
            if(b2.getText().toString().equals("")&&b5.getText().toString().equals("")&&b8.getText().toString().equals("")){
                return 4;

            }
            return 1;
        }
        else  if(b4.getText().toString().equals(b5.getText().toString())&&b5.getText().toString().equals(b6.getText().toString())){
            if(b4.getText().toString().equals("")&&b5.getText().toString().equals("")&&b6.getText().toString().equals("")){
                Log.e("Status:","empty method called");
                return 4;

            }
            return 1;
        }

        return 2;
    }



    public void initViews(){
        b1=(Button)findViewById(R.id.pos1);
        b2=(Button)findViewById(R.id.pos2);
        b3=(Button)findViewById(R.id.pos3);
        b4=(Button)findViewById(R.id.pos4);
        b5=(Button)findViewById(R.id.pos5);
        b6=(Button)findViewById(R.id.pos6);
        b7=(Button)findViewById(R.id.pos7);
        b8=(Button)findViewById(R.id.pos8);
        b9=(Button)findViewById(R.id.pos9);

        result=(TextView)dialogView.findViewById(R.id.message);
        quit=(CardView)dialogView.findViewById(R.id.quit) ;
        playAgain=(CardView)dialogView.findViewById(R.id.playAgain);
        playerText=(TextView) findViewById(R.id.playerText);
    }
    public void initListeners(){
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,FirstActivity.class));
                finish();
            }
        });
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        SplashActivity.thugSound.start();
        switch(view.getId()){
            case R.id.pos1:
                if(b1.isEnabled()){
                    buttonPressed=1;
                    play();
                    b1.setEnabled(false);
                }else{
                    playerText.setText("Invalid Move!!");
                }

                break;
            case R.id.pos2:
                if(b2.isEnabled()){
                    buttonPressed=2;
                    play();
                    b2.setEnabled(false);
                }else{
                    playerText.setText("Invalid Move!!");
                }
                break;
            case R.id.pos3:
                if(b3.isEnabled()){
                    buttonPressed=3;
                    play();
                    b3.setEnabled(false);
                }else{
                    playerText.setText("Invalid Move!!");
                }
                break;
            case R.id.pos4:
                if(b4.isEnabled()){
                    buttonPressed=4;
                    play();
                    b4.setEnabled(false);
                }else{
                    playerText.setText("Invalid Move!!");
                }
                break;
            case R.id.pos5:
                if(b5.isEnabled()){
                    buttonPressed=5;
                    play();
                    b5.setEnabled(false);
                }else{
                    playerText.setText("Invalid Move!!");
                }
                break;
            case R.id.pos6:
                if(b6.isEnabled()){
                    buttonPressed=6;
                    play();
                    b6.setEnabled(false);
                }else{
                    playerText.setText("Invalid Move!!");
                }
                break;
            case R.id.pos7:
                if(b7.isEnabled()){
                    buttonPressed=7;
                    play();
                    b7.setEnabled(false);
                }else{
                    playerText.setText("Invalid Move!!");
                }

                break;
            case R.id.pos8:
                if(b8.isEnabled()){
                    buttonPressed=8;
                    play();
                    b8.setEnabled(false);
                }else{
                    playerText.setText("Invalid Move!!");
                }

                break;
            case R.id.pos9:
                if(b9.isEnabled()){
                    buttonPressed=9;
                    play();
                    b9.setEnabled(false);
                }else{
                    playerText.setText("Invalid Move!!");
                }
                break;
        }
    }


}
