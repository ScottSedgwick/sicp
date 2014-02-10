(load "check.scm")

;; Exercise 1.3

(define (square x) (expt x 2))

(define (sum-squares lst)
  (reduce + 0 (map square lst)))

(define (largest-n n . values)
  (list-head (sort values >) n))

(define (ex13 a b c) 
  (sum-squares (largest-n 2 a b c)))

(define (ex13-test)
  (check (square 2) => 4)
  (check (map square '(1 2 3)) => '(1 4 9))
  (check (take 2 '(1 2 3 4)) => '(1 2))
  (check (ex13 1 2 3) => 13)
  (check (ex13 5 4 3) => 41)
  (check (ex13 4 6 2) => 52)
  (check-report)
)