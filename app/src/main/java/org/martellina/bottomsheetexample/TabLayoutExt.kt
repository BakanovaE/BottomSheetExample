package org.martellina.bottomsheetexample

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import androidx.core.text.clearSpans
import com.google.android.material.tabs.TabLayout

private const val START_CHARACTER = 0

fun TabLayout.makeSelectedTabTitleBold() {
    this.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            val text: Spannable = SpannableString(tab.text)
            text.setSpan(StyleSpan(Typeface.BOLD), START_CHARACTER, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            tab.text = text
        }
        override fun onTabUnselected(tab: TabLayout.Tab) {
            val text: Spannable = SpannableString(tab.text)
            text.clearSpans()
            text.setSpan(StyleSpan(Typeface.NORMAL), START_CHARACTER, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            tab.text = text
        }
        override fun onTabReselected(tab: TabLayout.Tab) {
            val text: Spannable = SpannableString(tab.text)
            text.setSpan(StyleSpan(Typeface.BOLD), START_CHARACTER, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            tab.text = text
        }
    })
}
