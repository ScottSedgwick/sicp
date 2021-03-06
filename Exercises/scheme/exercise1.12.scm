(define (zip f l1 l2)
  (if (or (null? l1) (null? l2))
      '()
      (cons (f (car l1) (car l2)) (zip f (cdr l1) (cdr l2)))))

(define (sum-offset lst)
  (zip + lst (cdr lst)))

(define (pascal n)
  (if (= n 0)
      '(1)
      (append (cons 1 (sum-offset (pascal (- n 1)))) '(1))))

; This is a far more efficient iterative algorithm for Pascal's triangle.
(define (pascal2 n)
  (define (ptvalue k prev)
  	(/ (* prev (- n k)) (+ k 1)))
  (define (iter k prev)
  	(if (= k n)
  		'()
  		(cons (ptvalue k prev) (iter (+ k 1) (ptvalue k prev)))))
  (cons 1 (iter 0 1)))

; Tests.
(load "check.scm")

(define (p-test)
  (check (pascal 0) => '(1))
  (check (pascal 1) => '(1 1))
  (check (pascal 2) => '(1 2 1))
  (check (pascal 3) => '(1 3 3 1))
  (check (pascal 4) => '(1 4 6 4 1))
  (check (pascal 5) => '(1 5 10 10 5 1))
  (check (pascal 6) => '(1 6 15 20 15 6 1))
  (check (pascal 7) => '(1 7 21 35 35 21 7 1))
  (check (pascal 8) => '(1 8 28 56 70 56 28 8 1))
  (check (pascal 9) => '(1 9 36 84 126 126 84 36 9 1))
  (check (pascal2 0) => '(1))
  (check (pascal2 1) => '(1 1))
  (check (pascal2 2) => '(1 2 1))
  (check (pascal2 3) => '(1 3 3 1))
  (check (pascal2 4) => '(1 4 6 4 1))
  (check (pascal2 5) => '(1 5 10 10 5 1))
  (check (pascal2 6) => '(1 6 15 20 15 6 1))
  (check (pascal2 7) => '(1 7 21 35 35 21 7 1))
  (check (pascal2 8) => '(1 8 28 56 70 56 28 8 1))
  (check (pascal2 9) => '(1 9 36 84 126 126 84 36 9 1))
  (check-report))