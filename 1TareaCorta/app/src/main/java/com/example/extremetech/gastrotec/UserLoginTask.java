package com.example.extremetech.gastrotec;

import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * Represents an asynchronous login/registration task used to authenticate
 * the user.
 */
public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

    private Student mStudent;
    private DataBaseHelper mDataBase;


    UserLoginTask(String id, String password) {
        //call database
        mDataBase = new DataBaseHelper(LoginActivity.getmContext());
        Cursor student = mDataBase.getStudent(Integer.parseInt(id));
        if(student.isNull(0)){
            Toast.makeText(LoginActivity.getmContext(),"@+id/error_invalid_id", Toast.LENGTH_SHORT).show();
        }else {
            //create student
            mStudent = new Student(student.getString(1), student.getString(3),
                    Integer.parseInt(student.getString(0)),student.getString(2),
                    Integer.parseInt(student.getString(5)));
            Log.d("usuario",student.getString(0));
        }
    }

    public Student UserRegisterTask(String id, String name, String email, String career, String password, String type){
        boolean addStudent = mDataBase.addStudent(name, career, id, email, password); // you would not typically call this on the main thread
        Log.d("insert", String.valueOf(addStudent));
        if (!addStudent) {
            Toast.makeText(LoginActivity.getmContext(), "@+id/error_invalid", Toast.LENGTH_SHORT).show();
        }
        else{
            mStudent = new Student(name, career, Integer.parseInt(id), email, Integer.parseInt(type));
        }

        return mStudent;
    }


    @Override
    protected Boolean doInBackground(Void... params) {
        /*// TODO: attempt authentication against a network service.

        try {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return false;
        }

        for (String credential : DUMMY_CREDENTIALS) {
            String[] pieces = credential.split(":");
            if (pieces[0].equals(mEmail)) {
                // Account exists, return true if the password matches.
                return pieces[1].equals(mPassword);
            }
        }

        // TODO: register the new account here.*/
        return true;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        /*LoginActivity.(null);
        showProgress(false);

        if (success) {
            finish();
        } else {
            mPasswordView.setError(getString(R.string.error_incorrect_password));
            mPasswordView.requestFocus();
        }*/
    }

    @Override
    protected void onCancelled() {
        /*mAuthTask = null;
        showProgress(false);*/
    }
}