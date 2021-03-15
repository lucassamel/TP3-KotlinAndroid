package lucassamel.br.tp3_kotlinandroid.ui.carro.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.carro_form_fragment.*
import lucassamel.br.tp3_kotlinandroid.R
import lucassamel.br.tp3_kotlinandroid.dao.CarroDaoFirestore

class CarroFormFragment : Fragment() {

    private lateinit var viewModel: CarroFormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireActivity().application

        val carroFormViewModelFactory = CarroFormViewModelFactory(CarroDaoFirestore(),
        application)

        viewModel = ViewModelProvider(this, carroFormViewModelFactory)
            .get(CarroFormViewModel::class.java)

        viewModel.status.observe(viewLifecycleOwner, Observer { status ->
            if (status)
                findNavController().popBackStack()
        })
        viewModel.msg.observe(viewLifecycleOwner, Observer { msg ->
            if (!msg.isNullOrBlank())
                Toast.makeText(
                        requireContext(),
                        msg,
                        Toast.LENGTH_LONG
                ).show()
        })

        return inflater.inflate(R.layout.carro_form_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCarroCadastro.setOnClickListener {
            val modelo = editTextModelo.text.toString()
            val marca = editTextMarca.text.toString()
            val ano = editTextAno.text.toString()
            val preco = editTextPreco.text.toString()
            viewModel.inserCarro(modelo,marca,ano,preco)
        }
    }

}