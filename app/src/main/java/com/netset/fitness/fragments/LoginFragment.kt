package com.netset.fitness.fragments

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.netset.fitness.R
import com.netset.fitness.databinding.FragmentLoginBinding
import com.netset.fitness.utils.CommonFunction


class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {

        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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