package com.example.extremetech.gastrotec;

import android.content.SharedPreferences;
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
    public SharedPreferences mPrefs;


    /**
     * constructor
     */
    UserLoginTask() {

    }

    /**
     * método par iniciar sesión
     *
     * @param id
     * @param password
     * @return true si si funcionó, null si hubo error, wrong si la contraseña es incorrecta
     */
    public String LoginTask(String id, String password) {
        //call database
        String retValue = "";
        mDataBase = new DataBaseHelper(LoginActivity.getmContext());
        Cursor student = mDataBase.getStudent(Integer.parseInt(id));
        if (student.isNull(0)) {
            retValue = "null";
        } else if (!password.equals(student.getString(4))) {
            retValue = "wrong";
        } else {
            //create student
            mStudent = new Student(student.getString(1), student.getString(3),
                    Integer.parseInt(student.getString(0)), student.getString(2),
                    Integer.parseInt(student.getString(5)));
            Log.d("usuario", student.getString(0));
            retValue = "true";
        }
        return retValue;
    }

    /**
     * registra un nuevo usuario
     *
     * @param id
     * @param name
     * @param email
     * @param career
     * @param password
     * @return el nuevo student
     */
    public Student UserRegisterTask(String id, String name, String email, String career, String password) {
        boolean addStudent = mDataBase.addStudent(name, career, id, email, password); // you would not typically call this on the main thread
        Log.d("insert student", String.valueOf(addStudent));
        if (!addStudent) {
            Toast.makeText(LoginActivity.getmContext(), "@strings/error_invalid", Toast.LENGTH_SHORT).show();
        } else {
            mStudent = new Student(name, career, Integer.parseInt(id), email, 1);
        }

        return mStudent;
    }


    @Override
    protected Boolean doInBackground(Void... params) {
        /*//

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

        // */
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