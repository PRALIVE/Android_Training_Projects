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

class firstFragment(val user : User, val roomdao : UserDao ) : Fragment(), MyFragment {
    lateinit var firstnamefield : EditText
    lateinit var secondnamefield: EditText

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
        firstnamefield = view.findViewById(R.id.firstname)
        secondnamefield = view.findViewById(R.id.secondname)
        firstnamefield.setText(user.firstname)
        secondnamefield.setText(user.secondname)

        //maintaining firstname field
        firstnamefield.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    user.firstname = charSequence.toString()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomdao.updateUser(user)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })

        //maintaining secondname field
        secondnamefield.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    user.secondname = charSequence.toString()
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

    override fun saveinfo() : Boolean{
        if(user.firstname != "" && user.secondname!= ""){
            firstnamefield.setBackgroundResource(R.drawable.border_field)
            secondnamefield.setBackgroundResource(R.drawable.border_field)
            return true
        }else{
            if(user.firstname == ""){
                firstnamefield.setBackgroundResource(R.drawable.error_border)
            }else{
                firstnamefield.setBackgroundResource(R.drawable.border_field)
            }
            if(user.secondname == "") {
                secondnamefield.setBackgroundResource(R.drawable.error_border)
            }else{
                secondnamefield.setBackgroundResource(R.drawable.border_field)
            }
            return false
        }
    }

    override fun updateallfiels() {
        user.firstname = ""
        user.secondname = ""
        firstnamefield.setText("")
        secondnamefield.setText("")
    }
}