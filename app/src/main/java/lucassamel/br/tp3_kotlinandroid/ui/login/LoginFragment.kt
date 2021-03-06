package lucassamel.br.tp3_kotlinandroid.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.login_fragment.*
import lucassamel.br.tp3_kotlinandroid.R

class LoginFragment : Fragment() {


    private lateinit var loginviewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginviewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginviewModel.status.observe(viewLifecycleOwner, Observer {
            if (it){
                findNavController().navigate(R.id.action_loginFragment_to_carroListFragment)
            }
        })

        loginviewModel.msg.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrBlank())
                Toast
                        .makeText(
                                requireContext(),
                                it,
                                Toast.LENGTH_LONG
                        ).show()

        })

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnEntrar.setOnClickListener {
            val email = editTextEmail.text.toString()
            val senha = editTextSenha.text.toString()
            loginviewModel.verificarUsuario(email,senha)
        }
        btnCadastrarse.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}