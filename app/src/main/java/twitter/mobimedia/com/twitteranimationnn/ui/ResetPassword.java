package twitter.mobimedia.com.twitteranimationnn.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

import twitter.mobimedia.com.twitteranimationnn.R;

public class ResetPassword extends Activity implements View.OnClickListener{


    private RelativeLayout mAddSubview;
    private RelativeLayout mAddview;
    private ImageView mbacknavigation;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        setUpUI();
        SetupToolBar();
        mbacknavigation.setOnClickListener(this);
       // setResetPasswordView();


    }

    private void SetupToolBar() {
        mbacknavigation = (ImageView) findViewById(R.id.back_navigation);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        mbacknavigation.setBackground(upArrow);
        mToolbar=(Toolbar)findViewById(R.id.toolbarlay);
    }

    private void setResetPasswordView() {

        for (int i = 0; i <= 2; i++) {
            String userarray[] = {"With Username or Email", "With SMS", "With Facebook"};

            View child = getLayoutInflater().inflate(R.layout.forgotpassword, null);
            ImageView userimage = (ImageView) child.findViewById(R.id.image);
            TextView user = (TextView) child.findViewById(R.id.imagetexxt);
            user.setText(userarray[i]);
            userimage.setImageDrawable(getResources().getDrawable(R.drawable.background));
            mAddview.addView(child);


        }

    }

    private void setUpUI() {
       /* mbacknavigation = (ImageView) findViewById(R.id.back_navigation);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        mbacknavigation.setBackground(upArrow);
*/
        mAddSubview = (RelativeLayout) findViewById(R.id.addsubview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reset_password, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_navigation:
                Intent intent_back=new Intent(ResetPassword.this,MainActivity.class);
                startActivity(intent_back);

                break;
            default:break;
        }
    }
}
