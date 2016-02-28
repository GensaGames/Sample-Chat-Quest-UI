package example.genka.fosquest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Genka on 27.10.2015.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupLoginAction();

        /** Just simulate simple progress
         * and remove freezing from setting
         * Drawable
         * TODO: Simulate progress and remove freezing
         * */

    }

    public void setupLoginAction() {
        Button loginButt = (Button) findViewById(R.id.button_login);
        loginButt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity( new Intent(this, MainActivity.class));
    }
}
