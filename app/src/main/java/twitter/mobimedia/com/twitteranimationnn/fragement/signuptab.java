package twitter.mobimedia.com.twitteranimationnn.fragement;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import twitter.mobimedia.com.twitteranimationnn.R;
import twitter.mobimedia.com.twitteranimationnn.utility.Validation;

/**
 * Created by RAM on 7/18/2015.
 */
public class signuptab extends Fragment {
    private TextView mnexttext;
    private EditText mEnterid;
    private TextView mLIne;
    private boolean nexttextshow = true;
    private RelativeLayout mhiddennext;
    private ProgressBar mProgressbar;
    private String mEmailValidate = "";
    final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Animatebackground mAnimatebackground;


    public interface Animatebackground {
        public void ChangeBackgroundstate();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

            mAnimatebackground = (Animatebackground) activity;

        } catch (Exception e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.signup, container, false);
        mhiddennext = (RelativeLayout) v.findViewById(R.id.hiddennext);
        mEnterid = (EditText) v.findViewById(R.id.enterid);
        mnexttext = (TextView) v.findViewById(R.id.nexttext);
        mLIne = (TextView) v.findViewById(R.id.line);
        mProgressbar = (ProgressBar) v.findViewById(R.id.progressbar);


        mnexttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  String email = mEnterid.getText().toString().trim();

                setAnimationCall();


                //   mnexttext.setVisibility(View.INVISIBLE);
                // mProgressbar.setVisibility(View.VISIBLE);
                //  mEmailValidate = ValidateEmailID(email);

/*
                if (mEmailValidate.length() == 0) {

                } else {

                    mEnterid.setText("Add your Full Name(optional)");
*/

                //   mProgressbar.setVisibility(View.INVISIBLE);

                //  ValidateEmailIdPattern(email, emailPattern);
//                }

                //  CheckForINternetConnection();

            }
        });


        mEnterid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mnexttext.setVisibility(View.VISIBLE);
                mLIne.setVisibility(View.VISIBLE);
                nexttextshow = false;
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mEnterid.length() == 0) {
                    mLIne.setVisibility(View.INVISIBLE);
                    mnexttext.setVisibility(View.INVISIBLE);

                } else {

                }

            }
        });


        return v;
    }

    private String ValidateEmailID(String email) {
        String message = "";
        Validation validation = new Validation();
        message = validation.signUpValidation(email);
        return message;
    }

    private void ValidateEmailIdPattern(final String email, final String emailPattern) {
        //  final String invalidmessage="";
        mEnterid.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (email.matches(emailPattern) && s.length() > 0) {
                    Toast.makeText(getActivity(), "valid email address", Toast.LENGTH_SHORT).show();
                    // or
                    //  textView.setText("valid email");

                } else {
                    Toast.makeText(getActivity(), "Invalid email address", Toast.LENGTH_SHORT).show();
                    // textView.setText("invalid email");
                    //   invalidmessage="Invalid email address";
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });

    }

    private void setAnimationCall() {
        mAnimatebackground.ChangeBackgroundstate();

    }

    private void CheckForINternetConnection() {


    }

    private void ShownextText() {
        mnexttext.setVisibility(View.VISIBLE);
        mLIne.setVisibility(View.VISIBLE);
        nexttextshow = false;
    }
}
