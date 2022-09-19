package com.zahirar.studikasussharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.zahirar.studikasussharedpreferences.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences("dataUser", Context.MODE_PRIVATE)

        var getDataUsername = sharedPref.getString("username", "")
        binding.tvFullname.text = "Hai $getDataUsername"

        binding.btnLogout.setOnClickListener {
            var pref = sharedPref.edit()
            pref.clear()
            pref.apply()
            Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }
}