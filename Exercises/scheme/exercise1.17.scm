(load "check.scm")

(define (m1 a b)
  (if (= b 0)
      0
      (+ a (m1 a (-1+ b)))))

; exerise 1.17
(define (double a) (* a 2))
(define (halve a) (/ a 2))

(define (m2 a b)
  (cond ((= b 0) 0)
  	    ((= b 1) a)
  	    ((even? b) (m2 (double a) (halve b)))
  	    (else (+ a (m2 a (-1+ b))))))

; exercise 1.18
(define (m3 a b)
  (define (iter a b acc)
    (cond ((= b 0) acc)
          ((even? b) (iter (double a) (halve b) acc))
          (else      (iter a (-1+ b) (+ acc a))))) 
  (iter a b 0))

(define (m-test)
  (check (m1 2 3) => 6)
  (check (m2 2 3) => 6)
  (check (m3 2 3) => 6)
  (check-report))

