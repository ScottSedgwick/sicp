; Exercise 1.27: Demonstrate that the Carmichael numbers listed in Footnote 1.47 
; (Carmichael numbers: 561, 1105, 1729, 2465, 2821, 6601)
; really do fool the Fermat test. That is, write a procedure that takes an 
; integer n and tests whether an is congruent to a modulo n for every a < n, and 
; try your procedure on the given Carmichael numbers.

; Fermat’s Little Theorem: If n is a prime number and a is any positive integer 
; less than n, then a raised to the nth power is congruent to a modulo n.
; That is, a^n mod n == a

(define (expmod base exp m)
  (cond ((= exp 0) 1)
        ((even? exp) (remainder (square (expmod base (/ exp 2) m)) m)) 
        (else        (remainder (* base (expmod base (- exp 1) m)) m))))

(define (congruent a n)
  (= (expmod a n n) a))

(define (congruent-test n)
  (define (c-test-iter n a)
  	(cond ((= a 0) #t)
  		  ((not (congruent a n)) #f)
  		  (else (c-test-iter n (- a 1)))))
  (c-test-iter n (- n 1)))

(load "check.scm")

(define (c-test)
  (check (congruent-test 560) => #f)
  (check (congruent-test 561) => #t)
  (check (congruent-test 562) => #f)

  (check (congruent-test 1104) => #f)
  (check (congruent-test 1105) => #t)
  (check (congruent-test 1106) => #f)

  (check (congruent-test 1728) => #f)
  (check (congruent-test 1729) => #t)
  (check (congruent-test 1730) => #f)

  (check (congruent-test 2464) => #f)
  (check (congruent-test 2465) => #t)
  (check (congruent-test 2466) => #f)

  (check (congruent-test 2820) => #f)
  (check (congruent-test 2821) => #t)
  (check (congruent-test 2822) => #f)

  (check (congruent-test 6600) => #f)
  (check (congruent-test 6601) => #t)
  (check (congruent-test 6602) => #f)
  (check-report)
)