package com.the.dionisio.apk.client.util.utilView;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import com.the.dionisio.apk.client.R;

/**
 * Created by igorm on 03/05/2017.
 */

public class ValidationInput
{
    public Boolean emptyInput(EditText editText, TextInputLayout textInputLayout)
    {
        if(editText.getText().toString().trim().isEmpty())
        {
            switch (editText.getId())
            {
                case R.id.inputNameFullCreateAccount:
                    editText.setError(editText.getResources().getString(R.string.field_nameFull));
                    break;
                case R.id.inputEmailCreateAccount:
                    editText.setError(editText.getResources().getString(R.string.field_email));
                    break;
                case R.id.inputPasswordCreateAccount:
                    editText.setError(editText.getResources().getString(R.string.field_password));
                    break;
                case R.id.inputBirthCreateAccount:
                    editText.setError(editText.getResources().getString(R.string.field_birth));
                    break;
                case R.id.inputEmailLogin:
                    editText.setError(editText.getResources().getString(R.string.field_email));
                    break;
                case R.id.inputPasswordLogin:
                    editText.setError(editText.getResources().getString(R.string.field_password));
                    break;
                case R.id.inputEmailForgotPassword:
                    editText.setError(editText.getResources().getString(R.string.field_email));
                    break;
            }

            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError(editText.getResources().getString(R.string.field_required));

            editText.requestFocus();
            return false;
        }

        editText.setError(null);
        textInputLayout.setErrorEnabled(false);
        return true;
    }
}
