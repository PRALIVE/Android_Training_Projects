package com.example.screens

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class SignIn : Fragment() {

    public lateinit var emailfield : EditText
    public lateinit var passfield : EditText
    public lateinit var email : String
    public lateinit var password : String
    private val emailPattern = "^[\\w-_.+]*[\\w-_.]@([\\w-]+\\.)+[\\w]+[\\w]\$"


    private val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_sign_in, container, false)
        emailfield = view.findViewById(R.id.email)
        passfield = view.findViewById(R.id.password)
        email  = emailfield.getText().toString()
        password = passfield.getText().toString()

        emailfield.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // This method is called when the text is changed.
                if (charSequence.length > 0) {
                    // User has started entering text.
                    // Do something here...
                    validemail(charSequence.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })

        passfield.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val c :String = "ram"
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // This method is called when the text is changed.
                if (charSequence.length > 0) {
                    // User has started entering text.
                    // Do something here...
                    validpassword(charSequence.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                val d :String = "ram"
            }
        })
        return view;
    }

    fun validemail(email : String){
       if(email.matches(emailPattern.toRegex())){
           emailfield.setBackgroundResource(R.drawable.green_border)
           //emaillayout.setBackgroundResource(R.drawable.green_border)
               Log.d("email","email is valid")
       }else{
           emailfield.setBackgroundResource(R.drawable.red_border)
           //emaillayout.setBackgroundResource(R.drawable.red_border)
           Log.d("email","email is invalid")
       }
    }

    fun validpassword(password : String){
        if(password.matches(passwordRegex.toRegex())){
            passfield.setBackgroundResource(R.drawable.green_border)
            Log.d("password","password is valid")
        }else{
            passfield.setBackgroundResource(R.drawable.red_border)
            Log.d("password","password is invalid")
        }
    }
}