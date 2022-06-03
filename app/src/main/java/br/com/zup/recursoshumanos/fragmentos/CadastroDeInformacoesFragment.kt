package br.com.zup.recursoshumanos.fragmentos

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.zup.recursoshumanos.FragmentoClick
import br.com.zup.recursoshumanos.MainActivity
import br.com.zup.recursoshumanos.R
import br.com.zup.recursoshumanos.databinding.FragmentCadastroDeInformacoesBinding


class CadastroDeInformacoesFragment : Fragment() {
    private lateinit var binding: FragmentCadastroDeInformacoesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroDeInformacoesBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botaoCalcular.setOnClickListener {
           enviarDadosProdutos()
        }
    }

    private fun enviarDadosProdutos(){
        val nome = binding.editTextPersonName.text.toString()
        val horasTrabalhada = binding.editTextPersonHoras.text.toString()
        val valorHoras = binding.editTextPersonValor.text.toString()

        if (nome.isNotEmpty() && horasTrabalhada.isNotEmpty() && valorHoras.isNotEmpty() ) {
            mudarFragment(nome, horasTrabalhada.toDouble(), valorHoras.toDouble())
        } else {
            binding.editTextPersonName.error = "Campo obrigatorio!"
            binding.editTextPersonHoras.error = "Campo obrigatorio!"
            binding.editTextPersonValor.error = "Campo obrigatorio!"
        }
    }

    fun mudarFragment(nome: String,horasTrabalhada: Double, valorHoras:Double ){
        val newFragment = SalarioReceberFragment(nome, horasTrabalhada, valorHoras)
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.layoutFragmeto, newFragment)
        transaction.commit()
    }

    }

