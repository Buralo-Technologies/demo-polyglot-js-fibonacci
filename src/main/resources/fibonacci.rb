def fibonacci0(a, b, n)
  n == 0 ? a : fibonacci0(b, a + b, n - 1)
end

def fibonacci(n)
  fibonacci0(0, 1, n)
end