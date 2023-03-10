package com.example.multistepform

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.multistepform.database.UserDao
import com.example.multistepform.databinding.FragmentSecondBinding
import com.example.multistepform.datamodels.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondFragment(val User : User, val roomDao : UserDao) : Fragment(), ValidateInfo {
//    lateinit var emailView : EditText
//    lateinit var phoneView  :EditText
    private val emailPattern = "^[\\w-_.+]*[\\w-_.]@([\\w-]+\\.)+[\\w]+[\\w]\$"
    lateinit var binding: FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("oncreateview","onCreateView is invoked on fragment 2")
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false)
        binding.user = User
        // Inflate the layout for this fragment
//        val view:View =  inflater.inflate(R.layout.fragment_second, container, false)
//        emailView = view.findViewById(R.id.email)
//        phoneView = view.findViewById(R.id.phone)
//        emailView.setText(user.email)
//        phoneView.setText(user.phone)

        binding.email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    User.email = charSequence.toString()
                    validemail(charSequence.toString())
                    CoroutineScope(Dispatchers.IO).launch{
                        roomDao.updateUser(User)
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })

        binding.phone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    User.phone = charSequence.toString()
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

    fun validemail(email : String) : Boolean{
        if(email.matches(emailPattern.toRegex())){
            binding.email.setBackgroundResource(R.drawable.border_field)
            return true
        }else{
            binding.email.setBackgroundResource(R.drawable.error_border)
            return false
        }
    }

    override fun isValid():Boolean{
        if(validemail(User.email) && User.phone !=""){
            binding.phone.setBackgroundResource(R.drawable.border_field)
            return true
        }else{
            if(User.phone==""){
                binding.phone.setBackgroundResource(R.drawable.error_border)
            }
            return false
        }
    }

    override fun updateAllFields() {
        User.email = ""
        User.phone = ""
        binding.email.setText("")
        binding.phone.setText("")
    }
}