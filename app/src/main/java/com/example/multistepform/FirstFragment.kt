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
import androidx.databinding.DataBindingUtil
import com.example.multistepform.database.UserDao
import com.example.multistepform.databinding.FragmentFirstBinding
import com.example.multistepform.datamodels.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstFragment(val User : User, val roomDao : UserDao ) : Fragment(), ValidateInfo {
//    lateinit var firstNameField : EditText
//    lateinit var secondNameField: EditText
    lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("oncreateview","onCreateView is invoked on fragment 1")
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        binding.user = User

        //maintaining firstname field
        binding.firstname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    User.firstName = charSequence.toString()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomDao.updateUser(User)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })

        //maintaining secondname field
        binding.secondname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    User.secondName = charSequence.toString()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomDao.updateUser(User)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })
        return binding.root
    }

    override fun isValid() : Boolean{
        if(User.firstName != "" && User.secondName!= ""){
            binding.firstname.setBackgroundResource(R.drawable.border_field)
            binding.secondname.setBackgroundResource(R.drawable.border_field)
            return true
        }else{
            if(User.firstName == ""){
                binding.firstname.setBackgroundResource(R.drawable.error_border)
            }else{
                binding.firstname.setBackgroundResource(R.drawable.border_field)
            }
            if(User.secondName == "") {
                binding.firstname.setBackgroundResource(R.drawable.error_border)
            }else{
                binding.secondname.setBackgroundResource(R.drawable.border_field)
            }
            return false
        }
    }

    override fun updateAllFields() {
        User.firstName = ""
        User.secondName = ""
        binding.firstname.setText("")
        binding.secondname.setText("")
    }
}