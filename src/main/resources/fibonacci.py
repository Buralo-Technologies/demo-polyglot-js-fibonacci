def fibonacci0(n, a, b):
    if n==0:
        return a
    if n==1:
        return b
    return fibonacci0(n - 1, b, a + b)

def fibonacci(n):
    return fibonacci0(n, 0, 1)