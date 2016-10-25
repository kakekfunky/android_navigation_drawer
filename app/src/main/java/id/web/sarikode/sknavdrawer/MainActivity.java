package id.web.sarikode.sknavdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // inisialisasi widget
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sambungkan ke object wodget  di layout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);

        // setting toolbarnya
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Judul");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);


        // action ketika salah satu menunya di klik
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // tutup drawernya
                drawerLayout.closeDrawers();

                // tampilkan apa yang di klik
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        getSupportActionBar().setTitle("HOME");
                        Toast.makeText(getApplicationContext(), "home di klik", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_setting:
                        getSupportActionBar().setTitle("SETTING");
                        Toast.makeText(getApplicationContext(), "setting di klik", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // handler ketika hamburger icon nya di klik
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
