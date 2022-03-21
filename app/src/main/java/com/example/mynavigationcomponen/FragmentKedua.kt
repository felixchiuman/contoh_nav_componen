package com.example.mynavigationcomponen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.mynavigationcomponen.databinding.FragmentKeduaBinding
import com.example.mynavigationcomponen.databinding.FragmentPertamaBinding


class FragmentKedua : Fragment() {

    private var _binding: FragmentKeduaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKeduaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToFragmentKeTiga.setOnClickListener {
            if (binding.etName.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Kolom nama masih kosong", Toast.LENGTH_SHORT).show()
            }else{
                val actionToFragmentKetiga = FragmentKeduaDirections.actionFragmentKeduaToFragmentKetiga(binding.etName.text.toString())
                it.findNavController().navigate(actionToFragmentKetiga)
            }
        }
        val aName = arguments?.getString(fragmentPertama.EXTRA_NAME)

        binding.tvNama.text = "Nama kamu : $aName"
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null}
}