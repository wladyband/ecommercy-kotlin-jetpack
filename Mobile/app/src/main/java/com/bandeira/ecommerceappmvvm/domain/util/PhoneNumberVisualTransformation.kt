

package com.bandeira.ecommerceappmvvm.domain.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation



class PhoneNumberVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val original = text.text.filter { it.isDigit() }.take(11)
        val formatted = formatPhoneNumber(original)

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return when {
                    offset <= 0 -> 0
                    offset <= 2 -> offset + 1   // '(': +1
                    offset <= 6 -> offset + 3   // '(', ') ', +3
                    offset <= 10 -> offset + 4  // '(', ') ', '-', +4
                    else -> formatted.length
                }
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when {
                    offset <= 0 -> 0
                    offset <= 3 -> offset - 1
                    offset <= 8 -> offset - 3
                    offset <= 13 -> offset - 4
                    else -> original.length
                }
            }
        }

        return TransformedText(
            text = AnnotatedString(formatted),
            offsetMapping = offsetMapping
        )
    }
}
