(define (show-point p)
  (display "(")
  (display (x-point p))
  (display ",")
  (display (y-point p))
  (display ")"))

(define (print-point p)
  (newline)
  (show-point p))

(define (make-segment p1 p2)
  (cons p1 p2))

(define (start-segment s)
  (car s))

(define (end-segment s)
  (cdr s))

(define (make-point x y)
  (cons x y))

(define (x-point p)
  (car p))

(define (y-point p)
  (cdr p))

(define (show-segment s)
  (display "[")
  (show-point (start-segment s))
  (display ",")
  (show-point (end-segment s))
  (display "]"))

(define (print-segment s)
  (newline)
  (show-segment s))

(define p1 (make-point 0 3))
(define p2 (make-point 2 1))

(define (test-2.2)
  (define s (make-segment p1 p2))
  (print-point p1)
  (print-point p2)
  (print-point (start-segment s))
  (print-point (end-segment s))
  (print-segment s))