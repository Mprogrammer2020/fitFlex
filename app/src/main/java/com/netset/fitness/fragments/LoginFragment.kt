package com.netset.fitness.fragments

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.HideReturnsTransformationMethod
import android.text.method.LinkMovementMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.databinding.FragmentLoginBinding
import com.netset.fitness.utils.CommonFunction


class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding
    private var isPasswordVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {

        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.showHideIcon.setOnClickListener {
            isPasswordVisible = !isPasswordVisible // Toggle the state

            val cursorPosition = binding.passwordEditText.selectionStart

            binding.passwordEditText.transformationMethod = if (isPasswordVisible) {
                PasswordTransformationMethod.getInstance()
            } else {
                HideReturnsTransformationMethod.getInstance()
            }

            binding.passwordEditText.setSelection(cursorPosition)

            val iconResource = if (isPasswordVisible) {
                R.drawable.hide_password // Use your hide icon resource
            } else {
                R.drawable.show_password_icon // Use your show icon resource
            }

            binding.showHideIcon.setImageResource(iconResource)
        }

        binding.loginButton.setOnClickListener {

            val i = Intent(requireContext(), DashBoardActivity::class.java)
            startActivity(i)
            activity?.finish()
        }



        val spannable = SpannableString("Don’t have an account yet? Register")

        val loginClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {

               CommonFunction.openFragment(requireActivity().supportFragmentManager, RegisterFragment(),R.id.registerContainer,false)
            }
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                val shader = LinearGradient(0f, 0f, ds.measureText("Login"), ds.textSize, intArrayOf(
                    ContextCompat.getColor(requireContext(), R.color.purpleStart),
                    ContextCompat.getColor(requireContext(), R.color.purpleEnd)
                ), null, Shader.TileMode.CLAMP)
                ds.shader = shader
                ds.isUnderlineText = false
            }
        }

        val startIndex = spannable.indexOf("Register")
        val endIndex = startIndex + "Register".length

        spannable.setSpan(loginClickableSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.dontAccount.text = spannable
        binding.dontAccount.highlightColor = Color.TRANSPARENT
        binding.dontAccount.movementMethod = LinkMovementMethod.getInstance()


    }
}