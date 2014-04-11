; Miller-Rabin test: if n is a prime number, and a is any positive integer less than n,
; then a^(n-1) is congruent to 1 modulo n.

; m = a^(n-1)
; Check that m is not a "non-trivial square root of 1 modulo n", that is, a number not 
; equal to 1 or n whose square is equal to 1 mod n.

(define (expmod base exp m)
  (cond ((= exp 0) 1)
        ((even? exp) (remainder (square (expmod base (/ exp 2) m)) m)) 
        (else        (remainder (* base (expmod base (- exp 1) m)) m))))

(define (fermat-test n)
  (define (try-it a) (= (expmod a n n) a))
  (try-it (+ 1 (random (- n 1)))))

(define (prime? n f times)
  (cond ((= times 0) true)
        ((f n) (prime? n f (- times 1)))
        (else false)))

(define (fermat-prime? n) (prime? n fermat-test 10))

; Miller-Rabin test:
; to test primality of N:
; 1) randomly select a < n
; 2) raise a to (n-1) using expmod
; 3) when squaring in expmod, check to see if we have discovered a "nontrivial square root of 1 mod n"
;      that is, a number not equal to 1 or n-1, whose square is equal to 1 mod n.

(define (square-check x m)
  (if (and (not (or (= x 1) (= x (- m 1))))
           (= (remainder (* x x) m) 1))
      0
      (remainder (* x x) m)))

(define (even? n)
  (= (remainder n 2) 0))

(define (expmod base exp m)
  (cond ((= exp 0) 1)
        ((even? exp) (square-check (expmod base (/ exp 2) m)  m))
        (else   (remainder (* base (expmod base (- exp 1) m)) m))))

(define (miller-rabin-test n)
  (define (try-it a)
     (= (expmod a (- n 1) n) 1))
  (try-it (+ 2 (random-integer (- n 2)))))

(define (mr-prime? n) (prime? n miller-rabin-test 10))

(load "check.scm")

(define (s-test)
	(check (sqmod 2 5) => 4)
	(check (sqmod 2 3) => 1)
	(check (sqmod 3 5) => 4)
	(check (sqmod 3 8) => 1)

	(check (ntsr1mn 2 5) => #f)
	(check (ntsr1mn 2 3) => #f)
	(check (ntsr1mn 3 5) => #f)
	(check (ntsr1mn 3 8) => #t)

	(check (fermat-prime? 25) => #f)
	(check (fermat-prime? 27) => #f)
	(check (fermat-prime? 29) => #t)
	(check (fermat-prime? 31) => #t)

	(check (mr-prime? 25) => #f)
	(check (mr-prime? 27) => #f)
	(check (mr-prime? 29) => #t)
	(check (mr-prime? 31) => #t)

	(check-report))