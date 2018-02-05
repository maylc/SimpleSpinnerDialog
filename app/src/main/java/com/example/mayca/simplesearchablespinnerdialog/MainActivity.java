package com.example.mayca.simplesearchablespinnerdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mayca.simplesearchablespinnerdialog.model.User;
import com.example.mayca.simplesearchablespinnerdialog.spinner.OnSpinnerItemClick;
import com.example.mayca.simplesearchablespinnerdialog.spinner.SimpleSpinnerDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<User>();
    SimpleSpinnerDialog gsd;
    TextView userName;
    TextView userId;
    TextView userEmail;
    TextView userPos;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***************************************************************************************/

        userName  = (TextView)findViewById(R.id.name);
        userId    = (TextView)findViewById(R.id.id);
        userEmail = (TextView)findViewById(R.id.email);
        userPos   = (TextView)findViewById(R.id.position);
        button    = (Button) findViewById(R.id.button);

        /***************************************************************************************/
        /** Example **/

        populateUserArrayList();

        gsd = new SimpleSpinnerDialog(MainActivity.this,users,"Simple Spinner Dialog Example");

        gsd.bindOnSpinerListener(new OnSpinnerItemClick()
        {
            @Override
            public void onClick(Object item, int position)
            {
                User selected = (User) item;

                userPos.setText("Position: " + position);
                userName.setText("Name: " + selected.getName());
                userId.setText("ID: " + String.valueOf(selected.getId()));
                userEmail.setText("Email: " + selected.getEmail());

            }
        });

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                gsd.show();
            }
        });
    }

    private void populateUserArrayList()
    {
        User user1 = new User(2, "Jon Snow", "jon@mail.com");
        User user2 = new User(7, "Daenerys", "dani@mail.com");
        User user3 = new User(1, "Cersei", "cersei@mail.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }
}
