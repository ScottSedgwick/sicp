(define (lpower x n) 
	(exp (* n (log x)))
)

(define (rpower x n) 
	(if (= n 1)
		x
		(* x (rpower x (- n 1)))
	)
)

(define (square x) 
	(rpower x 2)
)