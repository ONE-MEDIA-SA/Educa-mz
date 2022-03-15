package com.app.educa.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.app.educa.R
import com.app.educa.utils.ItemClickListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ActionBottomDialogFragment : BottomSheetDialogFragment(), View.OnClickListener{

    private var mListener: ItemClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_dialog_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**now call all textView*/
//        view.findViewById<TextView>(R.id.text0).setOnClickListener(this)
//        view.findViewById<TextView>(R.id.text1).setOnClickListener(this)
//        view.findViewById<TextView>(R.id.text2).setOnClickListener(this)
//        view.findViewById<TextView>(R.id.text3).setOnClickListener(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mListener = if (context is ItemClickListener){
            context
        }else{
            throw RuntimeException(
                context.toString() + "Must implement ItemClickListener"
            )
        }

    }

    override fun onDetach() {
        super.onDetach()
       // mListener = null
    }



    override fun onClick(v: View?) {
//        val tvSelected = v as TextView
//        mListener!!.onItemClick(tvSelected.text.toString())
        dismiss()
    }

}