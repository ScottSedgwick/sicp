(load "check.scm")

;; Original code from book
(define (average x y)
  (/ (+ x y) 2))

(define (improve guess x)
  (average guess (/ x guess)))

(define (good-enough? guess x)
  (< (abs (- (square guess) x)) 0.001))

(define (sqrt-iter guess x)
  (if (good-enough? guess x)
      guess
      (sqrt-iter (improve guess x) x)))

(define (sqrt x) (sqrt-iter 1.0 x))

;; In terms of accuracy, if the number is small, and 0.001 is an
;; appreciable fraction of the square roots value, then using 0.0001
;; as an acceptable error range is patently unacceptable.
;; For very large numbers (in some systems, depending on the internal
;; represenation of integers) the average function could overflow on 
;; addition, which would result in a large negative number. Though,
;; to do that, the initial value would also have to exceed the 
;; number size...

(define (sqrt2 x)
  (define (good-enough? g1 g2)
  	(< (/ (abs (- g1 g2)) x) 0.0000001))
  (define (sqrt-iter g1 g2)
  	(if (good-enough? g1 g2)
  		g2
  		(sqrt-iter g2 (improve g2 x))))
  (sqrt-iter 10000000 1.0))

;; Test function
(define (=~ a b) (< (abs (- a b)) 0.001))

(define (ex17-test)
  (check (=~ 1.0 1.001) => #t)
  (check (=~ 1.0 1.0011) => #f)
  (check (=~ (sqrt 9) 3) => #t)
  (check (=~ (sqrt (+ 100 37)) 11.704) => #t)
  (check (=~ (sqrt (+ (sqrt 2) (sqrt 3))) 1.7739) => #t)
  (check (=~ (square (sqrt 1000)) 1000) => #t)
  (check (=~ (sqrt2 9) 3) => #t)
  (check (=~ (sqrt2 (+ 100 37)) 11.704) => #t)
  (check (=~ (sqrt2 (+ (sqrt2 2) (sqrt2 3))) 1.7739) => #t)
  (check (=~ (square (sqrt2 1000)) 1000) => #t)
  (check-report)
)