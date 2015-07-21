package twitter.mobimedia.com.twitteranimationnn.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import twitter.mobimedia.com.twitteranimationnn.R;
import twitter.mobimedia.com.twitteranimationnn.ui.HomeActivity;
import twitter.mobimedia.com.twitteranimationnn.ui.ResetPassword;

/**
 * Created by RAM on 7/18/2015.
 */
public class logintab extends Fragment {
    private TextView mTextForgot;
    private EditText mpasswordid;
    private TextView mforgotpassword;
    private ImageView mnextarrow;
    private boolean nextarrowshow = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login, container, false);
        mforgotpassword = (TextView) v.findViewById(R.id.forgotpassword);
        mnextarrow = (ImageView) v.findViewById(R.id.nextarrow);

        mnextarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextClick();

            }
        });


        mpasswordid = (EditText) v.findViewById(R.id.passwordid);

        mpasswordid.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                ClickonDone();
                return false;
            }
        });

        mpasswordid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mforgotpassword.setVisibility(View.INVISIBLE);
                mnextarrow.setVisibility(View.VISIBLE);
                nextarrowshow = false;
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mpasswordid.length() == 0) {
                    mforgotpassword.setVisibility(View.VISIBLE);
                    mnextarrow.setVisibility(View.INVISIBLE);
                }
            }
        });


        mTextForgot = (TextView) v.findViewById(R.id.forgotpassword);
        mTextForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_password = new Intent(getActivity(), ResetPassword.class);
                startActivity(intent_password);

            }
        });


        return v;
    }

    private void onNextClick() {
        ClickonDone();

    }

    private void ClickonDone() {
        Intent intent_home = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent_home);
    }
}