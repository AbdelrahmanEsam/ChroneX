package com.apptikar.designSystem.dropdown

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.setTextAndSelectAll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.apptikar.designSystem.inputs.ChroneXInputField
import com.chroneX.designSystem.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChroneDropDown(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    options: List<String>,
    placeHolder: String?,
) {
    var expanded by remember { mutableStateOf(false) }
    val degrees by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f, animationSpec = tween(durationMillis = 500)
    )
    val focusManager = LocalFocusManager.current
    ExposedDropdownMenuBox(
        modifier = modifier.clickable {
            expanded = !expanded
        },
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        ChroneXInputField(
            state = state,
            readOnly = true,
            placeHolder = placeHolder,
            trailingComposable = {
                AsyncImage(
                    modifier = Modifier.size(20.dp).graphicsLayer {
                        this.rotationZ = degrees
                    },
                    model = R.drawable.drop_down_arrow,
                    contentDescription = "Gradient background",
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable, true)
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        state.setTextAndSelectAll(selectionOption)
                        expanded = false
                        focusManager.clearFocus()
                    },
                    text = { Text(text = selectionOption) },
                )
            }
        }
    }
}

