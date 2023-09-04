package com.netset.fitness.fragments

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.Drawable
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
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.netset.fitness.R
import com.netset.fitness.databinding.FragmentRegisterBinding
import com.netset.fitness.utils.CommonFunction


class RegisterFragment : Fragment() {
   private lateinit var binding: FragmentRegisterBinding

    private var isPasswordVisible = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.registerButton.setOnClickListener {

            CommonFunction.openFragment(requireActivity().supportFragmentManager,RegisterUserDetailsFragment(),R.id.registerContainer,true)
        }


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



        val spannable = SpannableString("By continuing you accept our Privacy Policy and \nTerm of Use")

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {



            }
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(requireContext(), R.color.hintColor)
                ds.isUnderlineText = true
            }
        }

        val clickableSpan2 = object : ClickableSpan() {
            override fun onClick(widget: View) {
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(requireContext(), R.color.hintColor)
                ds.isUnderlineText = true
            }
        }

        val startIndex = spannable.indexOf("Privacy Policy")
        val endIndex = startIndex + "Privacy Policy".length

        val startIndexTerms = spannable.indexOf("Term of Use")
        val endIndexTerms = startIndexTerms + "Term of Use".length

        spannable.setSpan(clickableSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.termsAndConditionText.text = spannable
        binding.termsAndConditionText.highlightColor = Color.TRANSPARENT
        binding.termsAndConditionText.movementMethod = LinkMovementMethod.getInstance()

        spannable.setSpan(clickableSpan2, startIndexTerms, endIndexTerms, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.termsAndConditionText.text = spannable
        binding.termsAndConditionText.highlightColor = Color.TRANSPARENT
        binding.termsAndConditionText.movementMethod = LinkMovementMethod.getInstance()
            spanableString()

    }



    private fun spanableString() {
        val loginSpannable = SpannableString("Already have an account? Login")

        val loginClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {

                CommonFunction.openFragment(requireActivity().supportFragmentManager,LoginFragment(),R.id.registerContainer,true)

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

        val startIndex = loginSpannable.indexOf("Login")
        val endIndex = startIndex + "Login".length

        loginSpannable.setSpan(loginClickableSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.alreadyAccount.text = loginSpannable
        binding.alreadyAccount.highlightColor = Color.TRANSPARENT
        binding.alreadyAccount.movementMethod = LinkMovementMethod.getInstance()

    }
}