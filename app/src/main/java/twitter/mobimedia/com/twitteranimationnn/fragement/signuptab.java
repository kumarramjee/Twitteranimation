package twitter.mobimedia.com.twitteranimationnn.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.signup, container, false);
        mhiddennext = (RelativeLayout) v.findViewById(R.id.hiddennext);
        mEnterid = (EditText) v.findViewById(R.id.enterid);
        mnexttext = (TextView) v.findViewById(R.id.nexttext);
        mLIne = (TextView) v.findViewById(R.id.line);


        mnexttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mnexttext.setVisibility(View.INVISIBLE);
                View child = getActivity().getLayoutInflater().inflate(R.layout.addnexttextview, null);
                mhiddennext.addView(child);


                ValidateEmailID();

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

                }

            }
        });


        return v;
    }

    private void ValidateEmailID() {

        final String email = mEnterid.getText().toString().trim();
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Validation validation = new Validation();
        String message = validation.signUpValidation(email);

        if (message.length() == 0) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        } else {
            ValidateEmailIdPattern(email, emailPattern);
        }

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
                    //or
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

    private void AddViewToNextView() {
        /*View child = getFragmentManager().LayoutInflater().getLA.inflate(R.layout.addnexttextview, null);
        mhiddennext.addView(child);
*/
    }

    private void CheckForINternetConnection() {


    }

    private void ShownextText() {
        mnexttext.setVisibility(View.VISIBLE);
        mLIne.setVisibility(View.VISIBLE);
        nexttextshow = false;
    }
}
