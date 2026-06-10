package com.example.dailyaffirmationsapp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayAffirmationScreen(
    viewModel: AffirmationViewModel = viewModel()
) {

    // TextField value
    var affirmationText by remember {
        mutableStateOf("")
    }

    // Edit dialog visibility
    var isEditing by remember {
        mutableStateOf(false)
    }

    // Selected affirmation id
    var editId by remember {
        mutableStateOf("")
    }

    // Edit text
    var editText by remember {
        mutableStateOf("")
    }

    val pink = Color(0xFFE91E63)

    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text("Daily Affirmations")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = pink,
                    titleContentColor = Color.White
                )
            )
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            // Input Section
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                OutlinedTextField(
                    value = affirmationText,
                    onValueChange = {
                        affirmationText = it
                    },
                    placeholder = {
                        Text("Write your affirmation...")
                    },
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {

                        viewModel.addAffirmation(
                            affirmationText
                        )

                        affirmationText = ""

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pink,
                        contentColor = Color.White
                    )
                ) {
                    Text("Save")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // List of affirmations
            LazyColumn {

                items(viewModel.affirmations) { (id, text) ->

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement =
                                Arrangement.SpaceBetween,
                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Text(
                                text = text,
                                modifier = Modifier.weight(1f)
                            )

                            // Edit Button
                            IconButton(
                                onClick = {

                                    isEditing = true
                                    editId = id
                                    editText = text
                                }
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Edit",
                                    tint = pink
                                )
                            }

                            // Delete Button
                            IconButton(
                                onClick = {
                                    viewModel.deleteAffirmation(id)
                                }
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = pink
                                )
                            }
                        }
                    }
                }
            }
        }

        // Edit Dialog
        if (isEditing) {

            AlertDialog(
                onDismissRequest = {
                    isEditing = false
                },

                title = {
                    Text("Edit Affirmation")
                },

                text = {

                    OutlinedTextField(
                        value = editText,
                        onValueChange = {
                            editText = it
                        },
                        label = {
                            Text("Edit Affirmation")
                        }
                    )
                },

                confirmButton = {

                    Button(
                        onClick = {

                            viewModel.updateAffirmation(
                                editId,
                                editText
                            )

                            isEditing = false
                        }
                    ) {
                        Text("Update")
                    }
                },

                dismissButton = {

                    Button(
                        onClick = {
                            isEditing = false
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}