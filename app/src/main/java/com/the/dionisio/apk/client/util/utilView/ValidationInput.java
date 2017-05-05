package com.the.dionisio.apk.client.util.utilView;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import com.the.dionisio.apk.client.R;

/**
 * Created by igorm on 03/05/2017.
 */

public class ValidationInput
{
    public Boolean emptyInput(EditText editText, TextInputLayout textInputLayout)
    {
        final int inputEmail = 33,
                  inputBirth = 20,
                  inputName = 97,
                  inputPassword = 129;

        if(editText.getText().toString().trim().isEmpty())
        {
            switch (editText.getInputType())
            {
                case inputName:
                    textInputLayout.setError(editText.getResources().getString(R.string.field_nameFull));
                    break;
                case inputEmail:
                    textInputLayout.setError(editText.getResources().getString(R.string.field_email));
                    break;
                case inputPassword:
                    textInputLayout.setError(editText.getResources().getString(R.string.field_password));
                    break;
                case inputBirth:
                    textInputLayout.setError(editText.getResources().getString(R.string.field_birth));
                    break;
            }

            textInputLayout.setErrorEnabled(true);
            editText.setError(editText.getResources().getString(R.string.field_required));

            editText.requestFocus();
            return false;
        }
        else if(editText.getInputType() == 33)
        {
            if(!isValidEmail(editText))
            {
                textInputLayout.setError(editText.getResources().getString(R.string.field_email));
                textInputLayout.setErrorEnabled(true);

                editText.setError(editText.getResources().getString(R.string.field_required));

                editText.requestFocus();
                return false;
            }
        }

        editText.setError(null);
        textInputLayout.setErrorEnabled(false);
        return true;
    }

    private Boolean isValidEmail(EditText editText)
    {
        String email = editText.getText().toString().trim();

        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
