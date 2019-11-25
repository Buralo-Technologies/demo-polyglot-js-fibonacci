fibonacci0 <- function(n, a, b) {
  if(n == 0) {
    return(a)
  } else if(n == 1) {
    return(b)
  } else {
    return(fibonacci0(n - 1, b, a + b))
  }
}

fibonacci <- function(n) {
  return(fibonacci0(n, 0, 1))
}