package labs.tcpclient;

import android.os.AsyncTask;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by abhinav.srivastava on 20/02/17.
 */

public class SendMessage extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String[] params) {
        send(params[0], params[1], params[2]);
        return null;
    }
    void send(String ip, String port, String message){
        try{
            // Creating new socket connection to the IP (first parameter) and its opened port (second parameter)
            Socket s = new Socket(ip, Integer.parseInt(port));
            // Initialize output stream to write message to the socket stream
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            // Write message to stream
            out.write(message);
            // Flush the data from the stream to indicate end of message
            out.flush();
            // Close the output stream
            out.close();
            // Close the socket connection
            s.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
