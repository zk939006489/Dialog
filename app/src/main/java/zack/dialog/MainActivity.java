package zack.dialog;

import android.content.*;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginDialog;
    EditText userName,psw;
    String un,ps;
    LinearLayout log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) this.findViewById(R.id.buttonTest);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("您好！请您登陆！")
                        .setTitle("对话框");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });


        loginDialog = (Button) findViewById(R.id.loginDialog);
        loginDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                log = (LinearLayout)getLayoutInflater().inflate(R.layout.log,null);
                builder.setView(log);
                builder.setTitle("Login");


                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"取消？",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userName = (EditText)log.findViewById(R.id.userName);
                        un = userName.getText().toString();
                        psw = (EditText)log.findViewById((R.id.psw));
                        ps = psw.getText().toString();
                        if(!un.equals("abc")){
                            Toast.makeText(MainActivity.this,"用户名不正确",Toast.LENGTH_SHORT).show();
                        }
                        if(!ps.equals("123")){
                            Toast.makeText(MainActivity.this,"密码不正确",Toast.LENGTH_SHORT).show();
                        }
                        if(un.equals("abc")&&ps.equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.create();
                builder.show();
            }
        });


    }
}
