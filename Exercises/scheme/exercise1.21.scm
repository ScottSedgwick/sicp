(define (smallest-divisor n) (find-divisor n 2))

(define (find-divisor n test-divisor)
  (cond ((> (square test-divisor) n) n)
        ((divides? test-divisor n) test-divisor)
        (else (find-divisor n (+ test-divisor 1)))))

(define (divides? a b) (= (remainder b a) 0))

(define (prime? n) (= n (smallest-divisor n)))

(load "check.scm")

(define (p-test)
  (check (prime? 2) => #t)
  (check (prime? 3) => #t)
  (check (prime? 4) => #f)
  (check (prime? 5) => #t)
  (check (prime? 6) => #f)
)

(define (expmod base exp m)
  (cond ((= exp 0) 1)
        ((even? exp) (remainder (square (expmod base (/ exp 2) m)) m)) 
        (else        (remainder (* base (expmod base (- exp 1) m)) m))))

(define (fermat-test n)
  (define (try-it a) (= (expmod a n n) a))
  (try-it (+ 1 (random (- n 1)))))

(define (fast-prime? n times)
  (cond ((= times 0) true)
        ((fermat-test n) (fast-prime? n (- times 1)))
        (else false)))

(define (fp-test)
  (check (fast-prime? 2 5) => #t)
  (check (fast-prime? 3 5) => #t)
  (check (fast-prime? 4 5) => #f)
  (check (fast-prime? 5 5) => #t)
  (check (fast-prime? 6 5) => #f)
)

; Exercise 1.21
(define (sd-test)
  (check (smallest-divisor 199) => 199)
  (check (smallest-divisor 1999) => 1999)
  (check (smallest-divisor 19999) => 7)
)