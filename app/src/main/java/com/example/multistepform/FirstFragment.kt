package com.example.multistepform

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.multistepform.database.UserDao
import com.example.multistepform.datamodels.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstFragment(val user : User, val roomDao : UserDao ) : Fragment(), ValidateInfo {
    lateinit var firstNameField : EditText
    lateinit var secondNameField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("oncreateview","onCreateView is invoked on fragment 1")
        val view :View = inflater.inflate(R.layout.fragment_first, container, false)
        firstNameField = view.findViewById(R.id.firstname)
        secondNameField = view.findViewById(R.id.secondname)
        firstNameField.setText(user.firstName)
        secondNameField.setText(user.secondName)

        //maintaining firstname field
        firstNameField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    user.firstName = charSequence.toString()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomDao.updateUser(user)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })

        //maintaining secondname field
        secondNameField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    user.secondName = charSequence.toString()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomDao.updateUser(user)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })
        return view
    }

    override fun isValid() : Boolean{
        if(user.firstName != "" && user.secondName!= ""){
            firstNameField.setBackgroundResource(R.drawable.border_field)
            secondNameField.setBackgroundResource(R.drawable.border_field)
            return true
        }else{
            if(user.firstName == ""){
                firstNameField.setBackgroundResource(R.drawable.error_border)
            }else{
                firstNameField.setBackgroundResource(R.drawable.border_field)
            }
            if(user.secondName == "") {
                secondNameField.setBackgroundResource(R.drawable.error_border)
            }else{
                secondNameField.setBackgroundResource(R.drawable.border_field)
            }
            return false
        }
    }

    override fun updateAllFields() {
        user.firstName = ""
        user.secondName = ""
        firstNameField.setText("")
        secondNameField.setText("")
    }
}