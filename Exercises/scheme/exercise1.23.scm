(define (next n)
  (if (= n 2) 
      3
      (+ n 2)))

(define (smallest-divisor n) (find-divisor n 2))

(define (find-divisor n test-divisor)
  (cond ((> (square test-divisor) n) n)
        ((divides? test-divisor n) test-divisor)
        (else (find-divisor n (next test-divisor)))))

(define (divides? a b) (= (remainder b a) 0))

(define (prime? n) (= n (smallest-divisor n)))

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