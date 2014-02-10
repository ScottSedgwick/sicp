(define (zip f l1 l2)
  (if (or (null? l1) (null? l2))
      '()
      (cons (f (car l1) (car l2)) (zip f (cdr l1) (cdr l2)))))

(define (sum-offset lst)
  (zip + lst (cdr lst)))

(define (pascal n)
  (if (= n 1)
      '(1)
      (append (cons 1 (sum-offset (pascal (- n 1)))) '(1))))

(define (fold f acc lst)
  (if (null? lst) acc
  	  (f (car lst) (fold f acc (cdr lst)))))