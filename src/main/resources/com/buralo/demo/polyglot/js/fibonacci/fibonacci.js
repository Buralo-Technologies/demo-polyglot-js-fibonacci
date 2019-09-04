function fibonacci(n, a, b) {
    if (n == 0) return a;
    if (n == 1) return b;
    return fibonacci(n - 1, b, a + b);
}

(function(n) {
    return fibonacci(n, 0, 1);
})