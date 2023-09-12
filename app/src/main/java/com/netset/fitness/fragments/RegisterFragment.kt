package com.netset.fitness.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.HideReturnsTransformationMethod
import android.text.method.LinkMovementMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.ClickableSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.databinding.FragmentRegisterBinding
import com.netset.fitness.utils.CommonFunction


class RegisterFragment : Fragment() {
   private lateinit var binding: FragmentRegisterBinding
    private var googleSignInClient : GoogleSignInClient? = null
    private lateinit var googleSignInLauncher: ActivityResultLauncher<Intent>


    private var isPasswordVisible = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        googleSignInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                handleGoogleSignInResult(data)
            }
        }

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

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                widget.context.startActivity(intent)

            }
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(requireContext(), R.color.hintColor)
                ds.isUnderlineText = true
            }
        }

        val clickableSpan2 = object : ClickableSpan() {
            override fun onClick(widget: View) {

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                widget.context.startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(requireContext(), R.color.hintColor)
                ds.isUnderlineText = true
            }
        }

        binding.googleIcon.setOnClickListener {
            openGoogleSignInEmail()
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

    private fun handleGoogleSignInResult(data: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {

            val account = task.getResult(ApiException::class.java)
            val idToken = account?.idToken
            Log.d("fdsf", idToken.toString())
            val displayName = account?.displayName
            Log.d("fdsf", displayName.toString())
            val email = account?.email
            Log.d("fdsf", email.toString())

            val userImage = account?.photoUrl
            Log.d("fdsf", userImage.toString())

        //    binding.spinKitProgressBar.visibility = View.GONE



        } catch (e: ApiException) {
            // Google Sign-In failed, handle the exception
        }
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

    private fun openGoogleSignInEmail() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
        val signInIntent = googleSignInClient?.signInIntent
        googleSignInLauncher.launch(signInIntent)
    }

}