(define (abs x) 
	(if (< x 0) (- x) x)
)

(define (avg2 a b) 
	(/ (+ a b) 2)
)

(define (within-percentage value guess percentage)
	(< (abs (/ (- value guess) value)) percentage)
)

(define (sqr x) (* x x))

(define (sqrt x) 
	(define (good-enough? guess) (within-percentage x (sqr guess) 0.00000000001))
	(define (improve guess) (avg2 guess (/ x guess)))
	(define (iter guess)
  		(if (good-enough? guess)
      		guess
      		(iter (improve guess))
  		)
	)
	(iter 1.0)
)

(define (cub x) (* x x x))

(define (cubt x) 
	(define (good-enough? guess) (within-percentage x (cub guess) 0.00000000001))
	(define (improve guess) (/ (+ (/ x (* guess guess)) (* 2 guess)) 3))
	(define (iter guess)
		(if (good-enough? guess)
			guess
			(iter (improve guess))
		)
	)
	(iter 1.0)
)
