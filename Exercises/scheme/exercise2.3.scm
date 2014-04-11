(load "exercise2.2.scm")

(define (make-rect top-left top-right bottom-right bottom-left)
  (cons top-left top-right bottom-right bottom-left))

(define (top-left r)
  (car r))

(define (top-right r)
  (car (cdr r)))

(define (bottom-right r)
  (car (cdr (cdr r))))

(define (bottom-left r)
  (cdr (cdr (cdr r))))

(define (top r)
  (make-segment (top-left r) (top-right r)))

(define (right r)
  (make-segment (top-right r) (bottom-right r)))

(define (bottom r)
  (make-segment (bottom-right r) (bottom-left r)))

(define (left r)
  (make-segment (bottom-left r) (top-left r)))

(define (display-rect r)
  (newline)
  (show-segment (top r))
  (show-segment (right r))
  (show-segment (bottom r))
  (show-segment (left r)))

(define (length-segment s)
  (sqrt (+ (square (- (x-point (start-segment s))
                      (x-point (end-segment s))))
           (square (- (y-point (start-segment s))
                      (y-point (end-segment s)))))))

(define (perimeter r)
  (* 2
    (+ (length-segment (top r))
       (length-segment (right r)))))

(define (area r)
  (* (length-segment (top r))
     (length-segment (right r))))

(define (test-2.3)
  (display-rect (make-rect p1 p2)))