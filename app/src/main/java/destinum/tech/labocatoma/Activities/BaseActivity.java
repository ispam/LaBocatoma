package destinum.tech.labocatoma.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import destinum.tech.labocatoma.R;

public class BaseActivity extends AppCompatActivity {

    public NavigationView mNavigationView;
    protected ActionBarDrawerToggle mToggle;
    protected Toolbar mToolbar;
    public DrawerLayout mDrawerLayout;
    private Menu mMenu;
    private ImageView mImageProfile;
    private TextView mName, mEmail;
    private FirebaseUser mUser;

    protected void onCreateDrawer() {
        //Instantiate Navigation Drawer
        setupNavDrawer();

    }

    //Set up Navigation Drawer
    private void setupNavDrawer() {

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToolbar =  findViewById(R.id.toolbar_actionbar);
        mNavigationView=  findViewById(R.id.navigation_view);
        mMenu = mNavigationView.getMenu();

//        MenuItem about = mMenu.findItem(R.id.about);
//        SpannableString s =  new SpannableString(about.getTitle());
//        s.setSpan(new TextAppearanceSpan(this, R.style.BlackTextColor), 0, s.length(), 0);
//        about.setTitle(s);

        View hView =  mNavigationView.getHeaderView(0);
        mImageProfile =  hView.findViewById(R.id.image_profile);
        mName =  hView.findViewById(R.id.nav_name);
        mEmail =  hView.findViewById(R.id.nav_email);

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mName.setText(mUser.getDisplayName());
        mEmail.setText(mUser.getEmail());
        Glide.with(this).load(mUser.getPhotoUrl()).into(mImageProfile);

        setSupportActionBar(mToolbar);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(mToggle);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
                mDrawerLayout.closeDrawers();

                item.setChecked(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch (item.getItemId()){

                            case R.id.nav_home:
                                Intent intent = new Intent(BaseActivity.this, HomeActivity.class);
                                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));

                                break;

//                            case R.id.nav_privacy_policy:
//                                intent = new Intent(BaseActivity.this, Policy.class);
//                                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//
//                                break;
//
//                            case R.id.nav_terms:
//                                intent = new Intent(BaseActivity.this, Terms.class);
//                                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//
//                                break;
//
//                            case R.id.nav_profile:
//                                intent = new Intent(BaseActivity.this, Profile.class);
//                                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//
//                                break;


                            default:
                                intent = new Intent(BaseActivity.this, HomeActivity.class);
                                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));

                                break;
                        }
                    }
                }, 225);
                return true;
            }
        });

        setNavigationViewCheckedItem();
    }

    private void setNavigationViewCheckedItem() {
        if (this.getClass().equals(HomeActivity.class)) {
            mNavigationView.setCheckedItem(R.id.nav_home);
        }
//        else if (this.getClass().equals(Policy.class)){
//            mNavigationView.setCheckedItem(R.id.nav_privacy_policy);
//            setTitle(R.string.privacy_policy_link);
//        } else if (this.getClass().equals(Terms.class)){
//            mNavigationView.setCheckedItem(R.id.nav_terms);
//            setTitle(R.string.terms_link);
//        } else if (this.getClass().equals(Profile.class)){
//            mNavigationView.setCheckedItem(R.id.nav_profile);
//            setTitle(R.string.nav_profile);
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (this.getClass().equals(HomeActivity.class)) {
            return false;
        }
//        else if (this.getClass().equals(Policy.class)){
//            return false;
//        } else if (this.getClass().equals(Terms.class)){
//            return false;
//        } else if (this.getClass().equals(Profile.class)){
//            getMenuInflater().inflate(R.menu.menu_main, menu);
//        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.logout) {
//            CredentialsManager.deleteCredentials(this);
//            Intent intent = new Intent(this, Login.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//            finish();
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }
}