package lucassamel.br.tp3_kotlinandroid.model

import com.google.firebase.firestore.DocumentId

class Carro(
    @DocumentId
    val modelo: String? = null,
    val marca: String? = null,
    val ano: String? = null,
    val preco: String? = null
) {

}