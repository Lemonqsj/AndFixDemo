package eyesight.kc.com.andfixdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = (TextView) findViewById(R.id.text);
        findViewById(R.id.fix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("i am old");
            }
        });


    }
}
