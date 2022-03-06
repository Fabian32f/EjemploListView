package com.cbtis.ejemplolistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorCustom(var context: Context, items:ArrayList<Fruta>): BaseAdapter (){

    var items : ArrayList<Fruta>? = null

    init {
        this.items = items
    }


    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(p0: Int): Any { //position ahora es p0
        return items?.get(p0)!!
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var holder:ViewHolder? = null
        var vista:View? = p1 //cambio a p1

        if(vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.template, null)
            holder = ViewHolder(vista)
            vista.tag = holder
        }else{
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(p0) as Fruta
        holder?.nombre?.text = item.nombre
        holder?.imagen?.setImageResource(item.imagen)

        //Tarea
        /*if(p0 % 2 == 0){
            holder?.celda?.setBackgroundColor(Color.LTGRAY)
        }*/

        return vista!!
    }

    private class ViewHolder(vista:View){
        var nombre: TextView? = null
        var imagen: ImageView? = null
        // Tarea
       // var celda:LinearLayout? = null
      //  var boton:Button? = null

        init {
            nombre = vista.findViewById(R.id.nombre)
            imagen = vista.findViewById(R.id.imagen)
            // Tarea
          //  celda = vista.findViewById(R.id.celda)
          //  boton = vista.findViewById(R.id.boton)

          /*  boton?.setOnClickListener{
                Toast.makeText(vista.context, nombre?.text, Toast.LENGTH_LONG).show()
            }*/
        }
    }


}