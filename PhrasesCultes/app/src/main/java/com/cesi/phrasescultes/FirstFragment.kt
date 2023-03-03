package com.cesi.phrasescultes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBindings
import com.cesi.phrasescultes.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        // Récupérer les phrases cultes depuis Strings.xml puis les afficher
        var phrasesCultesListe : ArrayList<String> = arrayListOf<String>()
        phrasesCultesListe.addAll(resources.getStringArray(R.array.phrases_cultes))

        // Récupérer la référence vers le Text View créé et y afficher une phrase culte aléatoire
        var textview = binding.phraseCulteTextview
        textview.setText(phrasesCultesListe.random())

        // Récupérer la référence vers le bouton aléatoire créé
        // et y afficher une autre phrase culte aléatoire et changer la couleur
        var clique = false
        var boutonAleatoire = binding.randomPhraseButton
        boutonAleatoire.setOnClickListener{
            textview.setText(phrasesCultesListe.random())
            clique = !clique
            if(clique) {
                boutonAleatoire.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.bouton_aleatoire_1))
            }  else {
                boutonAleatoire.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.bouton_aleatoire_2))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}