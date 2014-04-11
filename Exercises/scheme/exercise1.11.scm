(load "check.scm")

(define (f n)
  (if (< n 3) 
  	  n
      (+ (f (- n 1)) (* 2 (f (- n 2))) (* 3 (f (- n 3))))))

(define (f-test)
  (check (f 1) => 1)
  (check (f 2) => 2)
  (check (f 3) => 4)
  (check (f 4) => 11)
  (check (f 5) => 25)
  (check (f 6) => 59)
  (check-report))

(define (f2 n)
  (define (iter a b c n)
  	(if (= n 0)
  		c
  		(iter b c (+ (* 3 a) (* 2 b) c) (- n 1))))
  (if (< n 3)
  	n
  	(iter 0 1 2 (- n 2))))

(define (f2-test)
  (check (f2 1) => 1)
  (check (f2 2) => 2)
  (check (f2 3) => 4)
  (check (f2 4) => 11)
  (check (f2 5) => 25)
  (check (f2 6) => 59)
  (check-report))
