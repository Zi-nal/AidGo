package com.dsm.aidgo

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dsm.aidgo.databinding.SchoolDialogBinding

class SchoolDialog : DialogFragment() {
    var _binding: SchoolDialogBinding? = null
    val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = SchoolDialogBinding.inflate(layoutInflater)
        val view = binding.root

        val builder = AlertDialog.Builder(requireContext())
            .setTitle("Select an option")
            .setView(view)
            .setPositiveButton("OK") { _, _ ->
                // OK 버튼이 클릭되었을 때의 동작을 구현합니다.
                // 선택된 RadioButton을 확인하려면 binding.radioButton1.isChecked 등을 사용할 수 있습니다.
            }
            .setNegativeButton("Cancel", null)

        return builder.create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
