package dev.abd3lraouf.learn.googleauth.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.abd3lraouf.learn.googleauth.R
import dev.abd3lraouf.learn.googleauth.ui.theme.LoadingBlue

@Composable
fun GoogleButton(
  modifier: Modifier = Modifier,
  loading: Boolean = false,
  primaryText: String = "Sign in with Google",
  loadingText: String = "Loading...",
  shape: Shape = MaterialTheme.shapes.medium,
  onClick: () -> Unit
) {
  val text = if (loading) loadingText else primaryText

  Surface(
    modifier = modifier
      .clickable(enabled = !loading, onClick = onClick),
    shape = shape,
    border = BorderStroke(1.dp, Color.LightGray),
    color = MaterialTheme.colorScheme.surface
  ) {
    Row(
      modifier = Modifier
        .padding(12.dp)
        .animateContentSize(
          animationSpec = tween(
            durationMillis = 300,
            easing = FastOutSlowInEasing
          )
        ),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center
    ) {
      GoogleLogo()
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = text,
        color = MaterialTheme.colorScheme.onSurface
      )
      if (loading) {
        Spacer(modifier = Modifier.width(16.dp))
        CircularProgressIndicator(
          modifier = Modifier
            .size(16.dp),
          strokeWidth = 2.dp,
          color = LoadingBlue
        )
      }
    }

  }
}

@Composable
fun GoogleLogo() {
  Icon(
    painter = painterResource(id = R.drawable.ic_google),
    contentDescription = "Google Logo",
    tint = Color.Unspecified,
    modifier = Modifier.size(24.dp)
  )
}


@Composable
@Preview(showBackground = true)
fun GoogleButtonPreviewLoading() {
  GoogleButton(loading = true, onClick = {})
}

@Composable
@Preview(showBackground = true)
fun GoogleButtonPreview() {
  GoogleButton(onClick = {})
}