package raquel.ipca.listadecompras

class Item {
    var name : String? = null
    var description:String? = null
    var counter:Int? = null

    constructor(name: String?, description: String?, counter: Int?) {
        this.name = name
        this.description = description
        this.counter = counter
    }
}