(load "check.scm")

(define square
  (lambda (x) (* x x)))

;; these are constants that will be useful to us
(define gravity 9.8)  ;; in m/s
(define pi 3.14159)

;; Problem 1

(define position
  (lambda (a v u t)
    (+ (/ (* a (square t)) 2) (* v t) u)
  )
)

(define (posn-test)
	(check (position 00 00 00 00) => 00)
	(check (position 00 00 20 00) => 20)
	(check (position 00 05 10 10) => 60)
	(check (position 02 02 02 02) => 10)
	(check (position 05 05 05 05) => (/ 185 2))
)

;; Problem 2

(define (rootn a b c op)
	(define b2-4ac (- (square b) (* 4 a c)))
   	(if (< b2-4ac 0)
   		#f 
   		(/ (op (- b) (sqrt b2-4ac)) (* 2 a))
   	)
)

(define root1
	(lambda (a b c)
    	(rootn a b c +)
    )
)

(define root2
  (lambda (a b c)
    	(rootn a b c -)
    )
)


(define (root-test)
	(check (root1 2 3 4)     => #f)
	(check (root1 4 3 4)     => #f)
	(check (root1 4 8 4)     => (- 1))
	(check (root2 4 8 4)     => (- 1))
	(check (root1 2 8 2)     => (- .2679491924311228))
	(check (root2 2 8 2)     => (- 3.732050807568877))
	(check (root2 1 8 1)     => (- 7.872983346207417))
	(check (root1 1 8 1)     => (- .12701665379258298))
	(check (root1 1 30 1)    => (- .03337045290423468))
	(check (root2 1 30 1)    => (- 29.966629547095764)) 
	(check (root2 1 (- 2) 1) => 1) 
	(check (root1 1 (- 2) 1) => 1) 
	(check (root1 1 (- 3) 1) => 2.618033988749895) 
	(check (root2 1 (- 3) 1) => .3819660112501051) 
	(check-report)
)


;; Problem 3
(define time-to-impact
  	(lambda (vertical-velocity elevation)
  		(define a (- (/ gravity 2)))
  		(define b vertical-velocity)
  		(define c elevation)
    	(define t1 (root1 a b c))
    	(define t2 (root2 a b c))
    	(cond ((not t1) t2)
    		  ((not t2) t1)
    		  ((> t1 t2) t1)
    		  (else t2)
    	)
  	)
)

(define time-to-height
  (lambda (vertical-velocity elevation target-elevation)
    (time-to-impact vertical-velocity (- elevation target-elevation))
  )
)

(define (time-test)
	(check (time-to-impact 0.0 4.9) => 1.0)
	(check (time-to-impact 9.8 0.0) => 2.0)
	(check (time-to-height 9.8 0.0 4.9) => 1.0)
)

;; Problem 4

(define degree2radian
  (lambda (deg)
    (/ (* deg pi) 180.)))

(define travel-distance-simple
  (lambda (elevation velocity angle)
  	(define vertical-velocity (* v (sin (degree2radian angle))))
    (define travel-time (time-to-height vertical-velocity elevation 0))
    (define horizontal-velocity (* v (cos (degree2radian angle))))
    (* travel-time horizontal-velocity)
  )
)

