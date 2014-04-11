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

(define (prime? n) (fast-prime? n 10))

(define (timed-prime-test n)
  (start-prime-test n (runtime)))

(define (start-prime-test n start-time)
  (if (prime? n) (report-prime n (- (runtime) start-time))))

(define (report-prime n elapsed-time)
  (newline)
  (display n)
  (display " *** ")
  (display elapsed-time))

(define (search-for-primes min max)
  (define (test-and-proceed n)
  	(timed-prime-test n)
  	(iter (+ n 1)))
  (define (iter n)
  	(cond ((even? n) (iter (+ n 1)))
  		  ((not (> n max)) (test-and-proceed n))))
  (iter min))

; 1 ]=> (search-for-primes 1000000 1000038)

; 1000003 *** 0.
; 1000033 *** 0.
; 1000037 *** 0.

; Given that the slowest test is now down to 0 time, I'm not going to bother to test the rest.