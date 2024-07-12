import time

def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)

def fibonacci_with_caching(n, cache=None):
    if cache is None:
        cache = {}
    if n <= 1:
        return n
    if n in cache:
        return cache[n]
    result = fibonacci_with_caching(n - 1, cache) + fibonacci_with_caching(n - 2, cache)
    cache[n] = result
    return result

def fibonacci_caching(n):
    cache = [0] * (n + 1)
    return fibonacci_memoria(n, cache)

def fibonacci_memoria(n, cache):
    if n <= 1:
        return n
    if cache[n] != 0:
        return cache[n]
    cache[n] = fibonacci_memoria(n - 1, cache) + fibonacci_memoria(n - 2, cache)
    return cache[n]

def main():
    print("Dynamic Programming")

    start_time = time.time_ns()
    print(fibonacci(40))
    end_time = time.time_ns()
    print(f"Time taken: {end_time - start_time} ns")

    start_time = time.time_ns()
    print(fibonacci_with_caching(40))
    end_time = time.time_ns()
    print(f"Time taken: {end_time - start_time} ns")

    start_time = time.time_ns()
    print(fibonacci_caching(40))
    end_time = time.time_ns()
    print(f"Time taken: {end_time - start_time} ns")

if __name__ == "__main__":
    main()

# Dynamic Programming
# 102334155
# Time taken: 91722562000 ns

# 102334155
# Time taken: 325000 ns
# 102334155
# Time taken: 61000 ns