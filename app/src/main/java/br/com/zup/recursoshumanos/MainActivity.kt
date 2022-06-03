package br.com.zup.recursoshumanos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import br.com.zup.recursoshumanos.databinding.ActivityMainBinding
import br.com.zup.recursoshumanos.fragmentos.CadastroDeInformacoesFragment

class MainActivity : AppCompatActivity(), FragmentoClick {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(binding.layoutFragmeto.id, CadastroDeInformacoesFragment())
            .commit()
    }


}