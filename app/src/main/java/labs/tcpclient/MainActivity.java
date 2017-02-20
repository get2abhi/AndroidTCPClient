package labs.tcpclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send = ((Button)findViewById(R.id.send));
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ip = ((EditText)findViewById(R.id.ip)).getText().toString();
                String port = ((EditText)findViewById(R.id.port)).getText().toString();
                String message = ((EditText)findViewById(R.id.message)).getText().toString();
                new SendMessage().execute(ip, port, message);
            }
        });
    }
}
