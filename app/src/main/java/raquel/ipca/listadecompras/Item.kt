package raquel.ipca.listadecompras

import com.google.firebase.firestore.DocumentSnapshot

class Item {

    var id          : String
    var name        : String? = null
    var description : String? = null
    var counter     : Long? = null

    constructor(id : String, name: String?, description: String?, counter: Long?) {
        this.id = id
        this.name = name
        this.description = description
        this.counter = counter
    }

    fun toHashMap() : HashMap<String, Any?>{
        return hashMapOf(
            "id"          to id          ,
            "name"        to name        ,
            "description" to description ,
            "counter"     to counter     ,
        )
    }

    companion object {
        fun fromQueryDoc( documentSnapshot: DocumentSnapshot) : Item {
            return Item(
                documentSnapshot["id"         ] as String,
                documentSnapshot["name"       ] as String?,
                documentSnapshot["description"] as String?,
                documentSnapshot["counter"    ] as Long?,
            )
        }
    }
}
