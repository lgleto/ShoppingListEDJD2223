package raquel.ipca.listadecompras

class Item {

    var id : String
    var name : String? = null
    var description:String? = null
    var counter:Int? = null

    constructor(id : String, name: String?, description: String?, counter: Int?) {
        this.id = id
        this.name = name
        this.description = description
        this.counter = counter
    }
}
