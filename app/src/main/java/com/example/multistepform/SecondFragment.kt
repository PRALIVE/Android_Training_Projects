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

class SecondFragment(val user : User, val roomDao : UserDao) : Fragment(), ValidateInfo {
    lateinit var emailView : EditText
    lateinit var phoneView  :EditText
    private val emailPattern = "^[\\w-_.+]*[\\w-_.]@([\\w-]+\\.)+[\\w]+[\\w]\$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("oncreateview","onCreateView is invoked on fragment 2")
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_second, container, false)
        emailView = view.findViewById(R.id.email)
        phoneView = view.findViewById(R.id.phone)
        emailView.setText(user.email)
        phoneView.setText(user.phone)

        emailView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    user.email = charSequence.toString()
                    validemail(charSequence.toString())
                    CoroutineScope(Dispatchers.IO).launch{
                        roomDao.updateUser(user)
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })

        phoneView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    user.phone = charSequence.toString()
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

    fun validemail(email : String) : Boolean{
        if(email.matches(emailPattern.toRegex())){
            emailView.setBackgroundResource(R.drawable.border_field)
            return true
        }else{
            emailView.setBackgroundResource(R.drawable.error_border)
            return false
        }
    }

    override fun isValid():Boolean{
        if(validemail(user.email) && user.phone !=""){
            phoneView.setBackgroundResource(R.drawable.border_field)
            return true
        }else{
            if(user.phone==""){
                phoneView.setBackgroundResource(R.drawable.error_border)
            }
            return false
        }
    }

    override fun updateAllFields() {
        user.email = ""
        user.phone = ""
        emailView.setText("")
        phoneView.setText("")
    }
}