package com.app.educa.utils

import com.app.educa.ui.fragment.ActionBottomDialogFragment

class ActionBottom {
    companion object{
        const val TAG = "ActionBottomDialog"
        fun newInstance():ActionBottomDialogFragment{
            return ActionBottomDialogFragment()
        }
    }

}