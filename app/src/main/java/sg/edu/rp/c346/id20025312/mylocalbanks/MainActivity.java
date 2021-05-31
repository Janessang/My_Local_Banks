package sg.edu.rp.c346.id20025312.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvDbs;
    TextView tvOcbc;
    TextView tvUob;

    String bankClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.textViewDBS);
        tvOcbc = findViewById(R.id.textViewOCBC);
        tvUob = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDbs.setText("DBS");
            tvOcbc.setText("OCBC");
            tvUob.setText("UOB");
            return true;

        } else if (id == R.id.chineseSelection) {
            tvDbs.setText("星展银行");
            tvOcbc.setText("华侨银行");
            tvUob.setText("大华银行");
            return true;

        } else {
            tvDbs.setText("Error");
            tvOcbc.setText("Error");
            tvUob.setText("Error");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_sub, menu);

        if (v == tvDbs) {
            bankClicked = "dbs";

        } else if (v == tvOcbc) {
            bankClicked = "ocbc";

        } else if (v == tvUob) {
            bankClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (bankClicked.equalsIgnoreCase("dbs")) {
            if (id == R.id.websiteSelection) {
                Intent intentWeb = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);

            } else if (id == R.id.callSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbsNum)));
                startActivity(intentCall);
            }

        } else if (bankClicked.equalsIgnoreCase("ocbc")) {
            if (id == R.id.websiteSelection) {
                Intent intentWeb = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);

            } else if (id == R.id.callSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbcNum)));
                startActivity(intentCall);
            }

        } else if (bankClicked.equalsIgnoreCase("uob")) {
            if (id == R.id.websiteSelection) {
                Intent intentWeb = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);

            } else if (id == R.id.callSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uobNum)));
                startActivity(intentCall);
            }
        }

        return super.onOptionsItemSelected(item);

    }
}