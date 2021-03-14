package lucassamel.br.tp3_kotlinandroid.ui.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.register_fragment.*
import lucassamel.br.tp3_kotlinandroid.R

class RegisterFragment : Fragment() {


    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it)
                findNavController().popBackStack()
        })

        viewModel.msg.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrBlank())
                Toast
                        .makeText(
                                requireContext(),
                                it,
                                Toast.LENGTH_LONG
                        ).show()

        })

        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCadastrar.setOnClickListener {
            val email = editTextEmailCadastro.text.toString()
            val senha = editTextSenhaCadastro.text.toString()
            val resenha = editTextRepetirSenha.text.toString()
            if (senha == resenha){
                viewModel.salvarCadastro(email,senha)
            } else {
                viewModel.alterarMsg("Senhas não conferem")
            }
        }
    }

}