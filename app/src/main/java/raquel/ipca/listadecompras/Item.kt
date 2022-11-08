package raquel.ipca.listadecompras

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
class Item {

    @PrimaryKey
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
@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun getAll() : List<Item>

    @Query("SELECT * FROM item WHERE id =:id")
    fun getItemById(id : String) : Item

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Item)

    @Delete
    fun delete(item: Item)

}