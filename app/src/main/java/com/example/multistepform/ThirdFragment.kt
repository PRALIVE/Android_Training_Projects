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
import com.example.multistepform.databinding.FragmentThirdBinding
import com.example.multistepform.datamodels.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ThirdFragment(val User : User, val roomDao : UserDao) : Fragment(), ValidateInfo {

//    lateinit var addressLine1 :EditText
//    lateinit var addressLine2 : EditText
//    lateinit var addressLine3 : EditText
    lateinit var binding: FragmentThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("oncreateviewf3","onCreateView is invoked on fragment 3")
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_third,container,false)
        binding.user = User
//        val view:View =  inflater.inflate(R.layout.fragment_third, container, false)
//
//        addressLine1 = view.findViewById(R.id.add1)
//        addressLine2 = view.findViewById(R.id.add2)
//        addressLine3 = view.findViewById(R.id.add3)
//        addressLine1.setText(user.address1)
//        addressLine2.setText(user.address2)
//        addressLine3.setText(user.address3)

        binding.add1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    User.address1 = charSequence.toString()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomDao.updateUser(User)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })

        binding.add2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    User.address2 = charSequence.toString()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomDao.updateUser(User)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
                val a :String = "ram"
            }
        })

        binding.add3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val b :String = "ram"
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    User.address3 = charSequence.toString()
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
        return true
    }

    override fun updateAllFields() {
        User.address1 = ""
        User.address2 = ""
        User.address3 = ""
        binding.add1.setText("")
        binding.add2.setText("")
        binding.add3.setText("")
    }
}