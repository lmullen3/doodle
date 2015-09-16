
package com.example.lawrencemullen.doodle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @author Lawrence Mullen and Maddie Chilli CSC 303 - Fall 2015
 */


public class LinePainterActivity extends AppCompatActivity {

    private DoodleView doodleView;

    public final static int WIDTH_DIALOG = 1;
    public final static int COLOR_DIALOG = 2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_painter);
        doodleView = (DoodleView) findViewById(R.id.doodleview);

    }
    public void onClear(View view){
    doodleView.clearArray();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_line_painter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_set_width) {
            // start the Set Width dialog - pass the current pen width
            Intent intent = new Intent(this, SetWidthDialogActivity.class);
            intent.putExtra("width", doodleView.getLineWidth());
            startActivityForResult(intent, WIDTH_DIALOG);
            return true;
        }
        if (id == R.id.action_set_color) {

            // start the Set Color dialog - pass the current pen color
            Intent intent = new Intent(this, SetColorActivity.class);
            intent.putExtra("alpha", doodleView.getAlphaValue());
            intent.putExtra("red", doodleView.getRedValue());
            intent.putExtra("green", doodleView.getGreenValue());
            intent.putExtra("blue", doodleView.getBlueValue());
            startActivityForResult(intent, COLOR_DIALOG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == WIDTH_DIALOG) {
            if (resultCode == RESULT_OK) {
                // get the new line width and tell the DoodleView
                int width = data.getIntExtra("width", doodleView.getLineWidth());

                doodleView.setLineWidth(width);
            }
        }


        if (requestCode == COLOR_DIALOG) {
            if (resultCode == RESULT_OK) {
                // get the new line color and tell the DoodleView
                int alpha = data.getIntExtra("alpha", DoodleView.DEFAULT_COLOR);
                int red = data.getIntExtra("red", DoodleView.DEFAULT_COLOR);
                int green = data.getIntExtra("green", DoodleView.DEFAULT_COLOR);
                int blue = data.getIntExtra("blue", DoodleView.DEFAULT_COLOR);

                doodleView.setColor(alpha, red, green, blue);

            }
        }
        }

    }

