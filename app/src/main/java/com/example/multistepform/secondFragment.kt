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

class secondFragment(val user : User, val roomdao : UserDao) : Fragment(), MyFragment {
    lateinit var emailview : EditText
    lateinit var phoneview  :EditText
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
        emailview = view.findViewById(R.id.email)
        phoneview = view.findViewById(R.id.phone)
        emailview.setText(user.email)
        phoneview.setText(user.phone)

        emailview.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    user.email = charSequence.toString()
                    validemail(charSequence.toString())
                    CoroutineScope(Dispatchers.IO).launch{
                        roomdao.updateUser(user)
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })

        phoneview.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    user.phone = charSequence.toString()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomdao.updateUser(user)
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
            emailview.setBackgroundResource(R.drawable.border_field)
            return true
        }else{
            emailview.setBackgroundResource(R.drawable.error_border)
            return false
        }
    }

    override fun saveinfo():Boolean{
        if(validemail(user.email) && user.phone !=""){
            phoneview.setBackgroundResource(R.drawable.border_field)
            return true
        }else{
            if(user.phone==""){
                phoneview.setBackgroundResource(R.drawable.error_border)
            }
            return false
        }
    }

    override fun updateallfiels() {
        user.email = ""
        user.phone = ""
        emailview.setText("")
        phoneview.setText("")
    }
}