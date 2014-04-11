(load "check.scm")

(define (a-plus-abs-b a b)
  ((if (> b 0) + -) a b))

;; The if returns either a + or - operator, depending on the sign of b.
;; Then the result is calculated, so
;; if b > 0
;;   a + b
;; else
;;   a - b

(define (ex14-test)
  (check (a-plus-abs-b 3 4) => 7)
  (check (a-plus-abs-b 3 (- 4)) => 7)
  (check (a-plus-abs-b (- 3) 4) => 1)
  (check (a-plus-abs-b (- 3) (- 4)) => 1)
  (check-report)
)