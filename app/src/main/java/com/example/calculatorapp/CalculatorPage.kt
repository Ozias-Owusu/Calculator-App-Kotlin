package com.example.calculatorapp

//import androidx.compose.foundation.background
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

var buttonList = listOf(
    "C","+/-","%","÷",
    "7","8","9","x",
    "4","5","6","-",
    "1","2","3","+",
    "0",".","="
)

@Composable
fun Calculator(modifier: Modifier = Modifier, viewModel:CalculatorViewModel)
{
    val viewModel = viewModel
    val state = viewModel.state
//    val equationText = viewModel.equationText.observeAsState()
//    val resultText = viewModel.equationText.observeAsState()

    Box (modifier= modifier.fillMaxWidth().padding(20.dp)){
        Column(horizontalAlignment = Alignment.End) {

            Text(
//                text = equationText.value?:"",
                text = state.number1+(state.operation?.symbol ?: "")+ state.number2,
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
//                text = resultText.value?: "",
                text = state.number1+(state.operation?.symbol ?: "")+ state.number2,
                style = TextStyle(
                    fontSize = 70.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 2,
            )
            Spacer(modifier = modifier.height(10.dp))

//            LazyVerticalGrid(columns = GridCells.Fixed(4))
//            {
//                items(buttonList){
//                    CalculatorButton(btn = it, onClick = {viewModel.onButtonClicked(it)})
//                }
//            }
            Row {
                CalculatorButton(symbol = "C", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Delete)
                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "+/-", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.ToggleSign)

                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "%", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Modulo))

                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "÷", color = Color(0xFFFF9800),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))

                }

            }
            Spacer(modifier = modifier.height(10.dp))
            Row {
                CalculatorButton(symbol = "7", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Number(7))
                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "8", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Number(8))
                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "9", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Number(9))
                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "x", color = Color(0xFFFF9800),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                }

            }
            Spacer(modifier = modifier.height(10.dp))
            Row {
                CalculatorButton(symbol = "4", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Number(4))
                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "5", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Number(5))

                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "6", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Number(6))

                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "-", color = Color(0xFFFF9800),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                }

            }
            Spacer(modifier = modifier.height(10.dp))
            Row {
                CalculatorButton(symbol = "1", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Number(1))
                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "2", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Number(2))

                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "3", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Number(3))
                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "+", color = Color(0xFFFF9800),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                }

            }
            Spacer(modifier=modifier.height(10.dp))
            Row {
                CalculatorButton(symbol = "0", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f))
                {
                    viewModel.onAction(CalculatorAction.Number(0))
                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = ".", color = Color(0xC6404141),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Decimal)
                }
                Spacer(modifier = modifier.width(5.dp))
                CalculatorButton(symbol = "=", color = Color(0xFFFF9800),modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f))
                {
                    viewModel.onAction(CalculatorAction.Calculate)
                }

            }
        }
    }
}

//@Composable
//fun CalculatorButton(btn: String, onClick:() -> Unit){
//    Box (modifier = Modifier
//        .padding(8.dp)
////        .fillMaxWidth()
//    ){
//            FloatingActionButton(onClick = onClick, modifier = Modifier
////                .size(width = if (btn == "0") 120.dp else 90.dp, height = 90.dp),
//                .height(80.dp)
//                .fillMaxWidth(if (btn == "0") 2f else 1f),
//                shape = CircleShape,
//                containerColor = getColor(btn),
//                contentColor = Color.White)
//            {
//                Text(text = btn, fontSize = 40.sp, fontWeight = FontWeight.Bold)
//            }
//    }
//}
//
//fun getColor(symbol: String): Color{
//    if(symbol == "C" ||symbol =="+/-" || symbol =="%")
//        return Color(0xFF888686)
//    if (symbol ==" " || symbol ==")")
//        return Color.Transparent
//    if (symbol =="÷"|| symbol =="x" || symbol =="+" || symbol =="-"|| symbol == "=")
//        return Color(0xFFFF9800)
//    return Color(0xC6404141)
//
//}

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(color)
            .clickable {
                onClick()
            }
            .then(modifier)
    ) {
        Text(
            text = symbol,
            style = textStyle,
            fontSize = 36.sp,
            color = Color.White
        )
    }
}