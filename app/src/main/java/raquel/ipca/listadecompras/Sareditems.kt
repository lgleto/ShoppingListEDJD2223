package raquel.ipca.listadecompras

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.util.HashSet

var SharedPreferences.ITEMS_LIST_SET
    get() = getStringSet("items_list", null)
    set(value) = edit().putStringSet("items_list", value).apply()


class SharedItems {

    private var _items = arrayListOf<Item>()

    var items : List<Item>
        get()  {
            _items.clear()
            for (i in sharedPreferences.ITEMS_LIST_SET?: HashSet()){
                _items.add(Item(i,"",0))
            }
            return _items
        }
        set(value) {
            val set: MutableSet<String> = HashSet()
            var strings = arrayListOf<String>()
            for( v in value){
                strings.add(v.name?:"")
            }
            set.addAll(strings)
            sharedPreferences.ITEMS_LIST_SET = set
        }

    private var sharedPreferences: SharedPreferences

    constructor(context: Context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }


}