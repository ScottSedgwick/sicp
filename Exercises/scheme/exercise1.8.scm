(load "check.scm")

(define (newton-approx improve x)
  (define (good-enough? g1 g2)
  	(< (/ (abs (- g1 g2)) x) 0.0000001))
  (define (iter g1 g2)
  	(if (good-enough? g1 g2)
  		g2
  		(iter g2 (improve g2 x))))
  (iter 10000000 1.0))

(define (sqrt-improve guess x)
  (/ (+ (/ x guess) guess) 2))

(define (cbrt-improve guess x)
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

(define (sqrt x) (newton-approx sqrt-improve x))

(define (cbrt x) (newton-approx cbrt-improve x))

;; Test function, for floating point "close enough" equality
(define (=~ a b) (< (abs (- a b)) 0.001))

(define (ex18-test)
  (check (=~ (cbrt 27) 3) => #t)
  (check (=~ (sqrt 9) 3) => #t)
  (check-report)
)