(load "check.scm")

; Naive recursive expotentiation
(define (expt1 b n)
  (if (= n 0)
      1
      (* b (expt1 b (- n 1)))))

; Naive iterative expotentiation
(define (expt2 b n)
   (expt-iter b n 1))

(define (expt-iter b counter product)
  (if (= counter 0)
      product
      (expt-iter b
        (- counter 1)
        (* b product))))

; Fast recursive expotentiation
(define (fast-expt1 b n)
   (cond ((= n 0) 1)
         ((even? n) (square (fast-expt1 b (/ n 2))))
         (else (* b (fast-expt1 b (- n 1))))))

; Write a fast iterative expotentiation function
(define (fast-expt2 b n)
  (fast-expt-iter b n 1))

(define (fast-expt-iter b n acc)
  (cond ((= n 0) acc)
        ((even? n) (fast-expt-iter (square b) (/ n 2) acc))
        (else (fast-expt-iter b (-1+ n) (* acc b)))))

(define (e-test)
  (check (fast-expt1 2 2) => 4)
  (check (fast-expt1 2 3) => 8)
  (check (fast-expt1 2 4) => 16)
  (check (fast-expt1 2 5) => 32)
  (check (fast-expt1 2 6) => 64)
  (check (fast-expt1 2 7) => 128)
  (check (fast-expt1 2 8) => 256)
  (check (fast-expt2 2 2) => 4)
  (check (fast-expt2 2 3) => 8)
  (check (fast-expt2 2 4) => 16)
  (check (fast-expt2 2 5) => 32)
  (check (fast-expt2 2 6) => 64)
  (check (fast-expt2 2 7) => 128)
  (check (fast-expt1 2 8) => 256)
  (check-report))