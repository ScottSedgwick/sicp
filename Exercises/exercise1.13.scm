(load "check.scm")

(define (fib1 n)
  (cond ((= n 0) 0)
        ((= n 1) 1)
        (else (+ (fib1 (- n 1)) (fib1 (- n 2))))))

(define (fib1-test)
  (check (fib1 0) => 0)
  (check (fib1 1) => 1)
  (check (fib1 2) => 1)
  (check (fib1 3) => 2)
  (check (fib1 4) => 3)
  (check (fib1 5) => 5)
  (check (fib1 6) => 8)
  (check-report))

(define (fib2 n)
  (define phi (/ (+ 1 (sqrt 5)) 2))
  (inexact->exact (round (/ (expt phi n) (sqrt 5)))))

(define (fib2-test)
  (check (fib2 0) => 0)
  (check (fib2 1) => 1)
  (check (fib2 2) => 1)
  (check (fib2 3) => 2)
  (check (fib2 4) => 3)
  (check (fib2 5) => 5)
  (check (fib2 6) => 8)
  (check-report))

(define (all lst)
  (reduce (lambda (a b) (and a b)) #t lst))

(define (makelist start end)
  (define (iter current)
    (if (= current end)
      '()
      (cons current (iter (+ current 1)))))
  (iter start))

(define values (makelist 1 20))
(define fib1s (map fib1 values))
(define fib2s (map fib2 values))
(define fibs (zip fib1s fib2s))

(define matches (map (lambda (lst) (= (first lst) (second lst))) fibs))

(define (v-test) (all matches))