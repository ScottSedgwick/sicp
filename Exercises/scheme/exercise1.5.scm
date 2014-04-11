(define (p) (p))
(define (test x y)
  (if (= x 0) 0 y))

;; Don't do this...
;; (test 0 (p))

;; ...because if the interpreter uses normal order evaluation,
;; then it will go into an infinite loop trying to evaluate (p),
;; which is passed in as the y argument.
;; This is despite the value for y never being needed, because
;; x = 0. So if the interpreter uses applicative order evaluation
;; (which we know as lazy evalutation) then it will breeze through
;; this test.