(load "check.scm")

;; Exercise 1.2
(define ex12 (/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
                (* 3 (- 6 2) (- 2 7))))
(define (ex12-test)
  (check ex12 => (- (/ 74 300)))
  (check-report)
)