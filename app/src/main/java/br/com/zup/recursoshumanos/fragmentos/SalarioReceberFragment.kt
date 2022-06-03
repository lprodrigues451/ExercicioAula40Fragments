package br.com.zup.recursoshumanos.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.recursoshumanos.R
import br.com.zup.recursoshumanos.databinding.FragmentSalarioReceberBinding


class SalarioReceberFragment(val nomeInformado: String,val horasInrformada: Double , val valorInformado: Double) : Fragment() {
    private lateinit var binding: FragmentSalarioReceberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSalarioReceberBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mostrarResultado()

        binding.botaoVoltar.setOnClickListener {
            mudarFragment()
        }

        }

    private fun mostrarResultado(){
        binding.nomeUsuario.text = nomeInformado
        binding.horas.text = "Horas trabalhadas: $horasInrformada H"
        binding.valorHoras.text = "Valor por hora: R$ $valorInformado"
        binding.salarioReceberFinal.text = "Salário a receber: R$ ${calcularValor()}"
    }

    private fun calcularValor():Double{
        val valorFinal = valorInformado * horasInrformada
        return valorFinal
    }

   private fun mudarFragment(){
        val newFragment = CadastroDeInformacoesFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.layoutFragmeto, newFragment)
        transaction.commit()
    }
}