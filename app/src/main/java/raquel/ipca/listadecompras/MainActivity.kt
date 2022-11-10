package raquel.ipca.listadecompras

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.UUID

class MainActivity : AppCompatActivity() {

    var items = arrayListOf<Item>()

    val itemAdapter = ItemsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listViewItems = findViewById<ListView>(R.id.listVewItems)
        val editTextItemName = findViewById<EditText>(R.id.editTextItemName)
        val buttonAdd = findViewById<FloatingActionButton>(R.id.buttonAdd)
        buttonAdd.setOnClickListener {
            val item = Item ( UUID.randomUUID().toString(),
                editTextItemName.text.toString(),"", 0)


        }
        listViewItems.adapter=itemAdapter





    }



    inner class ItemsAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return items.size
        }

        override fun getItem(p0: Int): Any {
            return items[p0]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        @SuppressLint("SetTextI18n")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val rootView = layoutInflater.inflate(R.layout.row_item, p2, false)

            val textVewItemName = rootView.findViewById<TextView>(R.id.textVewItemName)
            val buttonTrash = rootView.findViewById<FloatingActionButton>(R.id.buttonTrash)
            val buttonAdd = rootView.findViewById<ImageButton>(R.id.buttonAdd)
            val buttonMinus = rootView.findViewById<ImageButton>(R.id.buttonMinus)
            val textViewNumber = rootView.findViewById<TextView>(R.id.textViewnumber)
            textViewNumber.text = items[p0].counter.toString()

            buttonAdd.setOnClickListener {
                textViewNumber.text = (textViewNumber.text.toString().toInt()+1).toString()
                items[p0].counter=textViewNumber.text.toString().toInt()

            }
            buttonMinus.setOnClickListener {
                textViewNumber.text = (textViewNumber.text.toString().toInt()-1).toString()
                items[p0].counter=textViewNumber.text.toString().toInt()

            }
            buttonTrash.setOnClickListener {
                //items.remove(items[p0])

            }

            textVewItemName.text=items[p0].name

            return rootView
        }

    }

}